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

package com.liferay.portalweb.portlet.myaccount.datepicker.selectbirthday;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectBirthdayTest extends BaseTestCase {
	public void testSelectBirthday() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Joe Bloggs");
		selenium.clickAt("link=Joe Bloggs",
			RuntimeVariables.replace("Joe Bloggs"));
		Thread.sleep(5000);
		selenium.waitForVisible("//select[@id='_2_birthdaymonth']");
		Thread.sleep(5000);
		selenium.click("//select[@id='_2_birthdaymonth']");
		selenium.select("//select[@id='_2_birthdaymonth']",
			RuntimeVariables.replace("March"));
		selenium.waitForSelectedLabel("//select[@id='_2_birthdaymonth']",
			"March");
		selenium.select("//select[@id='_2_birthdayyear']",
			RuntimeVariables.replace("1986"));
		selenium.waitForSelectedLabel("//select[@id='_2_birthdayyear']", "1986");
		selenium.waitForVisible("//button[@id='buttonTest']");
		selenium.clickAt("//button[@id='buttonTest']",
			RuntimeVariables.replace("Date Picker"));
		selenium.waitForVisible("//div[@class='aui-calendar-title']");
		assertEquals(RuntimeVariables.replace("March 1986"),
			selenium.getText("//div[@class='aui-calendar-title']"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("link=Next"));
		selenium.clickAt("link=Next", RuntimeVariables.replace("Next"));
		selenium.waitForText("//div[@class='aui-calendar-title']", "April 1986");
		assertEquals(RuntimeVariables.replace("April 1986"),
			selenium.getText("//div[@class='aui-calendar-title']"));
		selenium.clickAt("link=Next", RuntimeVariables.replace("Next"));
		selenium.waitForText("//div[@class='aui-calendar-title']", "May 1986");
		assertEquals(RuntimeVariables.replace("May 1986"),
			selenium.getText("//div[@class='aui-calendar-title']"));
		selenium.waitForVisible("link=31");
		selenium.clickAt("link=31", RuntimeVariables.replace("31"));
		selenium.waitForSelectedLabel("//select[@id='_2_birthdayday']", "31");
		assertEquals("May",
			selenium.getSelectedLabel("//select[@id='_2_birthdaymonth']"));
		assertEquals("31",
			selenium.getSelectedLabel("//select[@id='_2_birthdayday']"));
		assertEquals("1986",
			selenium.getSelectedLabel("//select[@id='_2_birthdayyear']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("May",
			selenium.getSelectedLabel("//select[@id='_2_birthdaymonth']"));
		assertEquals("31",
			selenium.getSelectedLabel("//select[@id='_2_birthdayday']"));
		assertEquals("1986",
			selenium.getSelectedLabel("//select[@id='_2_birthdayyear']"));
		assertEquals("May",
			selenium.getSelectedLabel("//select[@id='_2_birthdaymonth']"));
		assertEquals("31",
			selenium.getSelectedLabel("//select[@id='_2_birthdayday']"));
		assertEquals("1986",
			selenium.getSelectedLabel("//select[@id='_2_birthdayyear']"));
	}
}