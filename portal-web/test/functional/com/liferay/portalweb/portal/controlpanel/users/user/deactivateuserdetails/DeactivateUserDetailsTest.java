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

package com.liferay.portalweb.portal.controlpanel.users.user.deactivateuserdetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeactivateUserDetailsTest extends BaseTestCase {
	public void testDeactivateUserDetails() throws Exception {
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
			RuntimeVariables.replace("usersn"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("userfn"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("userln"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("usersn"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace(""), selenium.getText("//td[5]/a"));
		assertEquals(RuntimeVariables.replace(""), selenium.getText("//td[6]/a"));
		assertEquals(RuntimeVariables.replace(""), selenium.getText("//td[7]/a"));
		assertFalse(selenium.isChecked("//td[1]/input[@name='_125_rowIds']"));
		selenium.clickAt("//td[1]/input[@name='_125_rowIds']",
			RuntimeVariables.replace("User Checkbox"));
		assertTrue(selenium.isChecked("//td[1]/input[@name='_125_rowIds']"));
		selenium.click(RuntimeVariables.replace("//input[@value='Deactivate']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to deactivate the selected users[\\s\\S]$"));
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"Inactive Users (Search All Users)"),
			selenium.getText("//div[@id='usersAdminUsersPanel']/div/div/span"));
		assertTrue(selenium.isVisible("//input[@value='Delete']"));
		assertTrue(selenium.isVisible("//input[@value='Restore']"));
		assertEquals(RuntimeVariables.replace("userfn"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("userln"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("usersn"),
			selenium.getText("//td[4]/a"));
	}
}