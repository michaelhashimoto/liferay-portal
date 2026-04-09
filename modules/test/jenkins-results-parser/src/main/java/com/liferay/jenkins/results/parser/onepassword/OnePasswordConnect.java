/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import java.net.URL;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public interface OnePasswordConnect {

	public URL getURL();

	public String request(String urlPath);

	public String request(String urlPath, Map<String, String> parameters);

	public JSONArray requestJSONArray(String urlPath);

	public JSONArray requestJSONArray(
		String urlPath, Map<String, String> parameters);

	public JSONObject requestJSONObject(String urlPath);

	public JSONObject requestJSONObject(
		String urlPath, Map<String, String> parameters);

}