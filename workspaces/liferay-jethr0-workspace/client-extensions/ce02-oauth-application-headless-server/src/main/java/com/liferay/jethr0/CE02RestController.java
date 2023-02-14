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

import com.liferay.jethr0.server.LiferayServer;
import com.liferay.jethr0.server.Server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael Hashimoto
 */
@RestController
public class CE02RestController {

	@GetMapping("/")
	public ResponseEntity<String> home(Jwt jwt) {
		JSONObject jsonObject = new JSONObject(
			_liferayServer.httpRequest(
				"/o/c/tasks", null, jwt, Server.Method.GET, null, null));

		if (_log.isInfoEnabled()) {
			_log.info("Return: " + jsonObject);
		}

		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.CREATED);
	}

	private static final Log _log = LogFactory.getLog(CE02RestController.class);

	@Autowired
	private LiferayServer _liferayServer;

}