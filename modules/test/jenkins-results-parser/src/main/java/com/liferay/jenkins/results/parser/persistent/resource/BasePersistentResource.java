/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BasePersistentResource implements PersistentResource {

	@Override
	public String getControllerBuildURL() {
		return _jsonObject.optString("controller_build_url");
	}

	@Override
	public JSONObject getJSONObject() {
		return new JSONObject(_jsonObject.toString());
	}

	@Override
	public String getKey() {
		return _key;
	}

	@Override
	public List<PersistentResourceArtifact> getPersistentResourceArtifacts() {
		return new ArrayList<>();
	}

	@Override
	public String getProducerBuildURL() {
		return _jsonObject.optString("producer_build_url");
	}

	@Override
	public long getProducerQueueId() {
		return _jsonObject.optLong("producer_queue_id", -1);
	}

	@Override
	public Status getStatus() {
		String statusString = _jsonObject.optString("status");

		if (statusString.isEmpty()) {
			return Status.NOT_STARTED;
		}

		return Status.valueOf(statusString);
	}

	protected BasePersistentResource(String key, JSONObject jsonObject) {
		_key = key;
		_jsonObject = jsonObject;
	}

	protected final JSONObject _jsonObject;
	protected final String _key;

}
