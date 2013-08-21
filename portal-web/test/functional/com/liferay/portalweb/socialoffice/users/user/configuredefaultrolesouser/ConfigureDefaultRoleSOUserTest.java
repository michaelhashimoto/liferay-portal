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

package com.liferay.portalweb.socialoffice.users.user.configuredefaultrolesouser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigureDefaultRoleSOUserTest extends BaseTestCase {
	public void testConfigureDefaultRoleSOUser() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//li[contains(@class,'user-menu has-submenu')]/a/span[@class='full-name']",
			RuntimeVariables.replace("User Name"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@id='_130_usersLink']",
			RuntimeVariables.replace("Users(Modified)"));
		selenium.clickAt("link=Default User Associations",
			RuntimeVariables.replace("Default User Associations"));
		selenium.type("//textarea[@id='_130_admin.default.role.names']",
			RuntimeVariables.replace("Power User\nUser\nSocial Office User"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("link=Default User Associations",
			RuntimeVariables.replace("Default User Associations"));
		assertEquals("Power User\nUser\nSocial Office User",
			selenium.getValue(
				"//textarea[@name='_130_settings--admin.default.role.names--']"));
	}
}