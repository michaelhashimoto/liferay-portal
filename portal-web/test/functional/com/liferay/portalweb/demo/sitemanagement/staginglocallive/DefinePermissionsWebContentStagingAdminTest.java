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

package com.liferay.portalweb.demo.sitemanagement.staginglocallive;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DefinePermissionsWebContentStagingAdminTest extends BaseTestCase {
	public void testDefinePermissionsWebContentStagingAdmin()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_128_keywords']",
			RuntimeVariables.replace("Staging"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Staging Admin"),
			selenium.getText("//td[1]/a"));
		selenium.clickAt("//td[1]/a", RuntimeVariables.replace("Staging Admin"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_128_add-permissions']",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForVisible("xPath=(//input[@name='_128_allRowIds'])[1]");
		assertFalse(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[1]"));
		selenium.clickAt("xPath=(//input[@name='_128_allRowIds'])[1]",
			RuntimeVariables.replace("Web Content"));
		assertTrue(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[1]"));
		assertFalse(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[2]"));
		selenium.clickAt("xPath=(//input[@name='_128_allRowIds'])[2]",
			RuntimeVariables.replace("Web Content Feed"));
		assertTrue(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[2]"));
		assertFalse(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[3]"));
		selenium.clickAt("xPath=(//input[@name='_128_allRowIds'])[3]",
			RuntimeVariables.replace("Web Content Management"));
		assertTrue(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[3]"));
		assertFalse(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[4]"));
		selenium.clickAt("xPath=(//input[@name='_128_allRowIds'])[4]",
			RuntimeVariables.replace("Web Content Structure"));
		assertTrue(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[4]"));
		assertFalse(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[5]"));
		selenium.clickAt("xPath=(//input[@name='_128_allRowIds'])[5]",
			RuntimeVariables.replace("Web Content Template"));
		assertTrue(selenium.isChecked(
				"xPath=(//input[@name='_128_allRowIds'])[5]"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}