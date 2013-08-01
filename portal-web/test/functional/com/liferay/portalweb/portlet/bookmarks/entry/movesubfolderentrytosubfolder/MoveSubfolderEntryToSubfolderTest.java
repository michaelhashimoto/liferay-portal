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

package com.liferay.portalweb.portlet.bookmarks.entry.movesubfolderentrytosubfolder;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveSubfolderEntryToSubfolderTest extends BaseTestCase {
	public void testMoveSubfolderEntryToSubfolder() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Bookmarks Test Page",
			RuntimeVariables.replace("Bookmarks Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test1 Folder1"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong", RuntimeVariables.replace("Test1 Folder1"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test1 Subfolder1"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("Test1 Subfolder1"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Subfolder Entry"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//td[2]/a"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//td[5]/span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//td[5]/span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		Thread.sleep(1000);
		selenium.selectWindow("title=Bookmarks");
		selenium.waitForVisible("link=Home");
		selenium.clickAt("link=Home", RuntimeVariables.replace("Home"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Test2 Folder2",
			RuntimeVariables.replace("Test2 Folder2"));
		selenium.waitForPageToLoad("30000");
		selenium.click("//input[@value='Choose']");
		selenium.selectWindow("null");
		assertEquals(RuntimeVariables.replace("Test2 Subfolder2"),
			selenium.getText("//a[@id='_28_folderName']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertFalse(selenium.isTextPresent("Test Subfolder Entry"));
		assertFalse(selenium.isTextPresent("http://www.liferay.com"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Bookmarks Test Page",
			RuntimeVariables.replace("Bookmarks Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test1 Folder1"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong", RuntimeVariables.replace("Test1 Folder1"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test1 Subfolder1"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("Test1 Subfolder1"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Test Subfolder Entry"));
		assertFalse(selenium.isTextPresent("http://www.liferay.com"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Bookmarks Test Page",
			RuntimeVariables.replace("Bookmarks Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test2 Folder2"),
			selenium.getText("//tr[4]/td[1]/a/strong"));
		selenium.clickAt("//tr[4]/td[1]/a/strong",
			RuntimeVariables.replace("Test2 Folder2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test2 Subfolder2"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("Test2 Subfolder2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Subfolder Entry"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//td[2]/a"));
	}
}