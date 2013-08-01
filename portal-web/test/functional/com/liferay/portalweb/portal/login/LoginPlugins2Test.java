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

package com.liferay.portalweb.portal.login;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class LoginPlugins2Test extends BaseTestCase {
	public void testLoginPlugins2() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.setTimeout("180000");
				selenium.open("/web/guest/home");
				selenium.waitForVisible("link=Sign In");
				selenium.clickAt("link=Sign In", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("_58_login");
				selenium.type("_58_login",
					RuntimeVariables.replace("test@liferay.com"));
				selenium.type("_58_password", RuntimeVariables.replace("test"));
				selenium.waitForVisible("_58_rememberMeCheckbox");
				selenium.click("_58_rememberMeCheckbox");
				selenium.waitForVisible("//input[@value='Sign In']");
				selenium.clickAt("//input[@value='Sign In']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(5000);

				boolean iAgreePresent = selenium.isElementPresent(
						"//input[@value='I Agree']");

				if (!iAgreePresent) {
					label = 2;

					continue;
				}

				selenium.waitForElementPresent("//input[@value='I Agree']");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='I Agree']"));
				selenium.waitForPageToLoad("30000");

			case 2:
				selenium.waitForVisible("reminderQueryAnswer");
				selenium.type("reminderQueryAnswer",
					RuntimeVariables.replace("Test"));
				selenium.waitForVisible("//input[@value='Save']");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Save']"));
				selenium.waitForPageToLoad("30000");

			case 100:
				label = -1;
			}
		}
	}
}