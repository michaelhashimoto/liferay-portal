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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.webcontent.imageassociation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddTemplateImageAssociationTest extends BaseTestCase {
	public void testAddTemplateImageAssociation() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/web-content-image-association-community/");
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
			RuntimeVariables.replace("Image Template Test"));
		selenium.type("//textarea[@id='_15_description_en_US']",
			RuntimeVariables.replace("This is an image template test."));
		selenium.click("//input[@value='Select']");
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForVisible("//a[contains(.,'Image Structure Test')]");
		assertEquals(RuntimeVariables.replace("Image Structure Test"),
			selenium.getText("//a[contains(.,'Image Structure Test')]"));
		selenium.clickAt("//a[contains(.,'Image Structure Test')]",
			RuntimeVariables.replace("Image Structure Test"));
		selenium.selectFrame("relative=top");
		selenium.waitForText("//a[@id='_15_structureName']",
			"Image Structure Test");
		assertEquals(RuntimeVariables.replace("Image Structure Test"),
			selenium.getText("//a[@id='_15_structureName']"));
		selenium.clickAt("//input[@value='Launch Editor']",
			RuntimeVariables.replace("Launch Editor"));
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForVisible("//textarea[@id='_15_plainEditorField']");
		selenium.waitForElementPresent(
			"//div[@class='ace_layer ace_gutter-layer ace_folding-enabled']");
		selenium.type("//textarea[@id='_15_plainEditorField']",
			RuntimeVariables.replace(
				"<h1 id=\"web-content-title\">$text-test.getData()</h1>\n\n<h2 id=\"image-title\">Image Test:</h2>\n<a id=\"image\"><img src=\"$image-test.data\"></img></a>\n\n<h2 id=\"image-gallery-title\">Image Gallery Image Test:</h2>\n<a id=\"image-gallery\"><img src=\"$image-gallery-test.data\"></img></a>"));
		selenium.clickAt("//input[@value='Update']",
			RuntimeVariables.replace("Update"));
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Image Template Test"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[3]"));
	}
}