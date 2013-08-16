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

package com.liferay.portalweb.portal.dbupgrade.sampledata527.expando.webcontent;

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
		selenium.type("//input[@id='_15_title']",
			RuntimeVariables.replace("Expando Web Content Test"));
		selenium.waitForVisible("//iframe[@id='_15_editor']");
		selenium.selectFrame("//iframe[@id='_15_editor']");
		selenium.waitForElementPresent(
			"//textarea[@id='FCKeditor1' and @style='display: none']");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		assertTrue(selenium.getConfirmation()
						   .matches("^Selecting a new structure will change the available input fields and available templates[\\s\\S] Do you want to proceed[\\s\\S]$"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Web Content");
		selenium.waitForElementPresent("link=TEST_EXPANDO");
		selenium.click("link=TEST_EXPANDO");
		selenium.selectWindow("null");
		selenium.waitForText("//a[@id='_15_structureName']",
			"Expando Structure Test");
		assertEquals(RuntimeVariables.replace("Expando Structure Test"),
			selenium.getText("//a[@id='_15_structureName']"));
		selenium.clickAt("//input[@value='Save and Approve']",
			RuntimeVariables.replace("Save and Approve"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Expando Web Content Test"),
			selenium.getText("//td[3]/a"));
	}
}