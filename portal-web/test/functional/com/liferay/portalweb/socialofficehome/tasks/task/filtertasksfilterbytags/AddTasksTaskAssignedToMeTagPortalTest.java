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

package com.liferay.portalweb.socialofficehome.tasks.task.filtertasksfilterbytags;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTasksTaskAssignedToMeTagPortalTest extends BaseTestCase {
	public void testAddTasksTaskAssignedToMeTagPortal()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Tasks Test Page",
			RuntimeVariables.replace("Tasks Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("No tasks were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals(RuntimeVariables.replace("Add Task"),
			selenium.getText("link=Add Task"));
		selenium.clickAt("link=Add Task", RuntimeVariables.replace("Add Task"));
		selenium.waitForVisible("//input[@id='_1_WAR_tasksportlet_title']");
		selenium.type("//input[@id='_1_WAR_tasksportlet_title']",
			RuntimeVariables.replace("Portal Task Description"));
		selenium.select("//select[@name='_1_WAR_tasksportlet_assigneeUserId']",
			RuntimeVariables.replace("label=Joe Bloggs"));
		selenium.select("//select[@name='_1_WAR_tasksportlet_priority']",
			RuntimeVariables.replace("label=Normal"));
		selenium.waitForVisible("//input[@title='Add Tags']");
		selenium.type("//input[@title='Add Tags']",
			RuntimeVariables.replace("PortalTag1"));
		selenium.waitForVisible("//button[@id='add']");
		selenium.clickAt("//button[@id='add']", RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//li[contains(.,'Tag1')]/span/span");
		assertEquals(RuntimeVariables.replace("PortalTag1"),
			selenium.getText("//li[contains(.,'Tag1')]/span/span"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//h1[@class='header-title']",
			"Portal Task Description");
		assertEquals(RuntimeVariables.replace("Portal Task Description"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Assigned to Joe Bloggs"),
			selenium.getText("//div[@class='task-data assignee']"));
		assertEquals(RuntimeVariables.replace("portaltag1"),
			selenium.getText("//span[@class='tag']"));
	}
}