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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWCWebContentDisabledDeleteTest extends BaseTestCase {
	public void testViewWCWebContentDisabledDelete() throws Exception {
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
		assertEquals(RuntimeVariables.replace("WC WebContent Title"),
			selenium.getText("//td[3]/a"));
		assertFalse(selenium.isChecked("//input[@name='_15_allRowIds']"));
		assertFalse(selenium.isChecked("//input[@name='_15_rowIds']"));
		assertTrue(selenium.isVisible(
				"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']"));
		assertTrue(selenium.isVisible(
				"//input[@value='Delete' and @disabled='']"));
		selenium.clickAt("//input[@name='_15_allRowIds']",
			RuntimeVariables.replace("Select All"));
		assertTrue(selenium.isChecked("//input[@name='_15_allRowIds']"));
		selenium.waitForElementNotPresent(
			"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']");
		assertTrue(selenium.isElementNotPresent(
				"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Delete' and @disabled='']"));
		assertTrue(selenium.isVisible("//input[@value='Delete']"));
		selenium.clickAt("//input[@name='_15_allRowIds']",
			RuntimeVariables.replace("Select All"));
		assertFalse(selenium.isChecked("//input[@name='_15_allRowIds']"));
		selenium.waitForVisible(
			"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']");
		assertTrue(selenium.isVisible(
				"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']"));
		assertTrue(selenium.isVisible(
				"//input[@value='Delete' and @disabled='']"));
		selenium.clickAt("//input[@name='_15_rowIds']",
			RuntimeVariables.replace("Row Entry Check Box"));
		assertTrue(selenium.isChecked("//input[@name='_15_rowIds']"));
		selenium.waitForElementNotPresent(
			"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']");
		assertTrue(selenium.isElementNotPresent(
				"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Delete' and @disabled='']"));
		assertTrue(selenium.isVisible("//input[@value='Delete']"));
		selenium.clickAt("//input[@name='_15_rowIds']",
			RuntimeVariables.replace("Row Entry Check Box"));
		assertFalse(selenium.isChecked("//input[@name='_15_rowIds']"));
		selenium.waitForVisible(
			"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']");
		assertTrue(selenium.isVisible(
				"//span[contains(@class,'aui-button-disabled')]/span/input[@value='Delete']"));
		assertTrue(selenium.isVisible(
				"//input[@value='Delete' and @disabled='']"));
	}
}