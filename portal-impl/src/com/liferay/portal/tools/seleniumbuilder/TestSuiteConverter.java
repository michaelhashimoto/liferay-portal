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

package com.liferay.portal.tools.seleniumbuilder;

import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class TestSuiteConverter extends BaseConverter {

	public TestSuiteConverter(SeleniumBuilderContext seleniumBuilderContext) {
		super(seleniumBuilderContext);
	}

	public void convert(String testSuiteName) throws Exception {
		Map<String, Object> context = getContext();

		context.put("macroNameStack", new FreeMarkerStack());
		context.put("testSuiteName", testSuiteName);

		String javaContent = processTemplate("test_suite.ftl", context);

		seleniumBuilderFileUtil.writeFile(
			seleniumBuilderContext.getTestSuiteJavaFileName(testSuiteName),
			javaContent, true);

		String htmlContent = processTemplate("test_suite_html.ftl", context);

		seleniumBuilderFileUtil.writeFile(
			seleniumBuilderContext.getTestSuiteHTMLFileName(testSuiteName),
			htmlContent, false);
	}

}