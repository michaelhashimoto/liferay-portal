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

package com.liferay.portalweb.socialofficesite.home.bookmarks.editbookmarksentrysite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEditBookmarksEntrySiteTest extends BaseTestCase {
	public void testViewEditBookmarksEntrySite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Bookmarks Entry Name Edit"),
			selenium.getText(
				"//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-1']/a"));
		selenium.clickAt("//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-1']/a",
			RuntimeVariables.replace("Bookmarks Entry Name Edit"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Yahoo!");
		selenium.waitForVisible("//a[contains(.,'Yahoo')]");
		assertTrue(selenium.isVisible("//a[contains(.,'Yahoo')]"));
		selenium.close();
		selenium.selectWindow("null");
		Thread.sleep(1000);
		selenium.waitForVisible(
			"xPath=(//td[contains(.,'Actions')]/span/ul/li/strong/a)[1]");
		selenium.clickAt("xPath=(//td[contains(.,'Actions')]/span/ul/li/strong/a)[1]",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Bookmarks Entry Name Edit",
			selenium.getValue("//input[@id='_28_name']"));
		assertEquals("http://www.yahoo.com",
			selenium.getValue("//input[@id='_28_url']"));
		assertEquals("Bookmarks Entry Description Edit",
			selenium.getValue("//textarea[@id='_28_description']"));
	}
}