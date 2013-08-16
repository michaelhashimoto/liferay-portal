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

package com.liferay.portalweb.portal.controlpanel.settings.phonenumber.addsettingsphonenumbers;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSettingsPhoneNumber2Test extends BaseTestCase {
	public void testAddSettingsPhoneNumber2() throws Exception {
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
		selenium.waitForVisible("//a[@id='_130_phoneNumbersLink']");
		selenium.clickAt("//a[@id='_130_phoneNumbersLink']",
			RuntimeVariables.replace("Phone Numbers"));
		selenium.waitForVisible(
			"//div[7]/fieldset/div[2]/div/span/span/button[1]");
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[1]",
			RuntimeVariables.replace("Add Row"));
		selenium.type("//input[@id='_130_phoneNumber2']",
			RuntimeVariables.replace("123-123-1234"));
		selenium.type("//input[@id='_130_phoneExtension2']",
			RuntimeVariables.replace("123"));
		selenium.select("//select[@id='_130_phoneTypeId2']",
			RuntimeVariables.replace("label=Other"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("123-123-1234",
			selenium.getValue("//input[@id='_130_phoneNumber1']"));
		assertEquals("123",
			selenium.getValue("//input[@id='_130_phoneExtension1']"));
		assertEquals("Other",
			selenium.getSelectedLabel("//select[@id='_130_phoneTypeId1']"));
	}
}