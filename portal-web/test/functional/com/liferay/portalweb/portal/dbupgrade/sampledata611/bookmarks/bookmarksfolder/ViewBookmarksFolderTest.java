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

package com.liferay.portalweb.portal.dbupgrade.sampledata611.bookmarks.bookmarksfolder;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBookmarksFolderTest extends BaseTestCase {
	public void testViewBookmarksFolder() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/bookmarks-folder-community/");
		selenium.waitForVisible("link=Bookmarks Folder Page");
		selenium.clickAt("link=Bookmarks Folder Page",
			RuntimeVariables.replace("Bookmarks Folder Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Bookmarks Folder Name"),
			selenium.getText("//a/strong"));
		assertTrue(selenium.isPartialText("//tr[3]/td[1]/a",
				"Bookmarks Folder Description"));
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("Bookmarks Folder Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Bookmarks Folder Name"),
			selenium.getText("//h1[@class='header-title']/span"));
	}
}