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

import java.util.Map;

import org.dom4j.Element;

/**
 * @author Karen Dang
 * @author Michael Hashimoto
 */
public class PoshiRunnerValidation {

	public static void validate() throws PoshiRunnerException {
		Map<String, Element> rootElements =
			PoshiRunnerContext.getRootElementsMap();

		for (Map.Entry<String, Element> entry : rootElements.entrySet()) {
			String key = entry.getKey();
			Element element = entry.getValue();

			String filePath = _getFilePath(key);

			_validateRootElement(element, filePath);
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

	private static void _validateRootElement(Element element, String filePath)
		throws PoshiRunnerException {

		if (!element.getName().equals("definition")) {
			throw new PoshiRunnerException(
				"\nBUILD FAILED: Root element is not \"definition\"\n" +
				filePath + ":" + element.attributeValue("line-number"));
		}
	}

}