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

package com.liferay.portalweb.kaleo.mysubmissions.workflowtask.resubmittaskwebcontentdetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ResubmitTaskWebContentDetailsTest extends BaseTestCase {
	public void testResubmitTaskWebContentDetails() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=My Submissions",
					RuntimeVariables.replace("My Submissions"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Pending",
					RuntimeVariables.replace("Pending"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Single Approver"),
					selenium.getText("//td[1]/a"));
				assertEquals(RuntimeVariables.replace("Web Content Name"),
					selenium.getText("//td[2]/a"));
				assertEquals(RuntimeVariables.replace("Web Content"),
					selenium.getText("//td[3]/a"));
				assertEquals(RuntimeVariables.replace("Update"),
					selenium.getText("//td[4]/a"));
				assertTrue(selenium.isElementPresent("//td[5]/a"));
				assertEquals(RuntimeVariables.replace("Never"),
					selenium.getText("//td[6]/a"));
				selenium.clickAt("//td[2]/a",
					RuntimeVariables.replace("Web Content Name"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Update"),
					selenium.getText("//tr[3]/td[1]"));
				assertEquals(RuntimeVariables.replace("Never"),
					selenium.getText("//tr[3]/td[2]"));
				assertEquals(RuntimeVariables.replace("No"),
					selenium.getText("//tr[3]/td[3]"));
				assertEquals(RuntimeVariables.replace("Resubmit"),
					selenium.getText("//td[4]/span/a/span"));
				selenium.clickAt("//td[4]/span/a/span",
					RuntimeVariables.replace("Resubmit"));
				selenium.waitForVisible("//div[3]/span/span/button");
				selenium.clickAt("//div[3]/span/span/button",
					RuntimeVariables.replace("OK"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForText("//div[@class='portlet-msg-success']",
					"Your request completed successfully.");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

				boolean expandButtonPresent = selenium.isElementPresent(
						"//a[@title='Expand']");

				if (!expandButtonPresent) {
					label = 2;

					continue;
				}

				selenium.click("//a[@title='Expand']");

			case 2:
				assertEquals(RuntimeVariables.replace(
						"Task initially assigned to the Administrator role."),
					selenium.getText(
						"xPath=(//div[@class='task-activity task-type-1'])[4]/div[2]"));
				assertEquals(RuntimeVariables.replace("Assigned initial task."),
					selenium.getText(
						"xPath=(//div[@class='task-activity task-type-1'])[4]/div[3]"));

			case 100:
				label = -1;
			}
		}
	}
}