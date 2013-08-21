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

package com.liferay.portalweb.socialofficesite.home.announcement.viewannouncementsentrynotifications;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAnnouncementsEntryNotificationsTest extends BaseTestCase {
	public void testViewAnnouncementsEntryNotifications()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//span[@class='notification-count']");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//span[@class='notification-count']",
			RuntimeVariables.replace("1"));
		selenium.waitForElementPresent(
			"//div[contains(@class, 'user-notification-events-container')]");
		assertTrue(selenium.isVisible(
				"//div[contains(@class, 'user-notification-events-container')]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs sent a new announcement."),
			selenium.getText("//div[@class='notification-entry']/div"));
		assertEquals(RuntimeVariables.replace("Announcements Entry Title"),
			selenium.getText("//div[@class='notification-entry']/div[2]"));
		assertTrue(selenium.isVisible(
				"//div[@class='notification-entry']/div[3]"));
		assertEquals(RuntimeVariables.replace("Mark All as Read"),
			selenium.getText("link=Mark All as Read"));
		assertEquals(RuntimeVariables.replace("Mark All as Read"),
			selenium.getText("//span[@class='dismiss-notifications']/a"));
		selenium.clickAt("//span[@class='dismiss-notifications']/a",
			RuntimeVariables.replace("Mark All as Read"));
		selenium.waitForText("//span[@class='notification-count']", "0");
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//span[@class='notification-count']"));
	}
}