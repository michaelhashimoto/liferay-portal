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

package com.liferay.portalweb.kaleo.myworkflowtasks.workflowtask.assigntomewebcontentassigneduser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class UserSN_ViewWebContentAssignedToMeTest extends BaseTestCase {
	public void testUserSN_ViewWebContentAssignedToMe()
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
		selenium.click(RuntimeVariables.replace("link=Pending"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("My Workflow Tasks"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertEquals(RuntimeVariables.replace("Assigned to Me"),
			selenium.getText("//div[@id='workflowMyTasksPanel']/div/div"));
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to you."),
			selenium.getText("xpath=(//div[@class='portlet-msg-info'])[1]"));
		assertEquals(RuntimeVariables.replace("Assigned to My Roles"),
			selenium.getText("//div[@id='workflowMyRolesTasksPanel']/div/div"));
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to your roles."),
			selenium.getText("xpath=(//div[@class='portlet-msg-info'])[2]"));
		selenium.clickAt("link=Completed", RuntimeVariables.replace("Completed"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("My Workflow Tasks"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertEquals(RuntimeVariables.replace("There are no completed tasks."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}