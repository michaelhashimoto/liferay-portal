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

package com.liferay.portalweb.portal.controlpanel.users.user.changeuserpassword;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_ChangeUserPasswordTest extends BaseTestCase {
	public void testUser_ChangeUserPassword() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		assertEquals(RuntimeVariables.replace("userfn userln"),
			selenium.getText("//li[@id='_145_userAvatar']/span/a"));
		selenium.clickAt("//li[@id='_145_userAvatar']/span/a",
			RuntimeVariables.replace("userfn userln"));
		Thread.sleep(5000);
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForVisible("//a[@id='_2_passwordLink']");
		assertTrue(selenium.isPartialText("//a[@id='_2_passwordLink']",
				"Password"));
		selenium.clickAt("//a[@id='_2_passwordLink']",
			RuntimeVariables.replace("Password"));
		selenium.waitForVisible("//input[@id='_2_password0']");
		selenium.type("//input[@id='_2_password0']",
			RuntimeVariables.replace("test"));
		selenium.type("//input[@id='_2_password1']",
			RuntimeVariables.replace("test2"));
		selenium.type("//input[@id='_2_password2']",
			RuntimeVariables.replace("test2"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.selectFrame("relative=top");
	}
}