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
	protected String getTestClassRootDirName() {
		return "workspaces";
	}

	private File _getWorkspaceProjectDir(File modifiedFile) {
		File workspacesDir = new File(
			portalGitWorkingDirectory.getWorkingDirectory(), "workspaces");

		String workspacesDirPath = JenkinsResultsParserUtil.getCanonicalPath(
			workspacesDir);

		String modifiedFilePath = JenkinsResultsParserUtil.getCanonicalPath(
			modifiedFile);

		if (!modifiedFilePath.startsWith(workspacesDirPath + "/")) {
			return null;
		}

		String relativePath = modifiedFilePath.substring(
			workspacesDirPath.length() + 1);

		String[] relativePathParts = relativePath.split("/");

		if (relativePathParts.length < 2) {
			return null;
		}

		File workspaceDir = new File(workspacesDir, relativePathParts[0]);

		if ((relativePathParts.length < 3) ||
			!relativePathParts[1].equals("modules")) {

			return workspaceDir;
		}

		return new File(
			workspaceDir, relativePathParts[1] + "/" + relativePathParts[2]);
	}

}