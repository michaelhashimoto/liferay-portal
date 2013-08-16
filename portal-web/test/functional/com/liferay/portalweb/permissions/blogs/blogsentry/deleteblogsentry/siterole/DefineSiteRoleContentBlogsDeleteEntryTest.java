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

package com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.siterole;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DefineSiteRoleContentBlogsDeleteEntryTest extends BaseTestCase {
	public void testDefineSiteRoleContentBlogsDeleteEntry()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
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
			RuntimeVariables.replace("Siterole"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Roles Siterole Name"),
			selenium.getText("//tr[contains(.,'Roles Siterole Name')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Site"),
			selenium.getText("//tr[contains(.,'Roles Siterole Name')]/td[2]/a"));
		selenium.clickAt("//tr[contains(.,'Roles Siterole Name')]/td[1]/a",
			RuntimeVariables.replace("Roles Siterole Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Define Permissions"),
			selenium.getText(
				"//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]"));
		selenium.clickAt("//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Roles Siterole Name"),
			selenium.getText("//h1[@class='header-title']"));
		selenium.select("//select[@id='_128_add-permissions']",
			RuntimeVariables.replace("label=Blogs"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isChecked(
				"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryDELETE']"));
		selenium.check(
			"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryDELETE']");
		assertTrue(selenium.isChecked(
				"//input[@value='com.liferay.portlet.blogs.model.BlogsEntryDELETE']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Summary"),
			selenium.getText("//section[@id='portlet_128']/div/div/div/h3"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[2]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[3]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[4]/span/a/span"));
	}
}