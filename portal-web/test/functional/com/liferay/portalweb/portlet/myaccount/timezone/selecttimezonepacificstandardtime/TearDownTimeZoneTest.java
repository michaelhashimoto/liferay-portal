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

package com.liferay.portalweb.portlet.myaccount.timezone.selecttimezonepacificstandardtime;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownTimeZoneTest extends BaseTestCase {
	public void testTearDownTimeZone() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Joe Bloggs");
		selenium.clickAt("link=Joe Bloggs",
			RuntimeVariables.replace("Joe Bloggs"));
		Thread.sleep(5000);
		selenium.waitForVisible("//a[@id='_2_displaySettingsLink']");
		selenium.clickAt("//a[@id='_2_displaySettingsLink']",
			RuntimeVariables.replace("Display Settings"));
		selenium.waitForVisible("//select[@name='_2_timeZoneId']");
		selenium.select("//select[@name='_2_timeZoneId']",
			RuntimeVariables.replace("(UTC ) Coordinated Universal Time"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("(UTC ) Coordinated Universal Time",
			selenium.getSelectedLabel("//select[@name='_2_timeZoneId']"));
	}
}