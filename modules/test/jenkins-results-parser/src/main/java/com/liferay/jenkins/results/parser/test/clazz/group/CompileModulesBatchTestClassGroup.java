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

import java.nio.file.PathMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

/**
 * @author Leslie Wong
 */
public class CompileModulesBatchTestClassGroup
	extends ModulesBatchTestClassGroup {

	protected CompileModulesBatchTestClassGroup(
		JSONObject jsonObject, PortalTestClassJob portalTestClassJob) {

		super(jsonObject, portalTestClassJob);
	}

	protected CompileModulesBatchTestClassGroup(
		String batchName, PortalTestClassJob portalTestClassJob) {

		super(batchName, portalTestClassJob);
	}

	@Override
	protected void setTestClasses() throws IOException {
		PortalGitWorkingDirectory portalGitWorkingDirectory =
			getPortalGitWorkingDirectory();

		List<PathMatcher> excludesPathMatchers = getPathMatchers(
			getExcludesJobProperties());
		List<PathMatcher> includesPathMatchers = getIncludesPathMatchers();

		if (testRelevantChanges) {
			List<File> modifiedModuleDirsList =
				portalGitWorkingDirectory.getModifiedModuleDirsList(
					excludesPathMatchers, includesPathMatchers);

			for (File modifiedModuleDir : modifiedModuleDirsList) {
				List<File> lfrBuildPortalFiles =
					JenkinsResultsParserUtil.findFiles(
						modifiedModuleDir, "\\.lfrbuild-portal");

				if (!lfrBuildPortalFiles.isEmpty()) {
					moduleDirsList.add(modifiedModuleDir);
				}
			}
		}
		else {
			moduleDirsList.addAll(
				portalGitWorkingDirectory.getModuleDirsList(
					excludesPathMatchers, includesPathMatchers));
		}

		List<File> parentModuleDirs = new ArrayList<>();

		for (File moduleDir : moduleDirsList) {
			parentModuleDirs.add(_getParentModuleDir(moduleDir));
		}

		for (File parentModuleDir : parentModuleDirs) {
			TestClass testClass = TestClassFactory.newTestClass(
				this, parentModuleDir);

			if (!testClass.hasTestClassMethods()) {
				continue;
			}

			addTestClass(testClass);
		}
	}


	private File _getParentModuleDir(File dir) {
		List<File> moduleDirs = new ArrayList<>();

		File currentDir = dir;

		File modulesDir = new File(
				portalGitWorkingDirectory.getWorkingDirectory(), "modules");

		while ((currentDir != null) &&
				!modulesDir.equals(currentDir.getParentFile())) {

			moduleDirs.add(currentDir);

			currentDir = currentDir.getParentFile();
		}

		Collections.reverse(moduleDirs);

		for (File moduleDir : moduleDirs) {
			if (isModuleDir(moduleDir)) {
				return moduleDir;
			}
		}

		return dir;
	}

}