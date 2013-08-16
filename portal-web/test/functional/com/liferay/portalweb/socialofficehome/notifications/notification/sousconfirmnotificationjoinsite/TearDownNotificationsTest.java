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

package com.liferay.portalweb.socialofficehome.notifications.notification.sousconfirmnotificationjoinsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownNotificationsTest extends BaseTestCase {
	public void testTearDownNotifications() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.waitForVisible("//span[@class='notification-count']");
				selenium.mouseOver("//span[@class='notification-count']");
				assertEquals(RuntimeVariables.replace("View All\u00bb"),
					selenium.getText("link=View All\u00bb"));
				selenium.waitForElementPresent(
					"//div[contains(@class, 'user-notification-events-container')]");
				assertTrue(selenium.isVisible(
						"//div[contains(@class, 'user-notification-events-container')]"));
				selenium.waitForElementPresent("link=View All\u00bb");
				selenium.clickAt("link=View All\u00bb",
					RuntimeVariables.replace("View All\u00bb"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Notifications"),
					selenium.getText("//span[contains(.,'Notifications')]"));

				boolean notificationsPresent = selenium.isElementPresent(
						"//input[@name='_6_WAR_soportlet_allRowIds']");

				if (!notificationsPresent) {
					label = 2;

					continue;
				}

				assertTrue(selenium.isVisible(
						"//input[@name='_6_WAR_soportlet_allRowIds']"));
				selenium.clickAt("//input[@name='_6_WAR_soportlet_allRowIds']",
					RuntimeVariables.replace("Select All Checkbox"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");

			case 2:
				assertEquals(RuntimeVariables.replace(
						"You have no notifications."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}