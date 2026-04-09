/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
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

	@Override
	public OnePasswordItem getOnePasswordItem(String title) {
		_initializeOnePasswordItems();

		return _onePasswordItems.get(title);
	}

	@Override
	public List<OnePasswordItem> getOnePasswordItems() {
		_initializeOnePasswordItems();

		return new ArrayList<>(_onePasswordItems.values());
	}

	protected BaseOnePasswordVault(
		JSONObject jsonObject, OnePasswordConnect onePasswordConnect) {

		_jsonObject = jsonObject;
		_onePasswordConnect = onePasswordConnect;
	}

	private synchronized void _initializeOnePasswordItems() {
		if (_onePasswordItems != null) {
			return;
		}

		_onePasswordItems = new HashMap<>();

		OnePasswordConnect onePasswordConnect = getOnePasswordConnect();

		JSONArray itemsJSONArray = onePasswordConnect.requestJSONArray(
			"/v1/vaults/" + getId() + "/items");

		for (int i = 0; i < itemsJSONArray.length(); i++) {
			OnePasswordItem onePasswordItem =
				OnePasswordFactory.newOnePasswordItem(
					itemsJSONArray.getJSONObject(i), this);

			_onePasswordItems.put(onePasswordItem.getTitle(), onePasswordItem);
		}
	}

	private final JSONObject _jsonObject;
	private final OnePasswordConnect _onePasswordConnect;
	private Map<String, OnePasswordItem> _onePasswordItems;

}