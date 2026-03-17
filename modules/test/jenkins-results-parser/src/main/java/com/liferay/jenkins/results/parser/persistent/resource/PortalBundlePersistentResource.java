/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.PortalTopLevelBuild;
import com.liferay.jenkins.results.parser.TopLevelBuild;
import com.liferay.jenkins.results.parser.Workspace;
import com.liferay.jenkins.results.parser.WorkspaceGitRepository;

/**
 * @author Michael Hashimoto
 */
public class PortalBundlePersistentResource
	extends BaseBundlePersistentResource {

	@Override
	public Type getType() {
		return Type.PORTAL_BUNDLE;
	}

	protected PortalBundlePersistentResource(TopLevelBuild topLevelBuild) {
		super(topLevelBuild);
	}

	@Override
	protected WorkspaceGitRepository getBundleWorkspaceGitRepository() {
		TopLevelBuild topLevelBuild = getTopLevelBuild();

		Workspace workspace = getWorkspace();

		if (topLevelBuild instanceof PortalTopLevelBuild) {
			return workspace.getPrimaryWorkspaceGitRepository();
		}

		return workspace.getWorkspaceGitRepository("liferay-portal");
	}

}