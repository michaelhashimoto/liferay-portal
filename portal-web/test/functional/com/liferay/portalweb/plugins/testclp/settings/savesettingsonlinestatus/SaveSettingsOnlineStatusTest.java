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

package com.liferay.portalweb.plugins.testclp.settings.savesettingsonlinestatus;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SaveSettingsOnlineStatusTest extends BaseTestCase {
	public void testSaveSettingsOnlineStatus() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Test CLP Test Page");
				selenium.clickAt("link=Test CLP Test Page",
					RuntimeVariables.replace("Test CLP Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("true"),
					selenium.getText(
						"//div[@class='portlet-body']/table/tbody/tr[2]/td[4]"));
				selenium.clickAt("//ul[@class='chat-tabs']/li[2]/div[1]/span",
					RuntimeVariables.replace("Settings"));
				Thread.sleep(5000);
				selenium.waitForVisible("//input[@id='onlineStatus']");

				boolean onlineStatusChecked = selenium.isChecked("onlineStatus");

				if (!onlineStatusChecked) {
					label = 2;

					continue;
				}

				assertTrue(selenium.isChecked("//input[@id='onlineStatus']"));
				selenium.clickAt("//input[@id='onlineStatus']",
					RuntimeVariables.replace("Show me as online."));
				assertFalse(selenium.isChecked("//input[@id='onlineStatus']"));

			case 2:
				selenium.clickAt("//input[@id='saveSettings']",
					RuntimeVariables.replace("Save Settings"));
				selenium.waitForElementNotPresent(
					"//li[@class='chat-settings saved']");
				assertTrue(selenium.isElementNotPresent(
						"//li[@class='chat-settings saved']"));
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Test CLP Test Page");
				selenium.clickAt("link=Test CLP Test Page",
					RuntimeVariables.replace("Test CLP Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("false"),
					selenium.getText(
						"//div[@class='portlet-body']/table/tbody/tr[2]/td[4]"));

			case 100:
				label = -1;
			}
		}
	}
}