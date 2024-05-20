/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.object.actions;

import com.liferay.client.extension.util.spring.boot.ClientExtensionUtilSpringBootComponentScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author Michael Hashimoto
 */
@Import(ClientExtensionUtilSpringBootComponentScan.class)
@SpringBootApplication
public class ObjectActionsSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
			SpringApplication.run(
				ObjectActionsSpringBootApplication.class, args);

		ObjectActions objectActions = configurableApplicationContext.getBean(
			ObjectActions.class);

		objectActions.block();
		objectActions.subscribe();
	}

}