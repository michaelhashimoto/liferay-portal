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

package com.liferay.portalweb.socialofficesite.blogs.blogsentry.sousaddblogsentrysite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DefinePermissionsSiteMemberTest extends BaseTestCase {
	public void testDefinePermissionsSiteMember() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//li[contains(@class,'user-menu has-submenu')]/a/span[@class='full-name']",
			RuntimeVariables.replace("User Name"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_128_keywords']",
			RuntimeVariables.replace("Site Member"));
		selenium.clickAt("//form[contains(@id,'_128_')]/span/span[2]/span/input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Member"),
			selenium.getText("//tr[contains(.,'Site Member')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Site Member')]/td[1]/a",
			RuntimeVariables.replace("Site Member"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_128_add-permissions']",
			RuntimeVariables.replace("Blogs"));
		selenium.waitForText("//form/h3[contains(.,'Blogs')]", "Blogs");
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//form/h3[contains(.,'Blogs')]"));
		Thread.sleep(1000);
		assertFalse(selenium.isChecked(
				"xPath=(//th[@class='col-1 col-rowChecker first']/input)[1]"));
		selenium.clickAt("xPath=(//th[@class='col-1 col-rowChecker first']/input)[1]",
			RuntimeVariables.replace("Blogs All Actions"));
		assertTrue(selenium.isChecked(
				"xPath=(//th[@class='col-1 col-rowChecker first']/input)[1]"));
		assertFalse(selenium.isChecked(
				"xPath=(//th[@class='col-1 col-rowChecker first']/input)[2]"));
		selenium.clickAt("xPath=(//th[@class='col-1 col-rowChecker first']/input)[2]",
			RuntimeVariables.replace("Blogs Entry All Actions"));
		assertTrue(selenium.isChecked(
				"xPath=(//th[@class='col-1 col-rowChecker first']/input)[2]"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"The role permissions were updated."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}