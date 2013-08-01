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

package com.liferay.portalweb.portal.permissions.imagegallery.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignUserPortletRolesTest extends BaseTestCase {
	public void testAssignUserPortletRoles() throws Exception {
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
			RuntimeVariables.replace("portlet"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Portlet"),
			selenium.getText("//tr[contains(.,'Portlet')]/td[2]/a"));
		selenium.clickAt("//tr[contains(.,'Portlet')]/td[2]/a",
			RuntimeVariables.replace("Portlet"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_125_rolesLink']", "Roles"));
		selenium.clickAt("//a[@id='_125_rolesLink']",
			RuntimeVariables.replace("Roles"));
		selenium.waitForVisible("//div[@id='_125_roles']/span/a");
		assertEquals(RuntimeVariables.replace("Select"),
			selenium.getText("//div[@id='_125_roles']/span/a"));
		selenium.clickAt("//div[@id='_125_roles']/span/a",
			RuntimeVariables.replace("Select"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Users and Organizations");
		selenium.waitForVisible("//input[@id='_125_keywords']");
		selenium.type("//input[@id='_125_keywords']",
			RuntimeVariables.replace("Portlet"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Portlet"),
			selenium.getText("//tr[3]/td/a"));
		selenium.clickAt("//tr[3]/td/a", RuntimeVariables.replace("Portlet"));
		selenium.selectWindow("null");
		selenium.waitForVisible("//div[@id='_125_rolesSearchContainer']");
		assertTrue(selenium.isPartialText(
				"//div[@id='_125_rolesSearchContainer']", "Portlet"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Portlet"),
			selenium.getText("//tr[3]/td[1]"));
	}
}