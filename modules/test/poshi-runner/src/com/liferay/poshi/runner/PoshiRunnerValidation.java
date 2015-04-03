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

import com.liferay.poshi.runner.util.Validator;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * @author Karen Dang
 * @author Michael Hashimoto
 */
public class PoshiRunnerValidation {

	public static void validate(Element element, String filePath)
		throws PoshiRunnerException {

		String classType = PoshiRunnerGetterUtil.getClassTypeFromFilePath(
			filePath);

		if (classType.equals("path")) {
			_validatePathFile(element, filePath);
		}
		else {
			_validateRootElement(element, filePath);

			if (classType.equals("macro")) {
				_validateMacroFile(element, filePath);
			}
		}
	}

	private static void _parseElements(Element element, String filePath)
		throws PoshiRunnerException {

		List<Element> childElements = element.elements();

		List<String> possibleElementNames = Arrays.asList(
			"description", "echo", "execute", "fail", "for", "if",
			"take-screenshot", "task", "var", "while");

		for (Element childElement : childElements) {
			String elementName = childElement.getName();

			if (!possibleElementNames.contains(elementName)) {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Invalid " + elementName + " element\n" +
						filePath + ":" +
						childElement.attributeValue("line-number"));
			}
		}
	}

	private static void _validateMacroFile(Element element, String filePath)
		throws PoshiRunnerException {

		List<Element> childElements = element.elements();

		if (childElements.isEmpty() &&
			(element.attributeValue("extends") == null)) {

			throw new PoshiRunnerException(
				"\nBUILD FAILED: Missing child elements\n" + filePath + ":" +
					element.attributeValue("line-number"));
		}

		List<String> possibleTagElementNames = Arrays.asList("command", "var");

		for (Element childElement : childElements) {
			String childElementName = childElement.getName();

			if (!possibleTagElementNames.contains(childElementName)) {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Invalid " + childElementName +
						" element\n" + filePath + ":" +
						childElement.attributeValue("line-number"));
			}

			if (childElementName.equals("command")) {
				List<Attribute> childAttributes = childElement.attributes();

				List<String> possibleAttributes = Arrays.asList(
					"line-number", "name", "priority", "summary",
					"summary-ignore");

				boolean hasName = false;

				for (Attribute childAttribute : childAttributes) {
					String childAttributeName = childAttribute.getName();

					if (!possibleAttributes.contains(childAttributeName)) {
						throw new PoshiRunnerException(
							"\nBUILD FAILED: Invalid " + childAttributeName +
								" attribute\n" + filePath + ":" +
								childElement.attributeValue("line-number"));
					}

					if (Validator.isNull(childAttribute.getStringValue())) {
						throw new PoshiRunnerException(
							"\nBUILD FAILED: Missing attribute value\n" +
								filePath + ":" +
								childElement.attributeValue("line-number"));
					}

					if (childAttributeName.equals("name")) {
						hasName = true;
					}
				}

				if (!hasName) {
					throw new PoshiRunnerException(
						"\nBUILD FAILED: Missing \"name\" attribute\n" +
							filePath + ":" +
							childElement.attributeValue("line-number"));
				}

				_parseElements(childElement, filePath);
			}
			else {
				_validateVarElement(childElement, filePath);
			}
		}
	}

	private static void _validateVarElement(Element element, String filePath)
		throws PoshiRunnerException {

		List<Attribute> attributes = element.attributes();

		List<String> possibleAttributeNames = Arrays.asList(
			"attribute", "group", "line-number", "locator", "method", "name",
			"pattern", "value");

		boolean hasName = false;

		for (Attribute attribute : attributes) {
			String attributeName = attribute.getName();

			if (!possibleAttributeNames.contains(attributeName)) {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Invalid " + attributeName +
						" attribute\n" + filePath + ":" +
						element.attributeValue("line-number"));
			}

			if (attributeName.equals("name")) {
				hasName = true;
			}

			if (!attributeName.equals("value") &&
				Validator.isNull(attribute.getValue())) {

				throw new PoshiRunnerException(
					"\nBUILD FAILED: Missing " + attributeName +
						"attribute value in\n" + filePath + ":" +
						element.attributeValue("line-number"));
			}
		}

		if (!hasName) {
			throw new PoshiRunnerException(
				"\nBUILD FAILED: Missing \"name\" attribute \n" + filePath +
					":" + element.attributeValue("line-number"));
		}

		if (attributes.size() == 2) {
			if (Validator.isNull(element.getText())) {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Missing attribute value\n" + filePath +
						":" + element.attributeValue("line-number"));
			}
		}
	}

	private static void _validatePathFile(Element element, String filePath)
		throws PoshiRunnerException {

		String rootElementName = element.getName();

		if (!StringUtils.equals(rootElementName, "html")) {
			throw new PoshiRunnerException(
				"\nBUILD FAILED: Invalid " + rootElementName + " element\n" +
					filePath + ":" + element.attributeValue("line-number"));
		}

		List<Element> childElements = element.elements();

		if (childElements.isEmpty()) {
			throw new PoshiRunnerException(
				"\nBUILD FAILED: Missing child elements\n" + filePath + ":" +
					element.attributeValue("line-number"));
		}
	}

	private static void _validateRootElement(Element element, String filePath)
		throws PoshiRunnerException {

		String classType = PoshiRunnerGetterUtil.getClassTypeFromFilePath(
			filePath);
		String elementName = element.getName();

		if (!StringUtils.equals(elementName, "definition")) {
			throw new PoshiRunnerException(
				"\nBUILD FAILED: Invalid " +
					elementName + " element\n" + filePath + ":" +
					element.attributeValue("line-number"));
		}

		List<Attribute> attributes = element.attributes();

		for (Attribute attribute : attributes) {
			if (Validator.isNull(attribute.getValue())) {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Missing attribute value\n" + filePath +
						":" + element.attributeValue("line-number"));
			}

			String attributeName = attribute.getName();

			if ((attributeName.equals("component-name") ||
				 attributeName.equals("ignore") ||
				 attributeName.equals("ignore-command-names")) &&
				classType.equals("testcase")) {

				continue;
			}
			else if (attributeName.equals("extends") &&
					 (classType.equals("macro") ||
					  classType.equals("testcase"))) {

				continue;
			}
			else if (attributeName.equals("default") &&
					 classType.equals("function")) {

				continue;
			}
			else if (attributeName.equals("line-number")) {
				continue;
			}
			else {
				throw new PoshiRunnerException(
					"\nBUILD FAILED: Invalid \"" + attributeName +
						"\" attribute\n" + filePath + ":" +
						element.attributeValue("line-number"));
			}
		}
	}

}