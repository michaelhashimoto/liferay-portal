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

package com.liferay.portalweb.socialoffice.users.user.editsouserpassword;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditSOUser4PasswordTest extends BaseTestCase {
	public void testEditSOUser4Password() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
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
				selenium.clickAt("link=Search All Users",
					RuntimeVariables.replace("Search All Users"));
				selenium.waitForPageToLoad("30000");

				boolean basicVisible = selenium.isVisible(
						"//a[.='\u00ab Basic']");

				if (!basicVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//a[.='\u00ab Basic']",
					RuntimeVariables.replace("\u00ab Basic"));

			case 2:
				selenium.waitForVisible(
					"//input[@id='_125_toggle_id_users_admin_user_searchkeywords']");
				selenium.type("//input[@id='_125_toggle_id_users_admin_user_searchkeywords']",
					RuntimeVariables.replace("socialoffice04"));
				selenium.clickAt("//div[contains(@id,'user_searchbasic')]/span/span[2]/span/input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Social04"),
					selenium.getText("//td[contains(.,'Social04')]/a"));
				selenium.clickAt("//td[contains(.,'Social04')]/a",
					RuntimeVariables.replace("Social04"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isPartialText(
						"//a[@id='_125_passwordLink']", "Password"));
				selenium.clickAt("//a[@id='_125_passwordLink']",
					RuntimeVariables.replace("Password"));
				selenium.waitForVisible("//input[@id='_125_password1']");
				selenium.type("//input[@id='_125_password1']",
					RuntimeVariables.replace("password"));
				selenium.type("//input[@id='_125_password2']",
					RuntimeVariables.replace("password"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.open("/web/guest/home/");

				boolean socialOfficeUserBar1Present = selenium.isElementPresent(
						"//div[@class='so-portlet-user-bar']");

				if (!socialOfficeUserBar1Present) {
					label = 3;

					continue;
				}

				selenium.clickAt("//li[contains(@class,'user-menu has-submenu')]/a/span[@class='full-name']",
					RuntimeVariables.replace("User Name"));

			case 3:
				selenium.waitForVisible("link=Sign Out");
				selenium.clickAt("link=Sign Out",
					RuntimeVariables.replace("Sign Out"));
				selenium.waitForPageToLoad("30000");
				selenium.open("/web/guest/home/");
				selenium.waitForVisible("link=Sign In");
				selenium.clickAt("link=Sign In",
					RuntimeVariables.replace("Sign In"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_58_login']",
					RuntimeVariables.replace("socialoffice04@liferay.com"));
				selenium.type("//input[@id='_58_password']",
					RuntimeVariables.replace("password"));
				assertFalse(selenium.isChecked(
						"//input[@id='_58_rememberMeCheckbox']"));
				selenium.clickAt("//input[@id='_58_rememberMeCheckbox']",
					RuntimeVariables.replace("Remember Me"));
				assertTrue(selenium.isChecked(
						"//input[@id='_58_rememberMeCheckbox']"));
				selenium.clickAt("//input[@value='Sign In']",
					RuntimeVariables.replace("Sign In"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='password1']",
					RuntimeVariables.replace("test"));
				selenium.type("//input[@id='password2']",
					RuntimeVariables.replace("test"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='reminderQueryAnswer']",
					RuntimeVariables.replace("test"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				selenium.open("/web/guest/home/");

				boolean socialOfficeUserBar2Present = selenium.isElementPresent(
						"//div[@class='so-portlet-user-bar']");

				if (!socialOfficeUserBar2Present) {
					label = 4;

					continue;
				}

				selenium.clickAt("//li[contains(@class,'user-menu has-submenu')]/a/span[@class='full-name']",
					RuntimeVariables.replace("User Name"));

			case 4:
				selenium.waitForVisible("link=Sign Out");
				selenium.clickAt("link=Sign Out",
					RuntimeVariables.replace("Sign Out"));
				selenium.waitForPageToLoad("30000");
				selenium.open("/web/guest/home/");
				selenium.waitForVisible("link=Sign In");
				selenium.clickAt("link=Sign In",
					RuntimeVariables.replace("Sign In"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_58_login']",
					RuntimeVariables.replace("test@liferay.com"));
				selenium.type("//input[@id='_58_password']",
					RuntimeVariables.replace("test"));
				assertFalse(selenium.isChecked(
						"//input[@id='_58_rememberMeCheckbox']"));
				selenium.clickAt("//input[@id='_58_rememberMeCheckbox']",
					RuntimeVariables.replace("Remember Me"));
				assertTrue(selenium.isChecked(
						"//input[@id='_58_rememberMeCheckbox']"));
				selenium.clickAt("//input[@value='Sign In']",
					RuntimeVariables.replace("Sign In"));
				selenium.waitForPageToLoad("30000");

			case 100:
				label = -1;
			}
		}
	}
}