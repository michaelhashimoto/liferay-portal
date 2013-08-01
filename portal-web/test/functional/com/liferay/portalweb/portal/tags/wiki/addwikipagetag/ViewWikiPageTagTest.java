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

package com.liferay.portalweb.portal.tags.wiki.addwikipagetag;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWikiPageTagTest extends BaseTestCase {
	public void testViewWikiPageTag() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("All Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span/a/span[contains(.,'All Pages')]"));
		selenium.clickAt("//ul[@class='top-links-navigation']/li/span/a/span[contains(.,'All Pages')]",
			RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page Title"),
			selenium.getText("//tr[contains(.,'Wiki Page Title')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Wiki Page Title')]/td[1]/a",
			RuntimeVariables.replace("Wiki Page Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("wiki tag1"),
			selenium.getText("//div[@class='page-tags']/span/a"));
		selenium.clickAt("//div[@class='page-tags']/span/a",
			RuntimeVariables.replace("wiki tag1"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'FrontPage')]"));
		assertEquals(RuntimeVariables.replace("Recent Changes"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'Recent Changes')]"));
		assertEquals(RuntimeVariables.replace("All Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]"));
		assertEquals(RuntimeVariables.replace("Orphan Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'Orphan Pages')]"));
		assertEquals(RuntimeVariables.replace("Draft Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'Draft Pages')]"));
		assertTrue(selenium.isVisible("//input[@title='Search Pages']"));
		assertTrue(selenium.isVisible("//input[@value='Search']"));
		assertEquals(RuntimeVariables.replace("Pages with tag wiki tag1 ."),
			selenium.getText("//h1[contains(.,'Pages with tag')]"));
		assertEquals(RuntimeVariables.replace("wiki tag1"),
			selenium.getText("//span[@class='asset-entry']"));
		assertEquals(RuntimeVariables.replace("Wiki Page Title"),
			selenium.getText("//tr[contains(.,'Wiki Page Title')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//tr[contains(.,'Wiki Page Title')]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("1.1"),
			selenium.getText("//tr[contains(.,'Wiki Page Title')]/td[3]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[contains(.,'Wiki Page Title')]/td[4]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Wiki Page Title')]/td[5]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
	}
}