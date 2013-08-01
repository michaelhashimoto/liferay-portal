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

package com.liferay.portalweb.demo.useradmin.usermanagementorganizations;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationInvalidEmailTest extends BaseTestCase {
	public void testAddOrganizationInvalidEmail() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Users and Organizations",
			RuntimeVariables.replace("Users and Organizations"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_125_keywords']",
			RuntimeVariables.replace("Test Organization 1 Edited"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Organization 1 Edited"),
			selenium.getText("//a[2]/strong"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//a[@id='_125_additionalEmailAddressesLink']",
				"Additional Email Addresses"));
		selenium.clickAt("//a[@id='_125_additionalEmailAddressesLink']",
			RuntimeVariables.replace("Additional Email Addresses"));
		selenium.waitForVisible("//input[@id='_125_emailAddressAddress0']");
		selenium.type("//input[@id='_125_emailAddressAddress0']",
			RuntimeVariables.replace("testuser"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//label/div");
		assertEquals(RuntimeVariables.replace(
				"Please enter a valid email address."),
			selenium.getText("//label/div"));
		selenium.type("//input[@id='_125_emailAddressAddress0']",
			RuntimeVariables.replace("testuser@liferay.com"));
		assertFalse(selenium.isChecked(
				"//input[@id='_125_emailAddressPrimary0']"));
		selenium.clickAt("//input[@id='_125_emailAddressPrimary0']",
			RuntimeVariables.replace("Primary"));
		assertTrue(selenium.isChecked(
				"//input[@id='_125_emailAddressPrimary0']"));
		assertFalse(selenium.isTextPresent("//label/div"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}