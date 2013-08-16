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

package com.liferay.portalweb.plugins.testclp.settings.savesettingsstatusmessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SaveSettingsStatusMessageTest extends BaseTestCase {
	public void testSaveSettingsStatusMessage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Test CLP Test Page");
		selenium.clickAt("link=Test CLP Test Page",
			RuntimeVariables.replace("Test CLP Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText(
				"//div[@class='portlet-body']/table/tbody/tr[2]/td[7]"));
		selenium.clickAt("//ul[@class='chat-tabs']/li[2]/div[1]/span",
			RuntimeVariables.replace("Settings"));
		Thread.sleep(5000);
		selenium.waitForVisible("//input[@id='statusMessage']");
		selenium.type("statusMessage",
			RuntimeVariables.replace("status message."));
		selenium.clickAt("//input[@id='saveSettings']",
			RuntimeVariables.replace("Save Settings"));
		selenium.waitForElementNotPresent("//li[@class='chat-settings saved']");
		assertTrue(selenium.isElementNotPresent(
				"//li[@class='chat-settings saved']"));
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Test CLP Test Page");
		selenium.clickAt("link=Test CLP Test Page",
			RuntimeVariables.replace("Test CLP Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("status message."),
			selenium.getText(
				"//div[@class='portlet-body']/table/tbody/tr[2]/td[7]"));
	}
}