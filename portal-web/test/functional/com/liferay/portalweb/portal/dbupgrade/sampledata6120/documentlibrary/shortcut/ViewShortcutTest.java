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

package com.liferay.portalweb.portal.dbupgrade.sampledata6120.documentlibrary.shortcut;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewShortcutTest extends BaseTestCase {
	public void testViewShortcut() throws Exception {
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
		selenium.waitForText("//div/a/span[contains(.,'Test1 Document1.txt')]",
			"Test1 Document1.txt");
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt"),
			selenium.getText("//div/a/span[contains(.,'Test1 Document1.txt')]"));
		assertTrue(selenium.isVisible(
				"//div[contains(.,'Test1 Document1.txt')]/a/span/img[@alt='Shortcut']"));
		selenium.clickAt("//div/a/span[contains(.,'Test1 Document1.txt')]",
			RuntimeVariables.replace("Test1 Document1.txt"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("This is test1 document1."),
			selenium.getText("//span[@class='document-description']"));
	}
}