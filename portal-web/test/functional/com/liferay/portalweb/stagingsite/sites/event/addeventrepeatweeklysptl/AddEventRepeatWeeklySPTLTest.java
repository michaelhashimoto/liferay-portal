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

package com.liferay.portalweb.stagingsite.sites.event.addeventrepeatweeklysptl;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddEventRepeatWeeklySPTLTest extends BaseTestCase {
	public void testAddEventRepeatWeeklySPTL() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
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
				selenium.waitForVisible("link=Site Name");
				selenium.clickAt("link=Site Name",
					RuntimeVariables.replace("Site Name"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//body[contains(@class,'live-view')]"));
				assertTrue(selenium.isElementNotPresent(
						"//body[contains(@class,'local-staging')]"));
				assertTrue(selenium.isPartialText("//li[2]/span/a", "Staging"));
				selenium.clickAt("//li[2]/span/a",
					RuntimeVariables.replace("Staging"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//body[contains(@class,'local-staging')]"));
				assertTrue(selenium.isElementNotPresent(
						"//body[contains(@class,'live-view')]"));
				Thread.sleep(5000);
				selenium.clickAt("//span[@class='staging-icon-menu-container']/span/ul/li/strong/a",
					RuntimeVariables.replace("Staging Drop Down"));
				selenium.waitForVisible("//a[@id='_170_0publishScheduleLink']");
				selenium.clickAt("//a[@id='_170_0publishScheduleLink']",
					RuntimeVariables.replace("Schedule Publication to Live"));
				selenium.waitForVisible("//div[4]/div/a");

				boolean startDateMonthVisible = selenium.isVisible(
						"//select[@id='_88_schedulerStartDateMonth']");

				if (startDateMonthVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[4]/div/a",
					RuntimeVariables.replace("Plus"));

			case 2:
				selenium.waitForVisible(
					"//input[@id='_88_recurrenceTypeWeekly']");
				selenium.clickAt("//input[@id='_88_recurrenceTypeWeekly']",
					RuntimeVariables.replace("Weekly"));
				selenium.waitForVisible(
					"//div[2]/div/span[1]/span/span/input[2]");

				boolean mondayNotChecked = selenium.isChecked(
						"//div[2]/div/span[1]/span/span/input[2]");

				if (mondayNotChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("//div[2]/div/span[1]/span/span/input[2]",
					RuntimeVariables.replace("Monday"));

			case 3:
				assertTrue(selenium.isChecked(
						"//div[2]/div/span[1]/span/span/input[2]"));
				selenium.waitForVisible("//input[@value='Add Event']");
				selenium.clickAt("//input[@value='Add Event']",
					RuntimeVariables.replace("Add Event"));
				selenium.waitForVisible("//th[2]");
				assertEquals(RuntimeVariables.replace("No end date"),
					selenium.getText("//tr[3]/td[3]"));

			case 100:
				label = -1;
			}
		}
	}
}