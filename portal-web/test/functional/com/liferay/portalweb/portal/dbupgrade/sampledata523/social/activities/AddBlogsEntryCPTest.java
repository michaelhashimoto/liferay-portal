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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.social.activities;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddBlogsEntryCPTest extends BaseTestCase {
	public void testAddBlogsEntryCP() throws Exception {
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
		selenium.clickAt("link=Blogs", RuntimeVariables.replace("Blogs"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Blog Entry']",
			RuntimeVariables.replace("Add Blog Entry"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_33_title']",
			RuntimeVariables.replace("Blogs Entry Title"));
		selenium.waitForVisible("//iframe[@id='_33_editor']");
		selenium.selectFrame("//iframe[@id='_33_editor']");
		selenium.waitForVisible("//iframe[@id='FCKeditor1___Frame']");
		selenium.selectFrame("//iframe[@id='FCKeditor1___Frame']");
		selenium.waitForText("//td[@class='SC_FieldLabel']/label", "Normal");
		selenium.waitForVisible("//div[.='Source']");
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//div[.='Source']"));
		selenium.clickAt("//div[.='Source']", RuntimeVariables.replace("Source"));
		selenium.waitForVisible(
			"//td[@id='xEditingArea']/textarea[@class='SourceField']");
		selenium.waitForVisible("//div[@class='TB_Button_On']");
		selenium.type("//td[@id='xEditingArea']/textarea[@class='SourceField']",
			RuntimeVariables.replace("Blogs Entry Content"));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//div[.='Source']"));
		selenium.clickAt("//div[.='Source']", RuntimeVariables.replace("Source"));
		selenium.waitForElementNotPresent("//div[@class='TB_Button_On']");
		selenium.selectFrame("relative=top");
		selenium.waitForVisible("//iframe[@id='_33_editor']");
		selenium.selectFrame("//iframe[@id='_33_editor']");
		selenium.waitForVisible("//iframe[@id='FCKeditor1___Frame']");
		selenium.selectFrame("//iframe[@id='FCKeditor1___Frame']");
		selenium.waitForVisible("//td[@id='xEditingArea']/iframe");
		selenium.selectFrame("//td[@id='xEditingArea']/iframe");
		selenium.waitForText("//body", "Blogs Entry Content");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//div[@class='entry-title']/a"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Content"),
			selenium.getText("//div[@class='entry-body']/p"));
	}
}