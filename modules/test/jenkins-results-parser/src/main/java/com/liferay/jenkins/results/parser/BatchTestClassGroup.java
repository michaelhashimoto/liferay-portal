/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Hashimoto
 */
public class BatchTestClassGroup extends TestClassGroup {

	public int getAxisCount() {
		return axisTestClassGroups.size();
	}

	public AxisTestClassGroup getAxisTestClassGroup(int axisId) {
		return axisTestClassGroups.get(axisId);
	}

	public String getBatchName() {
		return batchName;
	}

	public GitWorkingDirectory getGitWorkingDirectory() {
		return gitWorkingDirectory;
	}

	public Properties getPortalTestProperties() {
		return portalTestProperties;
	}

	protected BatchTestClassGroup(
		String batchName, GitWorkingDirectory gitWorkingDirectory) {

		this(batchName, gitWorkingDirectory, null);
	}

	protected BatchTestClassGroup(
		String batchName, GitWorkingDirectory gitWorkingDirectory,
		String testSuiteName) {

		this.batchName = batchName;
		this.gitWorkingDirectory = gitWorkingDirectory;
		this.testSuiteName = testSuiteName;

		portalTestProperties = JenkinsResultsParserUtil.getProperties(
			new File(
				this.gitWorkingDirectory.getWorkingDirectory(),
				"test.properties"));

		setTestRelevantChanges();

		setTestClassNamesExcludesRelativeGlobs();
		setTestClassNamesIncludesRelativeGlobs();

		setTestClassFiles();

		setAxisTestClassGroups();
	}

	protected int getAxisMaxSize() {
		String axisMaxSize = getAxisMaxSizePropertyValue();

		if (axisMaxSize != null) {
			return Integer.parseInt(axisMaxSize);
		}

		return DEFAULT_AXIS_MAX_SIZE;
	}

	protected String getAxisMaxSizePropertyValue() {
		List<String> propertyNames = new ArrayList<>();

		if (testSuiteName != null) {
			propertyNames.add(
				JenkinsResultsParserUtil.combine(
					"test.batch.axis.max.size[", batchName, "][", testSuiteName,
					"]"));

			propertyNames.add(
				getWildcardPropertyName(
					batchName, portalTestProperties, "test.batch.axis.max.size",
					testSuiteName));

			propertyNames.add(
				JenkinsResultsParserUtil.combine(
					"test.batch.axis.max.size[", testSuiteName, "]"));
		}

		propertyNames.add(
			JenkinsResultsParserUtil.combine(
				"test.batch.axis.max.size[", batchName, "]"));

		propertyNames.add(
			getWildcardPropertyName(
				batchName, portalTestProperties, "test.batch.axis.max.size"));

		propertyNames.add("test.batch.axis.max.size");

		return getFirstPropertyValue(portalTestProperties, propertyNames);
	}

	protected String getFirstPropertyValue(
		Properties properties, List<String> propertyNames) {

		for (String propertyName : propertyNames) {
			if (propertyName == null) {
				continue;
			}

			if (properties.containsKey(propertyName)) {
				String propertyValue = properties.getProperty(propertyName);

				if ((propertyValue != null) && !propertyValue.isEmpty()) {
					return propertyValue;
				}
			}
		}

		return null;
	}

	protected List<String> getRelevantTestClassNamesRelativeGlobs(
		List<String> testClassNamesRelativeGlobs) {

		List<String> relevantTestClassNameRelativeGlobs = new ArrayList<>();

		PortalGitWorkingDirectory portalGitWorkingDirectory =
			(PortalGitWorkingDirectory)gitWorkingDirectory;

		List<File> moduleGroupDirs = null;

		try {
			moduleGroupDirs =
				portalGitWorkingDirectory.getCurrentBranchModuleGroupDirs();
		}
		catch (IOException ioe) {
			File workingDirectory = gitWorkingDirectory.getWorkingDirectory();

			throw new RuntimeException(
				JenkinsResultsParserUtil.combine(
					"Unable to get relevant module group directories in ",
					workingDirectory.getPath()),
				ioe);
		}

		for (File moduleGroupDir : moduleGroupDirs) {
			String modulesGroupRelativePath = moduleGroupDir.getPath();

			modulesGroupRelativePath = modulesGroupRelativePath.substring(
				modulesGroupRelativePath.indexOf("modules/"));

			for (String testClassNamesRelativeGlob :
					testClassNamesRelativeGlobs) {

				relevantTestClassNameRelativeGlobs.add(
					JenkinsResultsParserUtil.combine(
						modulesGroupRelativePath, "/",
						testClassNamesRelativeGlob));

				if (testClassNamesRelativeGlob.startsWith("**/")) {
					relevantTestClassNameRelativeGlobs.add(
						JenkinsResultsParserUtil.combine(
							modulesGroupRelativePath, "/",
							testClassNamesRelativeGlob.substring(3)));
				}
			}
		}

		return relevantTestClassNameRelativeGlobs;
	}

