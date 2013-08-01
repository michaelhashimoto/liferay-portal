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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.documentlibrary.shortcut;

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
		assertEquals(RuntimeVariables.replace("Test2 Folder2"),
			selenium.getText("//div[3]/a/span[2]"));
		selenium.clickAt("//div[3]/a/span[2]",
			RuntimeVariables.replace("Test2 Folder2"));
		selenium.waitForText("//div/a/span[2]", "Test1 Document1.txt");
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt"),
			selenium.getText("//div/a/span[2]"));
		selenium.clickAt("//div/a/span[2]",
			RuntimeVariables.replace("Test1 Document1.txt"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("This is test1 document1."),
			selenium.getText("//div[2]/div[1]/span[4]"));
	}
}