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

package com.liferay.portalweb.socialofficehome.activities.dashboardactivity.viewdashboardactivityactivities;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTasksTaskAssignedToConnectionTest extends BaseTestCase {
	public void testAddTasksTaskAssignedToConnection()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Tasks')]/a/span",
			RuntimeVariables.replace("Tasks"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Tasks')]"));
		assertEquals(RuntimeVariables.replace("Add Task"),
			selenium.getText("link=Add Task"));
		selenium.clickAt("link=Add Task", RuntimeVariables.replace("Add Task"));
		selenium.waitForVisible("//input[@id='_1_WAR_tasksportlet_title']");
		selenium.type("//input[@id='_1_WAR_tasksportlet_title']",
			RuntimeVariables.replace("Connection Task Description"));
		selenium.select("//select[@name='_1_WAR_tasksportlet_assigneeUserId']",
			RuntimeVariables.replace("label=Social01 Office01 User01"));
		selenium.select("//select[@name='_1_WAR_tasksportlet_priority']",
			RuntimeVariables.replace("label=Normal"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//h1[@class='header-title']",
			"Connection Task Description");
		assertEquals(RuntimeVariables.replace("Connection Task Description"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace(
				"Assigned to Social01 Office01 User01"),
			selenium.getText("//div[@class='task-data assignee']"));
	}
}