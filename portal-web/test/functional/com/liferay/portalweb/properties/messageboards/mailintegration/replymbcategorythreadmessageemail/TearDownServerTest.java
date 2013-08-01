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

package com.liferay.portalweb.properties.messageboards.mailintegration.replymbcategorythreadmessageemail;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownServerTest extends BaseTestCase {
	public void testTearDownServer() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Server Administration",
					RuntimeVariables.replace("Server Administration"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Mail", RuntimeVariables.replace("Mail"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_137_pop3Host']",
					RuntimeVariables.replace(""));
				selenium.type("//input[@id='_137_pop3Port']",
					RuntimeVariables.replace(""));

				boolean popSecureChecked = selenium.isChecked(
						"_137_pop3SecureCheckbox");

				if (!popSecureChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_137_pop3SecureCheckbox']",
					RuntimeVariables.replace("Use a Secure Network Connection"));

			case 2:
				selenium.type("//input[@id='_137_pop3User']",
					RuntimeVariables.replace(""));
				selenium.type("//input[@id='_137_pop3Password']",
					RuntimeVariables.replace(""));
				selenium.type("//input[@id='_137_smtpHost']",
					RuntimeVariables.replace(""));
				selenium.type("//input[@id='_137_smtpPort']",
					RuntimeVariables.replace(""));

				boolean smtpSecureChecked = selenium.isChecked(
						"_137_smtpSecureCheckbox");

				if (!smtpSecureChecked) {
					label = 3;

					continue;
				}

				selenium.click("//input[@id='_137_smtpSecureCheckbox']");

			case 3:
				selenium.type("//input[@id='_137_smtpUser']",
					RuntimeVariables.replace(""));
				selenium.type("//input[@id='_137_smtpPassword']",
					RuntimeVariables.replace(""));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Portal Instances",
					RuntimeVariables.replace("Portal Instances"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("liferay.com"),
					selenium.getText("//td[2]/a"));
				selenium.clickAt("//td[2]/a",
					RuntimeVariables.replace("liferay.com"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_135_virtualHostname']",
					RuntimeVariables.replace("localhost"));
				selenium.type("//input[@id='_135_mx']",
					RuntimeVariables.replace("liferay.com"));
				selenium.type("//input[@id='_135_maxUsers']",
					RuntimeVariables.replace("0"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}