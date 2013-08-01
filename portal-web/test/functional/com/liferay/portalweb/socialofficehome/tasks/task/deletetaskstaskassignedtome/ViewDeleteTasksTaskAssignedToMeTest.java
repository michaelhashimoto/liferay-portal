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

package com.liferay.portalweb.socialofficehome.tasks.task.deletetaskstaskassignedtome;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDeleteTasksTaskAssignedToMeTest extends BaseTestCase {
	public void testViewDeleteTasksTaskAssignedToMe() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
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
				selenium.waitForVisible("//div[@class='portlet-msg-info']");
				assertEquals(RuntimeVariables.replace("No tasks were found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

				boolean showCompleted1Checked = selenium.isChecked(
						"//td[1]/input");

				if (showCompleted1Checked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//td[1]/input",
					RuntimeVariables.replace("Check Show Completed Tasks"));

			case 2:
				selenium.waitForVisible("//div[@class='portlet-msg-info']");
				assertEquals(RuntimeVariables.replace("No tasks were found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}