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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.webcontent.journalfeed;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWCContentTest extends BaseTestCase {
	public void testAddWCContent() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("WC Journal Feed Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Open"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[2]/a"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[2]/a",
			RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//h2[@class='user-greeting']/span",
				"Welcome"));
		selenium.mouseOver("//h2[@class='user-greeting']/span");
		selenium.clickAt("//h2[@class='user-greeting']/span",
			RuntimeVariables.replace("Welcome"));
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
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//span[@class='portlet-title']"));
		selenium.type("//input[@id='_15_title']",
			RuntimeVariables.replace("Web Content Name"));
		Thread.sleep(5000);
		selenium.selectFrame("//iframe[@id=\"_15_editor\"]");
		selenium.selectFrame("//iframe[@id=\"FCKeditor1___Frame\"]");
		selenium.waitForText("//div[.='Source']", "Source");
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//div[.='Source']"));
		selenium.clickAt("//div[.='Source']", RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//div[@class='TB_Button_On']");
		selenium.waitForVisible("//textarea[@class='SourceField']");
		selenium.type("//textarea[@class='SourceField']",
			RuntimeVariables.replace("Web Content Content"));
		selenium.waitForText("//div[.='Source']", "Source");
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//div[.='Source']"));
		selenium.clickAt("//div[.='Source']", RuntimeVariables.replace("Source"));
		selenium.waitForElementPresent("//div[@class='TB_Button_Off']");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Save and Approve']",
			RuntimeVariables.replace("Save and Approve"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[3]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[5]/a"));
	}
}