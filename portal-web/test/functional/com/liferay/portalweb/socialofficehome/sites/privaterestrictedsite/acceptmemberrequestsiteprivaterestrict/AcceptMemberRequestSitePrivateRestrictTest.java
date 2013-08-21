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

package com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.acceptmemberrequestsiteprivaterestrict;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AcceptMemberRequestSitePrivateRestrictTest extends BaseTestCase {
	public void testAcceptMemberRequestSitePrivateRestrict()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Private Restricted"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Private Restricted Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Private Restricted Site Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[contains(@id,'toggleDockbar')]",
			RuntimeVariables.replace("Toggle Dockbar"));
		selenium.waitForElementPresent(
			"//body[contains(@class,'show-dockbar')]");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("//li[contains(.,'Site Memberships')]/a");
		assertEquals(RuntimeVariables.replace("Site Memberships"),
			selenium.getText("//li[contains(.,'Site Memberships')]/a"));
		selenium.clickAt("//li[contains(.,'Site Memberships')]/a",
			RuntimeVariables.replace("Site Memberships"));
		selenium.waitForVisible("//iframe[@id='manageContentDialog']");
		selenium.selectFrame("//iframe[@id='manageContentDialog']");
		selenium.waitForVisible(
			"//div[@class='site-membership-type']/span[3]/a");
		assertEquals(RuntimeVariables.replace(
				"There are 1 membership requests pending."),
			selenium.getText("//div[@class='site-membership-type']/span[3]/a"));
		selenium.clickAt("//div[@class='site-membership-type']/span[3]/a",
			RuntimeVariables.replace("There are 1 membership requests pending."));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Pending"),
			selenium.getText("link=Pending"));
		selenium.clickAt("link=Pending", RuntimeVariables.replace("Pending"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//td[contains(@id,'col-user_row-1')]",
				"Social01 Office01 User01"));
		assertTrue(selenium.isPartialText(
				"//td[contains(@id,'col-user_row-1')]",
				"(socialoffice01@liferay.com)"));
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 wishes to join Private Restricted Site Name."),
			selenium.getText("//td[contains(@id,'col-user-comments_row-1')]"));
		assertEquals(RuntimeVariables.replace("Reply"),
			selenium.getText("//a[contains(@id,'menu_reply')]"));
		selenium.clickAt("//a[contains(@id,'menu_reply')]",
			RuntimeVariables.replace("Reply"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Reply Membership Request for Private Restricted Site Name"),
			selenium.getText("//h1[@class='header-title']"));
		selenium.select("//select[@id='_174_statusId']",
			RuntimeVariables.replace("Approve"));
		selenium.type("//textarea[@id='_174_replyComments']",
			RuntimeVariables.replace(
				"Private Restricted Site Name Membership Approved"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("xPath=(//div[@class='portlet-msg-success'])[1]"));
		assertEquals(RuntimeVariables.replace(
				"Your reply will be sent to the user by email."),
			selenium.getText("xPath=(//div[@class='portlet-msg-success'])[2]"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("link=Approved"));
		selenium.clickAt("link=Approved", RuntimeVariables.replace("Approved"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//td[contains(@id,'col-user_row-1')]",
				"Social01 Office01 User01"));
		assertTrue(selenium.isPartialText(
				"//td[contains(@id,'col-user_row-1')]",
				"(socialoffice01@liferay.com)"));
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 wishes to join Private Restricted Site Name."),
			selenium.getText("//td[contains(@id,'col-user-comments_row-1')]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[contains(@id,'col-replier_row-1')]"));
		assertEquals(RuntimeVariables.replace(
				"Private Restricted Site Name Membership Approved"),
			selenium.getText("//td[contains(@id,'col-reply-comments_row-1')]"));
		selenium.selectFrame("relative=top");
	}
}