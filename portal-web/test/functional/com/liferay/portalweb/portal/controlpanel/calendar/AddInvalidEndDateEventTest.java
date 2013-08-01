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

package com.liferay.portalweb.portal.controlpanel.calendar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddInvalidEndDateEventTest extends BaseTestCase {
	public void testAddInvalidEndDateEvent() throws Exception {
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
		selenium.clickAt("link=Calendar", RuntimeVariables.replace("Calendar"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Event']",
			RuntimeVariables.replace("Add Event"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_8_title']",
			RuntimeVariables.replace("Invalid End Date Test Event"));
		selenium.clickAt("//input[@name='_8_recurrenceType' and @value='3']",
			RuntimeVariables.replace("Repeat Daily"));
		selenium.waitForVisible("//input[@id='_8_dailyInterval']");
		selenium.type("//input[@id='_8_dailyInterval']",
			RuntimeVariables.replace("1"));
		selenium.clickAt("//select[@id='_8_enddatemonth']",
			RuntimeVariables.replace("End Date Month"));
		selenium.select("//select[@id='_8_enddatemonth']",
			RuntimeVariables.replace("label=February"));
		selenium.select("//select[@id='_8_enddatemonth']",
			RuntimeVariables.replace("label=February"));
		assertFalse(selenium.isPartialText("//select[@id='_8_enddateday']", "30"));
	}
}