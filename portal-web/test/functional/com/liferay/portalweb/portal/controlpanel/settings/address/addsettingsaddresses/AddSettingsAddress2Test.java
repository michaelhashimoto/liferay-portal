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

package com.liferay.portalweb.portal.controlpanel.settings.address.addsettingsaddresses;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSettingsAddress2Test extends BaseTestCase {
	public void testAddSettingsAddress2() throws Exception {
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
		selenium.waitForVisible("//a[@id='_130_addressesLink']");
		selenium.clickAt("//a[@id='_130_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.waitForVisible("//span/button[1]");
		selenium.clickAt("//span/button[1]", RuntimeVariables.replace("Add Row"));
		selenium.waitForVisible("//input[@id='_130_addressStreet1_2']");
		selenium.type("//input[@id='_130_addressStreet1_2']",
			RuntimeVariables.replace("123. Liferay Ln."));
		selenium.type("//input[@id='_130_addressCity2']",
			RuntimeVariables.replace("Rays of Light"));
		selenium.type("//input[@id='_130_addressZip2']",
			RuntimeVariables.replace("12345"));
		selenium.select("//select[@id='_130_addressTypeId2']",
			RuntimeVariables.replace("label=Billing"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForVisible("//input[@id='_130_addressStreet1_1']");
		assertEquals("123. Liferay Ln.",
			selenium.getValue("//input[@id='_130_addressStreet1_1']"));
		assertEquals("Rays of Light",
			selenium.getValue("//input[@id='_130_addressCity1']"));
		assertEquals("12345",
			selenium.getValue("//input[@id='_130_addressZip1']"));
		assertEquals("Billing",
			selenium.getSelectedLabel("//select[@id='_130_addressTypeId1']"));
	}
}