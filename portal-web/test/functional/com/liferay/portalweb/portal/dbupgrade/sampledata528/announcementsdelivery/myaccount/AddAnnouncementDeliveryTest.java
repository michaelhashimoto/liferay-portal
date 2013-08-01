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

package com.liferay.portalweb.portal.dbupgrade.sampledata528.announcementsdelivery.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAnnouncementDeliveryTest extends BaseTestCase {
	public void testAddAnnouncementDelivery() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home");
				assertTrue(selenium.isPartialText(
						"//h2[@class='user-greeting']/span", "Welcome"));
				selenium.mouseOver("//h2[@class='user-greeting']/span");
				selenium.clickAt("//h2[@class='user-greeting']/span",
					RuntimeVariables.replace("Welcome"));
				selenium.waitForVisible("link=My Account");
				selenium.clickAt("link=My Account",
					RuntimeVariables.replace("My Account"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//a[@id='announcementsLink']",
					RuntimeVariables.replace("Announcements"));

				boolean generalEmailChecked = selenium.isChecked(
						"_2_announcementsTypegeneralEmailCheckbox");

				if (generalEmailChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_2_announcementsTypegeneralEmailCheckbox']",
					RuntimeVariables.replace("General Email"));

			case 2:

				boolean generalSmsChecked = selenium.isChecked(
						"_2_announcementsTypegeneralSmsCheckbox");

				if (generalSmsChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@id='_2_announcementsTypegeneralSmsCheckbox']",
					RuntimeVariables.replace("General Sms"));

			case 3:

				boolean newsEmailChecked = selenium.isChecked(
						"_2_announcementsTypenewsEmailCheckbox");

				if (newsEmailChecked) {
					label = 4;

					continue;
				}

				selenium.clickAt("//input[@id='_2_announcementsTypenewsEmailCheckbox']",
					RuntimeVariables.replace("News Email"));

			case 4:

				boolean newsSmsChecked = selenium.isChecked(
						"_2_announcementsTypenewsSmsCheckbox");

				if (newsSmsChecked) {
					label = 5;

					continue;
				}

				selenium.clickAt("//input[@id='_2_announcementsTypenewsSmsCheckbox']",
					RuntimeVariables.replace("News Sms"));

			case 5:

				boolean testEmailChecked = selenium.isChecked(
						"_2_announcementsTypetestEmailCheckbox");

				if (testEmailChecked) {
					label = 6;

					continue;
				}

				selenium.clickAt("//input[@id='_2_announcementsTypetestEmailCheckbox']",
					RuntimeVariables.replace("Test Email"));

			case 6:

				boolean testSmsChecked = selenium.isChecked(
						"_2_announcementsTypetestSmsCheckbox");

				if (testSmsChecked) {
					label = 7;

					continue;
				}

				selenium.clickAt("//input[@id='_2_announcementsTypetestSmsCheckbox']",
					RuntimeVariables.replace("Test Sms"));

			case 7:
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
						"//input[@id='_2_announcementsTypegeneralWebsiteCheckbox' and @disabled='disabled']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_2_announcementsTypenewsSmsCheckbox']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_2_announcementsTypenewsSmsCheckbox']"));
				assertTrue(selenium.isElementPresent(
						"//input[@id='_2_announcementsTypenewsWebsiteCheckbox' and @disabled='disabled']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_2_announcementsTypetestEmailCheckbox']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_2_announcementsTypetestSmsCheckbox']"));
				assertTrue(selenium.isElementPresent(
						"//input[@id='_2_announcementsTypetestWebsiteCheckbox' and @disabled='disabled']"));

			case 100:
				label = -1;
			}
		}
	}
}