/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.object.actions;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael Hashimoto
 */
@RestController
public class ObjectActionsRestController {

	@PostMapping("/object-actions")
	public ResponseEntity<String> action(
			@AuthenticationPrincipal Jwt jwt, @RequestBody String body)
		throws Exception {

		System.out.println("---REQUEST---\n" + new JSONObject(body));

		_objectActions.subscribe();
		_objectActions.block();

		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@Autowired
	private ObjectActions _objectActions;

}