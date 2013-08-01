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

package com.liferay.portalweb.portal.dbsharding.baker;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class LoginBakerTest extends BaseTestCase {
	public void testLoginBaker() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.setTimeout("180000");
		selenium.open("/web/guest/home");
		selenium.waitForVisible("link=Sign In");
		selenium.click(RuntimeVariables.replace("link=Sign In"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_58_login']",
			RuntimeVariables.replace("test@baker.com"));
		selenium.type("//input[@id='_58_password']",
			RuntimeVariables.replace("test"));
		assertFalse(selenium.isChecked("//input[@id='_58_rememberMeCheckbox']"));
		selenium.clickAt("//input[@id='_58_rememberMeCheckbox']",
			RuntimeVariables.replace("Remember Me"));
		assertTrue(selenium.isChecked("//input[@id='_58_rememberMeCheckbox']"));
		selenium.waitForVisible("//input[@value='Sign In']");
		selenium.click(RuntimeVariables.replace("//input[@value='Sign In']"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@value='I Agree']");
		selenium.click(RuntimeVariables.replace("//input[@value='I Agree']"));
		selenium.waitForPageToLoad("30000");
		selenium.type("reminderQueryAnswer", RuntimeVariables.replace("Test"));
		selenium.waitForVisible("//input[@value='Save']");
		selenium.click(RuntimeVariables.replace("//input[@value='Save']"));
		selenium.waitForPageToLoad("30000");
	}
}