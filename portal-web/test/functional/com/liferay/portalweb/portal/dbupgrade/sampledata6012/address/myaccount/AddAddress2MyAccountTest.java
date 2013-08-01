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
public class AddAddress2MyAccountTest extends BaseTestCase {
	public void testAddAddress2MyAccount() throws Exception {
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
		selenium.waitForVisible("//div[2]/div/span/span/button[1]");
		selenium.clickAt("//div[2]/div/span/span/button[1]",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//input[@id='_2_addressStreet1_2']");
		selenium.type("//input[@id='_2_addressStreet1_2']",
			RuntimeVariables.replace("123 Lets"));
		selenium.select("//select[@id='_2_addressTypeId2']",
			RuntimeVariables.replace("label=Other"));
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
			RuntimeVariables.replace("label=Canada"));
		selenium.waitForPartialText("//select[@id='_2_addressRegionId2']",
			"Ontario");
		selenium.select("//select[@id='_2_addressRegionId2']",
			RuntimeVariables.replace("label=Ontario"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.waitForSelectedLabel("//select[@id='_2_addressCountryId1']",
			"Canada");
		selenium.waitForSelectedLabel("//select[@id='_2_addressRegionId1']",
			"Ontario");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div[1]"));
		assertEquals("123 Lets",
			selenium.getValue("//input[@id='_2_addressStreet1_1']"));
		assertEquals("Other",
			selenium.getSelectedLabel("//select[@id='_2_addressTypeId1']"));
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