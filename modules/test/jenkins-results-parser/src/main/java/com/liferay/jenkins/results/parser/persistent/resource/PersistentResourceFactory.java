/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.CloudBucketUtil;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.WorkspaceGitRepository;

import java.io.IOException;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class PersistentResourceFactory {

	public static PersistentResource newPersistentResource(
			String resourceName,
			WorkspaceGitRepository workspaceGitRepository)
		throws IOException {

		String key = _getKey(resourceName, workspaceGitRepository);

		String s3ObjectPath = _getS3ObjectPath(
			resourceName, workspaceGitRepository);

		JSONObject jsonObject = null;

		if (CloudBucketUtil.isS3ObjectRefAvailable(s3ObjectPath)) {
			jsonObject = new JSONObject(
				CloudBucketUtil.readS3File(s3ObjectPath));
		}
		else {
			jsonObject = new JSONObject();
		}

		if (resourceName.equals("app-server-bundle")) {
			return new AppServerBundlePersistentResource(
				key, jsonObject, s3ObjectPath, workspaceGitRepository);
		}

		return null;
	}

	private static String _getKey(
		String resourceName, WorkspaceGitRepository workspaceGitRepository) {

		StringBuilder sb = new StringBuilder();

		sb.append(workspaceGitRepository.getName());
		sb.append("/");
		sb.append(workspaceGitRepository.getBaseBranchSHA());
		sb.append("/");
		sb.append(workspaceGitRepository.getSenderBranchSHA());
		sb.append("/");
		sb.append(resourceName);

		return sb.toString();
	}

	private static String _getS3ObjectPath(
			String resourceName,
			WorkspaceGitRepository workspaceGitRepository)
		throws IOException {

		StringBuilder sb = new StringBuilder();

		sb.append(
			JenkinsResultsParserUtil.getBuildProperty(
				"cloud.ci.s3.bucket.bundles.path"));
		sb.append("/");
		sb.append(_getKey(resourceName, workspaceGitRepository));
		sb.append("/resource-state.json");

		return sb.toString();
	}

}
