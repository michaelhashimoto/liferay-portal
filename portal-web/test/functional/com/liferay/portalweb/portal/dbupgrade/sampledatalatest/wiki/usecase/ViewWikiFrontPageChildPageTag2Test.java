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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.wiki.usecase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWikiFrontPageChildPageTag2Test extends BaseTestCase {
	public void testViewWikiFrontPageChildPageTag2() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/wiki-use-case-community/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//div[@class='child-pages']/ul/li/a"));
		selenium.clickAt("//div[@class='child-pages']/ul/li/a",
			RuntimeVariables.replace("Wiki FrontPage ChildPage Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("wiki tag 2"),
			selenium.getText("xPath=(//a[@class='tag'])[2]"));
		selenium.clickAt("xPath=(//a[@class='tag'])[2]",
			RuntimeVariables.replace("wiki tag 2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Pages with tag wiki tag 2 ."),
			selenium.getText(
				"//h1[@class='taglib-categorization-filter entry-title']"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[2]/a"));
		assertTrue(selenium.isPartialText("//td[3]/a", "1.2"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isElementPresent("//td[5]/a"));
		selenium.type("//input[@id='_36_keywords']",
			RuntimeVariables.replace("\"wiki tag 2\""));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Main"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Showing 1 - 1."),
			selenium.getText("//div[@class='search-results']"));
	}
}