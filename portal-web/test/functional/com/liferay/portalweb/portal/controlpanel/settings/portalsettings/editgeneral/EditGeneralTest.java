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

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings.editgeneral;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditGeneralTest extends BaseTestCase {
	public void testEditGeneral() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//a[@id='_130_generalLink']");
		selenium.clickAt("//a[@id='_130_generalLink']",
			RuntimeVariables.replace("General"));
		selenium.type("//input[@id='_130_legalId']",
			RuntimeVariables.replace("LIFE"));
		selenium.type("//input[@id='_130_sicCode']",
			RuntimeVariables.replace("1234"));
		selenium.type("//input[@id='_130_tickerSymbol']",
			RuntimeVariables.replace("LFRY"));
		selenium.type("//input[@id='_130_industry']",
			RuntimeVariables.replace("Web Portal"));
		selenium.type("//input[@id='_130_type']",
			RuntimeVariables.replace("Open Source"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("LIFE", selenium.getValue("//input[@id='_130_legalId']"));
		assertEquals("1234", selenium.getValue("//input[@id='_130_sicCode']"));
		assertEquals("LFRY",
			selenium.getValue("//input[@id='_130_tickerSymbol']"));
		assertEquals("Web Portal",
			selenium.getValue("//input[@id='_130_industry']"));
		assertEquals("Open Source",
			selenium.getValue("//input[@id='_130_type']"));
	}
}