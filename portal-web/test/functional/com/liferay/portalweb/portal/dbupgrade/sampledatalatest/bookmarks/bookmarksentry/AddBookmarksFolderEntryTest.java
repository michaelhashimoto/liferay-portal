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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.bookmarks.bookmarksentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddBookmarksFolderEntryTest extends BaseTestCase {
	public void testAddBookmarksFolderEntry() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/bookmarks-entry-community/");
		selenium.waitForVisible("link=Bookmarks Entry Page");
		selenium.clickAt("link=Bookmarks Entry Page",
			RuntimeVariables.replace("Bookmarks Entry Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a/strong",
			RuntimeVariables.replace("Bookmarks Folder Name"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[2]/ul/li[5]/a");
		selenium.clickAt("//div[2]/ul/li[5]/a",
			RuntimeVariables.replace("Add Bookmark"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_28_name']",
			RuntimeVariables.replace("Bookmarks Entry Name"));
		selenium.type("//input[@id='_28_url']",
			RuntimeVariables.replace("http://www.liferay.com"));
		selenium.type("//textarea[@id='_28_description']",
			RuntimeVariables.replace("Bookmarks Entry Comments"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Bookmarks Entry Name"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//td[2]/a"));
	}
}