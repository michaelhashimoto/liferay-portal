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

package com.liferay.portalweb.kaleo.myworkflowtasks.workflowtask.assigntouserwebcontentactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class UserSN_SignInTest extends BaseTestCase {
	public void testUserSN_SignIn() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Sign In");
		selenium.clickAt("link=Sign In", RuntimeVariables.replace("Sign In"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_58_login']",
			RuntimeVariables.replace("useremail@liferay.com"));
		selenium.type("//input[@id='_58_password']",
			RuntimeVariables.replace("password"));
		selenium.clickAt("//input[@id='_58_rememberMeCheckbox']",
			RuntimeVariables.replace("Remember Me Checkbox"));
		selenium.clickAt("//input[@value='Sign In']",
			RuntimeVariables.replace("Sign In"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='I Agree']",
			RuntimeVariables.replace("I Agree"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='password1']",
			RuntimeVariables.replace("test"));
		selenium.type("//input[@id='password2']",
			RuntimeVariables.replace("test"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.type("reminderQueryAnswer", RuntimeVariables.replace("test"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
	}
}