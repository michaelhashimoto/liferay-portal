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
public class AssignUserSubOrganization2Test extends BaseTestCase {
	public void testAssignUserSubOrganization2() throws Exception {
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
		selenium.type("//input[@id='_125_keywords']",
			RuntimeVariables.replace("Test Organization 1 Edited"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Organization 1 Edited"),
			selenium.getText("//a[2]/strong"));
		selenium.clickAt("//a[2]/strong",
			RuntimeVariables.replace("Test Organization 1 Edited"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Suborganization 2"),
			selenium.getText("//a[2]/strong"));
		selenium.clickAt("//a[2]/strong",
			RuntimeVariables.replace("Test Suborganization 2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Assign Users"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li[3]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li[3]/a",
			RuntimeVariables.replace("Assign Users"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Available"),
			selenium.getText("//li[2]/span/a"));
		selenium.clickAt("//li[2]/span/a", RuntimeVariables.replace("Available"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_125_keywords']",
			RuntimeVariables.replace("selenium01"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("selenium01"),
			selenium.getText("//tr[3]/td[3]"));
		selenium.clickAt("//input[@name='_125_rowIds']",
			RuntimeVariables.replace("Checkbox"));
		selenium.clickAt("//input[@value='Update Associations']",
			RuntimeVariables.replace("Update Associations"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Current"),
			selenium.getText("//form/ul/li[1]/span/a"));
		selenium.clickAt("//form/ul/li[1]/span/a",
			RuntimeVariables.replace("Current"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("selenium01"),
			selenium.getText("//tr[3]/td[3]"));
	}
}