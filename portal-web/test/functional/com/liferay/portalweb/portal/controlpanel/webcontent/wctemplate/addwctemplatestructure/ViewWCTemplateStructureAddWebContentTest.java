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
public class ViewWCTemplateStructureAddWebContentTest extends BaseTestCase {
	public void testViewWCTemplateStructureAddWebContent()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Add", RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a");
		assertEquals(RuntimeVariables.replace("Basic Web Content"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.waitForVisible("//a[@id='_15_changeStructureButton']");
		selenium.clickAt("//a[@id='_15_changeStructureButton']",
			RuntimeVariables.replace("Change"));
		selenium.waitForVisible("//iframe[@name='_15_changeStruture']");
		selenium.selectFrame("//iframe[@name='_15_changeStruture']");
		selenium.waitForVisible("//td[1]/a");
		assertTrue(selenium.isVisible("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure Name"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Structure Description"),
			selenium.getText("//td[3]/a"));
		selenium.click(RuntimeVariables.replace("//td[1]/a"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Selecting a new structure will change the available input fields and available templates[\\s\\S] Do you want to proceed[\\s\\S]$"));
		selenium.selectFrame("relative=top");
		selenium.waitForText("//span[@id='_15_structureNameLabel']",
			"WC Structure Name");
		assertEquals(RuntimeVariables.replace("WC Structure Name"),
			selenium.getText("//span[@id='_15_structureNameLabel']"));
		assertEquals(RuntimeVariables.replace("WC Template Name"),
			selenium.getText("//span[@class='template-name-label']"));
		assertTrue(selenium.isVisible("//input[@id='_15_title_en_US']"));
		selenium.waitForVisible(
			"//label[@class='journal-article-field-label']/span");
		assertEquals(RuntimeVariables.replace("text"),
			selenium.getText(
				"//label[@class='journal-article-field-label']/span"));
		assertTrue(selenium.isVisible("//input[@id='text']"));
		assertFalse(selenium.isChecked(
				"//input[contains(@id,'localized-checkboxCheckbox')]"));
		assertTrue(selenium.isChecked("//input[@id='_15_indexableCheckbox']"));
	}
}