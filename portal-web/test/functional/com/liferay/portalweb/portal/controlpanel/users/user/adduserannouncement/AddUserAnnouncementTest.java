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

package com.liferay.portalweb.portal.controlpanel.users.user.adduserannouncement;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserAnnouncementTest extends BaseTestCase {
	public void testAddUserAnnouncement() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Users and Organizations",
			RuntimeVariables.replace("Users and Organizations"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_125_keywords']",
			RuntimeVariables.replace("usersn"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("userfn"),
			selenium.getText("//td[2]/a"));
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("userfn"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//a[@id='_125_announcementsLink']");
		assertTrue(selenium.isPartialText("//a[@id='_125_announcementsLink']",
				"Announcements"));
		selenium.clickAt("//a[@id='_125_announcementsLink']",
			RuntimeVariables.replace("Announcements"));
		selenium.clickAt("//input[@id='_125_announcementsTypegeneralEmailCheckbox']",
			RuntimeVariables.replace("General Email Checkbox"));
		selenium.uncheck(
			"//input[@id='_125_announcementsTypegeneralSmsCheckbox']");
		selenium.uncheck(
			"//input[@id='_125_announcementsTypenewsEmailCheckbox']");
		selenium.clickAt("//input[@id='_125_announcementsTypenewsSmsCheckbox']",
			RuntimeVariables.replace("News SMS Checkbox"));
		selenium.clickAt("//input[@id='_125_announcementsTypetestEmailCheckbox']",
			RuntimeVariables.replace("Test Email Checkbox"));
		selenium.uncheck("//input[@id='_125_announcementsTypetestSmsCheckbox']");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_125_announcementsTypegeneralEmailCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_125_announcementsTypegeneralSmsCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_125_announcementsTypenewsEmailCheckbox']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_125_announcementsTypenewsSmsCheckbox']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_125_announcementsTypetestEmailCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_125_announcementsTypetestSmsCheckbox']"));
	}
}