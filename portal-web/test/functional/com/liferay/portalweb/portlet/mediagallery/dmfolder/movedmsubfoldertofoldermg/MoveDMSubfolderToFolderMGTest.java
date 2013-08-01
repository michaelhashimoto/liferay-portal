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

package com.liferay.portalweb.portlet.mediagallery.dmfolder.movedmsubfoldertofoldermg;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveDMSubfolderToFolderMGTest extends BaseTestCase {
	public void testMoveDMSubfolderToFolderMG() throws Exception {
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
		assertEquals(RuntimeVariables.replace("DM Subfolder Name"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Subfolder Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Subfolder Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText(
				"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Move')]"));
		selenium.click(RuntimeVariables.replace(
				"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Move')]"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//a[@id='_31_parentFolderName']"));
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		selenium.waitForPopUp("null", RuntimeVariables.replace("30000"));
		selenium.selectWindow("title=Media Gallery");
		selenium.waitForText("link=Home", "Home");
		selenium.clickAt("link=Home", RuntimeVariables.replace("Home"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder2 Name"),
			selenium.getText("//td[contains(@id,'col-folder_row-2')]/a"));
		selenium.click("xPath=(//input[@value='Choose'])[2]");
		selenium.selectWindow("null");
		selenium.waitForText("//a[@id='_31_parentFolderName']",
			"DM Folder2 Name");
		assertEquals(RuntimeVariables.replace("DM Folder2 Name"),
			selenium.getText("//a[@id='_31_parentFolderName']"));
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
		assertFalse(selenium.isTextPresent("DM Folder1 Subfolder Name"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder2 Name"),
			selenium.getText("xPath=(//span[@class='image-title'])[2]"));
		selenium.clickAt("xPath=(//span[@class='image-title'])[2]",
			RuntimeVariables.replace("DM Folder2 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Subfolder Name"),
			selenium.getText("//span[@class='image-title']"));
	}
}