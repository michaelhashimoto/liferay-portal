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

package com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.sousleavesitetypeprivaterestricted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewLeaveSiteTypePrivateRestrictedTest extends BaseTestCase {
	public void testSOUs_ViewLeaveSiteTypePrivateRestricted()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		assertTrue(selenium.isPartialText(
				"//select[@id='_5_WAR_soportlet_tabs1']", "My Sites"));
		selenium.select("//select[@id='_5_WAR_soportlet_tabs1']",
			RuntimeVariables.replace("My Sites"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("There are no results."),
			selenium.getText("//ul[@class='site-list']"));
		assertFalse(selenium.isTextPresent("Private Restricted Site Name"));
		assertEquals(RuntimeVariables.replace("Sites Directory"),
			selenium.getText("//button[contains(.,'Sites Directory')]/span[2]"));
		selenium.clickAt("//button[contains(.,'Sites Directory')]/span[2]",
			RuntimeVariables.replace("Sites Directory"));
		selenium.waitForVisible("xPath=(//h1[@class='header-title']/span)[1]");
		assertEquals(RuntimeVariables.replace("Directory"),
			selenium.getText("xPath=(//h1[@class='header-title']/span)[1]"));
		selenium.select("//span[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("My Sites"));
		Thread.sleep(1000);
		assertFalse(selenium.isTextPresent("Private Restricted Site Name"));
		selenium.select("//span[@class='sites-tabs']/span/span/span/select",
			RuntimeVariables.replace("All Sites"));
		selenium.type("//input[@id='_5_WAR_soportlet_dialogKeywords']",
			RuntimeVariables.replace("Private Restricted Site Name"));
		Thread.sleep(1000);
		selenium.waitForVisible(
			"xPath=(//span[@class='name'])[contains(.,'Private Restricted Site Name')]");
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='name'])[contains(.,'Private Restricted Site Name')]"));
		assertEquals(RuntimeVariables.replace("Private Restricted Site Name"),
			selenium.getText(
				"xPath=(//span[@class='name'])[contains(.,'Private Restricted Site Name')]"));
		assertEquals(RuntimeVariables.replace(
				"Private Restricted Site Description"),
			selenium.getText(
				"xPath=(//span[@class='description'])[contains(.,'Private Restricted Site Description')]"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//span[@class='name']/a)[contains(.,'Private Restricted Site Name')]"));
		assertTrue(selenium.isVisible("//a[@class='request-site']"));
	}
}