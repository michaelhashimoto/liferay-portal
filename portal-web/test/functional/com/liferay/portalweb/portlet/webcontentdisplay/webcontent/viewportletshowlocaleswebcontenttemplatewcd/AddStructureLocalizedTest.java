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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewportletshowlocaleswebcontenttemplatewcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddStructureLocalizedTest extends BaseTestCase {
	public void testAddStructureLocalized() throws Exception {
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
		selenium.clickAt("link=Structures",
			RuntimeVariables.replace("Structures"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Structure']",
			RuntimeVariables.replace("Add Structure"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_name_en_US']",
			RuntimeVariables.replace("Web Content Localized Structure Name"));
		selenium.type("//textarea[@id='_15_description_en_US']",
			RuntimeVariables.replace(
				"Web Content Localized Structure Description"));
		selenium.clickAt("//input[@id='_15_editorButton']",
			RuntimeVariables.replace("Launch Editor"));
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-dialog/aui-dialog-min.js')]");
		selenium.waitForVisible("//textarea[@id='_15_plainEditorField']");
		selenium.type("//textarea[@id='_15_plainEditorField']",
			RuntimeVariables.replace(
				"<root>\n\n<dynamic-element name='page-name' type='text'></dynamic-element> \n\n<dynamic-element name='page-description' type='text'></dynamic-element>\n\n</root>"));
		selenium.clickAt("//input[@value='Update']",
			RuntimeVariables.replace("Update"));
		selenium.selectFrame("relative=top");
		Thread.sleep(5000);
		selenium.waitForVisible("//input[@id='_15_structure_el0_name']");
		assertEquals("page-name",
			selenium.getValue("//input[@id='_15_structure_el0_name']"));
		assertEquals("page-description",
			selenium.getValue("//input[@id='_15_structure_el1_name']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"Web Content Localized Structure Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace(
				"Web Content Localized Structure Description"),
			selenium.getText("//td[4]/a"));
	}
}