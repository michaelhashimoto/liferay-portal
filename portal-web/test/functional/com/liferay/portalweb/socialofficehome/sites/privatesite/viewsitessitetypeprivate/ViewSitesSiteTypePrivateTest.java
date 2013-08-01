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

package com.liferay.portalweb.socialofficehome.sites.privatesite.viewsitessitetypeprivate;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSitesSiteTypePrivateTest extends BaseTestCase {
	public void testViewSitesSiteTypePrivate() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		selenium.waitForVisible("//select[@id='_5_WAR_soportlet_tabs1']");
		assertTrue(selenium.isPartialText(
				"//select[@id='_5_WAR_soportlet_tabs1']", "My Sites"));
		selenium.select("//select[@id='_5_WAR_soportlet_tabs1']",
			RuntimeVariables.replace("My Sites"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
			RuntimeVariables.replace("Private"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Private Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText("//div[@class='community-title']"));
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText("//nav/ul/li[1]/a/span"));
		assertEquals(RuntimeVariables.replace("Calendar"),
			selenium.getText("//nav/ul/li[2]/a/span"));
		assertEquals(RuntimeVariables.replace("Documents"),
			selenium.getText("//nav/ul/li[3]/a/span"));
		assertEquals(RuntimeVariables.replace("Forums"),
			selenium.getText("//nav/ul/li[4]/a/span"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[5]/a/span"));
		assertEquals(RuntimeVariables.replace("Wiki"),
			selenium.getText("//nav/ul/li[6]/a/span"));
		assertEquals(RuntimeVariables.replace("Members"),
			selenium.getText("//nav/ul/li[7]/a/span"));
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.waitForVisible(
			"//button[contains(.,'Sites Directory')]/span[2]");
		assertEquals(RuntimeVariables.replace("Sites Directory"),
			selenium.getText("//button[contains(.,'Sites Directory')]/span[2]"));
		selenium.clickAt("//button[contains(.,'Sites Directory')]/span[2]",
			RuntimeVariables.replace("Sites Directory"));
		selenium.waitForVisible("xPath=(//h1[@class='header-title']/span)[1]");
		assertEquals(RuntimeVariables.replace("Directory"),
			selenium.getText("xPath=(//h1[@class='header-title']/span)[1]"));
		selenium.select("//span[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("My Sites"));
		assertTrue(selenium.isVisible(
				"//input[@id='_5_WAR_soportlet_dialogKeywords']"));
		selenium.type("//input[@id='_5_WAR_soportlet_dialogKeywords']",
			RuntimeVariables.replace("Private Site Name"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText("//span[@class='name']/a"));
		assertEquals(RuntimeVariables.replace("Private Site Description"),
			selenium.getText("//span[@class='description']"));
		selenium.clickAt("//span[@class='name']/a",
			RuntimeVariables.replace("Private Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Private Site Name"),
			selenium.getText("//div[@class='community-title']"));
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText("//nav/ul/li[1]/a/span"));
		assertEquals(RuntimeVariables.replace("Calendar"),
			selenium.getText("//nav/ul/li[2]/a/span"));
		assertEquals(RuntimeVariables.replace("Documents"),
			selenium.getText("//nav/ul/li[3]/a/span"));
		assertEquals(RuntimeVariables.replace("Forums"),
			selenium.getText("//nav/ul/li[4]/a/span"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//nav/ul/li[5]/a/span"));
		assertEquals(RuntimeVariables.replace("Wiki"),
			selenium.getText("//nav/ul/li[6]/a/span"));
		assertEquals(RuntimeVariables.replace("Members"),
			selenium.getText("//nav/ul/li[7]/a/span"));
	}
}