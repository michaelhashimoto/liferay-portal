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

package com.liferay.portalweb.socialofficesite.blogs.blogslar.importblogssitelar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewImportBlogsSiteLARTest extends BaseTestCase {
	public void testSOUs_ViewImportBlogsSiteLAR() throws Exception {
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
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[contains(.,'Blogs')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Blogs')]/a/span",
			RuntimeVariables.replace("Blogs"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//input[@id='_33_keywords']"));
		assertTrue(selenium.isVisible(
				"//div[contains(@class,'search-form')]/div/span[2]/span/input[@value='Search']"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Title"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		assertTrue(selenium.isVisible("//div[@class='entry-date']"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Content"),
			selenium.getText("//div[@class='entry-body']"));
		assertEquals(RuntimeVariables.replace("By Joe Bloggs"),
			selenium.getText("//div[@class='entry-author']"));
		assertEquals(RuntimeVariables.replace("1 Comment"),
			selenium.getText("//span[@class='comments']/a"));
		assertEquals(RuntimeVariables.replace("Flag"),
			selenium.getText("//div[@class='taglib-flags']/span/a/span"));
		assertTrue(selenium.isVisible(
				"//li[@class='taglib-social-bookmark-twitter']"));
		assertTrue(selenium.isVisible(
				"//li[@class='taglib-social-bookmark-facebook']"));
		assertTrue(selenium.isVisible(
				"//li[@class='taglib-social-bookmark-plusone']"));
		assertTrue(selenium.isPartialText(
				"//div[contains(@id,'ratingStar')]/div", "Your Rating"));
		assertEquals(RuntimeVariables.replace("Average (1 Vote)"),
			selenium.getText("//div[contains(@id,'ratingScore')]/div"));
		assertTrue(selenium.isPartialText(
				"//div[@class='subscribe']/span/a[contains(@href,'rss')]", "RSS"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
		assertFalse(selenium.isTextPresent("Blogs Entry2 Title"));
		assertFalse(selenium.isTextPresent("Blogs Entry2 Content"));
		selenium.clickAt("//div[@class='entry-title']/h2/a",
			RuntimeVariables.replace("Blogs Entry1 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Content"),
			selenium.getText("//div[@class='entry-body']"));
		assertEquals(RuntimeVariables.replace("By Joe Bloggs"),
			selenium.getText("//div[@class='entry-author']"));
		assertEquals(RuntimeVariables.replace("1 Comment"),
			selenium.getText("//span[@class='comments']"));
		assertEquals(RuntimeVariables.replace("Your Rating"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[1]"));
		selenium.mouseOver("//div[contains(@id,'ratingStarContent')]");
		assertEquals(RuntimeVariables.replace("Average (1 Vote)"),
			selenium.getText(
				"xPath=(//div[@class='aui-rating-label-element'])[2]"));
		assertTrue(selenium.isElementPresent(
				"//img[@alt='The average rating is 4.0 stars out of 5.']"));
		assertEquals(RuntimeVariables.replace("Comments"),
			selenium.getText("//div[@class='lfr-panel-title']/span"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Blogs Entry1 Comment Body"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
	}
}