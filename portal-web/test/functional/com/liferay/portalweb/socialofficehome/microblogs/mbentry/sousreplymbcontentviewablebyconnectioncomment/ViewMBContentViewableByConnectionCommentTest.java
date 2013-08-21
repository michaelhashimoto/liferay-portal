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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymbcontentviewablebyconnectioncomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBContentViewableByConnectionCommentTest extends BaseTestCase {
	public void testViewMBContentViewableByConnectionComment()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard");
		assertTrue(selenium.isElementPresent(
				"//div[contains(@id,'_2_WAR_microblogsportlet_autocompleteContent')]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("//div[@class='content']"));
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs says"),
			selenium.getText("xPath=(//div[@class='user-name'])[1]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("xPath=(//div[@class='content'])[1]"));
		assertEquals(RuntimeVariables.replace("1 Comment"),
			selenium.getText("//span[@class='action comment']/a"));
		selenium.clickAt("//span[@class='action comment']/a",
			RuntimeVariables.replace("1 Comment"));
		selenium.waitForVisible("xPath=(//div[@class='user-name'])[2]");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01 says"),
			selenium.getText("xPath=(//div[@class='user-name'])[2]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
			selenium.getText("xPath=(//div[@class='content'])[2]"));
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertTrue(selenium.isElementPresent(
				"//a[contains(@class,'user-notification')]"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//a[contains(@class,'user-notification')]",
			RuntimeVariables.replace("Notifications"));
		selenium.waitForVisible("//div[@class='notification-entry']");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 commented on your post."),
			selenium.getText(
				"//div[@class='notification-entry']/div[@class='title']"));
		assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
			selenium.getText(
				"//div[@class='notification-entry']/div[@class='body']"));
		assertEquals(RuntimeVariables.replace("Mark All as Read"),
			selenium.getText("//a[@class='dismiss-notifications']"));
		selenium.clickAt("//a[@class='dismiss-notifications']",
			RuntimeVariables.replace("Mark All as Read"));
		selenium.waitForText("//span[@class='notification-count']", "0");
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//span[@class='notification-count']"));
	}
}