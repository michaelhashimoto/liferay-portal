/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portalweb.portal.util.block.action;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portalweb.portal.util.liferayselenium.LiferaySelenium;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Hashimoto
 */
public class BaseAction {

	public BaseAction(LiferaySelenium liferaySelenium) {
		this.liferaySelenium = liferaySelenium;
	}

	protected String getDescription(
			String description, String paramCount, String locator,
			String locatorKey, String value, Map<String, String> variables)
		throws Exception {

		Pattern pattern = Pattern.compile(
			".*(\\$\\{locator" + paramCount + "}).*");

		Matcher matcher = pattern.matcher(description);

		if ((locatorKey != null) && pathDescriptions.containsKey(locatorKey)) {
			while (matcher.find()) {
				description = StringUtil.replace(
					description, matcher.group(1),
					"<b>" + pathDescriptions.get(locatorKey) + "</b>");
			}
		}

		if (locator != null) {
			while (matcher.find()) {
				description = StringUtil.replace(
					description, matcher.group(1), "<b>" + locator + "</b>");
			}
		}

		pattern = Pattern.compile(".*(\\$\\{value" + paramCount + "}).*");

		matcher = pattern.matcher(description);

		while (matcher.find()) {
			description = StringUtil.replace(
				description, matcher.group(1), "<b>" + value + "</b>");
		}

		return description;
	}

	protected String getLocator(
			String locator, String locatorKey, Map<String, String> variables)
		throws Exception {

		if (locator != null) {
			return locator;
		}

		if (pathLocators.containsKey(locatorKey)) {
			String locatorValue = pathLocators.get(locatorKey);

			if (locatorValue.contains("${") && locatorValue.contains("}")) {
				String regex = "\\$\\{[^}]*?\\}";

				Pattern pattern = Pattern.compile(regex);

				Matcher matcher = pattern.matcher(locatorValue);

				while (matcher.find()) {
					String variable = matcher.group();

					int x = variable.indexOf("${");
					int y = variable.indexOf("}");

					String variableKey = variable.substring(x + 2, y);

					if (variables.containsKey(variableKey)) {
						locatorValue = locatorValue.replaceFirst(
							regex, variables.get(variableKey));
					}
					else {
						throw new Exception(
							"Variable \"" + variableKey + "\" found in \"" +
								pathLocators.get(locatorKey) + "\" is not set");
					}
				}
			}

			return locatorValue;
		}

		return locatorKey;
	}

	protected LiferaySelenium liferaySelenium;
	protected Map<String, String> pathDescriptions =
		new HashMap<String, String>();
	protected Map<String, String> pathLocators = new HashMap<String, String>();

}