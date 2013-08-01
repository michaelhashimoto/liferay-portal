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
public class AddSubfolder1Test extends BaseTestCase {
	public void testAddSubfolder1() throws Exception {
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
		assertEquals(RuntimeVariables.replace("Add Subfolder"),
			selenium.getText("//div[2]/ul/li[4]/a"));
		selenium.clickAt("//div[2]/ul/li[4]/a",
			RuntimeVariables.replace("Add Subfolder"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_28_name']",
			RuntimeVariables.replace("Test1 Subfolder1"));
		selenium.type("//textarea[@id='_28_description']",
			RuntimeVariables.replace("This is a test1 subfolder1."));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Test1 Subfolder1"),
			selenium.getText("//td[1]/a/strong"));
		assertTrue(selenium.isPartialText("//td[1]/a",
				"This is a test1 subfolder1."));
	}
}