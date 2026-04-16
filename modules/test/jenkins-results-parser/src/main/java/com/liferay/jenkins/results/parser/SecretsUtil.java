/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil.BearerHTTPAuthorization;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Peter Yoo
 */
public abstract class SecretsUtil {

	public static String getSecret(String key) {
		if (_bearerHTTPAuthorization == null) {
			return key;
		}

		Matcher matcher = _keyPattern.matcher(key);

		if (matcher.matches()) {
			String secret = getSecret(
				matcher.group("vaultName"), matcher.group("itemTitle"),
				matcher.group("fieldLabel"));

			if (!JenkinsResultsParserUtil.isNullOrEmpty(secret)) {
				return secret;
			}
		}

		return key;
	}

	public static String getSecret(
		String vaultName, String itemTitle, String fieldLabel) {

		if (_bearerHTTPAuthorization == null) {
			return null;
		}

		Vault vault = Vault.getInstance(vaultName);

		if (vault == null) {
			System.out.println("Vault Not Found: " + vaultName);

			return null;
		}

		Item item = vault.getItem(itemTitle);

		if (item == null) {
			System.out.println(
				JenkinsResultsParserUtil.combine(
					"Item Not Found: ", vaultName, "/", itemTitle));

			return null;
		}

		ItemField itemField = item.getItemField(fieldLabel);

		if (itemField != null) {
			return itemField.value;
		}

		ItemFile itemFile = item.getItemFile(fieldLabel);

		if (itemFile != null) {
			return itemFile.getValue();
		}

		System.out.println(
			JenkinsResultsParserUtil.combine(
				"Field Not Found: op://", vaultName, "/", itemTitle, "/",
				fieldLabel));

		return null;
	}

	public static boolean isSecretProperty(String value) {
		if (value == null) {
			return false;
		}

		Matcher matcher = _secretPropertyPattern.matcher(value);

		return matcher.matches();
	}

	private static String _getOnePasswordConnectServerURL() {
		if (_onePasswordConnectURL != null) {
			return _onePasswordConnectURL;
		}

		String onePasswordConnectURL;

		try {
			onePasswordConnectURL = JenkinsResultsParserUtil.getBuildProperty(
				"one.password.connect.url");

			if (!JenkinsResultsParserUtil.isURL(onePasswordConnectURL)) {
				onePasswordConnectURL = _SERVER_URL_DEFAULT;
			}
		}
		catch (IOException ioException) {
			onePasswordConnectURL = _SERVER_URL_DEFAULT;
		}

		_onePasswordConnectURL = onePasswordConnectURL;

		return _onePasswordConnectURL;
	}

	private static JSONArray _toJSONArray(String path) {
		if (_bearerHTTPAuthorization == null) {
			return new JSONArray();
		}

		try {
			return JenkinsResultsParserUtil.toJSONArray(
				_getOnePasswordConnectServerURL() + path, null,
				_bearerHTTPAuthorization);
		}
		catch (IOException ioException) {
			System.out.println(ioException.getMessage());

			ioException.printStackTrace();

			return new JSONArray();
		}
	}

	private static JSONObject _toJSONObject(String path) {
		if (_bearerHTTPAuthorization == null) {
			return new JSONObject();
		}

		try {
			return JenkinsResultsParserUtil.toJSONObject(
				_getOnePasswordConnectServerURL() + path, null,
				_bearerHTTPAuthorization);
		}
		catch (IOException ioException) {
			System.out.println(ioException.getMessage());

			ioException.printStackTrace();

			return null;
		}
	}

	private static String _toString(String path) {
		if (_bearerHTTPAuthorization == null) {
			return "";
		}

		try {
			return JenkinsResultsParserUtil.toString(
				_getOnePasswordConnectServerURL() + path, null,
				_bearerHTTPAuthorization);
		}
		catch (IOException ioException) {
			System.out.println(ioException.getMessage());

			ioException.printStackTrace();

			return "";
		}
	}

