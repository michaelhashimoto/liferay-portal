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

package com.liferay.portalweb.portal.dbupgrade.sampledata525.stagingorganization.webcontentdisplay;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWebContentTest extends BaseTestCase {
	public void testAddWebContent() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/staging-organization-wcd/");
		selenium.waitForVisible(
			"link=Page Staging Organization Web Content Display");
		selenium.clickAt("link=Page Staging Organization Web Content Display",
			RuntimeVariables.replace(
				"Page Staging Organization Web Content Display"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent(
				"//body[@class='blue staging controls-visible public-page']"));
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
			RuntimeVariables.replace("WC Web Content Name"));
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
			RuntimeVariables.replace("WC Web Content Content"));
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
		assertTrue(selenium.isElementPresent("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[5]/a"));
		assertTrue(selenium.isElementPresent("//td[6]/a"));
		assertTrue(selenium.isElementPresent("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[8]/a"));
	}
}