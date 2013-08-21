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

package com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.soussearchsitessitetypepublicrestricted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_SearchSitesSiteTypePublicRestrictedTest extends BaseTestCase {
	public void testSOUs_SearchSitesSiteTypePublicRestricted()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[contains(@class,'search-input')]");
		selenium.select("//div[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("All Sites"));
		selenium.type("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Public Restricted"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[contains(@class,'search-input')]");
		selenium.select("//div[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("My Sites"));
		selenium.type("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Public Restricted"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("There are no results."),
			selenium.getText("//li[@class='empty']"));
		assertFalse(selenium.isTextPresent("Open Site Name"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("User Name"));
		selenium.waitForVisible("link=Sites Directory");
		selenium.clickAt("link=Sites Directory",
			RuntimeVariables.replace("Sites Directory"));
		Thread.sleep(5000);
		selenium.waitForVisible("xPath=(//h1[@class='header-title']/span)[1]");
		assertEquals(RuntimeVariables.replace("Directory"),
			selenium.getText("xPath=(//h1[@class='header-title']/span)[1]"));
		selenium.select("//span[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("All Sites"));
		assertTrue(selenium.isVisible(
				"//input[@id='_5_WAR_soportlet_dialogKeywords']"));
		selenium.type("//input[@id='_5_WAR_soportlet_dialogKeywords']",
			RuntimeVariables.replace("Public Restricted Site Name"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText("//span[@class='name']/a"));
		assertEquals(RuntimeVariables.replace(
				"Public Restricted Site Description"),
			selenium.getText("//span[@class='description']"));
		assertTrue(selenium.isVisible("//span[@class='action request']/a"));
		selenium.clickAt("//span[@class='name']/a",
			RuntimeVariables.replace("Public Restricted Site Name"));
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=top");
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText("//div[@class='community-title']/a"));
		assertEquals(RuntimeVariables.replace("Request Membership"),
			selenium.getText("//span[@class='action request']/a"));
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[contains(@class,'search-input')]");
		selenium.select("//div[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("All Sites"));
		selenium.type("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Public Restricted"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Public Restricted Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText("//div[@class='community-title']/a"));
		assertEquals(RuntimeVariables.replace("Request Membership"),
			selenium.getText("//span[@class='action request']/a"));
	}
}