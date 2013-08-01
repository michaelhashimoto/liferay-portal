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

package com.liferay.portalweb.asset.webcontent.wcwebcontent.addnewwcwebcontentapactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddNewWCWebContentAPActionsTest extends BaseTestCase {
	public void testAddNewWCWebContentAPActions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Add New"),
			selenium.getText("//span[@title='Add New']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Add New']/ul/li/strong/a",
			RuntimeVariables.replace("Add New"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Web Content')]");
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Web Content')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Web Content')]",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForVisible("//iframe[contains(@id,'editAsset')]");
		selenium.selectFrame("//iframe[contains(@id,'editAsset')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/html/js/editor/ckeditor/lang/en.js')]");
		selenium.waitForVisible("//input[@id='_15_title_en_US']");
		selenium.type("//input[@id='_15_title_en_US']",
			RuntimeVariables.replace("WC Web Content Title"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("WC Web Content Content"));
		selenium.waitForVisible("//iframe[contains(@id,'editAsset')]");
		selenium.selectFrame("//iframe[contains(@id,'editAsset')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/html/js/editor/ckeditor/lang/en.js')]");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=top");
		selenium.waitForVisible("//h3[@class='asset-title']/a");
		assertEquals(RuntimeVariables.replace("WC Web Content Title"),
			selenium.getText("//h3[@class='asset-title']/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Content"),
			selenium.getText("//div[@class='asset-summary']"));
	}
}