	private static final String _ACCESS_TOKEN;

	private static final String _ACCESS_TOKEN_KEY_DEFAULT =
		"/ci/op/access-token";

	private static final String _SERVER_URL_DEFAULT =
		"https://1password.liferay.com";

	private static final BearerHTTPAuthorization _bearerHTTPAuthorization;
	private static final Pattern _keyPattern = Pattern.compile(
		"(op\\:\\/\\/|secret\\:)?(?<vaultName>[^\\/]*)\\/" +
			"(?<itemTitle>[^\\/]*)\\/(?<fieldLabel>.*)");
	private static String _onePasswordConnectURL;
	private static final Pattern _secretPropertyPattern = Pattern.compile(
		"(op\\:\\/\\/|secret\\:)(?<key>.*)");

	static {
		String accessToken = null;

		try {
			String onePasswordAccessTokenKey =
				JenkinsResultsParserUtil.getBuildProperty(
					"one.password.access.token.key");

			if (JenkinsResultsParserUtil.isNullOrEmpty(
					onePasswordAccessTokenKey)) {

				onePasswordAccessTokenKey = _ACCESS_TOKEN_KEY_DEFAULT;
			}

			Process process = JenkinsResultsParserUtil.executeBashCommands(
				true, false,
				"aws ssm get-parameter --name \"" + onePasswordAccessTokenKey +
					"\" --with-decryption | jq -r .Parameter.Value");

			accessToken = JenkinsResultsParserUtil.readInputStream(
				process.getInputStream());

			accessToken = accessToken.replace(
				"Finished executing Bash commands.", "");

			accessToken = accessToken.trim();
		}
		catch (IOException | TimeoutException exception) {
			System.out.println(
				"Unable to load 1Password connect bearer token.");
		}

		_ACCESS_TOKEN = accessToken;

		if (accessToken != null) {
			JenkinsResultsParserUtil.addRedactToken(_ACCESS_TOKEN);

			_bearerHTTPAuthorization = new BearerHTTPAuthorization(
				_ACCESS_TOKEN);
		}
		else {
			_bearerHTTPAuthorization = null;
		}
	}

	private static class Item {

		public Item(String id, String title, Vault vault) {
			this.id = id;
			this.title = title;

			_vault = vault;
		}

		public ItemField getItemField(String label) {
			if (_itemFields == null) {
				init();
			}

			for (ItemField itemField : _itemFields) {
				if (Objects.equals(itemField.label, label)) {
					return itemField;
				}
			}

			if (_linkedItem != null) {
				return _linkedItem.getItemField(label);
			}

			return null;
		}

		public ItemFile getItemFile(String fileName) {
			if (_itemFiles == null) {
				init();
			}

			for (ItemFile itemFile : _itemFiles) {
				if (Objects.equals(itemFile.name, fileName)) {
					return itemFile;
				}
			}

			if (_linkedItem != null) {
				return _linkedItem.getItemFile(fileName);
			}

			return null;
		}

