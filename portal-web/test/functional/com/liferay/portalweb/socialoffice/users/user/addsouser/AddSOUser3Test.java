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

package com.liferay.portalweb.socialoffice.users.user.addsouser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSOUser3Test extends BaseTestCase {
	public void testAddSOUser3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//li[contains(@class,'user-menu has-submenu')]/a/span[@class='full-name']",
			RuntimeVariables.replace("User Name"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Users and Organizations",
			RuntimeVariables.replace("Users and Organizations"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span[@title='Add']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Add']/ul/li/strong/a/span",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'User')]");
		assertEquals(RuntimeVariables.replace("User"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'User')]"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'User')]"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_125_screenName']",
			RuntimeVariables.replace("socialoffice03"));
		selenium.type("//input[@id='_125_emailAddress']",
			RuntimeVariables.replace("socialoffice03@liferay.com"));
		selenium.type("//input[@id='_125_firstName']",
			RuntimeVariables.replace("Social03"));
		selenium.type("//input[@id='_125_middleName']",
			RuntimeVariables.replace("Office03"));
		selenium.type("//input[@id='_125_lastName']",
			RuntimeVariables.replace("User03"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("socialoffice03",
			selenium.getValue("//input[@id='_125_screenName']"));
		assertEquals("socialoffice03@liferay.com",
			selenium.getValue("//input[@id='_125_emailAddress']"));
		assertEquals("Social03",
			selenium.getValue("//input[@id='_125_firstName']"));
		assertEquals("Office03",
			selenium.getValue("//input[@id='_125_middleName']"));
		assertEquals("User03", selenium.getValue("//input[@id='_125_lastName']"));
	}
}