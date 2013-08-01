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

package com.liferay.portalweb.portal.dbupgrade.sampledata6012.address.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAddress1MyAccountTest extends BaseTestCase {
	public void testAddAddress1MyAccount() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=My Account",
			RuntimeVariables.replace("My Account"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@id='_2_addressesLink']",
			RuntimeVariables.replace("Addresses Link"));
		selenium.waitForVisible("//input[@id='_2_addressStreet1_0']");
		selenium.type("//input[@id='_2_addressStreet1_0']",
			RuntimeVariables.replace("1220 Brea Canyon Rd"));
		selenium.type("//input[@id='_2_addressStreet2_0']",
			RuntimeVariables.replace("Ste 12"));
		selenium.select("//select[@name='_2_addressTypeId0']",
			RuntimeVariables.replace("label=Business"));
		selenium.type("//input[@id='_2_addressZip0']",
			RuntimeVariables.replace("91789"));
		selenium.type("//input[@id='_2_addressStreet3_0']",
			RuntimeVariables.replace("Walnut"));
		selenium.type("//input[@id='_2_addressCity0']",
			RuntimeVariables.replace("Los Angeles"));
		selenium.waitForPartialText("//select[@name='_2_addressCountryId0']",
			"United States");
		selenium.select("//select[@name='_2_addressCountryId0']",
			RuntimeVariables.replace("label=United States"));
		selenium.clickAt("//input[@id='_2_addressPrimary0']",
			RuntimeVariables.replace("Primary"));
		selenium.clickAt("//input[@id='_2_addressMailing0Checkbox']",
			RuntimeVariables.replace("Mailing"));
		selenium.waitForPartialText("//select[@name='_2_addressRegionId0']",
			"California");
		selenium.select("//select[@name='_2_addressRegionId0']",
			RuntimeVariables.replace("label=California"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.waitForSelectedLabel("//select[@name='_2_addressCountryId0']",
			"United States");
		selenium.waitForSelectedLabel("//select[@name='_2_addressRegionId0']",
			"California");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div[1]"));
		assertEquals("1220 Brea Canyon Rd",
			selenium.getValue("//input[@id='_2_addressStreet1_0']"));
		assertEquals("Ste 12",
			selenium.getValue("//input[@id='_2_addressStreet2_0']"));
		assertEquals("Business",
			selenium.getSelectedLabel("//select[@name='_2_addressTypeId0']"));
		assertEquals("91789", selenium.getValue("//input[@id='_2_addressZip0']"));
		assertEquals("Walnut",
			selenium.getValue("//input[@id='_2_addressStreet3_0']"));
		assertEquals("Los Angeles",
			selenium.getValue("//input[@id='_2_addressCity0']"));
		assertEquals("United States",
			selenium.getSelectedLabel("//select[@name='_2_addressCountryId0']"));
		assertTrue(selenium.isChecked("//input[@id='_2_addressPrimary0']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_addressMailing0Checkbox']"));
		assertEquals("California",
			selenium.getSelectedLabel("//select[@name='_2_addressRegionId0']"));
	}
}