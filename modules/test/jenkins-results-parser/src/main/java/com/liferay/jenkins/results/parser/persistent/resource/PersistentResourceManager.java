/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

/**
 * @author Michael Hashimoto
 */
public class PersistentResourceManager {

	public static void waitForPersistentResource(
		PersistentResource persistentResource) {

		persistentResource.update();

		while (true) {
			PersistentResource.Status status = persistentResource.getStatus();

			if (status == PersistentResource.Status.FAILED) {
				persistentResource.printStatusMessage();

				throw new RuntimeException(
					persistentResource.getStatusMessage() + " (" +
						persistentResource.getProducerBuildURL() + ")");
			}
			else if (status == PersistentResource.Status.SUCCESS) {
				persistentResource.printStatusMessage();

				break;
			}

			persistentResource.printStatusMessage();

			JenkinsResultsParserUtil.sleep(30000);

			persistentResource.update();
		}
	}

}