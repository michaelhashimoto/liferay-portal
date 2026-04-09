/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class BaseOnePasswordItemField implements OnePasswordItemField {

	@Override
	public String getId() {
		return _jsonObject.optString("id");
	}

	@Override
	public String getLabel() {
		return _jsonObject.optString("label");
	}

	@Override
	public OnePasswordItem getOnePasswordItem() {
		return _onePasswordItem;
	}

	@Override
	public Type getType() {
		String type = _jsonObject.getString("type");

		if (JenkinsResultsParserUtil.isNullOrEmpty(type)) {
			return Type.STRING;
		}

		return Type.valueOf(type.toUpperCase());
	}

	@Override
	public String getValue() {
		return _jsonObject.optString("value");
	}

	protected BaseOnePasswordItemField(
		JSONObject jsonObject, OnePasswordItem onePasswordItem) {

		_jsonObject = jsonObject;
		_onePasswordItem = onePasswordItem;
	}

	private final JSONObject _jsonObject;
	private final OnePasswordItem _onePasswordItem;

}