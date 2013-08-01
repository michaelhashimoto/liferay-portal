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

package com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentdraft;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWebContentDraftTest extends BaseTestCase {
	public void testAddWebContentDraft() throws Exception {
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
		selenium.clickAt("//input[@value='Add']",
			RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_title_en_US']",
			RuntimeVariables.replace("Web Content Name"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("Web Content Content"));
		selenium.clickAt("//input[@value='Save as Draft']",
			RuntimeVariables.replace("Save as Draft"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//div[2]/h1/span"));
		assertEquals(RuntimeVariables.replace("Draft"),
			selenium.getText("//span[3]/strong"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Web Content Name')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("Draft"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[4]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Web Content Name')]/td[5]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Web Content Name')]/td[6]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Web Content Name')]/td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[contains(.,'Web Content Name')]/td[8]/a"));
	}
}