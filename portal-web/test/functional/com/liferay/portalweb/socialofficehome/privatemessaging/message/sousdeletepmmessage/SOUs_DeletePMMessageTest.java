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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.sousdeletepmmessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_DeletePMMessageTest extends BaseTestCase {
	public void testSOUs_DeletePMMessage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard");
		selenium.waitForElementPresent(
			"//a[contains(@class,'user-notification')]");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.clickAt("//a[contains(@class,'user-notification')]",
			RuntimeVariables.replace("Notifications"));
		selenium.waitForVisible("//div[@class='title']");
		assertEquals(RuntimeVariables.replace("Joe Bloggs sent you a message."),
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
		assertFalse(selenium.isTextPresent("Joe Bloggs sent you a message."));
		selenium.waitForVisible("//nav/ul/li[contains(.,'Messages')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
			RuntimeVariables.replace("Messages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Messaging"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Private Messaging')]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='author-sender']"));
		assertEquals(RuntimeVariables.replace("Message Subject"),
			selenium.getText("//div[@class='subject']"));
		assertEquals(RuntimeVariables.replace("Message Body"),
			selenium.getText("//div[@class='body']"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
		assertFalse(selenium.isChecked("//td[1]/span/span/span/input[2]"));
		selenium.clickAt("//td[1]/span/span/span/input[2]",
			RuntimeVariables.replace("Message"));
		assertTrue(selenium.isChecked("//td[1]/span/span/span/input[2]"));
		selenium.clickAt("//input[@value='Delete']",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-info']");
		assertEquals(RuntimeVariables.replace("No messages found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}