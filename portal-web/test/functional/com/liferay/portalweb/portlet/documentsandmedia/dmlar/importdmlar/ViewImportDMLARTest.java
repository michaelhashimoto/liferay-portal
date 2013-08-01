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

package com.liferay.portalweb.portlet.documentsandmedia.dmlar.importdmlar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewImportDMLARTest extends BaseTestCase {
	public void testViewImportDMLAR() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[1]",
			"DL Folder1 Name");
		assertEquals(RuntimeVariables.replace("DL Folder1 Name"),
			selenium.getText(
				"xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[1]"));
		assertEquals(RuntimeVariables.replace("DL Folder2 Name Edit"),
			selenium.getText(
				"xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[2]"));
		selenium.clickAt("xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[1]",
			RuntimeVariables.replace("DL Folder1 Name"));
		selenium.waitForText("//li[@class='folder selected']/a/span[2]",
			"DL Folder1 Name");
		assertEquals(RuntimeVariables.replace("DL Folder1 Name"),
			selenium.getText("//li[@class='folder selected']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DL Folder1 Subfolder Name"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DL Folder1 Subfolder Name"));
		selenium.waitForText("//li[@class='folder selected']/a",
			"DL Folder1 Subfolder Name");
		assertEquals(RuntimeVariables.replace("DL Folder1 Subfolder Name"),
			selenium.getText("//li[@class='folder selected']/a"));
		assertEquals(RuntimeVariables.replace(
				"DL Folder1 Subfolder Document Title Edit"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DL Folder1 Subfolder Document Title Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//h2[@class='document-title']",
			"DL Folder1 Subfolder Document Title Edit");
		assertEquals(RuntimeVariables.replace(
				"DL Folder1 Subfolder Document Title Edit"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace(
				"DL Folder1 Subfolder Document Description Edit"),
			selenium.getText("//span[@class='document-description']"));
		assertEquals(RuntimeVariables.replace("Download (0.5k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DL Folder2 Name Edit"),
			selenium.getText(
				"xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[2]"));
		selenium.clickAt("xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[2]",
			RuntimeVariables.replace("DL Folder2 Name Edit"));
		selenium.waitForText("//li[@class='folder selected']/a/span[2]",
			"DL Folder2 Name Edit");
		assertEquals(RuntimeVariables.replace("DL Folder2 Name Edit"),
			selenium.getText("//li[@class='folder selected']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DL Folder2 Subfolder Name Edit"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
	}
}