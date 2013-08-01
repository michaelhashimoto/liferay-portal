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

package com.liferay.portalweb.stagingorganization.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DefinePermissionsBlogsManagePagesOrganizationUserTest
	extends BaseTestCase {
	public void testDefinePermissionsBlogsManagePagesOrganizationUser()
		throws Exception {
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
		selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_128_keywords']",
			RuntimeVariables.replace("Organization"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Organization User"),
			selenium.getText("//tr/td[1]/a[contains(.,'Organization User')]"));
		selenium.clickAt("//tr/td[1]/a[contains(.,'Organization User')]",
			RuntimeVariables.replace("Organization User"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_128_add-permissions']",
			RuntimeVariables.replace("Blogs"));
		selenium.waitForText("//tr[3]/td[2]", "Add Entry");
		assertEquals(RuntimeVariables.replace("Add Entry"),
			selenium.getText("//tr[3]/td[2]"));
		assertFalse(selenium.isChecked(
				"//input[@value='com.liferay.portlet.blogsADD_ENTRY']"));
		selenium.check("//input[@value='com.liferay.portlet.blogsADD_ENTRY']");
		assertTrue(selenium.isChecked(
				"//input[@value='com.liferay.portlet.blogsADD_ENTRY']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_128_add-permissions']",
			RuntimeVariables.replace("Organization Administration"));
		selenium.waitForText("//tr[14]/td[2]", "Manage Pages");
		assertEquals(RuntimeVariables.replace("Manage Pages"),
			selenium.getText("//tr[14]/td[2]"));
		assertFalse(selenium.isChecked(
				"//input[@value='com.liferay.portal.model.GroupMANAGE_LAYOUTS']"));
		selenium.check(
			"//input[@value='com.liferay.portal.model.GroupMANAGE_LAYOUTS']");
		assertTrue(selenium.isChecked(
				"//input[@value='com.liferay.portal.model.GroupMANAGE_LAYOUTS']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Add Entry"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//tr[4]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Manage Pages"),
			selenium.getText("//tr[4]/td[3]"));
	}
}