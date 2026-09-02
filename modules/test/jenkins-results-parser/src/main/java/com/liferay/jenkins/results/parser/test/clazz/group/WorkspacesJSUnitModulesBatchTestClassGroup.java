/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.PortalGitWorkingDirectory;
import com.liferay.jenkins.results.parser.PortalTestClassJob;

import java.io.File;
import java.io.IOException;

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
		PortalGitWorkingDirectory portalGitWorkingDirectory =
			getPortalGitWorkingDirectory();

		File workingDirectory = portalGitWorkingDirectory.getWorkingDirectory();

		List<File> baseModuleDirs = new ArrayList<>(
			portalGitWorkingDirectory.getModuleDirsList(
				new File(workingDirectory, "workspaces"),
				getPathMatchers(getExcludesJobProperties()),
				getIncludesPathMatchers()));

		File portalPrivateDir = portalGitWorkingDirectory.getPortalPrivateDir();

		if (portalPrivateDir != null) {
			baseModuleDirs.addAll(
				portalGitWorkingDirectory.getModuleDirsList(
					new File(portalPrivateDir, "workspaces"),
					getPathMatchers(getExcludesJobProperties()),
					getIncludesPathMatchers()));
		}

		return baseModuleDirs;
	}

}