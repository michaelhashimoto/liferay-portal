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

package com.liferay.portalweb.socialofficesite.members.member.sendmemberinvitesousersiterolesite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SendMemberInviteSOUser2SiteAdminRoleSiteTest extends BaseTestCase {
	public void testSendMemberInviteSOUser2SiteAdminRoleSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Open Site Name"),
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
		selenium.waitForVisible("//div[@class='search']");
		assertEquals(RuntimeVariables.replace("Social02 Office02 User02"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'user')]/span)[contains(.,'Social02 Office02 User02')]"));
		selenium.clickAt("xPath=(//div[contains(@class, 'user')]/span)[contains(.,'Social02 Office02 User02')]",
			RuntimeVariables.replace("Social02 Office02 User02"));
		selenium.waitForVisible("//div[@class='user-invited']/div/div");
		assertEquals(RuntimeVariables.replace(
				"Social02 Office02 User02 socialoffice02@liferay.com"),
			selenium.getText("//div[@class='user-invited']/div/div"));
		selenium.select("//select[contains(@name,'roleId')]",
			RuntimeVariables.replace("Site Administrator"));
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