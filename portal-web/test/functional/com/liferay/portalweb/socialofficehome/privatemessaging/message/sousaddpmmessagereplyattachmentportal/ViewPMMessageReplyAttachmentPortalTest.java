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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.sousaddpmmessagereplyattachmentportal;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPMMessageReplyAttachmentPortalTest extends BaseTestCase {
	public void testViewPMMessageReplyAttachmentPortal()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
		selenium.waitForElementPresent(
			"//a[contains(@class,'user-notification')]");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//a[contains(@class,'user-notification')]",
			RuntimeVariables.replace("Notifications"));
		selenium.waitForVisible("//div[@class='title']");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 sent you a message."),
			selenium.getText("//div[@class='title']"));
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
				"Social01 Office01 User01 sent you a message."));
		selenium.clickAt("link=Private Messaging Test Page",
			RuntimeVariables.replace("Private Messaging Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//span[@class='author-sender']"));
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//div[@class='subject']"));
		assertEquals(RuntimeVariables.replace("Message Subject Reply"),
			selenium.getText("//div[@class='body']"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
		selenium.clickAt("//div[@class='subject']",
			RuntimeVariables.replace("Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"Between Social01 Office01 User01 And You"),
			selenium.getText(
				"//div[@class='aui-layout-content thread-info-content ']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("xPath=(//span[@class='name'])[1]"));
		assertEquals(RuntimeVariables.replace("Message Body"),
			selenium.getText("xPath=(//div[@class='body'])[1]"));
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("xPath=(//span[@class='name'])[2]"));
		assertTrue(selenium.isPartialText("xPath=(//div[@class='body'])[2]",
				"Message Subject Reply"));
		assertTrue(selenium.isVisible("//div[@class='image-thumbnail']/a/img"));
		assertEquals(RuntimeVariables.replace("PM_Attachment.jpg"),
			selenium.getText("//td[2]/a"));
	}
}