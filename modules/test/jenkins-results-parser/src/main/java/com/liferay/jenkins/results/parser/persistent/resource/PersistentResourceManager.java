/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.util.Objects;

/**
 * @author Michael Hashimoto
 */
public class PersistentResourceManager {

	public void waitForPersistentResource(
		PersistentResource persistentResource) {

		PersistentResource.Status status = persistentResource.getStatus();

		if ((status == PersistentResource.Status.NOT_STARTED) ||
			(status == PersistentResource.Status.ABANDONED)) {

			persistentResource.trigger();
		}

		int abandonedCount = 0;

		while (true) {
			status = persistentResource.getStatus();

			String role = _getRole(persistentResource);

			if (status == PersistentResource.Status.SUCCESS) {
				persistentResource.touch();

				System.out.println(
					role + " Resource is available: " +
						persistentResource.getKey());

				return;
			}

			if (status == PersistentResource.Status.FAILED) {
				throw new RuntimeException(
					role + " Resource production failed: " +
						persistentResource.getKey());
			}

			if (status == PersistentResource.Status.ABANDONED) {
				abandonedCount++;

				if (abandonedCount >= 3) {
					System.out.println(
						role + " Resource was abandoned. Promoting to " +
							"[IN_PROGRESS] and retrying...");

					persistentResource.trigger();

					abandonedCount = 0;
				}
			}
			else {
				abandonedCount = 0;
			}

			System.out.println(
				role + " Waiting for resource: " + persistentResource.getKey() +
					" (Status: " + status + ")");

			JenkinsResultsParserUtil.sleep(30000);
		}
	}

	private String _getRole(PersistentResource persistentResource) {
		PersistentResource.Status status = persistentResource.getStatus();

		if (status == PersistentResource.Status.NOT_STARTED) {
			return "[IN_PROGRESS]";
		}

		String buildURL = JenkinsResultsParserUtil.getBuildProperty("BUILD_URL");

		if (Objects.equals(
				buildURL, persistentResource.getControllerBuildURL())) {

			return "[IN_PROGRESS]";
		}

		return "[WAITING]";
	}

}
