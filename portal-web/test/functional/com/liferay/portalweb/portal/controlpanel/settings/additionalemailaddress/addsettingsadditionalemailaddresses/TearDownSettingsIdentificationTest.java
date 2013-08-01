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

package com.liferay.portalweb.portal.controlpanel.settings.additionalemailaddress.addsettingsadditionalemailaddresses;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownSettingsIdentificationTest extends BaseTestCase {
	public void testTearDownSettingsIdentification() throws Exception {
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
		assertTrue(selenium.isPartialText("//a[@id='_130_addressesLink']",
				"Addresses"));
		selenium.clickAt("//a[@id='_130_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_phoneNumbersLink']",
				"Phone Numbers"));
		selenium.clickAt("//a[@id='_130_phoneNumbersLink']",
			RuntimeVariables.replace("Phone Numbers"));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText(
				"//a[@id='_130_additionalEmailAddressesLink']",
				"Additional Email Addresses"));
		selenium.clickAt("//a[@id='_130_additionalEmailAddressesLink']",
			RuntimeVariables.replace("Additional Email Addresses"));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_websitesLink']",
				"Websites"));
		selenium.clickAt("//a[@id='_130_websitesLink']",
			RuntimeVariables.replace("Websites"));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//section/div/div/div/div"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_130_addressesLink']",
				"Addresses"));
		selenium.clickAt("//a[@id='_130_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_phoneNumbersLink']",
				"Phone Numbers"));
		selenium.clickAt("//a[@id='_130_phoneNumbersLink']",
			RuntimeVariables.replace("Phone Numbers"));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText(
				"//a[@id='_130_additionalEmailAddressesLink']",
				"Additional Email Addresses"));
		selenium.clickAt("//a[@id='_130_additionalEmailAddressesLink']",
			RuntimeVariables.replace("Additional Email Addresses"));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_websitesLink']",
				"Websites"));
		selenium.clickAt("//a[@id='_130_websitesLink']",
			RuntimeVariables.replace("Websites"));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//section/div/div/div/div"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_130_addressesLink']",
				"Addresses"));
		selenium.clickAt("//a[@id='_130_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_phoneNumbersLink']",
				"Phone Numbers"));
		selenium.clickAt("//a[@id='_130_phoneNumbersLink']",
			RuntimeVariables.replace("Phone Numbers"));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText(
				"//a[@id='_130_additionalEmailAddressesLink']",
				"Additional Email Addresses"));
		selenium.clickAt("//a[@id='_130_additionalEmailAddressesLink']",
			RuntimeVariables.replace("Additional Email Addresses"));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_websitesLink']",
				"Websites"));
		selenium.clickAt("//a[@id='_130_websitesLink']",
			RuntimeVariables.replace("Websites"));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//section/div/div/div/div"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_130_addressesLink']",
				"Addresses"));
		selenium.clickAt("//a[@id='_130_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_phoneNumbersLink']",
				"Phone Numbers"));
		selenium.clickAt("//a[@id='_130_phoneNumbersLink']",
			RuntimeVariables.replace("Phone Numbers"));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText(
				"//a[@id='_130_additionalEmailAddressesLink']",
				"Additional Email Addresses"));
		selenium.clickAt("//a[@id='_130_additionalEmailAddressesLink']",
			RuntimeVariables.replace("Additional Email Addresses"));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_websitesLink']",
				"Websites"));
		selenium.clickAt("//a[@id='_130_websitesLink']",
			RuntimeVariables.replace("Websites"));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//section/div/div/div/div"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_130_addressesLink']",
				"Addresses"));
		selenium.clickAt("//a[@id='_130_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_phoneNumbersLink']",
				"Phone Numbers"));
		selenium.clickAt("//a[@id='_130_phoneNumbersLink']",
			RuntimeVariables.replace("Phone Numbers"));
		selenium.clickAt("//div[7]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText(
				"//a[@id='_130_additionalEmailAddressesLink']",
				"Additional Email Addresses"));
		selenium.clickAt("//a[@id='_130_additionalEmailAddressesLink']",
			RuntimeVariables.replace("Additional Email Addresses"));
		selenium.clickAt("//div[8]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		assertTrue(selenium.isPartialText("//a[@id='_130_websitesLink']",
				"Websites"));
		selenium.clickAt("//a[@id='_130_websitesLink']",
			RuntimeVariables.replace("Websites"));
		selenium.clickAt("//div[9]/fieldset/div[2]/div/span/span/button[2]",
			RuntimeVariables.replace("Delete Row"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//section/div/div/div/div"));
	}
}