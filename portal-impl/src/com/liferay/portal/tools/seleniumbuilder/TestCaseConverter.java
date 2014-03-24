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
public class TestCaseConverter extends BaseConverter {

	public TestCaseConverter(
		SeleniumBuilderContext seleniumBuilderContext,
		SeleniumBuilderFileUtil seleniumBuilderFileUtil) {

		super(seleniumBuilderContext, seleniumBuilderFileUtil);
	}

	public void convert(String testCaseName, String testCaseCommandName)
		throws Exception {

		Map<String, Object> context = getContext();

		context.put("blockLevelStack", new FreeMarkerStack());
		context.put("elementsStack", new FreeMarkerStack());
		context.put("forParameterStack", new FreeMarkerStack());
		context.put("ifTypeStack", new FreeMarkerStack());
		context.put("logicalOperatorElementStack", new FreeMarkerStack());
		context.put("macroNameStack", new FreeMarkerStack());
		context.put("testCaseCommandName", testCaseCommandName);
		context.put("testCaseNameStack", new FreeMarkerStack());
		context.put("testCaseName", testCaseName);
		context.put("variableContextStack", new FreeMarkerStack());

		String javaContent = processTemplate("test_case.ftl", context);

		seleniumBuilderFileUtil.writeFile(
			seleniumBuilderContext.getTestCaseJavaFileName(testCaseName),
			javaContent, true);

		String htmlContent = processTemplate("test_case_html.ftl", context);

		seleniumBuilderFileUtil.writeFile(
			seleniumBuilderContext.getTestCaseHTMLFileName(testCaseName),
			htmlContent, false);
	}

}