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

package com.liferay.portalweb.socialofficesite.home.bookmarks.editpermissionsbookmarksentry2guestnoview;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewBookmarksEntrySiteTest extends BaseTestCase {
	public void testSOUs_ViewBookmarksEntrySite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
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
		assertEquals(RuntimeVariables.replace("Bookmarks Entry1 Name"),
			selenium.getText(
				"//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-1']/a"));
		assertTrue(selenium.isElementNotPresent(
				"//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-2']/a"));
		assertFalse(selenium.isTextPresent("Bookmarks Entry2 Name"));
		selenium.clickAt("//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-1']/a",
			RuntimeVariables.replace("Bookmarks Entry Name"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Google");
		selenium.waitForVisible("//img[@alt='Google']");
		assertTrue(selenium.isVisible("//img[@alt='Google']"));
		selenium.close();
		selenium.selectWindow("null");
	}
}