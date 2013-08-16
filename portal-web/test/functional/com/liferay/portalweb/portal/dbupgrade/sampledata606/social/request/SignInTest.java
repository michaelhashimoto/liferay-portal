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

package com.liferay.portalweb.portal.dbupgrade.sampledata606.social.request;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SignInTest extends BaseTestCase {
	public void testSignIn() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.setTimeout("180000");
				selenium.open("/web/guest/home");
				selenium.waitForVisible("link=Sign In");
				selenium.clickAt("link=Sign In",
					RuntimeVariables.replace("Sign In"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//input[@id='_58_login']");
				selenium.type("//input[@id='_58_login']",
					RuntimeVariables.replace("test@liferay.com"));
				selenium.type("//input[@id='_58_password']",
					RuntimeVariables.replace("test"));
				selenium.waitForVisible("//input[@id='_58_rememberMeCheckbox']");
				selenium.click("//input[@id='_58_rememberMeCheckbox']");
				selenium.waitForVisible("//input[@value='Sign In']");
				selenium.clickAt("//input[@value='Sign In']",
					RuntimeVariables.replace("Sign In"));
				selenium.waitForPageToLoad("30000");

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
				selenium.waitForVisible("reminderQueryAnswer");
				selenium.type("reminderQueryAnswer",
					RuntimeVariables.replace("Test"));
				selenium.waitForVisible("//input[@value='Save']");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Save']"));
				selenium.waitForPageToLoad("30000");

			case 2:
			case 100:
				label = -1;
			}
		}
	}
}