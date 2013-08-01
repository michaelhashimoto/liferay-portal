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

package com.liferay.portalweb.socialofficehome.tasks.task.edittaskstaskassignedtomecomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditTasksTaskAssignedToMeCommentTest extends BaseTestCase {
	public void testEditTasksTaskAssignedToMeComment()
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
		assertEquals(RuntimeVariables.replace("Task Description"),
			selenium.getText("link=Task Description"));
		selenium.clickAt("link=Task Description",
			RuntimeVariables.replace("Task Description"));
		selenium.waitForText("//h1[@class='header-title']", "Task Description");
		assertEquals(RuntimeVariables.replace("Task Description"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Assigned to Joe Bloggs"),
			selenium.getText("//div[@class='task-data assignee']"));
		assertEquals(RuntimeVariables.replace("Task Comment"),
			selenium.getText("//div[@class='comment-body']/span"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("link=Edit"));
		selenium.clickAt("link=Edit", RuntimeVariables.replace("Edit"));
		assertEquals("Task Comment",
			selenium.getValue("//textarea[@class='comment-form']"));
		selenium.sendKeys("//textarea[@class='comment-form']",
			RuntimeVariables.replace(" Edit"));
		selenium.click("//input[@value='Post']");
		selenium.waitForText("//div[@class='comment-body']/span",
			"Task Comment Edit");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Modified"),
			selenium.getText("//span[@class='edit-notice']"));
	}
}