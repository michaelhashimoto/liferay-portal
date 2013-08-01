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

package com.liferay.portalweb.portal.dbupgrade.sampledata6012.messageboards.mbban;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserMBBanTest extends BaseTestCase {
	public void testAddUserMBBan() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Users", RuntimeVariables.replace("Users"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Add", RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_125_screenName']",
			RuntimeVariables.replace("mbbansn"));
		selenium.type("//input[@name='_125_emailAddress']",
			RuntimeVariables.replace("mbban@liferay.com"));
		selenium.type("//input[@name='_125_firstName']",
			RuntimeVariables.replace("mbbanfn"));
		selenium.type("//input[@name='_125_middleName']",
			RuntimeVariables.replace("mbbanmn"));
		selenium.type("//input[@name='_125_lastName']",
			RuntimeVariables.replace("mbbanln"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("mbbansn",
			selenium.getValue("//input[@name='_125_screenName']"));
		assertEquals("mbban@liferay.com",
			selenium.getValue("//input[@name='_125_emailAddress']"));
		assertEquals("mbbanfn",
			selenium.getValue("//input[@name='_125_firstName']"));
		assertEquals("mbbanmn",
			selenium.getValue("//input[@name='_125_middleName']"));
		assertEquals("mbbanln",
			selenium.getValue("//input[@name='_125_lastName']"));
	}
}