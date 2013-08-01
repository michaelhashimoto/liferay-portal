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

package com.liferay.portalweb.portal.permissions.imagegallery.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignUserSiteAdminRolesTest extends BaseTestCase {
	public void testAssignUserSiteAdminRoles() throws Exception {
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
			RuntimeVariables.replace("siteadmin"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("SiteAdmin"),
			selenium.getText("//tr[contains(.,'SiteAdmin')]/td[2]/a"));
		selenium.clickAt("//tr[contains(.,'SiteAdmin')]/td[2]/a",
			RuntimeVariables.replace("SiteAdmin"));
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
			RuntimeVariables.replace("SiteAdmin"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("SiteAdmin"),
			selenium.getText("//tr[contains(.,'SiteAdmin')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'SiteAdmin')]/td[1]/a",
			RuntimeVariables.replace("SiteAdmin"));
		selenium.selectWindow("null");
		selenium.waitForPartialText("//tr[contains(.,'SiteAdmin')]/td[1]",
			"SiteAdmin");
		assertTrue(selenium.isPartialText(
				"//tr[contains(.,'SiteAdmin')]/td[1]", "SiteAdmin"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}