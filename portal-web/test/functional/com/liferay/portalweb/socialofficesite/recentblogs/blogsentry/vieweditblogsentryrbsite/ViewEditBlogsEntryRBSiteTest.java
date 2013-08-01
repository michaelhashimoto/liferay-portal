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

package com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.vieweditblogsentryrbsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEditBlogsEntryRBSiteTest extends BaseTestCase {
	public void testViewEditBlogsEntryRBSite() throws Exception {
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
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[contains(.,'Blogs')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Blogs')]/a/span",
			RuntimeVariables.replace("Blogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title Edit"),
			selenium.getText("//span[@class='entry-title']"));
		assertEquals(RuntimeVariables.replace("By Joe Bloggs,"),
			selenium.getText("//span[@class='entry-author']"));
		assertTrue(selenium.isElementPresent("//span[@class='entry-date']"));
		assertTrue(selenium.isPartialText("//div[@class='comments']/a",
				"Read More"));
		selenium.clickAt("//div[@class='comments']/a",
			RuntimeVariables.replace("Read More"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title Edit"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Content Edit"),
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
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//span[@class='previous']"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//span[@class='next']"));
		assertEquals(RuntimeVariables.replace("Comments"),
			selenium.getText("//div[@class='lfr-panel-title']/span"));
	}
}