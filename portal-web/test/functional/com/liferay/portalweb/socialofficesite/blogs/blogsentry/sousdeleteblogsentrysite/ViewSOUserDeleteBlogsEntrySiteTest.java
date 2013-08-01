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

package com.liferay.portalweb.socialofficesite.blogs.blogsentry.sousdeleteblogsentrysite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSOUserDeleteBlogsEntrySiteTest extends BaseTestCase {
	public void testViewSOUserDeleteBlogsEntrySite() throws Exception {
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
		assertTrue(selenium.isElementNotPresent("//input[@id='_33_keywords']"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Search']"));
		assertTrue(selenium.isVisible("//input[@value='Add Blog Entry']"));
		assertTrue(selenium.isVisible("//input[@value='Permissions']"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='entry-title']/h2/a"));
		assertTrue(selenium.isElementNotPresent("//div[@class='entry-date']"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Edit')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Permissions')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Delete')]/span/a/span"));
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
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Edit')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Permissions')]/span/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//td[contains(.,'Delete')]/span/a/span"));
		assertFalse(selenium.isTextPresent("Blogs Entry Title"));
		assertFalse(selenium.isTextPresent("Blogs Entry Content"));
	}
}