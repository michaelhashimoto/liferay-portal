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
public class GetAppointmentEventsTest extends BaseTestCase {
	public void testGetAppointmentEvents() throws Exception {
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
		selenium.clickAt("link=Day", RuntimeVariables.replace("Day"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='day-grid']");
		selenium.select("//select", RuntimeVariables.replace("Appointment"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent("link=Test Event");
		assertTrue(selenium.isElementPresent("link=Test Event"));
		assertTrue(selenium.isElementNotPresent("link=Off to Yosemite!"));
		assertTrue(selenium.isElementNotPresent("link=Caedmon Call Concert!"));
		selenium.clickAt("link=Week", RuntimeVariables.replace("Week"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//table[@class='calendar']");
		selenium.select("//select", RuntimeVariables.replace("Appointment"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent("link=Test Event");
		assertTrue(selenium.isElementPresent("link=Test Event"));
		assertTrue(selenium.isElementNotPresent("link=Off to Yosemite!"));
		assertTrue(selenium.isElementNotPresent("link=Caedmon Call Concert!"));
		selenium.clickAt("link=Month", RuntimeVariables.replace("Month"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//table[@class='calendar']/tbody/tr[2]");
		selenium.select("//select", RuntimeVariables.replace("Appointment"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent("link=Test Event");
		assertTrue(selenium.isElementPresent("link=Test Event"));
		assertTrue(selenium.isElementNotPresent("link=Off to Yosemite!"));
		assertTrue(selenium.isElementNotPresent("link=Caedmon Call Concert!"));
		selenium.clickAt("link=Events", RuntimeVariables.replace("Events"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Test Event"));
	}
}