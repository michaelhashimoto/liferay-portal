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

package com.liferay.portalweb.socialofficehome.sites.site.sousviewsiteslinksauserprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewSitesLinkSAUserProfileTest extends BaseTestCase {
	public void testSOUs_ViewSitesLinkSAUserProfile() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/joebloggs/so/profile");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"xPath=(//li[@class='user-information-sites']/a)[contains(.,'Open Site Name')]"));
		selenium.clickAt("xPath=(//li[@class='user-information-sites']/a)[contains(.,'Open Site Name')]",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText("//div[@class='community-title']/a"));
		assertEquals(RuntimeVariables.replace("Join Site"),
			selenium.getText("//span[@class='action request']"));
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
		selenium.open("/web/joebloggs/so/profile");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Private Restricted Site Name"),
			selenium.getText(
				"xPath=(//li[@class='user-information-sites']/a)[contains(.,'Private Restricted Site Name')]"));
		selenium.clickAt("xPath=(//li[@class='user-information-sites']/a)[contains(.,'Private Restricted Site Name')]",
			RuntimeVariables.replace("Private Restricted Site Name"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='community-title']/a"));
		assertTrue(selenium.isElementNotPresent(
				"//nav/ul/li[contains(.,'Home')]/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//nav/ul/li[contains(.,'Calendar')]/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//nav/ul/li[3]/a/span[contains(.,'Documents')]"));
		assertTrue(selenium.isElementNotPresent(
				"//nav/ul/li[contains(.,'Forums')]/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//nav/ul/li[contains(.,'Blogs')]/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//nav/ul/li[contains(.,'Wiki')]/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//nav/ul/li[contains(.,'Members')]/a/span"));
		selenium.open("/web/joebloggs/so/profile");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText(
				"xPath=(//li[@class='user-information-sites']/a)[contains(.,'Public Restricted Site Name')]"));
		selenium.clickAt("xPath=(//li[@class='user-information-sites']/a)[contains(.,'Public Restricted Site Name')]",
			RuntimeVariables.replace("Public Restricted Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Public Restricted Site Name"),
			selenium.getText("//div[@class='community-title']/a"));
		assertEquals(RuntimeVariables.replace("Request Membership"),
			selenium.getText("//span[@class='action request']"));
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
		selenium.open("/web/joebloggs/so/profile");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//li[@class='user-information-sites']/a)[contains(.,'Private Site Name')]"));
		assertFalse(selenium.isTextPresent("Private Site Name"));
	}
}