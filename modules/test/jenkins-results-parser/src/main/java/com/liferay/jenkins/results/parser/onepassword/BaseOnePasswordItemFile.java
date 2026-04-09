/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class BaseOnePasswordItemFile implements OnePasswordItemFile {

	@Override
	public String getContent() {
		if (_content != null) {
			return _content;
		}

		OnePasswordConnect onePasswordConnect = getOnePasswordConnect();

		_content = onePasswordConnect.request(
			_jsonObject.getString("content_path"));

		return _content;
	}

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
		return _onePasswordItem.getOnePasswordConnect();
	}

	@Override
	public OnePasswordItem getOnePasswordItem() {
		return _onePasswordItem;
	}

	@Override
	public long getSize() {
		return _jsonObject.optLong("size");
	}

	protected BaseOnePasswordItemFile(
		JSONObject jsonObject, OnePasswordItem onePasswordItem) {

		_jsonObject = jsonObject;
		_onePasswordItem = onePasswordItem;
	}

	private String _content;
	private final JSONObject _jsonObject;
	private final OnePasswordItem _onePasswordItem;

}