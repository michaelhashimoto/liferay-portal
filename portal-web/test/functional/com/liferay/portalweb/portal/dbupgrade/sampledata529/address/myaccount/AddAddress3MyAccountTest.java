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

package com.liferay.portalweb.portal.dbupgrade.sampledata529.address.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAddress3MyAccountTest extends BaseTestCase {
	public void testAddAddress3MyAccount() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=My Account");
		selenium.clickAt("link=My Account",
			RuntimeVariables.replace("My Account"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@id='addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.waitForVisible("//input[@id='_2_addressStreet1_0']");
		selenium.clickAt("//div[2]/span/a[1]", RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//input[@id='_2_addressStreet1_3']");
		selenium.type("//input[@id='_2_addressStreet1_3']",
			RuntimeVariables.replace("1220 Brea Canyon Rd"));
		selenium.select("//select[@id='_2_addressTypeId3']",
			RuntimeVariables.replace("label=Business"));
		selenium.type("//input[@id='_2_addressStreet2_3']",
			RuntimeVariables.replace("Ste 12"));
		selenium.type("//input[@id='_2_addressZip3']",
			RuntimeVariables.replace("91789"));
		selenium.type("//input[@id='_2_addressStreet3_3']",
			RuntimeVariables.replace("Walnut"));
		selenium.type("//input[@id='_2_addressCity3']",
			RuntimeVariables.replace("Los Angeles"));
		selenium.waitForPartialText("//select[@id='_2_addressCountryId3']",
			"United States");
		selenium.select("//select[@id='_2_addressCountryId3']",
			RuntimeVariables.replace("label=United States"));
		Thread.sleep(5000);
		selenium.waitForPartialText("//select[@id='_2_addressRegionId3']",
			"California");
		selenium.select("//select[@id='_2_addressRegionId3']",
			RuntimeVariables.replace("label=California"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForSelectedLabel("//select[@id='_2_addressCountryId2']",
			"United States");
		selenium.waitForSelectedLabel("//select[@id='_2_addressRegionId2']",
			"California");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("1220 Brea Canyon Rd",
			selenium.getValue("//input[@id='_2_addressStreet1_2']"));
		assertEquals("Business",
			selenium.getSelectedLabel("//select[@name='_2_addressTypeId2']"));
		assertEquals("Ste 12",
			selenium.getValue("//input[@id='_2_addressStreet2_2']"));
		assertEquals("91789", selenium.getValue("//input[@id='_2_addressZip2']"));
		assertEquals("Walnut",
			selenium.getValue("//input[@id='_2_addressStreet3_2']"));
		assertEquals("Los Angeles",
			selenium.getValue("//input[@id='_2_addressCity2']"));
		assertEquals("United States",
			selenium.getSelectedLabel("//select[@id='_2_addressCountryId2']"));
		assertEquals("California",
			selenium.getSelectedLabel("//select[@id='_2_addressRegionId2']"));
	}
}