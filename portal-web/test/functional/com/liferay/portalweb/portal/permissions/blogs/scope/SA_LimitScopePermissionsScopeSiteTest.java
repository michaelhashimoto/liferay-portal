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

package com.liferay.portalweb.portal.permissions.blogs.scope;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_LimitScopePermissionsScopeSiteTest extends BaseTestCase {
	public void testSA_LimitScopePermissionsScopeSite()
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
			RuntimeVariables.replace("Scope"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Scope"),
			selenium.getText("//tr/td[1]/a[contains(.,'Scope')]"));
		selenium.clickAt("//tr/td[1]/a[contains(.,'Scope')]",
			RuntimeVariables.replace("Scope"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Define Permissions"),
			selenium.getText(
				"//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]"));
		selenium.clickAt("//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_128_add-permissions']",
			RuntimeVariables.replace("label=Blogs"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr/td[4]/span/a[contains(.,'Limit Scope')]",
			RuntimeVariables.replace("Limit Scope"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Roles");
		selenium.waitForVisible("//input[@id='_128_name']");
		selenium.type("//input[@id='_128_name']",
			RuntimeVariables.replace("Site Name"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr/td[1]/a[contains(.,'Site Name')]",
			RuntimeVariables.replace("Site Name"));
		Thread.sleep(5000);
		selenium.selectWindow("null");
		selenium.waitForText("//span[@id='_128_groupHTMLcom.liferay.portlet.blogsADD_ENTRY']/span",
			"Site Name");
		assertEquals(RuntimeVariables.replace("Site Name"),
			selenium.getText(
				"//span[@id='_128_groupHTMLcom.liferay.portlet.blogsADD_ENTRY']/span"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.select("//select[@id='_128_add-permissions']",
			RuntimeVariables.replace("label=Blogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//form[@id='_128_fm']/h3"));
		assertTrue(selenium.isChecked(
				"//input[@value='com.liferay.portlet.blogsADD_ENTRY']"));
		assertEquals(RuntimeVariables.replace("Add Entry"),
			selenium.getText("//tr[contains(.,'Add Entry')]/td[2]"));
		assertEquals(RuntimeVariables.replace("Site Name"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[3]"));
	}
}