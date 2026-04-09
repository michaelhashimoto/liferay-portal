/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.onepassword;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class OnePasswordFactory {

	public static OnePasswordConnect newOnePasswordConnect(URL url) {
		if (url == null) {
			return null;
		}

		OnePasswordConnect onePasswordConnect = _onePasswordConnects.get(url);

		if (onePasswordConnect == null) {
			onePasswordConnect = new BaseOnePasswordConnect(url);

			_onePasswordConnects.put(url, onePasswordConnect);
		}

		return onePasswordConnect;
	}

	private static final Map<URL, OnePasswordConnect> _onePasswordConnects =
		new HashMap<>();

}