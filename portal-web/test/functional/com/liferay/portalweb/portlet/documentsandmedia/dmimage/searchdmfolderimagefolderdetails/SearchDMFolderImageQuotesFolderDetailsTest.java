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

package com.liferay.portalweb.portlet.documentsandmedia.dmimage.searchdmfolderimagefolderdetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchDMFolderImageQuotesFolderDetailsTest extends BaseTestCase {
	public void testSearchDMFolderImageQuotesFolderDetails()
		throws Exception {
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
		selenium.waitForText("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			"DM Folder Image Title");
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("\"DM Folder Image Title\""));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForText("//span[@class='keywords']",
			"Searched for \"DM Folder Image Title\" in DM Folder Name");
		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM Folder Image Title\" in DM Folder Name"),
			selenium.getText("//span[@class='keywords']"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		Thread.sleep(5000);
		selenium.click("//input[@value='Search Everywhere']");
		selenium.waitForText("//span[@class='keywords']",
			"Searched for \"DM Folder Image Title\" everywhere.");
		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM Folder Image Title\" everywhere."),
			selenium.getText("//span[@class='keywords']"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		Thread.sleep(5000);
		selenium.type("//input[@id='_20_keywords']",
			RuntimeVariables.replace("\"DM1 Folder1 Image1 Title1\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForText("//span[@class='keywords']",
			"Searched for \"DM1 Folder1 Image1 Title1\" in DM Folder Name");
		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM1 Folder1 Image1 Title1\" in DM Folder Name"),
			selenium.getText("//span[@class='keywords']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		Thread.sleep(5000);
		selenium.click("//input[@value='Search Everywhere']");
		selenium.waitForText("//span[@class='keywords']",
			"Searched for \"DM1 Folder1 Image1 Title1\" everywhere.");
		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM1 Folder1 Image1 Title1\" everywhere."),
			selenium.getText("//span[@class='keywords']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
	}
}