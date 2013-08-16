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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.announcementsdelivery.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAnnouncementDeliveryTest extends BaseTestCase {
	public void testAddAnnouncementDelivery() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=My Account");
		selenium.clickAt("link=My Account",
			RuntimeVariables.replace("My Account"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@id='announcementsLink']",
			RuntimeVariables.replace("Announcements"));
		assertFalse(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralEmailCheckbox']"));
		selenium.clickAt("//input[@id='_2_announcementsTypegeneralEmailCheckbox']",
			RuntimeVariables.replace("General Email"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralEmailCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralSmsCheckbox']"));
		selenium.clickAt("//input[@id='_2_announcementsTypegeneralSmsCheckbox']",
			RuntimeVariables.replace("General SMS"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralSmsCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_2_announcementsTypenewsEmailCheckbox']"));
		selenium.clickAt("//input[@id='_2_announcementsTypenewsEmailCheckbox']",
			RuntimeVariables.replace("News Email"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypenewsEmailCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_2_announcementsTypenewsSmsCheckbox']"));
		selenium.clickAt("//input[@id='_2_announcementsTypenewsSmsCheckbox']",
			RuntimeVariables.replace("News SMS"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypenewsSmsCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_2_announcementsTypetestEmailCheckbox']"));
		selenium.clickAt("//input[@id='_2_announcementsTypetestEmailCheckbox']",
			RuntimeVariables.replace("Test Email"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypetestEmailCheckbox']"));
		assertFalse(selenium.isChecked(
				"//input[@id='_2_announcementsTypetestSmsCheckbox']"));
		selenium.clickAt("//input[@id='_2_announcementsTypetestSmsCheckbox']",
			RuntimeVariables.replace("Test SMS"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypetestSmsCheckbox']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralEmailCheckbox']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralSmsCheckbox']"));
		assertTrue(selenium.isElementPresent(
				"//input[@id='_2_announcementsTypegeneralWebsiteCheckbox' and @disabled='']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypenewsEmailCheckbox']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypenewsSmsCheckbox']"));
		assertTrue(selenium.isElementPresent(
				"//input[@id='_2_announcementsTypenewsWebsiteCheckbox' and @disabled='']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypetestEmailCheckbox']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypetestSmsCheckbox']"));
		assertTrue(selenium.isElementPresent(
				"//input[@id='_2_announcementsTypetestWebsiteCheckbox' and @disabled='']"));
	}
}