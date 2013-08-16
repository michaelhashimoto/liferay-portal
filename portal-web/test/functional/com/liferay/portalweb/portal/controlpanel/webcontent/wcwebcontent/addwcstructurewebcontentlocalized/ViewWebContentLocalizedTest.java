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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcstructurewebcontentlocalized;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentLocalizedTest extends BaseTestCase {
	public void testViewWebContentLocalized() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
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
		assertEquals(RuntimeVariables.replace("Hello World Localized Article"),
			selenium.getText("//td[3]/a"));
		selenium.clickAt("//td[3]/a",
			RuntimeVariables.replace("Hello World Localized Article"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Hello World Localized Article",
			selenium.getValue("//input[@id='_15_title_en_US']"));
		assertEquals("Hello World Page Name",
			selenium.getValue("//input[@id='page-name']"));
		assertEquals("Hello World Page Description",
			selenium.getValue("//input[@id='page-description']"));
		assertEquals(RuntimeVariables.replace("Chinese (China)"),
			selenium.getText("//span[@id='_15_availableTranslationsLinks']/a"));
		selenium.clickAt("//span[@id='_15_availableTranslationsLinks']/a",
			RuntimeVariables.replace("Chinese (China)"));
		selenium.waitForVisible("//iframe[@id='_15_zh_CN']");
		selenium.selectFrame("//iframe[@id='_15_zh_CN']");
		selenium.waitForVisible("//h1[@class='header-title']/span");
		assertEquals(RuntimeVariables.replace("Hello World Localized Article"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"Translating Web Content to Chinese (China)"),
			selenium.getText("//div[@id='_15_availableTranslationContainer']"));
		assertEquals("Hello World Localized Article",
			selenium.getValue("//input[@id='_15_title_zh_CN']"));
		selenium.waitForVisible("//input[@id='page-name']");
		assertEquals("\u4e16\u754c\u60a8\u597d Page Name",
			selenium.getValue("//input[@id='page-name']"));
		selenium.waitForVisible("//input[@id='page-description']");
		assertEquals("\u4e16\u754c\u60a8\u597d Page Description",
			selenium.getValue("//input[@id='page-description']"));
		selenium.selectFrame("relative=top");
	}
}