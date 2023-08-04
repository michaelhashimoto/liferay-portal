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

package com.liferay.jethr0;

import com.liferay.jethr0.util.StringUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Michael Hashimoto
 */
public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println(_createProjects(5, 4));
	}

	private static JSONObject _createProject(int projectNum, int buildCount) {
		JSONObject projectJSONObject = new JSONObject();

		String projectName = "p" + projectNum;

		projectJSONObject.put("name", projectName);
		projectJSONObject.put("priority", projectNum);
		projectJSONObject.put("type", "defaultJob");

		JSONArray buildsJSONArray = new JSONArray();

		for (int i = 1; i <= buildCount; i++) {
			JSONObject parametersJSONObject = new JSONObject();

			String buildName = StringUtil.combine("p", projectNum, " - b", i);

			parametersJSONObject.put("VALUE", buildName);

			JSONObject buildJSONObject = new JSONObject();

			buildJSONObject.put("buildName", buildName);
			buildJSONObject.put("jobName", "top-level-job");
			buildJSONObject.put("parameters", parametersJSONObject);

			buildsJSONArray.put(buildJSONObject);
		}

		projectJSONObject.put("builds", buildsJSONArray);

		JSONObject messageJSONObject = new JSONObject();

		messageJSONObject.put("eventTrigger", "CREATE_PROJECT");
		messageJSONObject.put("project", projectJSONObject);

		JSONObject oAuthorizationJSONObject =
			_getOAuthAuthorizationJSONObject();

		return new JSONObject(
			WebClient.create(
				_springBootURL
			).post(
			).accept(
				MediaType.APPLICATION_JSON
			).contentType(
				MediaType.APPLICATION_JSON
			).header(
				"Authorization",
				"Bearer " + oAuthorizationJSONObject.getString("access_token")
			).body(
				BodyInserters.fromValue(messageJSONObject.toString())
			).retrieve(
			).bodyToMono(
				String.class
			).block());
	}

	private static JSONArray _createProjects(int projectCount, int buildCount) {
		JSONArray projectsJSONArray = new JSONArray();

		for (int i = projectCount; i >= 1; i--) {
			JSONObject projectJSONObject = _createProject(i, buildCount);

			projectsJSONArray.put(projectJSONObject);

			_startProject(projectJSONObject.getLong("id"));
		}

		return projectsJSONArray;
	}

	private static JSONObject _getOAuthAuthorizationJSONObject() {
		StringBuilder sb = new StringBuilder();

		sb.append(_liferayPortalURL);
		sb.append("/o/oauth2/token?");
		sb.append("client_id=" + _getOAuthClientID());
		sb.append("&client_secret=" + _liferayOAuthClientSecret);
		sb.append("&grant_type=client_credentials");

		return new JSONObject(
			WebClient.create(
				sb.toString()
			).post(
			).accept(
				MediaType.APPLICATION_JSON
			).contentType(
				MediaType.APPLICATION_FORM_URLENCODED
			).retrieve(
			).bodyToMono(
				String.class
			).block());
	}

	private static String _getOAuthClientID() {
		StringBuilder sb = new StringBuilder();

		sb.append(_liferayPortalURL);
		sb.append("/o/oauth2/application?");
		sb.append("externalReferenceCode=" + _externalReferenceCode);

		JSONObject jsonObject = new JSONObject(
			WebClient.create(
				sb.toString()
			).get(
			).accept(
				MediaType.APPLICATION_JSON
			).retrieve(
			).bodyToMono(
				String.class
			).block());

		return jsonObject.getString("client_id");
	}

	private static JSONObject _startProject(long projectId) {
		JSONObject projectJSONObject = new JSONObject();

		projectJSONObject.put("id", projectId);

		JSONObject messageJSONObject = new JSONObject();

		messageJSONObject.put("eventTrigger", "QUEUE_PROJECT");
		messageJSONObject.put("project", projectJSONObject);

		JSONObject oAuthorizationJSONObject =
			_getOAuthAuthorizationJSONObject();

		return new JSONObject(
			WebClient.create(
				_springBootURL
			).post(
			).accept(
				MediaType.APPLICATION_JSON
			).contentType(
				MediaType.APPLICATION_JSON
			).header(
				"Authorization",
				"Bearer " + oAuthorizationJSONObject.getString("access_token")
			).body(
				BodyInserters.fromValue(messageJSONObject.toString())
			).retrieve(
			).bodyToMono(
				String.class
			).block());
	}

	private static final String _externalReferenceCode =
		"liferay-jethr0-etc-spring-boot-oauth-application-headless-server";
	private static final String _liferayOAuthClientSecret =
		"mysecretpassword";
	private static final String _liferayPortalURL = "http://localhost:8080";
	private static final String _springBootURL = "http://localhost:58081";

}