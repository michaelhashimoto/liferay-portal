/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.JenkinsMaster;
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

			if (status == PersistentResource.Status.IN_QUEUE) {
				JenkinsMaster producerJenkinsMaster =
					persistentResource.getProducerJenkinsMaster();

				persistentResource.print(
					"In queue at " + producerJenkinsMaster.getURL());

				_sleepAndUpdate(persistentResource);

				continue;
			}

			String producerBuildURL = persistentResource.getProducerBuildURL();

			if (status == PersistentResource.Status.IN_PROGRESS) {
				if (persistentResource.isController()) {
					persistentResource.print(
						"Building artifact at " + producerBuildURL);
				}
				else {
					persistentResource.print(
						"Waiting for artifact from " + producerBuildURL);
				}

				_sleepAndUpdate(persistentResource);

				continue;
			}

			if (status == PersistentResource.Status.FAILED) {
				String failureMessage =
					"Failed to build artifacts at " + producerBuildURL;

				persistentResource.print(failureMessage);

				throw new RuntimeException(failureMessage);
			}

			if (status == PersistentResource.Status.SUCCESS) {
				persistentResource.print(
					"Completed successfully at " + producerBuildURL);

				break;
			}

			_sleepAndUpdate(persistentResource);
		}
	}

	private static void _sleepAndUpdate(PersistentResource persistentResource) {
		JenkinsResultsParserUtil.sleep(30000);

		persistentResource.update();
	}

}