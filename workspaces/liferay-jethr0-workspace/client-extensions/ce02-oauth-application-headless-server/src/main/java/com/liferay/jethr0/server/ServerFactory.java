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

import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Michael Hashimoto
 */
@Configuration
public class ServerFactory {

	public JenkinsServer newJenkinsServer(String jenkinsHostname) {
		try {
			Matcher matcher = _jenkinsHostnamePattern.matcher(jenkinsHostname);

			if (!matcher.find()) {
				throw new RuntimeException(
					"Invalid Jenkins hostname " + jenkinsHostname);
			}

			URL url = new URL(
				"https://" + matcher.group("localHostname") + ".liferay.com");

			if (_jenkinsServers.containsKey(url)) {
				return _jenkinsServers.get(url);
			}

			JenkinsServer jenkinsServer = new JenkinsServer(
				url, _jenkinsPassword, _jenkinsToken, _jenkinsUserName);

			_jenkinsServers.put(url, jenkinsServer);

			return jenkinsServer;
		}
		catch (MalformedURLException malformedURLException) {
			throw new RuntimeException(malformedURLException);
		}
	}

	private static final Pattern _jenkinsHostnamePattern = Pattern.compile(
		"(?<localHostname>test-\\d-\\d)(\\.liferay\\.com)");

	@Value("${jenkins.password}")
	private String _jenkinsPassword;

	private final Map<URL, JenkinsServer> _jenkinsServers = new HashMap<>();

	@Value("${jenkins.token}")
	private String _jenkinsToken;

	@Value("${jenkins.user.name}")
	private String _jenkinsUserName;

}