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

package com.liferay.portalweb.socialofficehome.upcomingtasks.task.viewresolvetaskstaskassignedtomeut;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewResolveTasksTaskAssignedToMeUTTest extends BaseTestCase {
	public void testViewResolveTasksTaskAssignedToMeUT()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.waitForText("//h1/span[contains(.,'Upcoming Tasks')]",
					"Upcoming Tasks");
				assertEquals(RuntimeVariables.replace("Upcoming Tasks"),
					selenium.getText("//h1/span[contains(.,'Upcoming Tasks')]"));
				assertTrue(selenium.isElementNotPresent(
						"//li[@class='tasks-title normal']/a"));
				assertFalse(selenium.isTextPresent("Task Description"));
				assertEquals(RuntimeVariables.replace("View All Tasks"),
					selenium.getText("//div[@class='view-all-tasks']/a"));
				selenium.clickAt("//div[@class='view-all-tasks']/a",
					RuntimeVariables.replace("View All Tasks"));
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
				selenium.waitForVisible("link=Task Description");
				assertEquals(RuntimeVariables.replace("Task Description"),
					selenium.getText("link=Task Description"));

			case 100:
				label = -1;
			}
		}
	}
}