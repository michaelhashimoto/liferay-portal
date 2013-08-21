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

package com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.configurerbselectionmethodusers;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewBlogsEntryMultipleRBSite2Test extends BaseTestCase {
	public void testSOUs_ViewBlogsEntryMultipleRBSite2()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Open Site2"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site2 Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site2 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[contains(.,'Blogs')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Blogs')]/a/span",
			RuntimeVariables.replace("Blogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry2 Title"),
			selenium.getText(
				"//div[contains(.,'Blogs Entry2 Title')]/span[@class='entry-title']"));
		assertEquals(RuntimeVariables.replace("By Social01 Office01 User01,"),
			selenium.getText(
				"//div[contains(.,'Blogs Entry2 Title')]/span[@class='entry-author']"));
		assertTrue(selenium.isElementPresent(
				"//div[contains(.,'Blogs Entry2 Title')]/span[@class='entry-date']"));
		selenium.clickAt("//div[contains(.,'Blogs Entry2 Title')]/span[@class='entry-title']/a",
			RuntimeVariables.replace("Blogs Entry2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry2 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Blogs Entry2 Content"),
			selenium.getText("//div[@class='entry-body']"));
		assertEquals(RuntimeVariables.replace("By Social01 Office01 User01"),
			selenium.getText("//div[@class='entry-author']"));
		assertEquals(RuntimeVariables.replace("0 Comments"),
			selenium.getText("//span[@class='comments']"));
		assertEquals(RuntimeVariables.replace("Your Rating"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[1]"));
		assertEquals(RuntimeVariables.replace("Average (0 Votes)"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[2]"));
		assertEquals(RuntimeVariables.replace("Comments"),
			selenium.getText("//div[@class='lfr-panel-title']/span"));
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Open Site2"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site2 Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site2 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[contains(.,'Blogs')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Blogs')]/a/span",
			RuntimeVariables.replace("Blogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Title"),
			selenium.getText(
				"//div[contains(.,'Blogs Entry1 Title')]/span[@class='entry-title']"));
		assertEquals(RuntimeVariables.replace("By Joe Bloggs,"),
			selenium.getText(
				"//div[contains(.,'Blogs Entry1 Title')]/span[@class='entry-author']"));
		assertTrue(selenium.isElementPresent(
				"//div[contains(.,'Blogs Entry1 Title')]/span[@class='entry-date']"));
		selenium.clickAt("//div[contains(.,'Blogs Entry1 Title')]/span[@class='entry-title']/a",
			RuntimeVariables.replace("Blogs Entry1 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Content"),
			selenium.getText("//div[@class='entry-body']"));
		assertEquals(RuntimeVariables.replace("By Joe Bloggs"),
			selenium.getText("//div[@class='entry-author']"));
		assertEquals(RuntimeVariables.replace("0 Comments"),
			selenium.getText("//span[@class='comments']"));
		assertEquals(RuntimeVariables.replace("Your Rating"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[1]"));
		assertEquals(RuntimeVariables.replace("Average (0 Votes)"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[2]"));
		assertEquals(RuntimeVariables.replace("Comments"),
			selenium.getText("//div[@class='lfr-panel-title']/span"));
	}
}