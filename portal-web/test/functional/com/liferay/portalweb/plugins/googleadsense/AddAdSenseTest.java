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

package com.liferay.portalweb.plugins.googleadsense;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAdSenseTest extends BaseTestCase {
	public void testAddAdSense() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Google Adsense Test Page",
			RuntimeVariables.replace("Google Adsense Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible(
			"//iframe[contains(@id,'googleadsenseportlet')]");
		selenium.selectFrame("//iframe[contains(@id,'googleadsenseportlet')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("//input[@id='_86_adClient']");
		selenium.type("//input[@id='_86_adClient']",
			RuntimeVariables.replace("ca-pub-7910614330042482"));
		selenium.type("//input[@id='_86_adChannel']",
			RuntimeVariables.replace("12345678"));
		selenium.select("//select[@id='_86_adType']",
			RuntimeVariables.replace("Text"));
		selenium.select("//select[@id='_86_adFormat']",
			RuntimeVariables.replace("(728 x 90) - Leaderboard"));
		selenium.type("//input[@id='_86_colorBorder']",
			RuntimeVariables.replace("FFFFFF"));
		selenium.type("//input[@id='_86_colorBg']",
			RuntimeVariables.replace("0000FF"));
		selenium.type("//input[@id='_86_colorLink']",
			RuntimeVariables.replace("FFFFFF"));
		selenium.type("//input[@id='_86_colorText']",
			RuntimeVariables.replace("000000"));
		selenium.type("//input[@id='_86_colorUrl']",
			RuntimeVariables.replace("008000"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		Thread.sleep(5000);
		selenium.selectFrame("relative=top");
	}
}