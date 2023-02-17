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

package com.liferay.jethr0.server;

import com.liferay.jethr0.util.ThreadUtil;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * @author Michael Hashimoto
 */
public class LiferayServer extends BaseServer {

	public List<String> getAllowedOrigins() {
		List<String> allowedOrigins = new ArrayList<>();

		for (String liferayPortalDomain :
				_liferayPortalDomains.split("\\s*[,\n]\\s*")) {

			allowedOrigins.add("http://" + liferayPortalDomain);
			allowedOrigins.add("https://" + liferayPortalDomain);
		}

		return allowedOrigins;
	}

	public URL getJWKSetURL() {
		try {
			return new URL(getURL() + "/o/oauth2/jwks");
		}
		catch (MalformedURLException malformedURLException) {
			throw new RuntimeException(malformedURLException);
		}
	}

	public OAuth2TokenValidator<Jwt> getOAuth2TokenValidator() {
		return _oAuth2TokenValidator;
	}

	public String getOAuthClientID() {
		if (_oAuthClientID != null) {
			return _oAuthClientID;
		}

		Map<String, String> parameters = new HashMap<>();

		parameters.put(
			"externalReferenceCode",
			_liferayOAuthApplicationExternalReferenceCode);

		while (true) {
			try {
				JSONObject responseJSONObject = new JSONObject(
					httpRequest(
						"/o/oauth2/application", null, Method.GET, parameters,
						null));

				_oAuthClientID = responseJSONObject.getString("client_id");
			}
			catch (Throwable throwable) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to get client ID: " + throwable.getMessage());
				}

				ThreadUtil.sleep(1000);
			}

			break;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Using Liferay OAuth Client ID " + _oAuthClientID);
		}

		return _oAuthClientID;
	}

	@Override
	public URL getURL() {
		try {
			return new URL(_liferayPortalURL);
		}
		catch (MalformedURLException malformedURLException) {
			throw new RuntimeException(malformedURLException);
		}
	}

	private static final Log _log = LogFactory.getLog(LiferayServer.class);

	@Value("${liferay.oauth.application.external.reference.code}")
	private String _liferayOAuthApplicationExternalReferenceCode;

	@Value("${liferay.portal.domains}")
	private String _liferayPortalDomains;

	@Value("${liferay.portal.url}")
	private String _liferayPortalURL;

	private final OAuth2TokenValidator<Jwt> _oAuth2TokenValidator =
		new LiferayOAuth2TokenValidator();
	private String _oAuthClientID;

	private class LiferayOAuth2TokenValidator
		implements OAuth2TokenValidator<Jwt> {

		@Override
		public OAuth2TokenValidatorResult validate(Jwt jwt) {
			if (Objects.equals(
					jwt.getClaimAsString("client_id"), getOAuthClientID())) {

				return OAuth2TokenValidatorResult.success();
			}

			return OAuth2TokenValidatorResult.failure(_oAuth2Error);
		}

		private final OAuth2Error _oAuth2Error = new OAuth2Error(
			"invalid_token", "The client_id does not match", null);

	}

}