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

package com.liferay.portalweb.portal.dbupgrade.sampledata6012.stagingorganization.webcontentdisplay;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWebContentTest extends BaseTestCase {
	public void testAddWebContent() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/staging-organization-wcd-staging/");
		selenium.clickAt("link=Page Staging Organization Web Content Display",
			RuntimeVariables.replace(
				"Page Staging Organization Web Content Display"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//body[@class='blue staging controls-visible signed-in public-page dockbar-ready']"));
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
		selenium.type("//input[@id='_15_title']",
			RuntimeVariables.replace("WC Web Content Name"));
		selenium.waitForElementPresent(
			"//textarea[@id='_15__15_structure_el_TextAreaField_content' and @style=\"display: none;\"]");
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//a/span[.='Source']"));
		selenium.clickAt("//a/span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//a[@class='cke_button_source cke_on']");
		selenium.waitForVisible(
			"//td[@id='cke_contents__15__15_structure_el_TextAreaField_content']/textarea");
		selenium.type("//td[@id='cke_contents__15__15_structure_el_TextAreaField_content']/textarea",
			RuntimeVariables.replace("WC Web Content Content"));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//a/span[.='Source']"));
		selenium.clickAt("//a/span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForElementPresent(
			"//textarea[@id='_15__15_structure_el_TextAreaField_content' and @style=\"display: none;\"]");
		selenium.waitForVisible(
			"//td[@id='cke_contents__15__15_structure_el_TextAreaField_content']/iframe");
		selenium.selectFrame(
			"//td[@id='cke_contents__15__15_structure_el_TextAreaField_content']/iframe");
		selenium.waitForText("//body", "WC Web Content Content");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isVisible("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isVisible("//td[6]/a"));
		assertTrue(selenium.isVisible("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[7]/a"));
	}
}