	protected String getTestClassNamesExcludesPropertyValue() {
		List<String> propertyNames = new ArrayList<>();

		if (testSuiteName != null) {
			propertyNames.add(
				JenkinsResultsParserUtil.combine(
					"test.batch.class.names.excludes[", batchName, "][",
					testSuiteName, "]"));

			propertyNames.add(
				getWildcardPropertyName(
					batchName, portalTestProperties,
					"test.batch.class.names.excludes", testSuiteName));

			propertyNames.add(
				JenkinsResultsParserUtil.combine(
					"test.batch.class.names.excludes[", testSuiteName, "]"));
		}

		propertyNames.add(
			getWildcardPropertyName(
				batchName, portalTestProperties,
				"test.batch.class.names.excludes"));

		propertyNames.add(
			JenkinsResultsParserUtil.combine(
				"test.batch.class.names.excludes[", batchName, "]"));

		propertyNames.add("test.batch.class.names.excludes");

		propertyNames.add("test.class.names.excludes");

		return getFirstPropertyValue(portalTestProperties, propertyNames);
	}

	protected String getTestClassNamesIncludesPropertyValue() {
		List<String> propertyNames = new ArrayList<>();

		if (testSuiteName != null) {
			propertyNames.add(
				JenkinsResultsParserUtil.combine(
					"test.batch.class.names.includes[", batchName, "][",
					testSuiteName, "]"));

			propertyNames.add(
				getWildcardPropertyName(
					batchName, portalTestProperties,
					"test.batch.class.names.includes", testSuiteName));

			propertyNames.add(
				JenkinsResultsParserUtil.combine(
					"test.batch.class.names.includes[", testSuiteName, "]"));
		}

		propertyNames.add(
			JenkinsResultsParserUtil.combine(
				"test.batch.class.names.includes[", batchName, "]"));

		propertyNames.add(
			getWildcardPropertyName(
				batchName, portalTestProperties,
				"test.batch.class.names.includes"));

		propertyNames.add("test.batch.class.names.includes");

		propertyNames.add("test.class.names.includes");

		return getFirstPropertyValue(portalTestProperties, propertyNames);
	}

	protected List<PathMatcher> getTestClassNamesPathMatchers(
		List<String> testClassNamesRelativeGlobs) {

		List<PathMatcher> pathMatchers = new ArrayList<>();

		File workingDirectory = gitWorkingDirectory.getWorkingDirectory();

		String workingDirectoryPath = workingDirectory.getAbsolutePath();

		for (String testClassNamesRelativeGlob : testClassNamesRelativeGlobs) {
			FileSystem fileSystem = FileSystems.getDefault();

			pathMatchers.add(
				fileSystem.getPathMatcher(
					JenkinsResultsParserUtil.combine(
						"glob:", workingDirectoryPath, "/",
						testClassNamesRelativeGlob)));
		}

		return pathMatchers;
	}

	protected String getWildcardPropertyName(
		String batchName, Properties properties, String propertyName) {

		return getWildcardPropertyName(
			batchName, properties, propertyName, null);
	}

	protected String getWildcardPropertyName(
		String batchName, Properties properties, String propertyName,
		String testSuiteName) {

		for (String wildcardPropertyName : properties.stringPropertyNames()) {
			if (!wildcardPropertyName.startsWith(propertyName)) {
				continue;
			}

			Matcher matcher = propertyNamePattern.matcher(wildcardPropertyName);

			if (matcher.find()) {
				String batchNameMatcher = matcher.group("batchName");

				batchNameMatcher = batchNameMatcher.replace("*", ".+");

				if (!batchName.matches(batchNameMatcher)) {
					continue;
				}

				String testSuiteNameMatcher = matcher.group("testSuiteName");

				if (testSuiteName != testSuiteNameMatcher) {
					continue;
				}

				return wildcardPropertyName;
			}
		}

		return null;
	}

	protected void setAxisTestClassGroups() {
		int testClassFileCount = testClassFiles.size();

		if (testClassFileCount == 0) {
			return;
		}

		int axisMaxSize = getAxisMaxSize();

		int axisCount = (int)Math.ceil(
			(double)testClassFileCount / axisMaxSize);

		int axisSize = (int)Math.ceil((double)testClassFileCount / axisCount);

		int id = 0;

		for (List<File> axisTestClassFiles :
				Lists.partition(testClassFiles, axisSize)) {

			AxisTestClassGroup axisTestClassGroup = new AxisTestClassGroup(id);

			axisTestClassGroups.put(id, axisTestClassGroup);

			for (File axisTestClassFile : axisTestClassFiles) {
				axisTestClassGroup.addTestClassFile(axisTestClassFile);
			}

			id++;
		}
	}

