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

package com.liferay.portalweb.portal.controlpanel.webcontent.wctemplate.addwctemplatestructure;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWCTemplateStructureTest extends BaseTestCase {
	public void testAddWCTemplateStructure() throws Exception {
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
		selenium.clickAt("link=Templates", RuntimeVariables.replace("Templates"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Template']",
			RuntimeVariables.replace("Add Template"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_name_en_US']",
			RuntimeVariables.replace("WC Template Name"));
		selenium.type("//textarea[@id='_15_description_en_US']",
			RuntimeVariables.replace("WC Template Description"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText("//a[@id='_15_structureName']"));
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		selenium.waitForVisible("//iframe[@id='_15_structureSelector']");
		selenium.selectFrame("//iframe[@id='_15_structureSelector']");
		selenium.waitForVisible("//td[1]/a");
		assertTrue(selenium.isVisible("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure Name"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure Description"),
			selenium.getText("//td[3]/a"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("WC Structure ID"));
		selenium.selectFrame("relative=top");
		selenium.waitForNotVisible("//iframe[@id='_15_structureSelector']");
		assertFalse(selenium.isVisible("//iframe[@id='_15_structureSelector']"));
		selenium.waitForText("//a[@id='_15_structureName']", "WC Structure Name");
		assertEquals(RuntimeVariables.replace("WC Structure Name"),
			selenium.getText("//a[@id='_15_structureName']"));
		selenium.clickAt("//input[@id='_15_editorButton']",
			RuntimeVariables.replace("Launch Editor"));
		selenium.waitForVisible("//iframe[@id='_15_xslContentIFrame']");
		selenium.selectFrame("//iframe[@id='_15_xslContentIFrame']");
		selenium.waitForNotValue("//textarea[@id='_15_plainEditorField']", "");
		selenium.type("//textarea[@id='_15_plainEditorField']",
			RuntimeVariables.replace("<h3>$text.getData()</h3>"));
		selenium.waitForVisible("//input[@value='Update']");
		selenium.click("//input[@value='Update']");
		selenium.selectFrame("relative=top");
		selenium.waitForNotVisible("//iframe[@id='_15_xslContentIFrame']");
		assertFalse(selenium.isVisible("//iframe[@id='_15_xslContentIFrame']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isVisible("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Template Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("WC Template Description"),
			selenium.getText("//td[4]/a"));
	}
}