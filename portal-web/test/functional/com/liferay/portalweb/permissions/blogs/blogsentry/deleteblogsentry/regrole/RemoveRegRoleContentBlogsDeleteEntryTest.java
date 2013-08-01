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

package com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.regrole;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemoveRegRoleContentBlogsDeleteEntryTest extends BaseTestCase {
	public void testRemoveRegRoleContentBlogsDeleteEntry()
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
			RuntimeVariables.replace("Regrole"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Roles Regrole Name"),
			selenium.getText("//tr[contains(.,'Roles Regrole Name')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Regular"),
			selenium.getText("//tr[contains(.,'Roles Regrole Name')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//tr[contains(.,'Roles Regrole Name')]/td[3]/a"));
		selenium.clickAt("//tr[contains(.,'Roles Regrole Name')]/td[1]/a",
			RuntimeVariables.replace("Roles Regrole Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Define Permissions"),
			selenium.getText(
				"//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]"));
		selenium.clickAt("//ul[@class='aui-tabview-list']/li/span/a[contains(.,'Define Permissions')]",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Roles Regrole Name"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Summary"),
			selenium.getText("//div[@class='portlet-body']//div/h3"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[2]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[3]"));
		assertEquals(RuntimeVariables.replace("Portal"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[4]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//tr[contains(.,'Blogs')]/td[5]/span/a/span"));
		selenium.clickAt("//tr[contains(.,'Blogs')]/td[5]/span/a/span",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("The permission was deleted."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"This role does not have any permissions."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}