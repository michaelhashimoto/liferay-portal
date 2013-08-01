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
public class ViewBlogsEntry2RBSite2Test extends BaseTestCase {
	public void testViewBlogsEntry2RBSite2() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.select("//div[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("All Sites"));
		selenium.type("//input[@class='search-input']",
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
			selenium.getText("//span[@class='entry-title']"));
		assertEquals(RuntimeVariables.replace("By Social01 Office01 User01,"),
			selenium.getText("//span[@class='entry-author']"));
		assertTrue(selenium.isElementPresent("//span[@class='entry-date']"));
		assertFalse(selenium.isTextPresent("Blogs Entry1 Title"));
		assertFalse(selenium.isTextPresent("//div[@class='comments']/a"));
		selenium.clickAt("//div[@class='comments']/a",
			RuntimeVariables.replace("Read More"));
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
		assertEquals(RuntimeVariables.replace("Previous"),
			selenium.getText("//span[@class='previous']"));
		assertEquals(RuntimeVariables.replace("Next"),
			selenium.getText("//span[@class='next']"));
		assertEquals(RuntimeVariables.replace("Comments"),
			selenium.getText("//div[@class='lfr-panel-title']/span"));
	}
}