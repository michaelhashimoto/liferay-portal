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

package com.liferay.portalweb.portal.dbupgrade.sampledata6011.expando.webcontent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWebContentExpandoTest extends BaseTestCase {
	public void testAddWebContentExpando() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/expando-web-content-community/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Web Content']",
			RuntimeVariables.replace("Add Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"//iframe[@id='_15_structure_el_TextAreaField_content']");
		selenium.selectFrame(
			"//iframe[@id='_15_structure_el_TextAreaField_content']");
		selenium.waitForElementPresent(
			"//textarea[@id='CKEditor1' and @style='display: none;']");
		selenium.selectFrame("relative=top");
		assertEquals(RuntimeVariables.replace("Choose"),
			selenium.getText("//a[@id='_15_changeStructureBtn']"));
		selenium.clickAt("//a[@id='_15_changeStructureBtn']",
			RuntimeVariables.replace("Choose"));
		assertTrue(selenium.getConfirmation()
						   .matches("^Selecting a new structure will change the available input fields and available templates[\\s\\S] Do you want to proceed[\\s\\S]$"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Web Content");
		selenium.waitForVisible("link=TEST_EXPANDO");
		selenium.click("link=TEST_EXPANDO");
		selenium.selectWindow("null");
		selenium.waitForText("//span[@id='_15_structureNameLabel']",
			"Expando Structure Test (Use Default)");
		assertEquals(RuntimeVariables.replace(
				"Expando Structure Test (Use Default)"),
			selenium.getText("//span[@id='_15_structureNameLabel']"));
		selenium.type("//input[@id='_15_title']",
			RuntimeVariables.replace("Expando Web Content Test"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isVisible("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Expando Web Content Test"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[5]/a"));
		assertTrue(selenium.isVisible("//td[6]/a"));
		assertTrue(selenium.isVisible("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[8]/a"));
	}
}