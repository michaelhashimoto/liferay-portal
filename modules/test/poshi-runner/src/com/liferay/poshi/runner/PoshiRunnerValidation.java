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

package com.liferay.poshi.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * @author Karen Dang
 * @author Michael Hashimoto
 */
public class PoshiRunnerValidation {

	public static void validate() throws PoshiRunnerException {
		Map<String, Element> commandElements =
			PoshiRunnerContext.getCommandElementsMap();

		for (Map.Entry<String, Element> entry : commandElements.entrySet()) {
			String key = entry.getKey();
			Element element = entry.getValue();

			String filePath = _getFilePath(key);

			_validateCommandElement(element, filePath);

			_validateCommandChildElement(element, filePath);
		}
	}

	private static String _getFilePath(String key) {
		int hash = key.indexOf("#");
		int hash2 = key.length();

		if (key.matches(".*#.*#.*")) {
			hash2 = key.indexOf("#", hash + 1);
		}

		String classType = key.substring(0, hash);
		String className = key.substring(hash + 1, hash2);

		return PoshiRunnerContext.getFilePath(className + "." + classType);
	}

	private static void _validateCommandChildElement(
			Element element, String filePath)
		throws PoshiRunnerException {

		List<Element> childElements = element.elements();

		if (childElements.isEmpty()) {
			throw new PoshiRunnerException(
				"\nBUILD FAILED: Missing child element\n" + filePath + ":" +
				element.attributeValue("line-number"));
		}

		for (Element childElement : childElements) {
			List<String> possibleChildElements = Arrays.asList(
				"case", "default", "description", "echo", "execute", "fail",
				"for", "if", "property", "take-screenshot", "var", "while");

			if (!possibleChildElements.contains(childElement.getName())) {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Invalid child element\n" + filePath + ":" +
					childElement.attributeValue("line-number"));
			}
		}
	}

	private static void _validateCommandElement(
			Element element, String filePath)
		throws PoshiRunnerException {

		List<Attribute> attributes = element.attributes();

		for (Attribute attribute : attributes) {
			List<String> possibleAttributes = Arrays.asList(
				"description", "known-issues", "line-number", "name",
				"priority", "summary"
			);

			if (!possibleAttributes.contains(attribute.getName())) {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Not a valid attribute name \"" +
					attribute.getName() + "\"\n" + filePath + ":" +
					element.attributeValue("line-number"));
			}

			if (attribute.getValue() == "") {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: No attribute value\n" +
					filePath + ":" + element.attributeValue("line-number"));
			}
		}
	}

}