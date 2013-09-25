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

package com.liferay.portalweb.socialofficehome.notifications.notification.sousconfirmnotificationjoinpubrstrsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SendMembersInvitationPubRstrSiteTest extends BaseTestCase {
	public void testSendMembersInvitationPubRstrSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible(
			"//li[contains(@class, 'social-office-enabled')]");
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Public Restricted Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText("//div[@class='community-title']/a/span"));
		assertEquals(RuntimeVariables.replace("Members"),
			selenium.getText("//nav/ul/li[contains(.,'Members')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Members')]/a/span",
			RuntimeVariables.replace("Members"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Invite members to this site."),
			selenium.getText(
				"//a[contains(text(),'Invite members to this site.')]"));
		selenium.clickAt("//a[contains(text(),'Invite members to this site.')]",
			RuntimeVariables.replace("Invite members to this site."));
		selenium.waitForVisible(
			"//div[contains(@class,'user-search')]/div[@class='search']");
		Thread.sleep(1000);
		selenium.waitForText("//div[contains(@class,'list')]/div/span[@class='name']",
			"Social01 Office01 User01");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText(
				"//div[contains(@class,'list')]/div/span[@class='name']"));
		selenium.clickAt("//div[contains(@class,'list')]/div/span[@class='name']",
			RuntimeVariables.replace("Social01 Office01 User01"));
		selenium.waitForVisible("//div[@class='user-invited']/div/div");
		assertTrue(selenium.isPartialText(
				"//div[@class='user-invited']/div/div",
				"Social01 Office01 User01"));
		assertTrue(selenium.isPartialText(
				"//div[@class='user-invited']/div/div",
				"socialoffice01@liferay.com"));
		assertEquals("Send Invitations",
			selenium.getValue("//input[@value='Send Invitations']"));
		selenium.clickAt("//input[@value='Send Invitations']",
			RuntimeVariables.replace("Send Invitations"));
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}