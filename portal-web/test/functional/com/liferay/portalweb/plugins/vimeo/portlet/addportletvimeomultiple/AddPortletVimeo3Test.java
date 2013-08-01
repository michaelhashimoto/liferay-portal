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

package com.liferay.portalweb.plugins.vimeo.portlet.addportletvimeomultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPortletVimeo3Test extends BaseTestCase {
	public void testAddPortletVimeo3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Vimeo Test Page",
			RuntimeVariables.replace("Vimeo Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//li[@id='_145_addContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_addContent']/a/span");
		selenium.waitForVisible("//a[@id='_145_addApplication']");
		assertTrue(selenium.isPartialText("//a[@id='_145_addApplication']",
				"More"));
		selenium.clickAt("//a[@id='_145_addApplication']",
			RuntimeVariables.replace("More"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-live-search/aui-live-search-min.js')]");
		selenium.waitForVisible("//input[@id='layout_configuration_content']");
		selenium.sendKeys("//input[@id='layout_configuration_content']",
			RuntimeVariables.replace("v"));
		selenium.waitForVisible("//div[@title='Vimeo']/p/a");
		selenium.clickAt("//div[@title='Vimeo']/p/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//div[1]/div/section");
		assertTrue(selenium.isVisible("//div[1]/div/section"));
		assertEquals(RuntimeVariables.replace("Vimeo"),
			selenium.getText("xpath=(//span[@class='portlet-title-text'])[1]"));
		selenium.waitForVisible("//div[2]/div/section");
		assertTrue(selenium.isVisible("//div[2]/div/section"));
		assertEquals(RuntimeVariables.replace("Vimeo"),
			selenium.getText("xpath=(//span[@class='portlet-title-text'])[2]"));
		assertTrue(selenium.isVisible("//div[3]/div/section"));
		selenium.waitForVisible("//div[3]/div/section");
		assertEquals(RuntimeVariables.replace("Vimeo"),
			selenium.getText("xpath=(//span[@class='portlet-title-text'])[3]"));
	}
}