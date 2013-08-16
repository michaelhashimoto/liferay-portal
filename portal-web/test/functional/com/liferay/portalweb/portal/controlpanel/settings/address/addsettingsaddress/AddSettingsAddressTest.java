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

package com.liferay.portalweb.portal.controlpanel.settings.address.addsettingsaddress;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSettingsAddressTest extends BaseTestCase {
	public void testAddSettingsAddress() throws Exception {
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
		selenium.type("//input[@id='_130_addressStreet1_0']",
			RuntimeVariables.replace("123. Liferay Ln."));
		selenium.type("//input[@id='_130_addressCity0']",
			RuntimeVariables.replace("Rays of Light"));
		selenium.type("//input[@id='_130_addressZip0']",
			RuntimeVariables.replace("12345"));
		selenium.select("//select[@id='_130_addressCountryId0']",
			RuntimeVariables.replace("label=United States"));
		selenium.waitForPartialText("//select[@id='_130_addressRegionId0']",
			"California");
		selenium.select("//select[@id='_130_addressRegionId0']",
			RuntimeVariables.replace("label=California"));
		selenium.select("//select[@id='_130_addressTypeId0']",
			RuntimeVariables.replace("label=Billing"));
		selenium.clickAt("//input[@id='_130_addressMailing0Checkbox']",
			RuntimeVariables.replace("Mailing Checkbox"));
		selenium.clickAt("//input[@id='_130_addressPrimary0']",
			RuntimeVariables.replace("Primary Button"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForVisible("//input[@id='_130_addressStreet1_0']");
		assertEquals("123. Liferay Ln.",
			selenium.getValue("//input[@id='_130_addressStreet1_0']"));
		assertEquals("Rays of Light",
			selenium.getValue("//input[@id='_130_addressCity0']"));
		assertEquals("12345",
			selenium.getValue("//input[@id='_130_addressZip0']"));
		assertEquals("Billing",
			selenium.getSelectedLabel("//select[@id='_130_addressTypeId0']"));
		assertEquals("United States",
			selenium.getSelectedLabel("//select[@id='_130_addressCountryId0']"));
		assertEquals("California",
			selenium.getSelectedLabel("//select[@id='_130_addressRegionId0']"));
	}
}