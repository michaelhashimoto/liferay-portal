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

package com.liferay.portalweb.portlet.documentsandmedia.dmdocument.comparedmfolderdocumentversion;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CompareDMFolderDocumentVersionTest extends BaseTestCase {
	public void testCompareDMFolderDocumentVersion() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForText("//li[@class='folder selected']/a",
			"DM Folder Name");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//li[@class='folder selected']/a"));
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Document Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//button[2]"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadCommonFile("//input[@id='_20_file']",
			RuntimeVariables.replace("Document_1.txt"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//tr[3]/td[2]"));
		assertFalse(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[1]"));
		selenium.clickAt("xPath=(//input[@name='_20_rowIds'])[1]",
			RuntimeVariables.replace("1.1 Check Box"));
		assertTrue(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[1]"));
		assertFalse(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[2]"));
		selenium.clickAt("xPath=(//input[@name='_20_rowIds'])[2]",
			RuntimeVariables.replace("1.0 Check Box"));
		assertTrue(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[2]"));
		selenium.clickAt("//input[@value='Compare Versions']",
			RuntimeVariables.replace("Compare Versions"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//section/div/div/div",
				"There are no differences between DM Folder Document Title 1.0 and DM Folder Document Title 1.1."));
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForText("//li[@class='folder selected']/a",
			"DM Folder Name");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//li[@class='folder selected']/a"));
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Document Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//button[2]"));
		selenium.clickAt("//button[2]", RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadCommonFile("//input[@id='_20_file']",
			RuntimeVariables.replace("Document_4.txt"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("1.2"),
			selenium.getText("//tr[3]/td[2]"));
		assertFalse(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[1]"));
		selenium.clickAt("xPath=(//input[@name='_20_rowIds'])[1]",
			RuntimeVariables.replace("1.2 Check Box"));
		assertTrue(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[1]"));
		assertFalse(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[2]"));
		selenium.clickAt("xPath=(//input[@name='_20_rowIds'])[2]",
			RuntimeVariables.replace("1.1 Check Box"));
		assertTrue(selenium.isChecked("xPath=(//input[@name='_20_rowIds'])[2]"));
		selenium.clickAt("//input[@value='Compare Versions']",
			RuntimeVariables.replace("Compare Versions"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//tr[3]/td[1]", ".txt"));
		assertFalse(selenium.isPartialText("//tr[3]/td[1]", "_4"));
		assertTrue(selenium.isPartialText("//tr[3]/td[2]", "_4"));
	}
}