/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jethr0.object;

import com.liferay.jethr0.util.LiferayOAuthConfiguration;
import com.liferay.jethr0.util.StringUtil;
import com.liferay.jethr0.util.ThreadUtil;
import com.liferay.petra.http.invoker.HttpInvoker;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Michael Hashimoto
 */
@Configuration
public class ObjectDALO {

	protected JSONObject create(JSONObject requestJSONObject) {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(requestJSONObject.toString(), "application/json");

		httpInvoker.header(
			"Authorization", _liferayOAuthConfiguration.getAuthorization());

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(_liferayPortalURL + getObjectURLPath());

		for (int i = 0; i <= _RETRY_COUNT; i++) {
			try {
				HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

				JSONObject responseJSONObject = new JSONObject(
					httpResponse.getContent());

				if (_log.isDebugEnabled()) {
					_log.debug(
						StringUtil.combine(
							"Created ", getObjectLabel(), " ",
							String.valueOf(responseJSONObject.getLong("id")),
							" on Liferay"));
				}

				return responseJSONObject;
			}
			catch (Exception exception) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						StringUtil.combine(
							"Failed to create ", getObjectLabel(),
							"s on Liferay retry", " in ",
							String.valueOf(_RETRY_DELAY_DURATION), "ms ",
							exception.getMessage()));
				}

				ThreadUtil.sleep(_RETRY_DELAY_DURATION);
			}
		}

		return null;
	}

	protected void delete(long liferayObjectID) {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.header(
			"Authorization", _liferayOAuthConfiguration.getAuthorization());

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			StringUtil.combine(
				_liferayPortalURL, getObjectURLPath(), "/",
				String.valueOf(liferayObjectID)));

		for (int i = 0; i <= _RETRY_COUNT; i++) {
			try {
				httpInvoker.invoke();

				if (_log.isDebugEnabled()) {
					_log.debug(
						StringUtil.combine(
							"Deleted ", getObjectLabel(), " ",
							String.valueOf(liferayObjectID), " from Liferay"));
				}

				break;
			}
			catch (Exception exception) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						StringUtil.combine(
							"Failed to delete ", getObjectLabel(), " ",
							String.valueOf(liferayObjectID),
							" on Liferay retry in ",
							String.valueOf(_RETRY_DELAY_DURATION), "ms ",
							exception.getMessage()));
				}

				ThreadUtil.sleep(_RETRY_DELAY_DURATION);
			}
		}
	}

	protected String getObjectLabel() {
		throw new UnsupportedOperationException();
	}

	protected String getObjectURLPath() {
		throw new UnsupportedOperationException();
	}

	protected List<JSONObject> retrieve() {
		List<JSONObject> jsonObjects = new ArrayList<>();

		int currentPage = 1;
		int lastPage = -1;

		while (true) {
			for (int i = 0; i <= _RETRY_COUNT; i++) {
				HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

				httpInvoker.header(
					"Authorization",
					_liferayOAuthConfiguration.getAuthorization());
				httpInvoker.header("Content-Type", "application/json");

				httpInvoker.path(_liferayPortalURL + getObjectURLPath());

				httpInvoker.parameter("page", String.valueOf(currentPage));

				try {
					HttpInvoker.HttpResponse httpResponse =
						httpInvoker.invoke();

					JSONObject responseJSONObject = new JSONObject(
						httpResponse.getContent());

					lastPage = responseJSONObject.getInt("lastPage");

					JSONArray itemsJSONArray = responseJSONObject.getJSONArray(
						"items");

					if (itemsJSONArray.isEmpty()) {
						break;
					}

					for (int j = 0; j < itemsJSONArray.length(); j++) {
						jsonObjects.add(itemsJSONArray.getJSONObject(j));
					}

					break;
				}
				catch (Exception exception) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							StringUtil.combine(
								"Failed to retrieve ", getObjectLabel(),
								"s on Liferay retry in ",
								String.valueOf(_RETRY_DELAY_DURATION), "ms ",
								exception.getMessage()));
					}

					ThreadUtil.sleep(_RETRY_DELAY_DURATION);
				}
			}

			if ((currentPage >= lastPage) || (lastPage == -1)) {
				break;
			}

			currentPage++;
		}

		if (_log.isDebugEnabled()) {
			_log.debug(
				StringUtil.combine(
					"Retrieved ", String.valueOf(jsonObjects.size()), " ",
					getObjectLabel(), "s on Liferay"));
		}

		return jsonObjects;
	}

	protected JSONObject update(JSONObject requestJSONObject) {
		long liferayObjectID = requestJSONObject.getLong("id");

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(requestJSONObject.toString(), "application/json");

		httpInvoker.header(
			"Authorization", _liferayOAuthConfiguration.getAuthorization());

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			StringUtil.combine(
				_liferayPortalURL, getObjectURLPath(), "/",
				String.valueOf(liferayObjectID)));

		for (int i = 0; i <= _RETRY_COUNT; i++) {
			try {
				HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

				JSONObject responseJSONObject = new JSONObject(
					httpResponse.getContent());

				if (_log.isDebugEnabled()) {
					_log.debug(
						StringUtil.combine(
							"Updated ", getObjectLabel(), " ",
							String.valueOf(liferayObjectID), " on Liferay"));
				}

				return responseJSONObject;
			}
			catch (Exception exception) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						StringUtil.combine(
							"Failed to update ", getObjectLabel(), " ",
							String.valueOf(liferayObjectID),
							" on Liferay retry in ",
							String.valueOf(_RETRY_DELAY_DURATION), "ms ",
							exception.getMessage()));
				}

				ThreadUtil.sleep(_RETRY_DELAY_DURATION);
			}
		}

		return null;
	}

	private static final long _RETRY_COUNT = 3;

	private static final long _RETRY_DELAY_DURATION = 1000;

	private static final Log _log = LogFactory.getLog(ObjectDALO.class);

	@Autowired
	private LiferayOAuthConfiguration _liferayOAuthConfiguration;

	@Value("${liferay.portal.url}")
	private String _liferayPortalURL;

}