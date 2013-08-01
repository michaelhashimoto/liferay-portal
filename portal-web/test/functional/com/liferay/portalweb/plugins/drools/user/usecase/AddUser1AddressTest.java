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

package com.liferay.portalweb.plugins.drools.user.usecase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUser1AddressTest extends BaseTestCase {
	public void testAddUser1Address() throws Exception {
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
		selenium.clickAt("link=Users and Organizations",
			RuntimeVariables.replace("Users and Organizations"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_125_keywords']",
			RuntimeVariables.replace("user1"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[4]/a",
			RuntimeVariables.replace("user1"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//a[@id='_125_addressesLink']");
		assertTrue(selenium.isPartialText("//a[@id='_125_addressesLink']",
				"Addresses"));
		selenium.clickAt("//a[@id='_125_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.waitForVisible("//input[@id='_125_addressStreet1_0']");
		selenium.type("//input[@id='_125_addressStreet1_0']",
			RuntimeVariables.replace("1234 Test Street"));
		selenium.select("//select[@id='_125_addressCountryId0']",
			RuntimeVariables.replace("label=France"));
		selenium.waitForPartialText("//select[@id='_125_addressRegionId0']",
			"Champagne-Ardenne");
		selenium.select("//select[@id='_125_addressRegionId0']",
			RuntimeVariables.replace("label=Champagne-Ardenne"));
		selenium.type("//input[@id='_125_addressZip0']",
			RuntimeVariables.replace("10049"));
		selenium.type("//input[@id='_125_addressCity0']",
			RuntimeVariables.replace("Paris"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("1234 Test Street",
			selenium.getValue("//input[@id='_125_addressStreet1_0']"));
		assertEquals("10049",
			selenium.getValue("//input[@id='_125_addressZip0']"));
		assertEquals("Paris",
			selenium.getValue("//input[@id='_125_addressCity0']"));
		assertEquals("France",
			selenium.getSelectedLabel("//select[@id='_125_addressCountryId0']"));
		assertEquals("Champagne-Ardenne",
			selenium.getSelectedLabel("//select[@id='_125_addressRegionId0']"));
	}
}