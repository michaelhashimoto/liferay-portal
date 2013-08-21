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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousdeletereplymicroblogscontentprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDeleteReplyMicroblogsContentNotificationsTest
	extends BaseTestCase {
	public void testViewDeleteReplyMicroblogsContentNotifications()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForElementPresent(
			"//a[contains(@class,'user-notification')]");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//a[contains(@class,'user-notification')]",
			RuntimeVariables.replace("Notifications"));
		selenium.waitForVisible("//div[@class='title']");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 commented on your post."),
			selenium.getText("//div[@class='title']"));
		assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
			selenium.getText("//div[@class='body']"));
		selenium.clickAt("//div[@class='title']",
			RuntimeVariables.replace(
				"Social01 Office01 User01 commented on your post."));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"xPath=(//div[@class='user-name']/span)[contains(.,'Joe Bloggs')]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("xPath=(//div[@class='content'])[1]"));
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("//span[@class='action comment']/a"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//div[@class='user-name']/span)[contains(.,'Social01 Office01 User01')]"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//div[@class='content'])[2]"));
		assertFalse(selenium.isTextPresent("1 Comment"));
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForElementPresent(
			"//a[contains(@class,'user-notification')]");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//a[contains(@class,'user-notification')]",
			RuntimeVariables.replace("Notifications"));
		selenium.waitForVisible("//div[@class='title']");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 commented on your post."),
			selenium.getText("//div[@class='title']"));
		assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
			selenium.getText("//div[@class='body']"));
		assertEquals(RuntimeVariables.replace("Mark All as Read"),
			selenium.getText("//span[@class='dismiss-notifications']/a"));
		selenium.clickAt("//span[@class='dismiss-notifications']/a",
			RuntimeVariables.replace("Mark All as Read"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent(
			"//a[contains(@class,'user-notification')]");
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//a[contains(@class,'user-notification')]",
			RuntimeVariables.replace("Notifications"));
		assertFalse(selenium.isTextPresent(
				"Social01 Office01 User01 commented on your post."));
	}
}