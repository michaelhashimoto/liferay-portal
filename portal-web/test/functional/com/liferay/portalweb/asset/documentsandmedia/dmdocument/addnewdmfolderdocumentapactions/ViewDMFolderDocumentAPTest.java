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

package com.liferay.portalweb.asset.documentsandmedia.dmdocument.addnewdmfolderdocumentapactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMFolderDocumentAPTest extends BaseTestCase {
	public void testViewDMFolderDocumentAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//h3[@class='asset-title']/a",
			"DM Folder Document Title");
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText("//h3[@class='asset-title']/a"));
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText("//div[@class='asset-resource-info']/span/a/span"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//button[@title='Icon View']",
			RuntimeVariables.replace("Icon View"));
		selenium.waitForVisible(
			"//button[@title='Icon View' and contains(@class,'aui-state-active')]");
		assertTrue(selenium.isVisible(
				"//button[@title='Icon View' and contains(@class,'aui-state-active')]"));
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//div/a/span[2]"));
		selenium.clickAt("//div/a/span[2]",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForText("//li[@class='folder selected']/a/span[2]",
			"DM Folder Name");
		assertTrue(selenium.isPartialText(
				"//li[@class='folder selected']/a/span[2]", "DM Folder Name"));
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText("//div[@id='_20_entries']/div/a/span[2]"));
		selenium.clickAt("//div[@id='_20_entries']/div/a/span[2]",
			RuntimeVariables.replace("DM Folder Document Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("Version 1.0"),
			selenium.getText("//h3[@class='version ']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Download (0.3k)"),
			selenium.getText("//span[1]/span/a/span"));
		assertTrue(selenium.isPartialText(
				"//div[2]/div[2]/div/div[1]/div[2]/div[1]", "ISO-8859-1"));
		assertTrue(selenium.isPartialText("//div[2]/div/div[1]/div[2]/div[2]",
				"text/plain"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//tr[3]/td[2]"));
		assertTrue(selenium.isElementPresent("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("0.3k"),
			selenium.getText("//tr[3]/td[4]"));
	}
}