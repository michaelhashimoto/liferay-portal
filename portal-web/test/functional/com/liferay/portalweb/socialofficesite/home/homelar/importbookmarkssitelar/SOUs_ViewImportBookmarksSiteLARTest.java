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

package com.liferay.portalweb.socialofficesite.home.homelar.importbookmarkssitelar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewImportBookmarksSiteLARTest extends BaseTestCase {
	public void testSOUs_ViewImportBookmarksSiteLAR() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
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
		assertFalse(selenium.isTextPresent("Bookmarks Entry2 Name Edit"));
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