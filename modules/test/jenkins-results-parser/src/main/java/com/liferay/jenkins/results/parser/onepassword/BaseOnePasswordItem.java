/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseOnePasswordItem implements OnePasswordItem {

	@Override
	public String getId() {
		return _jsonObject.optString("id");
	}

	@Override
	public OnePasswordConnect getOnePasswordConnect() {
		return _onePasswordVault.getOnePasswordConnect();
	}

	@Override
	public OnePasswordVault getOnePasswordVault() {
		return _onePasswordVault;
	}

	@Override
	public String getTitle() {
		return _jsonObject.optString("title");
	}

	protected BaseOnePasswordItem(
		JSONObject jsonObject, OnePasswordVault onePasswordVault) {

		_jsonObject = jsonObject;
		_onePasswordVault = onePasswordVault;
	}

	private final JSONObject _jsonObject;
	private final OnePasswordVault _onePasswordVault;

}