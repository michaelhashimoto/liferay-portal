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

package com.liferay.portalweb.plugins.audit.user.viewusersignin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_SignInTest extends BaseTestCase {
	public void testUser_SignIn() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.waitForVisible("_58_login");
				selenium.type("_58_login",
					RuntimeVariables.replace("test01@selenium.com"));
				selenium.type("_58_password", RuntimeVariables.replace("test"));

				boolean rememberMeCheckboxChecked = selenium.isChecked(
						"_58_rememberMeCheckbox");

				if (rememberMeCheckboxChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("_58_rememberMeCheckbox",
					RuntimeVariables.replace(""));

			case 2:
				selenium.clickAt("//input[@value='Sign In']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

				boolean iAgreeVisible = selenium.isElementPresent(
						"//span/input");

				if (!iAgreeVisible) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@value='I Agree']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

			case 3:

				boolean passwordReminderVisible = selenium.isElementPresent(
						"reminderQueryAnswer");

				if (!passwordReminderVisible) {
					label = 4;

					continue;
				}

				assertEquals(RuntimeVariables.replace(
						"Please choose a reminder query."),
					selenium.getText("//form/div[1]"));
				selenium.type("reminderQueryAnswer",
					RuntimeVariables.replace("test"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

			case 4:
			case 100:
				label = -1;
			}
		}
	}
}