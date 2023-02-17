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

import java.net.URL;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Base64Utils;

import reactor.core.publisher.Mono;

/**
 * @author Michael Hashimoto
 */
public class JenkinsServer extends BaseServer {

	public String invoke(String jobName, Map<String, String> buildParameters) {
		Mono<String> stringMono = invokeMono(jobName, buildParameters);

		return stringMono.block();
	}

	public Mono<String> invokeMono(
		String jobName, Map<String, String> buildParameters) {

		Map<String, String> headers = new HashMap<>();

		headers.put("Authorization", _getAuthorizationHeader());

		Map<String, String> parameters = new HashMap<>();

		parameters.put("token", _jenkinsToken);

		if (buildParameters != null) {
			parameters.putAll(buildParameters);
		}

		return httpRequestMono(
			"/job/" + jobName + "/buildWithParameters", headers, Method.GET,
			parameters, null);
	}

	protected JenkinsServer(
		URL url, String jenkinsPassword, String jenkinsToken,
		String jenkinsUserName) {

		super(url);

		_jenkinsPassword = jenkinsPassword;
		_jenkinsToken = jenkinsToken;
		_jenkinsUserName = jenkinsUserName;
	}

	private String _getAuthorizationHeader() {
		String authorization = _jenkinsUserName + ":" + _jenkinsPassword;

		return "Basic " + Base64Utils.encode(authorization.getBytes());
	}

	private final String _jenkinsPassword;
	private final String _jenkinsToken;
	private final String _jenkinsUserName;

}