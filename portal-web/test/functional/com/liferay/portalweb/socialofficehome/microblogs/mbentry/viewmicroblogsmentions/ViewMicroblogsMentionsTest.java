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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.viewmicroblogsmentions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMicroblogsMentionsTest extends BaseTestCase {
	public void testViewMicroblogsMentions() throws Exception {
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
		assertEquals(RuntimeVariables.replace(
				"Microblogs Post Comment [@joebloggs]"),
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
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Mentions"),
			selenium.getText("link=Mentions"));
		selenium.clickAt("link=Mentions", RuntimeVariables.replace("Mentions"));
		selenium.waitForText("//div[@class='user-name']/span",
			"Social01 Office01 User01");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='user-name']/span"));
		assertEquals(RuntimeVariables.replace(
				"Microblogs Post Comment Joe Bloggs"),
			selenium.getText("//div[@class='content']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='content']/span/a"));
	}
}