/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.IOException;

import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class BaseOnePasswordConnect implements OnePasswordConnect {

	@Override
	public OnePasswordVault getOnePasswordVault(String vaultName) {
		_initializeOnePasswordVaults();

		return _onePasswordVaults.get(vaultName);
	}

	@Override
	public List<OnePasswordVault> getOnePasswordVaults() {
		_initializeOnePasswordVaults();

		return new ArrayList<>(_onePasswordVaults.values());
	}

	@Override
	public URL getURL() {
		return _url;
	}

	@Override
	public String request(String urlPath) {
		return request(urlPath, null);
	}

	@Override
	public String request(String urlPath, Map<String, String> parameters) {
		try {
			StringBuilder sb = new StringBuilder();

			sb.append(getURL());

			if (!urlPath.startsWith("/")) {
				sb.append("/");
			}

			sb.append(urlPath);

			if ((parameters != null) && !parameters.isEmpty()) {
				sb.append("?");

				for (Map.Entry<String, String> parameter :
						parameters.entrySet()) {

					sb.append(parameter.getKey());
					sb.append("=");
					sb.append(parameter.getValue());
					sb.append("&");
				}

				sb.setLength(sb.length() - 1);
			}

			return JenkinsResultsParserUtil.toString(
				sb.toString(), null, _httpAuthorization);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	@Override
	public JSONArray requestJSONArray(String urlPath) {
		return new JSONArray(request(urlPath));
	}

	@Override
	public JSONArray requestJSONArray(
		String urlPath, Map<String, String> parameters) {

		return new JSONArray(request(urlPath, parameters));
	}

	@Override
	public JSONObject requestJSONObject(String urlPath) {
		return new JSONObject(request(urlPath));
	}

	@Override
	public JSONObject requestJSONObject(
		String urlPath, Map<String, String> parameters) {

		return new JSONObject(request(urlPath, parameters));
	}

	protected BaseOnePasswordConnect(URL url) {
		_url = url;

		_httpAuthorization = _getHTTPAuthorization();
	}

	private JenkinsResultsParserUtil.HTTPAuthorization _getHTTPAuthorization() {
		try {
			String onePasswordAccessTokenKey =
				JenkinsResultsParserUtil.getBuildProperty(
					"one.password.access.token.key");

			Process process = JenkinsResultsParserUtil.executeBashCommands(
				"aws ssm get-parameter --name \"" + onePasswordAccessTokenKey +
					"\" --with-decryption | jq -r .Parameter.Value");

			String accessToken = JenkinsResultsParserUtil.readInputStream(
				process.getInputStream());

			accessToken = accessToken.replace(
				"Finished executing Bash commands.", "");

			return new JenkinsResultsParserUtil.BearerHTTPAuthorization(
				accessToken.trim());
		}
		catch (IOException | TimeoutException exception) {
			throw new RuntimeException(exception);
		}
	}

	private synchronized void _initializeOnePasswordVaults() {
		if (_onePasswordVaults != null) {
			return;
		}

		_onePasswordVaults = new HashMap<>();

		JSONArray vaultsJSONArray = requestJSONArray("/v1/vaults");

		for (int i = 0; i < vaultsJSONArray.length(); i++) {
			OnePasswordVault onePasswordVault =
				OnePasswordFactory.newOnePasswordVault(
					vaultsJSONArray.getJSONObject(i), this);

			_onePasswordVaults.put(
				onePasswordVault.getName(), onePasswordVault);
		}
	}

	private final JenkinsResultsParserUtil.HTTPAuthorization _httpAuthorization;
	private Map<String, OnePasswordVault> _onePasswordVaults;
	private final URL _url;

}