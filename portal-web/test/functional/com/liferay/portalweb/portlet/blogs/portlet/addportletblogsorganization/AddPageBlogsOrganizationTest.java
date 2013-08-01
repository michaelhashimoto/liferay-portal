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

package com.liferay.portalweb.portlet.blogs.portlet.addportletblogsorganization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPageBlogsOrganizationTest extends BaseTestCase {
	public void testAddPageBlogsOrganization() throws Exception {
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
		selenium.clickAt("link=Sites", RuntimeVariables.replace("Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Organization Name"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Manage Pages')]/a");
		assertEquals(RuntimeVariables.replace("Manage Pages"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Manage Pages')]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Manage Pages')]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("link=Public Pages");
		selenium.clickAt("link=Public Pages",
			RuntimeVariables.replace("Public Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Page"),
			selenium.getText(
				"//div[@id='_156_layoutSetToolbar']/span/button[contains(.,'Add Page')]"));
		selenium.clickAt("//div[@id='_156_layoutSetToolbar']/span/button[contains(.,'Add Page')]",
			RuntimeVariables.replace("Add Page"));
		selenium.waitForVisible("//input[@name='_156_name_en_US']");
		selenium.type("//input[@name='_156_name_en_US']",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.clickAt("//input[@value='Add Page']",
			RuntimeVariables.replace("Add Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForVisible(
			"//ul[@class='aui-tree-container']/li/div/div/a[contains(.,'Blogs Test Page')]");
		assertEquals(RuntimeVariables.replace("Blogs Test Page"),
			selenium.getText(
				"//ul[@class='aui-tree-container']/li/div/div/a[contains(.,'Blogs Test Page')]"));
	}
}