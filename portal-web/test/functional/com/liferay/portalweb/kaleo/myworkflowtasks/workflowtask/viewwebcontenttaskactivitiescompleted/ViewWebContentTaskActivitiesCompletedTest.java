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

package com.liferay.portalweb.kaleo.myworkflowtasks.workflowtask.viewwebcontenttaskactivitiescompleted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentTaskActivitiesCompletedTest extends BaseTestCase {
	public void testViewWebContentTaskActivitiesCompleted()
		throws Exception {
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
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/div[2]/div[1]/div/span",
			RuntimeVariables.replace("Activities"));
		assertEquals(RuntimeVariables.replace(
				"Task initially assigned to the Administrator role."),
			selenium.getText("//div[2]/div[2]/div[1]/div[2]"));
		assertEquals(RuntimeVariables.replace("Assigned initial task."),
			selenium.getText("//div[2]/div[2]/div[1]/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText("//div[2]/div[2]/div[2]/div[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs completed the task Review."),
			selenium.getText("//div[2]/div[2]/div[3]/div[2]"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=My Submissions",
			RuntimeVariables.replace("My Submissions"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/div[2]/div[1]/div",
			RuntimeVariables.replace("Activities"));
		assertEquals(RuntimeVariables.replace(
				"Task initially assigned to the Administrator role."),
			selenium.getText("//div[2]/div[2]/div[1]/div[2]"));
		assertEquals(RuntimeVariables.replace("Assigned initial task."),
			selenium.getText("//div[2]/div[2]/div[1]/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText("//div[2]/div[2]/div[2]/div[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs completed the task Review."),
			selenium.getText("//div[2]/div[2]/div[3]/div[2]"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Workflow", RuntimeVariables.replace("Workflow"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Submissions",
			RuntimeVariables.replace("Submissions"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/div[3]/div[1]/div",
			RuntimeVariables.replace("Activities"));
		assertEquals(RuntimeVariables.replace(
				"Task initially assigned to the Administrator role."),
			selenium.getText("//div[3]/div[2]/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Assigned initial task."),
			selenium.getText("//div[3]/div[2]/div/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText("//div[3]/div[2]/div[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs completed the task Review."),
			selenium.getText("//div[3]/div[2]/div[3]/div[2]"));
	}
}