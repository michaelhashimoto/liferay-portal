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

package com.liferay.portalweb.socialofficesite.members.member.viewsousermultiplejoinsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSOUserAllJoinSiteTest extends BaseTestCase {
	public void testViewSOUserAllJoinSite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
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
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText("//div[@class='community-title']/a/span"));
		assertEquals(RuntimeVariables.replace("Members"),
			selenium.getText("//nav/ul/li[contains(.,'Members')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Members')]/a/span",
			RuntimeVariables.replace("Members"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have 2 connections in this site."),
			selenium.getText(
				"//div[@class='aui-layout contacts-count connections']"));
		assertEquals(RuntimeVariables.replace(
				"You are following 2 people in this site."),
			selenium.getText(
				"//div[@class='aui-layout contacts-count followings']"));
		assertEquals(RuntimeVariables.replace("View all 5 users."),
			selenium.getText("//div[@class='aui-layout contacts-count all']"));
		selenium.clickAt("//div[@class='aui-layout contacts-count connections']",
			RuntimeVariables.replace("You have 2 connections in this site."));
		selenium.waitForText("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[1]",
			"User01, Social01");
		assertEquals(RuntimeVariables.replace("User01, Social01"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[1]"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-extra')])[1]"));
		assertEquals(RuntimeVariables.replace("User03, Social03"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[2]"));
		assertEquals(RuntimeVariables.replace("socialoffice03@liferay.com"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-extra')])[2]"));
		selenium.clickAt("//div[@class='aui-layout contacts-count followings']",
			RuntimeVariables.replace("You are following 2 people in this site."));
		selenium.waitForText("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[1]",
			"User02, Social02");
		assertEquals(RuntimeVariables.replace("User02, Social02"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[1]"));
		assertEquals(RuntimeVariables.replace("socialoffice02@liferay.com"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-extra')])[1]"));
		assertEquals(RuntimeVariables.replace("User04, Social04"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[2]"));
		assertEquals(RuntimeVariables.replace("socialoffice04@liferay.com"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-extra')])[2]"));
	}
}