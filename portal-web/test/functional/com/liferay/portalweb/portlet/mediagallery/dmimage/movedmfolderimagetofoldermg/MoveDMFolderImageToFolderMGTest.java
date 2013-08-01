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

package com.liferay.portalweb.portlet.mediagallery.dmimage.movedmfolderimagetofoldermg;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveDMFolderImageToFolderMGTest extends BaseTestCase {
	public void testMoveDMFolderImageToFolderMG() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("xPath=(//span[@class='image-title'])[1]"));
		selenium.clickAt("xPath=(//span[@class='image-title'])[1]",
			RuntimeVariables.replace("DM Folder1 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("xPath=(//span[@class='image-title'])[1]"));
		selenium.clickAt("xPath=(//span[@class='image-title'])[1]",
			RuntimeVariables.replace("DM Folder Image Title"));
		selenium.waitForVisible(
			"//div[contains(@class,'image-viewer-content')]/div/div[contains(@class,'image-viewer-caption')]");
		selenium.clickAt("//img[@title='View']",
			RuntimeVariables.replace("View"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText("//div[@id='_31_fileEntryToolbar']/span/button[3]"));
		selenium.click(RuntimeVariables.replace(
				"//div[@id='_31_fileEntryToolbar']/span/button[3]"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//a[@id='_31_folderName']"));
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		Thread.sleep(1000);
		selenium.selectWindow("title=Media Gallery");
		selenium.waitForVisible("link=Home");
		selenium.clickAt("link=Home", RuntimeVariables.replace("Home"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder2 Name"),
			selenium.getText("//td[contains(@id,'folder_row-2')]/a"));
		selenium.click("xPath=(//input[@value='Choose'])[2]");
		selenium.selectWindow("null");
		selenium.waitForText("//a[@id='_31_folderName']", "DM Folder2 Name");
		assertEquals(RuntimeVariables.replace("DM Folder2 Name"),
			selenium.getText("//a[@id='_31_folderName']"));
		selenium.clickAt("//input[@value='Move']",
			RuntimeVariables.replace("Move"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("xPath=(//span[@class='image-title'])[1]"));
		selenium.clickAt("xPath=(//span[@class='image-title'])[1]",
			RuntimeVariables.replace("DM Folder1 Name"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("DM Folder Image Title"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder2 Name"),
			selenium.getText("xPath=(//span[@class='image-title'])[2]"));
		selenium.clickAt("xPath=(//span[@class='image-title'])[2]",
			RuntimeVariables.replace("DM Folder2 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Image Title"),
			selenium.getText("//span[@class='image-title']"));
	}
}