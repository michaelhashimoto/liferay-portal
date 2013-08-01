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

package com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.assignmembersugusergroupuser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAssignMembersUGUserGroupUserTest extends BaseTestCase {
	public void testViewAssignMembersUGUserGroupUser()
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
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Assign Members')]/a");
		assertEquals(RuntimeVariables.replace("Assign Members"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Assign Members')]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Assign Members')]/a"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Current"),
			selenium.getText("//ul[@class='aui-tabview-list']/li/span/a/strong"));
		assertTrue(selenium.isChecked("//input[@name='_127_allRowIds']"));
		assertTrue(selenium.isChecked("//input[@name='_127_rowIds']"));
		assertEquals(RuntimeVariables.replace("userfn userln"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("usersn"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Available"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[2]/span/a"));
		selenium.clickAt("//ul[@class='aui-tabview-list']/li[2]/span/a",
			RuntimeVariables.replace("Available"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_127_keywords']",
			RuntimeVariables.replace("user"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isChecked("//input[@name='_127_allRowIds']"));
		assertTrue(selenium.isChecked("//input[@name='_127_rowIds']"));
		assertEquals(RuntimeVariables.replace("userfn userln"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("usersn"),
			selenium.getText("//tr[3]/td[3]"));
	}
}