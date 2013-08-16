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

package com.liferay.portalweb.properties.webcontent.mailintegration.editwcwebcontentemail;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownEmailConfigurationTest extends BaseTestCase {
	public void testTearDownEmailConfiguration() throws Exception {
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
				selenium.clickAt("link=Web Content",
					RuntimeVariables.replace("Web Content"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Options"),
					selenium.getText("//span[@title='Options']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
					RuntimeVariables.replace("Options"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
				selenium.click(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
				selenium.waitForVisible("link=Email From");
				selenium.clickAt("link=Email From",
					RuntimeVariables.replace("Email From"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_86_emailFromName']",
					RuntimeVariables.replace("Joe Bloggs"));
				selenium.type("//input[@id='_86_emailFromAddress']",
					RuntimeVariables.replace("test@liferay.com"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"You have successfully updated the setup."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.clickAt("link=Web Content Added Email",
					RuntimeVariables.replace("Web Content Added Email"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//input[@id='_86_emailArticleAddedEnabledCheckbox']"));

				boolean webContentAddedChecked = selenium.isChecked(
						"_86_emailArticleAddedEnabledCheckbox");

				if (!webContentAddedChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_86_emailArticleAddedEnabledCheckbox']",
					RuntimeVariables.replace("Enabled"));
				Thread.sleep(5000);
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"You have successfully updated the setup."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 2:
				selenium.click("//button[@id='closethick']");

			case 100:
				label = -1;
			}
		}
	}
}