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

package com.liferay.portalweb.portal.dbupgrade.sampledata6012.announcementsdelivery.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAnnouncementDeliveryTest extends BaseTestCase {
	public void testViewAnnouncementDelivery() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=My Account", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@id='_2_addressesLink']",
			RuntimeVariables.replace("Addresses Link"));
		selenium.waitForVisible(
			"//input[@id='_2_announcementsTypegeneralEmailCheckbox']");
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralEmailCheckbox']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypegeneralSmsCheckbox']"));
		assertTrue(selenium.isElementPresent(
				"//input[@id='_2_announcementsTypegeneralWebsiteCheckbox' and @disabled='']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_announcementsTypenewsSmsCheckbox']"));
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