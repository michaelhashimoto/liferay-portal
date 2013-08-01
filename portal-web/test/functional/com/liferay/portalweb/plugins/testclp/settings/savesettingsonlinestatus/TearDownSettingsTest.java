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
public class TearDownSettingsTest extends BaseTestCase {
	public void testTearDownSettings() throws Exception {
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
				selenium.clickAt("//ul[@class='chat-tabs']/li[2]/div[1]/span",
					RuntimeVariables.replace("Settings"));
				Thread.sleep(5000);
				selenium.waitForVisible("//input[@id='statusMessage']");
				selenium.type("//input[@id='statusMessage']",
					RuntimeVariables.replace(""));

				boolean onlineStatusChecked = selenium.isChecked("onlineStatus");

				if (onlineStatusChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='onlineStatus']",
					RuntimeVariables.replace("Show me as online."));

			case 2:

				boolean playSoundChecked = selenium.isChecked("playSound");

				if (playSoundChecked) {
					label = 3;

					continue;
				}

				selenium.clickAt("playSound", RuntimeVariables.replace(""));

			case 3:
				selenium.clickAt("//input[@id='saveSettings']",
					RuntimeVariables.replace("Save Settings"));
				selenium.waitForElementNotPresent(
					"//li[@class='chat-settings saved']");
				selenium.waitForVisible(
					"//ul[@class='chat-tabs']/li[2]/div[1]/span");
				selenium.clickAt("//ul[@class='chat-tabs']/li[2]/div[1]/span",
					RuntimeVariables.replace("Settings"));
				Thread.sleep(5000);
				selenium.clickAt("//input[@id='saveSettings']",
					RuntimeVariables.replace("Save Settings"));
				selenium.waitForElementNotPresent(
					"//li[@class='chat-settings saved']");
				assertTrue(selenium.isElementNotPresent(
						"//li[@class='chat-settings saved']"));

			case 100:
				label = -1;
			}
		}
	}
}