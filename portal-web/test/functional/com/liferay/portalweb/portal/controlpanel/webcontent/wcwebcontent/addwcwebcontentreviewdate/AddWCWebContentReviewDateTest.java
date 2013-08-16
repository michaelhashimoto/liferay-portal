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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontentreviewdate;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWCWebContentReviewDateTest extends BaseTestCase {
	public void testAddWCWebContentReviewDate() throws Exception {
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
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add']",
			RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_title_en_US']",
			RuntimeVariables.replace("WC WebContent Title"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("WC WebContent Content"));
		assertTrue(selenium.isPartialText("//a[@id='_15_scheduleLink']",
				"Schedule"));
		selenium.clickAt("//a[@id='_15_scheduleLink']",
			RuntimeVariables.replace("Schedule"));
		selenium.waitForVisible(
			"//div[@id='_15_schedule' and contains(@class,'selected')]");
		selenium.waitForVisible(
			"//select[@name='_15_reviewDateMonth' and @disabled='disabled']");
		assertTrue(selenium.isVisible(
				"//select[@name='_15_reviewDateMonth' and @disabled='disabled']"));
		assertTrue(selenium.isVisible(
				"//select[@name='_15_reviewDateDay' and @disabled='disabled']"));
		assertTrue(selenium.isVisible(
				"//select[@name='_15_reviewDateYear' and @disabled='disabled']"));
		assertTrue(selenium.isVisible(
				"//select[@name='_15_reviewDateHour' and @disabled='disabled']"));
		assertTrue(selenium.isVisible(
				"//select[@name='_15_reviewDateMinute' and @disabled='disabled']"));
		assertTrue(selenium.isVisible(
				"//select[@name='_15_reviewDateAmPm' and @disabled='disabled']"));
		assertTrue(selenium.isChecked("//input[@id='_15_neverReviewCheckbox']"));
		selenium.clickAt("//input[@id='_15_neverReviewCheckbox']",
			RuntimeVariables.replace("Never Auto Review"));
		assertFalse(selenium.isChecked("//input[@id='_15_neverReviewCheckbox']"));
		selenium.clickAt("//select[@name='_15_reviewDateMonth']",
			RuntimeVariables.replace("Review Date Month"));
		assertFalse(selenium.isChecked("//input[@id='_15_neverReviewCheckbox']"));
		selenium.clickAt("//input[@id='_15_neverReviewCheckbox']",
			RuntimeVariables.replace("Never Auto Review"));
		assertTrue(selenium.isChecked("//input[@id='_15_neverReviewCheckbox']"));
		selenium.clickAt("//input[@id='_15_neverReviewCheckbox']",
			RuntimeVariables.replace("Never Auto Review"));
		assertFalse(selenium.isChecked("//input[@id='_15_neverReviewCheckbox']"));
		selenium.waitForElementNotPresent(
			"//select[@name='_15_reviewDateMonth' and @disabled='disabled']");
		assertTrue(selenium.isElementNotPresent(
				"//select[@name='_15_reviewDateMonth' and @disabled='disabled']"));
		assertTrue(selenium.isElementNotPresent(
				"//select[@name='_15_reviewDateDay' and @disabled='disabled']"));
		assertTrue(selenium.isElementNotPresent(
				"//select[@name='_15_reviewDateYear' and @disabled='disabled']"));
		assertTrue(selenium.isElementNotPresent(
				"//select[@name='_15_reviewDateHour' and @disabled='disabled']"));
		assertTrue(selenium.isElementNotPresent(
				"//select[@name='_15_reviewDateMinute' and @disabled='disabled']"));
		assertTrue(selenium.isElementNotPresent(
				"//select[@name='_15_reviewDateAmPm' and @disabled='disabled']"));
		selenium.select("//select[@name='_15_reviewDateMonth']",
			RuntimeVariables.replace("label=December"));
		selenium.select("//select[@name='_15_reviewDateDay']",
			RuntimeVariables.replace("label=31"));
		selenium.select("//select[@name='_15_reviewDateYear']",
			RuntimeVariables.replace("label=2015"));
		selenium.select("//select[@name='_15_reviewDateHour']",
			RuntimeVariables.replace("label=12"));
		selenium.select("//select[@name='_15_reviewDateMinute']",
			RuntimeVariables.replace("label=:00"));
		selenium.select("//select[@name='_15_reviewDateAmPm']",
			RuntimeVariables.replace("label=AM"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[4]/a"));
		selenium.clickAt("//td[3]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		assertTrue(selenium.isPartialText("//a[@id='_15_scheduleLink']",
				"Schedule"));
		selenium.clickAt("//a[@id='_15_scheduleLink']",
			RuntimeVariables.replace("Schedule"));
		selenium.waitForVisible(
			"//div[@id='_15_schedule' and contains(@class,'selected')]");
		selenium.waitForVisible("//select[@name='_15_reviewDateMonth']");
		assertEquals("December",
			selenium.getSelectedLabel("//select[@name='_15_reviewDateMonth']"));
		assertEquals("31",
			selenium.getSelectedLabel("//select[@name='_15_reviewDateDay']"));
		assertEquals("2015",
			selenium.getSelectedLabel("//select[@name='_15_reviewDateYear']"));
		assertEquals("12",
			selenium.getSelectedLabel("//select[@name='_15_reviewDateHour']"));
		assertEquals(":00",
			selenium.getSelectedLabel("//select[@name='_15_reviewDateMinute']"));
		assertEquals("AM",
			selenium.getSelectedLabel("//select[@name='_15_reviewDateAmPm']"));
		assertFalse(selenium.isChecked("//input[@id='_15_neverReviewCheckbox']"));
	}
}