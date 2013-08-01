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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontents;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWCWebContentsTest extends BaseTestCase {
	public void testViewWCWebContents() throws Exception {
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
		assertEquals(RuntimeVariables.replace("WC WebContent1 Title"),
			selenium.getText("//tr[3]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("WC WebContent2 Title"),
			selenium.getText("//tr[4]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("WC WebContent3 Title"),
			selenium.getText("//tr[5]/td[3]/a"));
		selenium.clickAt("//tr[3]/td[3]/a",
			RuntimeVariables.replace("WC WebContent1 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent1 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals("WC WebContent1 Title",
			selenium.getValue("//input[@id='_15_title_en_US']"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.selectFrame("//iframe[contains(@title,'Rich text editor')]");
		selenium.waitForText("//body", "WC WebContent1 Content");
		assertEquals(RuntimeVariables.replace("WC WebContent1 Content"),
			selenium.getText("//body"));
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
		assertEquals(RuntimeVariables.replace("WC WebContent2 Title"),
			selenium.getText("//tr[4]/td[3]/a"));
		selenium.clickAt("//tr[4]/td[3]/a",
			RuntimeVariables.replace("WC WebContent2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent2 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals("WC WebContent2 Title",
			selenium.getValue("//input[@id='_15_title_en_US']"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.selectFrame("//iframe[contains(@title,'Rich text editor')]");
		selenium.waitForText("//body", "WC WebContent2 Content");
		assertEquals(RuntimeVariables.replace("WC WebContent2 Content"),
			selenium.getText("//body"));
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
		assertEquals(RuntimeVariables.replace("WC WebContent3 Title"),
			selenium.getText("//tr[5]/td[3]/a"));
		selenium.clickAt("//tr[5]/td[3]/a",
			RuntimeVariables.replace("WC WebContent3 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent3 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals("WC WebContent3 Title",
			selenium.getValue("//input[@id='_15_title_en_US']"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.selectFrame("//iframe[contains(@title,'Rich text editor')]");
		selenium.waitForText("//body", "WC WebContent3 Content");
		assertEquals(RuntimeVariables.replace("WC WebContent3 Content"),
			selenium.getText("//body"));
		selenium.selectFrame("relative=top");
	}
}