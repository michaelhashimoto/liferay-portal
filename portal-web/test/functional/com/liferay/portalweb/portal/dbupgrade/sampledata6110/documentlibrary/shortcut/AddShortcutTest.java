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

package com.liferay.portalweb.portal.dbupgrade.sampledata6110.documentlibrary.shortcut;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddShortcutTest extends BaseTestCase {
	public void testAddShortcut() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/document-library-shortcut-community/");
		selenium.clickAt("link=Document Library Page",
			RuntimeVariables.replace("Document Library Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div/a/span[contains(.,'Test2 Folder2')]");
		assertEquals(RuntimeVariables.replace("Test2 Folder2"),
			selenium.getText("//div/a/span[contains(.,'Test2 Folder2')]"));
		selenium.clickAt("//div/a/span[contains(.,'Test2 Folder2')]",
			RuntimeVariables.replace("Test2 Folder2"));
		selenium.waitForVisible(
			"//li[@class='folder selected']/a/span[contains(.,'Test2 Folder2')]");
		assertEquals(RuntimeVariables.replace("Test2 Folder2"),
			selenium.getText(
				"//li[@class='folder selected']/a/span[contains(.,'Test2 Folder2')]"));
		selenium.clickAt("//h1[@class='portlet-title']",
			RuntimeVariables.replace("Documents and Media"));
		selenium.waitForElementPresent("//div[@id='column-1_shim']");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span[@title='Add']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Add']/ul/li/strong/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Shortcut')]");
		assertEquals(RuntimeVariables.replace("Shortcut"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Shortcut')]"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Shortcut')]"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("xpath=(//input[@value='Select'])[1]",
			RuntimeVariables.replace("Select"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Documents and Media");
		selenium.waitForVisible("link=Document Library Shortcut Community");
		selenium.clickAt("link=Document Library Shortcut Community",
			RuntimeVariables.replace("Document Library Shortcut Community"));
		selenium.selectWindow("null");
		selenium.waitForVisible("//span[@id='_20_toGroupName']");
		assertEquals(RuntimeVariables.replace(
				"Document Library Shortcut Community"),
			selenium.getText("//span[@id='_20_toGroupName']"));
		selenium.clickAt("xpath=(//input[@value='Select'])[2]",
			RuntimeVariables.replace("Select"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Documents and Media");
		selenium.waitForVisible("link=Test1 Folder1");
		selenium.click(RuntimeVariables.replace("link=Test1 Folder1"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//td[1]/a", "Test1 Document1.txt"));
		assertTrue(selenium.isPartialText("//td[1]/a",
				"This is test1 document1."));
		selenium.click("//td[1]/a");
		selenium.selectWindow("null");
		selenium.waitForVisible("//span[@id='_20_toFileEntryTitle']");
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt"),
			selenium.getText("//span[@id='_20_toFileEntryTitle']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt"),
			selenium.getText("//div/a/span[contains(.,'Test1 Document1.txt')]"));
	}
}