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

package com.liferay.portalweb.plugins.mail.mailaccount.addmailaccount;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownMailAccountTest extends BaseTestCase {
	public void testTearDownMailAccount() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home");
				selenium.waitForVisible("link=Mail Test Page");
				selenium.clickAt("link=Mail Test Page",
					RuntimeVariables.replace("Mail Test Page"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(5000);

				boolean enterYourPasswordPresent = selenium.isElementPresent(
						"//input[@id='_1_WAR_mailportlet_password']");

				if (!enterYourPasswordPresent) {
					label = 2;

					continue;
				}

				selenium.type("//input[@id='_1_WAR_mailportlet_password']",
					RuntimeVariables.replace("loveispatient"));
				selenium.clickAt("//input[@value='Login']",
					RuntimeVariables.replace("Login"));
				selenium.waitForElementNotPresent(
					"//input[@id='_1_WAR_mailportlet_password']");
				Thread.sleep(5000);

			case 2:

				boolean emailPresent = selenium.isElementPresent(
						"//div/div/div[1]/div/ul/li/span/span");

				if (!emailPresent) {
					label = 3;

					continue;
				}

				assertEquals(RuntimeVariables.replace(
						"liferay.qa.testing@gmail.com"),
					selenium.getText("//div/div/div[1]/div/ul/li/span/span"));
				selenium.clickAt("//div/div/div[1]/div/ul/li/span/span",
					RuntimeVariables.replace("liferay.qa.testing@gmail.com"));
				selenium.waitForText("//a[@class='edit-account']",
					"Edit Account");
				assertEquals(RuntimeVariables.replace("Edit Account"),
					selenium.getText("//a[@class='edit-account']"));
				selenium.clickAt("//a[@class='edit-account']",
					RuntimeVariables.replace("Edit Account"));
				Thread.sleep(5000);
				selenium.waitForElementPresent("//a[@class='delete-account']");
				assertTrue(selenium.isElementPresent(
						"//a[@class='delete-account']"));
				selenium.clickAt("//a[@class='delete-account']",
					RuntimeVariables.replace("Delete Account"));
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this account[\\s\\S]$"));
				selenium.waitForVisible(
					"//span[@class='message portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Account has been deleted."),
					selenium.getText(
						"//span[@class='message portlet-msg-success']"));
				Thread.sleep(5000);

			case 3:
				selenium.open("/web/guest/home/");
				selenium.waitForVisible("link=Mail Test Page");
				selenium.clickAt("link=Mail Test Page",
					RuntimeVariables.replace("Mail Test Page"));
				selenium.waitForPageToLoad("30000");
				assertFalse(selenium.isTextPresent(
						"liferay.qa.testing@gmail.com"));

			case 100:
				label = -1;
			}
		}
	}
}