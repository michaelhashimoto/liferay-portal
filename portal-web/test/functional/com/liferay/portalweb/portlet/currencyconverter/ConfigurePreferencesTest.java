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

package com.liferay.portalweb.portlet.currencyconverter;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePreferencesTest extends BaseTestCase {
	public void testConfigurePreferences() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Currency Converter Test Page");
		selenium.clickAt("link=Currency Converter Test Page",
			RuntimeVariables.replace("Currency Converter Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.waitForElementPresent("//strong/a");
		selenium.clickAt("//strong/a", RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a");
		assertEquals(RuntimeVariables.replace("Preferences"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a",
			RuntimeVariables.replace("Preferences"));
		selenium.waitForVisible("//select[@id='_16_available_actions']");
		selenium.addSelection("//select[@id='_16_available_actions']",
			RuntimeVariables.replace("Korean Won"));
		selenium.waitForVisible(
			"//button[@title='Move selected items from Available to Current.']");
		selenium.clickAt("//button[@title='Move selected items from Available to Current.']",
			RuntimeVariables.replace("Left Arrow"));
		selenium.waitForPartialText("//select[@id='_16_current_actions']",
			"Korean Won");
		selenium.waitForElementPresent("//input[@value='Save']");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"You have successfully updated your preferences.");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated your preferences."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("link=Return to Full Page",
			RuntimeVariables.replace("Return to Full Page"));
		selenium.waitForPageToLoad("30000");
	}
}