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
	public OnePasswordItemField getOnePasswordItemField(String label) {
		_initialize();

		return _onePasswordItemFields.get(label);
	}

	@Override
	public List<OnePasswordItemField> getOnePasswordItemFields() {
		_initialize();

		return new ArrayList<>(_onePasswordItemFields.values());
	}

	@Override
	public OnePasswordItemFile getOnePasswordItemFile(String name) {
		_initialize();

		return _onePasswordItemFiles.get(name);
	}

	@Override
	public List<OnePasswordItemFile> getOnePasswordItemFiles() {
		_initialize();

		return new ArrayList<>(_onePasswordItemFiles.values());
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

	private synchronized void _initialize() {
		if (_itemDetailsJSONObject != null) {
			return;
		}

		OnePasswordConnect onePasswordConnect = getOnePasswordConnect();
		OnePasswordVault onePasswordVault = getOnePasswordVault();

		_itemDetailsJSONObject = onePasswordConnect.requestJSONObject(
			"/v1/vaults/" + onePasswordVault.getId() + "/items/" + getId());

		JSONArray fieldsJSONArray = _itemDetailsJSONObject.optJSONArray(
			"fields");

		if (fieldsJSONArray != null) {
			for (int j = 0; j < fieldsJSONArray.length(); j++) {
				JSONObject fieldJSONObject = fieldsJSONArray.getJSONObject(j);

				OnePasswordItemField onePasswordItemField =
					OnePasswordFactory.newOnePasswordItemField(
						this, fieldJSONObject);

				_onePasswordItemFields.put(
					onePasswordItemField.getLabel(), onePasswordItemField);
			}
		}

		JSONArray filesJSONArray = _itemDetailsJSONObject.optJSONArray("files");

		if (filesJSONArray != null) {
			for (int j = 0; j < filesJSONArray.length(); j++) {
				JSONObject fileJSONObject = filesJSONArray.getJSONObject(j);

				OnePasswordItemFile onePasswordItemFile =
					OnePasswordFactory.newOnePasswordItemFile(
						this, fileJSONObject);

				_onePasswordItemFiles.put(
					onePasswordItemFile.getName(), onePasswordItemFile);
			}
		}
	}

	private JSONObject _itemDetailsJSONObject;
	private final JSONObject _jsonObject;
	private final Map<String, OnePasswordItemField> _onePasswordItemFields =
		new HashMap<>();
	private final Map<String, OnePasswordItemFile> _onePasswordItemFiles =
		new HashMap<>();
	private final OnePasswordVault _onePasswordVault;

}