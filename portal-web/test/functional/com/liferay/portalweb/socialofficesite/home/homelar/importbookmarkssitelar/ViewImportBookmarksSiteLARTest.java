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
public class ViewImportBookmarksSiteLARTest extends BaseTestCase {
	public void testViewImportBookmarksSiteLAR() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
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
		selenium.clickAt("//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-1']/a",
			RuntimeVariables.replace("Bookmarks Entry1 Name"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Google");
		selenium.waitForVisible("//img[@alt='Google']");
		assertTrue(selenium.isVisible("//img[@alt='Google']"));
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
		assertEquals("Bookmarks Entry1 Name",
			selenium.getValue("//input[@id='_28_name']"));
		assertEquals("http://www.google.com",
			selenium.getValue("//input[@id='_28_url']"));
		assertEquals("Bookmarks Entry1 Description",
			selenium.getValue("//textarea[@id='_28_description']"));
		selenium.open("/user/joebloggs/so/dashboard/");
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
		assertEquals(RuntimeVariables.replace("Bookmarks Entry2 Name Edit"),
			selenium.getText(
				"//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-2']/a"));
		selenium.clickAt("//td[@id='_28_bookmarksEntriesSearchContainer_col-name_row-2']/a",
			RuntimeVariables.replace("Bookmarks Entry2 Name Edit"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Yahoo!");
		selenium.waitForVisible("//a[contains(.,'Yahoo')]");
		assertTrue(selenium.isVisible("//a[contains(.,'Yahoo')]"));
		selenium.close();
		selenium.selectWindow("null");
		Thread.sleep(1000);
		selenium.waitForVisible(
			"xPath=(//td[contains(.,'Actions')]/span/ul/li/strong/a)[2]");
		selenium.clickAt("xPath=(//td[contains(.,'Actions')]/span/ul/li/strong/a)[2]",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Bookmarks Entry2 Name Edit",
			selenium.getValue("//input[@id='_28_name']"));
		assertEquals("http://www.yahoo.com",
			selenium.getValue("//input[@id='_28_url']"));
		assertEquals("Bookmarks Entry2 Description Edit",
			selenium.getValue("//textarea[@id='_28_description']"));
		assertEquals(RuntimeVariables.replace("tag1"),
			selenium.getText(
				"xPath=(//span[contains(@class,'textboxlistentry-content')])[1]"));
		assertEquals(RuntimeVariables.replace("tag2"),
			selenium.getText(
				"xPath=(//span[contains(@class,'textboxlistentry-content')])[2]"));
		selenium.open("/user/joebloggs/so/dashboard/");
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
		Thread.sleep(1000);
		selenium.waitForVisible(
			"xPath=(//td[contains(.,'Actions')]/span/ul/li/strong/a)[2]");
		selenium.clickAt("xPath=(//td[contains(.,'Actions')]/span/ul/li/strong/a)[2]",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@id='guest_ACTION_VIEW']");
		assertFalse(selenium.isChecked("//input[@id='guest_ACTION_VIEW']"));
	}
}