		public void init() {
			JSONObject itemJSONObject = _toJSONObject(
				JenkinsResultsParserUtil.combine(
					"/v1/vaults/", _vault.id, "/items/", id));

			JSONArray fieldsJSONArray = itemJSONObject.getJSONArray("fields");

			_itemFields = new ArrayList<>(fieldsJSONArray.length());

			for (int i = 0; i < fieldsJSONArray.length(); i++) {
				JSONObject fieldJSONObject = fieldsJSONArray.getJSONObject(i);

				try {
					JSONObject sectionJSONObject =
						fieldJSONObject.optJSONObject("section");

					if (sectionJSONObject != null) {
						if (Objects.equals(
								sectionJSONObject.optString("label"),
								"Related Items")) {

							_linkedItem = _vault.getItem(
								fieldJSONObject.getString("label"));
						}

						if (_linkedItem != null) {
							continue;
						}
					}

					if (!fieldJSONObject.has("value")) {
						continue;
					}

					_itemFields.add(
						new ItemField(
							fieldJSONObject.getString("label"),
							fieldJSONObject.getString("value")));
				}
				catch (JSONException jsonException) {
					System.err.println(jsonException.toString());
					System.out.println(fieldJSONObject.toString(2));
				}
			}

			JSONArray filesJSONArray = itemJSONObject.optJSONArray(
				"files", new JSONArray());

			_itemFiles = new ArrayList<>(filesJSONArray.length());

			for (int i = 0; i < filesJSONArray.length(); i++) {
				JSONObject fileJSONObject = filesJSONArray.getJSONObject(i);

				try {
					JSONObject sectionJSONObject = fileJSONObject.optJSONObject(
						"section");

					if (sectionJSONObject != null) {
						if (Objects.equals(
								sectionJSONObject.optString("label"),
								"Related Items")) {

							_linkedItem = _vault.getItem(
								fileJSONObject.getString("label"));
						}

						if (_linkedItem != null) {
							continue;
						}
					}

					if (!fileJSONObject.has("content_path")) {
						continue;
					}

					_itemFiles.add(
						new ItemFile(
							fileJSONObject.getString("content_path"),
							fileJSONObject.getString("name")));
				}
				catch (JSONException jsonException) {
					System.err.println(jsonException.toString());
					System.out.println(fileJSONObject.toString(2));
				}
			}
		}

		public final String id;
		public final String title;

		private List<ItemField> _itemFields;
		private List<ItemFile> _itemFiles;
		private Item _linkedItem;
		private final Vault _vault;

	}

	private static class ItemField {

		public ItemField(String label, String value) {
			this.label = label;
			this.value = value;

			if (!JenkinsResultsParserUtil.isNullOrEmpty(value)) {
				JenkinsResultsParserUtil.addRedactToken(value);
			}
		}

		public final String label;
		public final String value;

	}

	private static class ItemFile {

		public ItemFile(String contentPath, String name) {
			this.contentPath = contentPath;
			this.name = name;
		}

		public String getValue() {
			if (_value != null) {
				return _value;
			}

			String value = _toString(contentPath);

			value = value.trim();

			if (!JenkinsResultsParserUtil.isNullOrEmpty(value)) {
				JenkinsResultsParserUtil.addRedactToken(value);
			}

			_value = value;

			return _value;
		}

		public final String contentPath;
		public final String name;

		private String _value;

	}

	private static class Vault {

		public static Vault getInstance(String name) {
			return _vaultsMap.get(name);
		}

		public Item getItem(String title) {
			if (_items == null) {
				init();
			}

			for (Item item : _items) {
				if (Objects.equals(item.id, title) ||
					Objects.equals(item.title, title)) {

					return item;
				}
			}

			return null;
		}

		public void init() {
			JSONArray itemsJSONArray = _toJSONArray(
				JenkinsResultsParserUtil.combine("/v1/vaults/", id, "/items"));

			_items = new ArrayList<>(itemsJSONArray.length());

			for (int i = 0; i < itemsJSONArray.length(); i++) {
				JSONObject itemJSONObject = itemsJSONArray.getJSONObject(i);

				_items.add(
					new Item(
						itemJSONObject.getString("id"),
						itemJSONObject.getString("title"), this));
			}
		}

		public final String id;
		public final String name;

		private Vault(String id, String name) {
			this.id = id;
			this.name = name;
		}

		private static final Map<String, Vault> _vaultsMap = new HashMap<>();

		static {
			JSONArray vaultsJSONArray = _toJSONArray("/v1/vaults");

			for (int i = 0; i < vaultsJSONArray.length(); i++) {
				JSONObject vaultJSONObject = vaultsJSONArray.getJSONObject(i);

				Vault vault = new Vault(
					vaultJSONObject.getString("id"),
					vaultJSONObject.getString("name"));

				_vaultsMap.put(vault.name, vault);
			}
		}

		private List<Item> _items;

	}

}