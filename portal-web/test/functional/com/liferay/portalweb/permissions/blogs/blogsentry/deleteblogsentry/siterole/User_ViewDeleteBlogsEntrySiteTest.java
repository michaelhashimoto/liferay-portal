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

package com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.siterole;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_ViewDeleteBlogsEntrySiteTest extends BaseTestCase {
	public void testUser_ViewDeleteBlogsEntrySite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//div[@class='entry-title']"));
		assertTrue(selenium.isElementNotPresent("//div[@class='entry-body']"));
		assertTrue(selenium.isElementNotPresent("//div[@class='entry-author']"));
		assertTrue(selenium.isElementNotPresent("//span[@class='comments']/a"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='taglib-flags']/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//li[@class='taglib-social-bookmark-twitter']"));
		assertTrue(selenium.isElementNotPresent(
				"//li[@class='taglib-social-bookmark-facebook']"));
		assertTrue(selenium.isElementNotPresent(
				"//li[@class='taglib-social-bookmark-plusone']"));
		assertTrue(selenium.isElementNotPresent(
				"//div[contains(@id,'ratingStar')]/div"));
		assertTrue(selenium.isElementNotPresent(
				"//div[contains(@id,'ratingScore')]/div"));
		assertTrue(selenium.isPartialText(
				"//div[@class='subscribe']/span/a[contains(@href,'rss')]", "RSS"));
		assertEquals(RuntimeVariables.replace("Showing 0 results."),
			selenium.getText("//div[@class='search-results']"));
	}
}