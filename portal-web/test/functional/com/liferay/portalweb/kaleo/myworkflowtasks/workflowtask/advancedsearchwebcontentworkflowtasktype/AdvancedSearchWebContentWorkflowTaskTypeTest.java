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

package com.liferay.portalweb.kaleo.myworkflowtasks.workflowtask.advancedsearchwebcontentworkflowtasktype;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchWebContentWorkflowTaskTypeTest extends BaseTestCase {
	public void testAdvancedSearchWebContentWorkflowTaskType()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=My Workflow Tasks",
					RuntimeVariables.replace("My Workflow Tasks"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Pending",
					RuntimeVariables.replace("Pending"));
				selenium.waitForPageToLoad("30000");

				boolean advancedVisible = selenium.isVisible(
						"link=Advanced \u00bb");

				if (!advancedVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Advanced \u00bb",
					RuntimeVariables.replace("Advanced \u00bb"));

			case 2:
				selenium.waitForVisible("//select[@id='_153_andOperator']");
				selenium.select("//select[@id='_153_andOperator']",
					RuntimeVariables.replace("label=Any"));
				selenium.type("//input[@id='_153_name']",
					RuntimeVariables.replace(""));
				selenium.select("//select[@id='_153_type']",
					RuntimeVariables.replace("label=Web Content"));
				selenium.clickAt("xPath=(//input[@value='Search'])[2]",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"There are no pending tasks assigned to you with the specified search criteria."),
					selenium.getText("//div[@class='portlet-msg-info']"));
				assertEquals(RuntimeVariables.replace("Review"),
					selenium.getText("//td[1]/a"));
				assertEquals(RuntimeVariables.replace("Web Content Name"),
					selenium.getText("//td[2]/a"));
				assertEquals(RuntimeVariables.replace("Web Content"),
					selenium.getText("//td[3]/a"));
				assertTrue(selenium.isElementPresent("//td[4]/a"));
				assertEquals(RuntimeVariables.replace("Never"),
					selenium.getText("//td[5]/a"));
				selenium.select("//select[@id='_153_type']",
					RuntimeVariables.replace("label=Blogs Entry"));
				selenium.clickAt("xPath=(//input[@value='Search'])[2]",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertFalse(selenium.isTextPresent("Web Content Name"));
				assertEquals(RuntimeVariables.replace(
						"There are no pending tasks assigned to you with the specified search criteria."),
					selenium.getText(
						"xPath=(//div[@class='portlet-msg-info'])[1]"));
				assertEquals(RuntimeVariables.replace(
						"There are no pending tasks assigned to your roles with the specified search criteria."),
					selenium.getText(
						"xPath=(//div[@class='portlet-msg-info'])[2]"));
				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace("\u00ab Basic"));

			case 100:
				label = -1;
			}
		}
	}
}