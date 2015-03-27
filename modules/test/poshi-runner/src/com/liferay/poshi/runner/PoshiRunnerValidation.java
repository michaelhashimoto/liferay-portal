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

		String className = PoshiRunnerGetterUtil.getClassNameFromFilePath(
			filePath);

		for (Element childElement : childElements) {
			if (StringUtils.equals(childElement.getName(), "body")) {
				List<Element> tableElements = childElement.elements();

				if (tableElements.isEmpty()) {
					throw new PoshiRunnerException(
						"\nBUILD FAILED: Missing child elements\n" +
						filePath + ":" +
						childElement.attributeValue("line-number"));
				}

				for (Element tableElement : tableElements) {
					if (!StringUtils.equals(tableElement.getName(), "table") ||
						(tableElement == null)) {

						throw new PoshiRunnerException(
							"\nBUILD FAILED: Missing or invalid table element" +
							filePath + ":" +
							childElement.attributeValue("line-number"));
					}
					else {
						List<Attribute> tableAttributes =
							tableElement.attributes();

						for (Attribute tableAttribute : tableAttributes) {
							String attributeName = tableAttribute.getName();

							List<String> possibleAttributes = Arrays.asList(
								"border", "cellpadding", "cellspacing",
								"line-number");

							if (!possibleAttributes.contains(attributeName)) {
								throw new PoshiRunnerException(
									"\nBUILD FAILED: Invalid attribute in " +
									"table element\n" + filePath + ":" +
									tableElement.attributeValue("line-number"));
							}
						}

						List<Element> tableChildElements =
							tableElement.elements();

						if (tableChildElements.isEmpty()) {
							throw new PoshiRunnerException(
								"\nBUILD FAILED: Missing child elements\n" +
								filePath + ":" +
								tableElement.attributeValue("line-number"));
						}

						Element tBodyElement = tableElement.element("tbody");

						List<Element> trElements = tBodyElement.elements("tr");

						for (Element trElement : trElements) {
							List<Element> tdElements = trElement.elements();

							if (tdElements.size() != 3) {
								throw new PoshiRunnerException(
									"\nBUILD FAILED: <tr> must have 3 " +
									"<td> following it\n" + filePath + ":" +
									trElement.attributeValue("line-number"));
							}

							Element descriptionElement = tdElements.get(2);
							Element locatorKeyElement = tdElements.get(0);
							Element locatorElement = tdElements.get(1);

							String description = descriptionElement.getText();
							String locator = locatorElement.getText();
							String locatorKey = locatorKeyElement.getText();

							if ((description == "") && (locator == "") &&
								(locatorKey == "")) {

								continue;
							}
							else if ((description != "") && (locator != "") &&
									 (locatorKey != "")) {

								continue;
							}
							else if ((description == "") && (locator != "") &&
									 (locatorKey != "")) {

								continue;
							}
							else {
								throw new PoshiRunnerException(
									"\nBUILD FAILED: Invalid or missing " +
									"locator text\n" + filePath + ":" +
									trElement.attributeValue("line-number"));
							}
						}

						Element theadElement = tableElement.element("thead");

						List<Element> theadChildElements =
							theadElement.elements();

						if (theadChildElements.size() > 1) {
							throw new PoshiRunnerException(
								"\nBUILD FAILED: Too many child elements\n" +
								filePath + ":" +
								theadElement.attributeValue("line-number"));
						}
						else {
							Element theadChildElement = theadChildElements.get(
								0);

							List<Element> tdElements =
								theadChildElement.elements();

							if (tdElements.size() > 1) {
								throw new PoshiRunnerException(
									"\nBUILD FAILED: Too many child elements" +
									"\n" + filePath + ":" +
									theadChildElement.attributeValue(
										"line-number"));
							}
							else {
								Element tdElement = tdElements.get(0);

								List<Attribute> attributes =
									tdElement.attributes();

								for (Attribute attribute : attributes) {
									String attributeName = attribute.getName();

									List<String> possibleAttributes =
										Arrays.asList("colspan", "rowspan");

									if (!possibleAttributes.contains(
											attributeName)) {

										throw new PoshiRunnerException(
											"\nBUILD FAILED: Invalid " +
											"attribute \"" + attributeName +
											"\"\n" + filePath + ":" +
											theadChildElement.attributeValue(
												"line-number"));
									}
								}

								String text = tdElement.getText();

								if ((text == "") || (text == null)) {
									throw new PoshiRunnerException(
										"\nBUILD FAILED: Missing file name" +
										"\n" + filePath + ":" +
										theadChildElement.attributeValue(
											"line-number"));
								}
								else if (!text.equals(className)) {
									throw new PoshiRunnerException(
										"\nBUILD FAILED: File name and text " +
										"are different\n" + filePath + ":" +
										theadChildElement.attributeValue(
											"line-number"));
								}
							}
						}
					}
				}
			}
			else if (StringUtils.equals(childElement.getName(), "head")) {
				List<Element> headChildElements = childElement.elements();

				if (headChildElements.size() > 1) {
					throw new PoshiRunnerException(
						"\nBUILD FAILED: Too many child elements\n" + filePath +
						":" + childElement.attributeValue("line-number"));
				}

				Element headChildElement = headChildElements.get(0);

				String name = headChildElement.getName();

				if (!StringUtils.equals(name, "title")) {
					throw new PoshiRunnerException(
						"\nBUILD FAILED: Invalid " + name + " element\n"+
						filePath + ":" +
						childElement.attributeValue("line-number"));
				}
				else if (!StringUtils.equals(
							headChildElement.getText(), className)) {

					throw new PoshiRunnerException(
						"\nBUILD FAILED: File name and title are different\n" +
						filePath + ":" +
						headChildElement.attributeValue("line-number"));
				}
			}
		}
	}

}