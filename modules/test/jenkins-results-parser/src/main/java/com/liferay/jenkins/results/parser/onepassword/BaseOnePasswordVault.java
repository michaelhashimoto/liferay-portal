/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseOnePasswordVault implements OnePasswordVault {

	@Override
	public String getId() {
		return _jsonObject.optString("id");
	}

	@Override
	public String getName() {
		return _jsonObject.optString("name");
	}

	@Override
	public OnePasswordConnect getOnePasswordConnect() {
		return _onePasswordConnect;
	}

	protected BaseOnePasswordVault(
		JSONObject jsonObject, OnePasswordConnect onePasswordConnect) {

		_jsonObject = jsonObject;
		_onePasswordConnect = onePasswordConnect;
	}

	private final JSONObject _jsonObject;
	private final OnePasswordConnect _onePasswordConnect;

}