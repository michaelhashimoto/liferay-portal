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

package com.liferay.portalweb.socialofficehome.navigation.links.viewlinkprivatemessaging;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewLinkPrivateMessagingTest extends BaseTestCase {
	public void testViewLinkPrivateMessaging() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//nav/ul/li[contains(.,'Messages')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Messages')]/a/span",
			RuntimeVariables.replace("Messages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Messaging"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-default'])[contains(.,'Private Messaging')]"));
		assertEquals(RuntimeVariables.replace("No messages found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertEquals("Mark as Unread",
			selenium.getValue("//input[@value='Mark as Unread']"));
		assertEquals("Mark as Read",
			selenium.getValue("//input[@value='Mark as Read']"));
		assertEquals("Delete", selenium.getValue("//input[@value='Delete']"));
		assertEquals("New Message",
			selenium.getValue("//input[@value='New Message']"));
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//div/input[1]"));
		assertEquals(RuntimeVariables.replace("Liferay, Inc."),
			selenium.getText("//li/span[2]/a"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//li[2]/span[2]/a"));
	}
}