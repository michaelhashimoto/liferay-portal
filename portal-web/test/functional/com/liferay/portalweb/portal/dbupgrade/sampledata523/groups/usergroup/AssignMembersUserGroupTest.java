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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.groups.usergroup;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignMembersUserGroupTest extends BaseTestCase {
	public void testAssignMembersUserGroup() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_127_name']",
			RuntimeVariables.replace("User Group Sample Test"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User Group Sample Test"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//strong/span"));
		selenium.clickAt("//strong/span", RuntimeVariables.replace("Actions"));
		selenium.waitForText("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Assign Members')]",
			"Assign Members");
		assertEquals(RuntimeVariables.replace("Assign Members"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Assign Members')]"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Assign Members')]"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Available", RuntimeVariables.replace("Available"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_127_keywords']",
			RuntimeVariables.replace("Joe Bloggs"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[4]/table/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("joebloggs"),
			selenium.getText("//div[4]/table/tbody/tr[3]/td[3]"));
		assertFalse(selenium.isChecked("//input[@name='_127_rowIds']"));
		selenium.clickAt("//input[@name='_127_rowIds']",
			RuntimeVariables.replace("Checkbox"));
		assertTrue(selenium.isChecked("//input[@name='_127_rowIds']"));
		selenium.clickAt("//input[@value='Update Associations']",
			RuntimeVariables.replace("Update Associations"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isChecked("//input[@name='_127_rowIds']"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[4]/table/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("joebloggs"),
			selenium.getText("//div[4]/table/tbody/tr[3]/td[3]"));
	}
}