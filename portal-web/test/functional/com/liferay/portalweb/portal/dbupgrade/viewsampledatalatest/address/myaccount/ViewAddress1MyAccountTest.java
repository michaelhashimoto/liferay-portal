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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.address.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAddress1MyAccountTest extends BaseTestCase {
	public void testViewAddress1MyAccount() throws Exception {
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
		selenium.clickAt("link=My Account",
			RuntimeVariables.replace("My Account"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//a[@id='_2_addressesLink']");
		assertTrue(selenium.isPartialText("//a[@id='_2_addressesLink']",
				"Addresses"));
		selenium.clickAt("//a[@id='_2_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.waitForVisible("//input[@id='_2_addressStreet1_0']");
		selenium.waitForSelectedLabel("//select[@id='_2_addressCountryId0']",
			"United States");
		selenium.waitForSelectedLabel("//select[@id='_2_addressRegionId0']",
			"California");
		assertEquals("1220 Brea Canyon Rd",
			selenium.getValue("//input[@id='_2_addressStreet1_0']"));
		assertEquals("Ste 12",
			selenium.getValue("//input[@id='_2_addressStreet2_0']"));
		assertEquals("Business",
			selenium.getSelectedLabel("//select[@id='_2_addressTypeId0']"));
		assertEquals("91789", selenium.getValue("//input[@id='_2_addressZip0']"));
		assertEquals("Walnut",
			selenium.getValue("//input[@id='_2_addressStreet3_0']"));
		assertEquals("Los Angeles",
			selenium.getValue("//input[@id='_2_addressCity0']"));
		assertEquals("United States",
			selenium.getSelectedLabel("//select[@id='_2_addressCountryId0']"));
		assertTrue(selenium.isChecked("//input[@id='_2_addressPrimary0']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_2_addressMailing0Checkbox']"));
		assertEquals("California",
			selenium.getSelectedLabel("//select[@id='_2_addressRegionId0']"));
	}
}