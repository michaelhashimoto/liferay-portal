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
public class AddRepeatingEventTest extends BaseTestCase {
	public void testAddRepeatingEvent() throws Exception {
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
			RuntimeVariables.replace("Repeating Test Event"));
		selenium.clickAt("//input[@id='_8_allDayCheckbox']",
			RuntimeVariables.replace("All Day Event"));
		selenium.clickAt("//input[@id='_8_timeZoneSensitiveCheckbox']",
			RuntimeVariables.replace(""));
		selenium.select("//select[@id='_8_startdatemonth']",
			RuntimeVariables.replace("label=January"));
		selenium.select("//select[@id='_8_startdateday']",
			RuntimeVariables.replace("label=1"));
		selenium.select("//select[@id='_8_startdateyear']",
			RuntimeVariables.replace("label=2010"));
		selenium.select("//select[@id='_8_type']",
			RuntimeVariables.replace("Event"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("link=Events", RuntimeVariables.replace("Events"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("link=Repeating Test Event");
		assertTrue(selenium.isVisible("link=Repeating Test Event"));
	}
}