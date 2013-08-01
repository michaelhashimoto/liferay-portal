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

package com.liferay.portalweb.portlet.documentsandmedia.dmdocumenttype.adddmdocumenttypes;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMDocumentTypesTest extends BaseTestCase {
	public void testViewDMDocumentTypes() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span[@title='Add']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Add']/ul/li/strong/a/span",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'DM DocumentType1 Name')]");
		assertEquals(RuntimeVariables.replace("DM DocumentType1 Name"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'DM DocumentType1 Name')]"));
		assertEquals(RuntimeVariables.replace("DM DocumentType2 Name"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'DM DocumentType2 Name')]"));
		assertEquals(RuntimeVariables.replace("DM DocumentType3 Name"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'DM DocumentType3 Name')]"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//span[@title='Manage']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Manage']/ul/li/strong/a/span",
			RuntimeVariables.replace("Manage"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		assertEquals(RuntimeVariables.replace("Document Types"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
			RuntimeVariables.replace("Document Types"));
		selenium.waitForVisible("//iframe[@id='_20_openFileEntryTypeView']");
		selenium.selectFrame("//iframe[@id='_20_openFileEntryTypeView']");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("//input[@title='Search Entries']");
		selenium.type("//input[@title='Search Entries']",
			RuntimeVariables.replace("DocumentType1"));
		selenium.clickAt("//input[@class='aui-button-input aui-button-input-submit']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"//tr[contains(.,'DM DocumentType1 Name')]/td[1]");
		assertEquals(RuntimeVariables.replace("DM DocumentType1 Name"),
			selenium.getText("//tr[contains(.,'DM DocumentType1 Name')]/td[1]"));
		selenium.waitForVisible("//input[@title='Search Entries']");
		selenium.type("//input[@title='Search Entries']",
			RuntimeVariables.replace("DocumentType2"));
		selenium.clickAt("//input[@class='aui-button-input aui-button-input-submit']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"//tr[contains(.,'DM DocumentType2 Name')]/td[1]");
		assertEquals(RuntimeVariables.replace("DM DocumentType2 Name"),
			selenium.getText("//tr[contains(.,'DM DocumentType2 Name')]/td[1]"));
		selenium.waitForVisible("//input[@title='Search Entries']");
		selenium.type("//input[@title='Search Entries']",
			RuntimeVariables.replace("DocumentType3"));
		selenium.clickAt("//input[@class='aui-button-input aui-button-input-submit']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"//tr[contains(.,'DM DocumentType3 Name')]/td[1]");
		assertEquals(RuntimeVariables.replace("DM DocumentType3 Name"),
			selenium.getText("//tr[contains(.,'DM DocumentType3 Name')]/td[1]"));
		selenium.selectFrame("relative=top");
	}
}