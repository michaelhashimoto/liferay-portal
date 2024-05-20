/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.object.actions;

import com.liferay.client.extension.util.spring.boot.LiferayOAuth2AccessTokenManager;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Michael Hashimoto
 */
@Configuration
public class ObjectActions {

	public void block() {
		String result = WebClient.create(
			"http://localhost:8080/o/c/childentities"
		).get(
		).accept(
			MediaType.APPLICATION_JSON
		).header(
			"Authorization", _getAuthorization()
		).retrieve(
		).bodyToMono(
			String.class
		).block();

		JSONObject jsonObject = new JSONObject(result);

		System.out.println("---BLOCK---\n" + jsonObject);
	}

	public void subscribe() {
		WebClient.create(
			"http://localhost:8080/o/c/childentities"
		).get(
		).accept(
			MediaType.APPLICATION_JSON
		).header(
			"Authorization", _getAuthorization()
		).retrieve(
		).bodyToMono(
			String.class
		).subscribe(
			response -> System.out.println(
				"---SUBSCRIBE---\n" + new JSONObject(response))
		);
	}

	private String _getAuthorization() {
		return _liferayOAuth2AccessTokenManager.getAuthorization(
			"liferay-object-actions-etc-spring-boot-oauth-application-" +
				"headless-server");
	}

	@Autowired
	private LiferayOAuth2AccessTokenManager _liferayOAuth2AccessTokenManager;

}