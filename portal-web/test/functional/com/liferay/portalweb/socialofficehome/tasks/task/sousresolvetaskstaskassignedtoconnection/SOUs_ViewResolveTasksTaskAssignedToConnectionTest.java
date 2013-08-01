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

package com.liferay.portalweb.socialofficehome.tasks.task.sousresolvetaskstaskassignedtoconnection;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewResolveTasksTaskAssignedToConnectionTest
	extends BaseTestCase {
	public void testSOUs_ViewResolveTasksTaskAssignedToConnection()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/socialoffice01/so/dashboard/");
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
				selenium.waitForVisible("//td[1]/input");

				boolean showCompleted1Checked = selenium.isChecked(
						"//td[1]/input");

				if (showCompleted1Checked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//td[1]/input",
					RuntimeVariables.replace("Check Show Completed Tasks"));

			case 2:
				selenium.waitForVisible("link=Task Description");
				assertEquals(RuntimeVariables.replace("Task Description"),
					selenium.getText("link=Task Description"));
				selenium.clickAt("link=Task Description",
					RuntimeVariables.replace("Task Description"));
				selenium.waitForText("//h1[@class='header-title']",
					"Task Description");
				assertEquals(RuntimeVariables.replace("Task Description"),
					selenium.getText("//h1[@class='header-title']"));
				assertEquals(RuntimeVariables.replace(
						"Assigned to Social01 Office01 User01"),
					selenium.getText("//div[@class='task-data assignee']"));
				assertEquals(RuntimeVariables.replace("Resolved"),
					selenium.getText("//div[@class='task-data status']"));
				assertEquals(RuntimeVariables.replace("Normal"),
					selenium.getText("//div[@class='task-data normal']"));
				assertEquals("Reopen",
					selenium.getValue("//input[@value='Reopen']"));

			case 100:
				label = -1;
			}
		}
	}
}