	protected void setTestClassFiles() {
		File workingDirectory = gitWorkingDirectory.getWorkingDirectory();

		try {
			Files.walkFileTree(
				workingDirectory.toPath(),
				new SimpleFileVisitor<Path>() {

					@Override
					public FileVisitResult preVisitDirectory(
							Path filePath, BasicFileAttributes attrs)
						throws IOException {

						if (_pathExcluded(filePath)) {
							return FileVisitResult.SKIP_SUBTREE;
						}

						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult visitFile(
							Path filePath, BasicFileAttributes attrs)
						throws IOException {

						if (_pathIncluded(filePath) &&
							!_pathExcluded(filePath)) {

							testClassFiles.add(
								_getPackagePathClassFile(filePath));
						}

						return FileVisitResult.CONTINUE;
					}

					private File _getPackagePathClassFile(Path path) {
						String filePath = path.toString();

						Matcher matcher = packagePathPattern.matcher(filePath);

						if (matcher.find()) {
							String packagePath = matcher.group("packagePath");

							packagePath = packagePath.replace(
								".java", ".class");

							return new File(packagePath);
						}

						return new File(filePath.replace(".java", ".class"));
					}

					private boolean _pathExcluded(Path path) {
						return _pathMatches(
							path, testClassNamesExcludesPathMatchers);
					}

					private boolean _pathIncluded(Path path) {
						return _pathMatches(
							path, testClassNamesIncludesPathMatchers);
					}

					private boolean _pathMatches(
						Path path, List<PathMatcher> pathMatchers) {

						for (PathMatcher pathMatcher : pathMatchers) {
							if (pathMatcher.matches(path)) {
								return true;
							}
						}

						return false;
					}

				});
		}
		catch (IOException ioe) {
			throw new RuntimeException(
				"Unable to search for test file names in " +
					workingDirectory.getPath(),
				ioe);
		}

		Collections.sort(testClassFiles);
	}

	protected void setTestClassNamesExcludesRelativeGlobs() {
		String testClassNamesExcludesPropertyValue =
			getTestClassNamesExcludesPropertyValue();

		if ((testClassNamesExcludesPropertyValue == null) ||
			testClassNamesExcludesPropertyValue.isEmpty()) {

			return;
		}

		List<String> testClassNamesExcludesRelativeGlobs = Arrays.asList(
			testClassNamesExcludesPropertyValue.split(","));

		if (testRelevantChanges) {
			testClassNamesExcludesRelativeGlobs =
				getRelevantTestClassNamesRelativeGlobs(
					testClassNamesExcludesRelativeGlobs);
		}

		testClassNamesExcludesPathMatchers.addAll(
			getTestClassNamesPathMatchers(testClassNamesExcludesRelativeGlobs));
	}

	protected void setTestClassNamesIncludesRelativeGlobs() {
		String testClassNamesIncludesPropertyValue =
			getTestClassNamesIncludesPropertyValue();

		if ((testClassNamesIncludesPropertyValue == null) ||
			testClassNamesIncludesPropertyValue.isEmpty()) {

			return;
		}

		List<String> testClassNamesIncludesRelativeGlobs = Arrays.asList(
			testClassNamesIncludesPropertyValue.split(","));

		if (testRelevantChanges) {
			testClassNamesIncludesRelativeGlobs =
				getRelevantTestClassNamesRelativeGlobs(
					testClassNamesIncludesRelativeGlobs);
		}

		testClassNamesIncludesPathMatchers.addAll(
			getTestClassNamesPathMatchers(testClassNamesIncludesRelativeGlobs));
	}

	protected void setTestRelevantChanges() {
		List<String> propertyNames = new ArrayList<>();

		if (testSuiteName != null) {
			propertyNames.add(
				JenkinsResultsParserUtil.combine(
					"test.relevant.changes[", testSuiteName, "]"));
		}

		propertyNames.add("test.relevant.changes");

		String propertyValue = getFirstPropertyValue(
			portalTestProperties, propertyNames);

		if (propertyValue != null) {
			testRelevantChanges = Boolean.parseBoolean(propertyValue);

			return;
		}

		testRelevantChanges = DEFAULT_TEST_RELEVANT_CHANGES;
	}

	protected static final int DEFAULT_AXIS_MAX_SIZE = 5000;

	protected static final boolean DEFAULT_TEST_RELEVANT_CHANGES = false;

	protected final Map<Integer, AxisTestClassGroup> axisTestClassGroups =
		new HashMap<>();
	protected final String batchName;
	protected final GitWorkingDirectory gitWorkingDirectory;
	protected final Pattern packagePathPattern = Pattern.compile(
		".*/(?<packagePath>com/.*)");
	protected final Properties portalTestProperties;
	protected final Pattern propertyNamePattern = Pattern.compile(
		"[^\\]]+\\[(?<batchName>[^\\]]+)\\](\\[(?<testSuiteName>[^\\]]+)\\])?");
	protected final List<PathMatcher> testClassNamesExcludesPathMatchers =
		new ArrayList<>();
	protected final List<PathMatcher> testClassNamesIncludesPathMatchers =
		new ArrayList<>();
	protected boolean testRelevantChanges;
	protected final String testSuiteName;

}