/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.PortalTestClassJob;
import com.liferay.jenkins.results.parser.job.property.JobProperty;
import com.liferay.jenkins.results.parser.test.batch.JUnitTestBatch;

import java.io.File;

import java.nio.file.PathMatcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class WorkspacesJUnitBatchTestClassGroup
	extends ModulesJUnitBatchTestClassGroup {

	protected WorkspacesJUnitBatchTestClassGroup(
		JSONObject jsonObject, PortalTestClassJob portalTestClassJob) {

		super(jsonObject, portalTestClassJob);
	}

	protected WorkspacesJUnitBatchTestClassGroup(
		String batchName, PortalTestClassJob portalTestClassJob) {

		super(batchName, portalTestClassJob);
	}

	protected WorkspacesJUnitBatchTestClassGroup(
		String batchName, PortalTestClassJob portalTestClassJob,
		JUnitTestBatch jUnitTestBatch) {

		super(batchName, portalTestClassJob, jUnitTestBatch);
	}

	@Override
	protected List<File> getAdditionalJavaFileDirs() {
		File portalPrivateWorkspacesDir = _getPortalPrivateWorkspacesDir();

		if (portalPrivateWorkspacesDir == null) {
			return super.getAdditionalJavaFileDirs();
		}

		List<File> additionalJavaFileDirs = new ArrayList<>(
			super.getAdditionalJavaFileDirs());

		additionalJavaFileDirs.add(portalPrivateWorkspacesDir);

		return additionalJavaFileDirs;
	}

	@Override
	protected List<PathMatcher> getFilterPathMatchers() {
		List<PathMatcher> filterPathMatchers = new ArrayList<>(
			super.getFilterPathMatchers());

		File portalPrivateDir = _getPortalPrivateDir();

		if (portalPrivateDir == null) {
			return filterPathMatchers;
		}

		JobProperty jobProperty = getJobProperty(
			"test.batch.class.names.filter", JobProperty.Type.FILTER_GLOB);

		filterPathMatchers.addAll(
			getPathMatchers(jobProperty.getValue(), portalPrivateDir));

		return filterPathMatchers;
	}

	@Override
	protected List<PathMatcher> getIncludesPathMatchers() {
		List<PathMatcher> includesPathMatchers = new ArrayList<>(
			super.getIncludesPathMatchers());

		if (testRelevantChanges || testReleaseBundle) {
			return includesPathMatchers;
		}

		File portalPrivateDir = _getPortalPrivateDir();

		if (portalPrivateDir == null) {
			return includesPathMatchers;
		}

		JobProperty jobProperty = getJobProperty(
			"test.batch.class.names.includes");

		includesPathMatchers.addAll(
			getPathMatchers(jobProperty.getValue(), portalPrivateDir));

		return includesPathMatchers;
	}

	@Override
	protected List<JobProperty> getRelevantIncludesJobProperties() {
		if (includeStableTestSuite && isStableTestSuiteBatch()) {
			return super.getRelevantIncludesJobProperties();
		}

		Set<JobProperty> includesJobProperties = new HashSet<>();

		for (File modifiedFile :
				portalGitWorkingDirectory.getModifiedFilesList()) {

			File workspaceProjectDir = _getWorkspaceProjectDir(modifiedFile);

			if (workspaceProjectDir == null) {
				continue;
			}

			includesJobProperties.add(
				getJobProperty(
					"test.batch.class.names.includes.workspaces",
					workspaceProjectDir, JobProperty.Type.INCLUDE_GLOB));
		}

		return new ArrayList<>(includesJobProperties);
	}

	@Override
	protected List<File> getTestClassRootDirs() {
		List<File> testClassRootDirs = new ArrayList<>();

		testClassRootDirs.add(
			new File(
				portalGitWorkingDirectory.getWorkingDirectory(), "workspaces"));

		File portalPrivateWorkspacesDir = _getPortalPrivateWorkspacesDir();

		if (portalPrivateWorkspacesDir != null) {
			testClassRootDirs.add(portalPrivateWorkspacesDir);
		}

		return testClassRootDirs;
	}

	private File _getPortalPrivateDir() {
		return portalGitWorkingDirectory.getPortalPrivateDir();
	}

	private File _getPortalPrivateWorkspacesDir() {
		File portalPrivateDir = _getPortalPrivateDir();

		if (portalPrivateDir == null) {
			return null;
		}

		File portalPrivateWorkspacesDir = new File(
			portalPrivateDir, "workspaces");

		if (!portalPrivateWorkspacesDir.exists()) {
			return null;
		}

		return portalPrivateWorkspacesDir;
	}

	private File _getWorkspaceModuleDir(File workspaceDir, File modifiedFile) {
		File parentDir = modifiedFile.getParentFile();

		while ((parentDir != null) && !parentDir.equals(workspaceDir)) {
			File buildGradleFile = new File(parentDir, "build.gradle");

			if (buildGradleFile.exists()) {
				return parentDir;
			}

			parentDir = parentDir.getParentFile();
		}

		return workspaceDir;
	}

	private File _getWorkspaceProjectDir(File modifiedFile) {
		File canonicalModifiedFile = JenkinsResultsParserUtil.getCanonicalFile(
			modifiedFile);

		String modifiedFilePath = JenkinsResultsParserUtil.getCanonicalPath(
			canonicalModifiedFile);

		for (File workspacesDir : getTestClassRootDirs()) {
			String workspacesDirPath =
				JenkinsResultsParserUtil.getCanonicalPath(workspacesDir);

			if (!modifiedFilePath.startsWith(workspacesDirPath + "/")) {
				continue;
			}

			String relativePath = modifiedFilePath.substring(
				workspacesDirPath.length() + 1);

			String[] relativePathParts = relativePath.split("/");

			if (relativePathParts.length < 2) {
				return null;
			}

			return _getWorkspaceModuleDir(
				new File(workspacesDir, relativePathParts[0]),
				canonicalModifiedFile);
		}

		return null;
	}

}