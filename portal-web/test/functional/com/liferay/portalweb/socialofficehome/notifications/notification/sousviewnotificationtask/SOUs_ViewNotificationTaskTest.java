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

package com.liferay.portalweb.socialofficehome.notifications.notification.sousviewnotificationtask;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewNotificationTaskTest extends BaseTestCase {
	public void testSOUs_ViewNotificationTask() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		assertTrue(selenium.isElementPresent(
				"//a[contains(@class,'user-notification')]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//a[contains(@class,'user-notification')]",
			RuntimeVariables.replace("Notifications"));
		selenium.waitForVisible("//div[@class='notification-entry']");
		assertEquals(RuntimeVariables.replace("Joe Bloggs assigned you a task."),
			selenium.getText(
				"//div[@class='notification-entry']/div[@class='title']"));
		assertEquals(RuntimeVariables.replace("Task Description"),
			selenium.getText(
				"//div[@class='notification-entry']/div[@class='body']"));
		assertTrue(selenium.isVisible(
				"//div[@class='notification-entry']/div[@class='datetime']"));
		selenium.clickAt("//div[@class='notification-entry']/div[@class='title']",
			RuntimeVariables.replace("Joe Bloggs assigned you a task."));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Assigned to Me"),
			selenium.getText("link=Assigned to Me"));
		assertEquals(RuntimeVariables.replace("Task Description"),
			selenium.getText("//a[@class='tasks-title normal']"));
		assertEquals(RuntimeVariables.replace("Reporter: Joe Bloggs"),
			selenium.getText("//div[@class='result-data']/span"));
	}
}