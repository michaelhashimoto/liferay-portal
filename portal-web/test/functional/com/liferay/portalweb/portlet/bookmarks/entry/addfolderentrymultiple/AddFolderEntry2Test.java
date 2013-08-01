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

package com.liferay.portalweb.portlet.bookmarks.entry.addfolderentrymultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFolderEntry2Test extends BaseTestCase {
	public void testAddFolderEntry2() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Bookmarks Test Page",
			RuntimeVariables.replace("Bookmarks Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Folder"),
			selenium.getText("//a/strong"));
		selenium.clickAt("//a/strong", RuntimeVariables.replace("Test Folder"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Bookmark"),
			selenium.getText("//div[2]/ul/li[5]/a"));
		selenium.clickAt("//div[2]/ul/li[5]/a",
			RuntimeVariables.replace("Add Bookmark"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_28_name']",
			RuntimeVariables.replace("Test2 Folder2 Entry2"));
		selenium.type("//input[@id='_28_url']",
			RuntimeVariables.replace("http://www.openqa.org"));
		selenium.type("//textarea[@id='_28_description']",
			RuntimeVariables.replace("This is a test2 folder2 entry2."));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Test1 Folder1 Entry1"),
			selenium.getText("//tr[3]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Test2 Folder2 Entry2"),
			selenium.getText("//tr[4]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.openqa.org"),
			selenium.getText("//tr[4]/td[2]/a"));
	}
}