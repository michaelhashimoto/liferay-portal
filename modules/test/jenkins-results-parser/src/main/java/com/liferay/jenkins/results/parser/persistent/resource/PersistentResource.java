/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import java.util.List;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public interface PersistentResource {

	public String getControllerBuildURL();

	public JSONObject getJSONObject();

	public String getKey();

	public List<PersistentResourceArtifact> getPersistentResourceArtifacts();

	public String getProducerBuildURL();

	public long getProducerQueueId();

	public Status getStatus();

	public void touch();

	public long trigger();

	public enum Status {

		ABANDONED, FAILED, IN_PROGRESS, IN_QUEUE, NOT_STARTED, SUCCESS, WAITING

	}

}
