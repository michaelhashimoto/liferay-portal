/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.PortalTestClassJob;
import com.liferay.jenkins.results.parser.job.property.JobProperty;

import java.io.File;
import java.io.IOException;

import java.nio.file.PathMatcher;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class WorkspacesJSUnitModulesBatchTestClassGroup
	extends JSUnitModulesBatchTestClassGroup {

	protected WorkspacesJSUnitModulesBatchTestClassGroup(
		JSONObject jsonObject, PortalTestClassJob portalTestClassJob) {

		super(jsonObject, portalTestClassJob);
	}

	protected WorkspacesJSUnitModulesBatchTestClassGroup(
		String batchName, PortalTestClassJob portalTestClassJob) {

		super(batchName, portalTestClassJob);
	}

	@Override
	protected List<File> getBaseModuleDirs() throws IOException {
		List<File> baseModuleDirs = new ArrayList<>();

		for (File workspacesDir : getWorkspacesDirs()) {
			baseModuleDirs.addAll(
				portalGitWorkingDirectory.getModuleDirsList(
					workspacesDir, getExcludesPathMatchers(),
					getIncludesPathMatchers()));
		}

		return baseModuleDirs;
	}

	@Override
	protected List<PathMatcher> getExcludesPathMatchers() {
		return _getWorkspacesPathMatchers(getExcludesJobProperties());
	}

	@Override
	protected List<PathMatcher> getIncludesPathMatchers() {
		if (isRootCauseAnalysis()) {
			return super.getIncludesPathMatchers();
		}

		return _getWorkspacesPathMatchers(getIncludesJobProperties());
	}

	protected List<File> getWorkspacesDirs() {
		List<File> workspacesDirs = new ArrayList<>();

		workspacesDirs.add(
			new File(
				portalGitWorkingDirectory.getWorkingDirectory(), "workspaces"));

		File portalPrivateDir = portalGitWorkingDirectory.getPortalPrivateDir();

		if (portalPrivateDir != null) {
			workspacesDirs.add(new File(portalPrivateDir, "workspaces"));
		}

		return workspacesDirs;
	}

	@Override
	protected boolean isSkippedProjectDir(File projectDir) {
		return false;
	}

	private List<PathMatcher> _getWorkspacesPathMatchers(
		List<JobProperty> jobProperties) {

		List<PathMatcher> pathMatchers = new ArrayList<>();

		for (File workspacesDir : getWorkspacesDirs()) {
			for (JobProperty jobProperty : jobProperties) {
				if (jobProperty == null) {
					continue;
				}

				pathMatchers.addAll(
					getPathMatchers(jobProperty.getValue(), workspacesDir));
			}
		}

		return pathMatchers;
	}

}