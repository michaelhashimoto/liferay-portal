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

package com.liferay.portalweb.portal.controlpanel.users.userphonenumber.adduserphonenumbers;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewUserPhoneNumbersTest extends BaseTestCase {
	public void testViewUserPhoneNumbers() throws Exception {
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
			RuntimeVariables.replace("usersn"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("userfn"),
			selenium.getText("//td[2]/a"));
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("userfn"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_125_phoneNumbersLink']",
				"Phone Numbers"));
		selenium.clickAt("//a[@id='_125_phoneNumbersLink']",
			RuntimeVariables.replace("Phone Numbers"));
		selenium.waitForVisible("//h1[@class='portlet-title']/span");
		assertEquals(RuntimeVariables.replace("Users and Organizations"),
			selenium.getText("//h1[@class='portlet-title']/span"));
		assertEquals(RuntimeVariables.replace("View All"),
			selenium.getText(
				"//div[@class='lfr-portlet-toolbar']/span/a[contains(.,'View All')]"));
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText(
				"//div[@class='lfr-portlet-toolbar']/span/ul/li/strong/a/span[contains(.,'Add')]"));
		assertEquals(RuntimeVariables.replace("Export Users"),
			selenium.getText(
				"//div[@class='lfr-portlet-toolbar']/span/a[contains(.,'Export Users')]"));
		assertEquals(RuntimeVariables.replace("userfn userln"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("\u00ab Back"),
			selenium.getText("//span[@class='header-back-to']/a"));
		assertEquals(RuntimeVariables.replace("Phone Numbers"),
			selenium.getText("//div[@id='_125_phoneNumbers']/h3"));
		assertEquals(RuntimeVariables.replace(
				"Phone number and type are required fields. Extension must be numeric."),
			selenium.getText("//div[@id='_125_phoneNumbers']/div"));
		assertEquals(RuntimeVariables.replace("Number"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Number')])[1]"));
		assertEquals(RuntimeVariables.replace("Extension"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Extension')])[1]"));
		assertEquals(RuntimeVariables.replace("Type"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Type')])[1]"));
		assertEquals("123-123-1234",
			selenium.getValue("//input[@id='_125_phoneNumber0']"));
		assertEquals("123",
			selenium.getValue("//input[@id='_125_phoneExtension0']"));
		assertEquals("Business",
			selenium.getSelectedLabel("//select[@id='_125_phoneTypeId0']"));
		assertTrue(selenium.isChecked("//input[@id='_125_phonePrimary0']"));
		assertTrue(selenium.isVisible(
				"xpath=(//button[contains(@class,'add-row aui-button')]/span)[1]"));
		assertTrue(selenium.isVisible(
				"xpath=(//button[contains(@class,'delete-row aui-button')]/span)[1]"));
		assertEquals(RuntimeVariables.replace("Number"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Number')])[2]"));
		assertEquals(RuntimeVariables.replace("Extension"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Extension')])[2]"));
		assertEquals(RuntimeVariables.replace("Type"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Type')])[2]"));
		assertEquals("123-123-1234",
			selenium.getValue("//input[@id='_125_phoneNumber1']"));
		assertEquals("123",
			selenium.getValue("//input[@id='_125_phoneExtension1']"));
		assertEquals("Business",
			selenium.getSelectedLabel("//select[@id='_125_phoneTypeId1']"));
		assertFalse(selenium.isChecked("//input[@id='_125_phonePrimary1']"));
		assertTrue(selenium.isVisible(
				"xpath=(//button[contains(@class,'add-row aui-button')]/span)[2]"));
		assertTrue(selenium.isVisible(
				"xpath=(//button[contains(@class,'delete-row aui-button')]/span)[2]"));
		assertEquals(RuntimeVariables.replace("Number"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Number')])[3]"));
		assertEquals(RuntimeVariables.replace("Extension"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Extension')])[3]"));
		assertEquals(RuntimeVariables.replace("Type"),
			selenium.getText(
				"xpath=(//div[@class='row-fields']/span/span/label[contains(.,'Type')])[3]"));
		assertEquals("123-123-1234",
			selenium.getValue("//input[@id='_125_phoneNumber2']"));
		assertEquals("123",
			selenium.getValue("//input[@id='_125_phoneExtension2']"));
		assertEquals("Business",
			selenium.getSelectedLabel("//select[@id='_125_phoneTypeId2']"));
		assertFalse(selenium.isChecked("//input[@id='_125_phonePrimary2']"));
		assertTrue(selenium.isVisible(
				"xpath=(//button[contains(@class,'add-row aui-button')]/span)[3]"));
		assertTrue(selenium.isVisible(
				"xpath=(//button[contains(@class,'delete-row aui-button')]/span)[3]"));
	}
}