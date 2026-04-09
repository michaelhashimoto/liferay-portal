/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class OnePasswordFactory {

	public static OnePasswordConnect newOnePasswordConnect(URL url) {
		if (url == null) {
			return null;
		}

		OnePasswordConnect onePasswordConnect = _onePasswordConnects.get(url);

		if (onePasswordConnect == null) {
			onePasswordConnect = new BaseOnePasswordConnect(url);

			_onePasswordConnects.put(url, onePasswordConnect);
		}

		return onePasswordConnect;
	}

	public static OnePasswordItem newOnePasswordItem(
		JSONObject jsonObject, OnePasswordVault onePasswordVault) {

		String key =
			onePasswordVault.getName() + "__" + jsonObject.getString("id");

		OnePasswordItem onePasswordItem = _onePasswordItems.get(key);

		if (onePasswordItem == null) {
			onePasswordItem = new DefaultOnePasswordItem(
				jsonObject, onePasswordVault);

			_onePasswordItems.put(key, onePasswordItem);
		}

		return onePasswordItem;
	}

	public static OnePasswordItemField newOnePasswordItemField(
		OnePasswordItem onePasswordItem, JSONObject jsonObject) {

		String key =
			onePasswordItem.getId() + "__" + jsonObject.getString("label");

		OnePasswordItemField onePasswordItemField = _onePasswordItemFields.get(
			key);

		if (onePasswordItemField == null) {
			onePasswordItemField = new DefaultOnePasswordItemField(
				jsonObject, onePasswordItem);

			_onePasswordItemFields.put(key, onePasswordItemField);
		}

		return onePasswordItemField;
	}

	public static OnePasswordVault newOnePasswordVault(
		JSONObject jsonObject, OnePasswordConnect onePasswordConnect) {

		String key =
			onePasswordConnect.getURL() + "__" + jsonObject.getString("name");

		OnePasswordVault onePasswordVault = _onePasswordVaults.get(key);

		if (onePasswordVault == null) {
			onePasswordVault = new DefaultOnePasswordVault(
				jsonObject, onePasswordConnect);

			_onePasswordVaults.put(key, onePasswordVault);
		}

		return onePasswordVault;
	}

	private static final Map<URL, OnePasswordConnect> _onePasswordConnects =
		new HashMap<>();
	private static final Map<String, OnePasswordItemField>
		_onePasswordItemFields = new HashMap<>();
	private static final Map<String, OnePasswordItem> _onePasswordItems =
		new HashMap<>();
	private static final Map<String, OnePasswordVault> _onePasswordVaults =
		new HashMap<>();

}