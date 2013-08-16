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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.address.myaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAddress2MyAccountTest extends BaseTestCase {
	public void testAddAddress2MyAccount() throws Exception {
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
		selenium.waitForVisible("//button[contains(@class,'add-row')]");
		selenium.clickAt("//button[contains(@class,'add-row')]",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//input[@id='_2_addressStreet1_2']");
		selenium.type("//input[@id='_2_addressStreet1_2']",
			RuntimeVariables.replace("123 Lets"));
		selenium.select("//select[@id='_2_addressTypeId2']",
			RuntimeVariables.replace("Other"));
		selenium.type("//input[@id='_2_addressStreet2_2']",
			RuntimeVariables.replace("897 Hope"));
		selenium.type("//input[@id='_2_addressZip2']",
			RuntimeVariables.replace("00000"));
		selenium.type("//input[@id='_2_addressStreet3_2']",
			RuntimeVariables.replace("7896 This"));
		selenium.type("//input[@id='_2_addressCity2']",
			RuntimeVariables.replace("Works"));
		selenium.waitForPartialText("//select[@id='_2_addressCountryId2']",
			"Canada");
		selenium.select("//select[@id='_2_addressCountryId2']",
			RuntimeVariables.replace("Canada"));
		selenium.waitForPartialText("//select[@id='_2_addressRegionId2']",
			"Ontario");
		selenium.select("//select[@id='_2_addressRegionId2']",
			RuntimeVariables.replace("Ontario"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForSelectedLabel("//select[@id='_2_addressCountryId1']",
			"Canada");
		selenium.waitForSelectedLabel("//select[@id='_2_addressRegionId1']",
			"Ontario");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("123 Lets",
			selenium.getValue("//input[@id='_2_addressStreet1_1']"));
		assertEquals("Other",
			selenium.getSelectedLabel("//select[@name='_2_addressTypeId1']"));
		assertEquals("897 Hope",
			selenium.getValue("//input[@id='_2_addressStreet2_1']"));
		assertEquals("00000", selenium.getValue("//input[@id='_2_addressZip1']"));
		assertEquals("7896 This",
			selenium.getValue("//input[@id='_2_addressStreet3_1']"));
		assertEquals("Works",
			selenium.getValue("//input[@id='_2_addressCity1']"));
		assertEquals("Canada",
			selenium.getSelectedLabel("//select[@id='_2_addressCountryId1']"));
		assertEquals("Ontario",
			selenium.getSelectedLabel("//select[@id='_2_addressRegionId1']"));
	}
}