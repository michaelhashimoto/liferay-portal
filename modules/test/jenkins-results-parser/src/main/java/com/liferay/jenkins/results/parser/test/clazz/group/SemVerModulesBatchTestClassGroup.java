/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.PortalGitWorkingDirectory;
import com.liferay.jenkins.results.parser.PortalTestClassJob;
import com.liferay.jenkins.results.parser.test.clazz.TestClass;
import com.liferay.jenkins.results.parser.test.clazz.TestClassFactory;

import java.io.File;
import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

/**
 * @author Leslie Wong
 */
public class SemVerModulesBatchTestClassGroup
	extends ModulesBatchTestClassGroup {

	protected SemVerModulesBatchTestClassGroup(
		JSONObject jsonObject, PortalTestClassJob portalTestClassJob) {

		super(jsonObject, portalTestClassJob);
	}

	protected SemVerModulesBatchTestClassGroup(
		String batchName, PortalTestClassJob portalTestClassJob) {

		super(batchName, portalTestClassJob);
	}

	@Override
	protected boolean ignore() {
		if (!isStableTestSuiteBatch() && testRelevantJUnitTestsOnly) {
			return true;
		}

		if ((isStableTestSuiteBatch() && testRelevantJUnitTestsOnlyInStable) ||
			isQuarterlyReleaseBranch()) {

			return true;
		}

		return false;
	}

	protected boolean isQuarterlyReleaseBranch() {
		Matcher quarterlyReleaseNameMatcher =
			_quarterlyReleaseNamePattern.matcher(
				portalGitWorkingDirectory.getUpstreamBranchName());

		return quarterlyReleaseNameMatcher.find();
	}

	@Override
	protected void setTestClasses() throws IOException {
		Set<File> moduleDirs = new HashSet<>();

		List<PathMatcher> excludesPathMatchers = getPathMatchers(
			getExcludesJobProperties());
		List<PathMatcher> includesPathMatchers = getIncludesPathMatchers();

		PortalGitWorkingDirectory portalGitWorkingDirectory =
			getPortalGitWorkingDirectory();

		File portalModulesBaseDir = new File(
			portalGitWorkingDirectory.getWorkingDirectory(), "modules");

		if (testRelevantChanges &&
			!(includeStableTestSuite && isStableTestSuiteBatch())) {

			moduleDirs.addAll(
				portalGitWorkingDirectory.getModifiedModuleDirsList(
					excludesPathMatchers, includesPathMatchers));
		}
		else if (isRootCauseAnalysis()) {
			moduleDirs.addAll(
				portalGitWorkingDirectory.getModuleDirsList(
					excludesPathMatchers, includesPathMatchers));
		}
		else {
			moduleDirs.addAll(
				portalGitWorkingDirectory.getModuleDirsList(
					excludesPathMatchers, includesPathMatchers));

			List<File> semVerMarkerFiles = JenkinsResultsParserUtil.findFiles(
				portalModulesBaseDir, "\\.lfrbuild-semantic-versioning");

			semVerMarkerFiles = JenkinsResultsParserUtil.getIncludedFiles(
				excludesPathMatchers, includesPathMatchers, semVerMarkerFiles);

			for (File semVerMarkerFile : semVerMarkerFiles) {
				moduleDirs.add(semVerMarkerFile.getParentFile());
			}
		}

		for (File moduleDir : moduleDirs) {
			List<File> bndBndFiles = JenkinsResultsParserUtil.findFiles(
				moduleDir, "bnd.bnd");

			boolean exportPackageModule = false;

			for (File bndBndFile : bndBndFiles) {
				String bndBndFileContent = JenkinsResultsParserUtil.read(
					bndBndFile);

				if ((bndBndFileContent == null) ||
					!bndBndFileContent.contains("Export-Package:")) {

					continue;
				}

				exportPackageModule = true;
			}

			if (!exportPackageModule) {
				continue;
			}

			for (File modulesProjectDir : _getModulesProjectDirs(moduleDir)) {
				moduleDirsList.add(modulesProjectDir);

				TestClass testClass = TestClassFactory.newTestClass(
					this, modulesProjectDir);

				if (!testClass.hasTestClassMethods()) {
					continue;
				}

				addTestClass(testClass);
			}
		}
	}

	private List<File> _getModulesProjectDirs(File moduleDir) {
		final List<File> modulesProjectDirs = new ArrayList<>();

		final File portalModulesBaseDir = getPortalModulesBaseDir();

		try {
			Files.walkFileTree(
				moduleDir.toPath(),
				new SimpleFileVisitor<Path>() {

					@Override
					public FileVisitResult preVisitDirectory(
						Path filePath,
						BasicFileAttributes basicFileAttributes) {

						if (filePath.equals(portalModulesBaseDir.toPath())) {
							return FileVisitResult.CONTINUE;
						}

						String filePathString = filePath.toString();

						if (filePathString.endsWith("-test")) {
							return FileVisitResult.SKIP_SUBTREE;
						}

						File currentDirectory = filePath.toFile();

						File bndBndFile = new File(currentDirectory, "bnd.bnd");

						File buildFile = new File(
							currentDirectory, "build.gradle");

						File lfrRelengIgnoreFile = new File(
							currentDirectory, ".lfrbuild-releng-ignore");

						if (buildFile.exists() && bndBndFile.exists() &&
							!lfrRelengIgnoreFile.exists()) {

							modulesProjectDirs.add(currentDirectory);

							return FileVisitResult.SKIP_SUBTREE;
						}

						return FileVisitResult.CONTINUE;
					}

				});
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to get module marker files from " + moduleDir,
				ioException);
		}

		return modulesProjectDirs;
	}

	private static final Pattern _quarterlyReleaseNamePattern = Pattern.compile(
		"(release-\\d{4}.[qQ](.\\d)?)");

}