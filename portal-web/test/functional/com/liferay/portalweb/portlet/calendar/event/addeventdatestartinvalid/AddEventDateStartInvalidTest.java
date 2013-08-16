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

package com.liferay.portalweb.portlet.calendar.event.addeventdatestartinvalid;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddEventDateStartInvalidTest extends BaseTestCase {
	public void testAddEventDateStartInvalid() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Calendar Test Page",
			RuntimeVariables.replace("Calendar Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Event']",
			RuntimeVariables.replace("Add Event"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_8_title']",
			RuntimeVariables.replace("Invalid Start Date Test Event"));
		selenium.clickAt("//select[@id='_8_startdatemonth']",
			RuntimeVariables.replace("Start Date"));
		selenium.waitForVisible("//select[@id='_8_startdatemonth']");
		selenium.select("//select[@id='_8_startdatemonth']",
			RuntimeVariables.replace("February"));
		assertFalse(selenium.isPartialText("//select[@id='_8_startdateday']",
				"30"));
	}
}