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

package com.liferay.portalweb.socialofficehome.tasks.task.addtaskstaskassignedtomemultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewTasksTaskAssignedToMeMultipleTest extends BaseTestCase {
	public void testViewTasksTaskAssignedToMeMultiple()
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
		assertEquals(RuntimeVariables.replace("Assigned to Me"),
			selenium.getText("link=Assigned to Me"));
		selenium.clickAt("link=Assigned to Me",
			RuntimeVariables.replace("Assigned to Me"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Task1 Description"),
			selenium.getText("link=Task1 Description"));
		selenium.clickAt("link=Task1 Description",
			RuntimeVariables.replace("Task1 Description"));
		selenium.waitForText("//h1[@class='header-title']", "Task1 Description");
		assertEquals(RuntimeVariables.replace("Task1 Description"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Assigned to Joe Bloggs"),
			selenium.getText("//div[@class='task-data assignee']"));
		assertEquals(RuntimeVariables.replace("Open"),
			selenium.getText("//div[@class='task-data status']"));
		assertEquals(RuntimeVariables.replace("Normal"),
			selenium.getText("//div[@class='task-data normal']"));
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Tasks')]/a/span",
			RuntimeVariables.replace("Tasks"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Tasks')]"));
		assertEquals(RuntimeVariables.replace("Assigned to Me"),
			selenium.getText("link=Assigned to Me"));
		selenium.clickAt("link=Assigned to Me",
			RuntimeVariables.replace("Assigned to Me"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Task2 Description"),
			selenium.getText("link=Task2 Description"));
		selenium.clickAt("link=Task2 Description",
			RuntimeVariables.replace("Task2 Description"));
		selenium.waitForText("//h1[@class='header-title']", "Task2 Description");
		assertEquals(RuntimeVariables.replace("Task2 Description"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Assigned to Joe Bloggs"),
			selenium.getText("//div[@class='task-data assignee']"));
		assertEquals(RuntimeVariables.replace("Open"),
			selenium.getText("//div[@class='task-data status']"));
		assertEquals(RuntimeVariables.replace("Normal"),
			selenium.getText("//div[@class='task-data normal']"));
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Tasks')]/a/span",
			RuntimeVariables.replace("Tasks"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Tasks')]"));
		assertEquals(RuntimeVariables.replace("Assigned to Me"),
			selenium.getText("link=Assigned to Me"));
		selenium.clickAt("link=Assigned to Me",
			RuntimeVariables.replace("Assigned to Me"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Task3 Description"),
			selenium.getText("link=Task3 Description"));
		selenium.clickAt("link=Task3 Description",
			RuntimeVariables.replace("Task3 Description"));
		selenium.waitForText("//h1[@class='header-title']", "Task3 Description");
		assertEquals(RuntimeVariables.replace("Task3 Description"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Assigned to Joe Bloggs"),
			selenium.getText("//div[@class='task-data assignee']"));
		assertEquals(RuntimeVariables.replace("Open"),
			selenium.getText("//div[@class='task-data status']"));
		assertEquals(RuntimeVariables.replace("Normal"),
			selenium.getText("//div[@class='task-data normal']"));
	}
}