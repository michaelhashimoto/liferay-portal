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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.unfollowccusermultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewUnfollowCCUserMultipleTest extends BaseTestCase {
	public void testViewUnfollowCCUserMultiple() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//input[@id='_1_WAR_contactsportlet_name']"));
		assertTrue(selenium.isVisible(
				"//div[contains(@class, 'contacts-center-home-content')]"));
		selenium.type("//input[@id='_1_WAR_contactsportlet_name']",
			RuntimeVariables.replace("socialoffice"));
		selenium.waitForText("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User01, Social01')]",
			"User01, Social01");
		assertEquals(RuntimeVariables.replace("User01, Social01"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User01, Social01')]"));
		Thread.sleep(1000);
		selenium.clickAt("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User01, Social01')]",
			RuntimeVariables.replace("User01, Social01"));
		selenium.waitForVisible(
			"//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[contains(@class, 'contacts-center-home-content')]"));
		assertEquals(RuntimeVariables.replace("Follow"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_followButton']"));
		assertFalse(selenium.isVisible(
				"//button[@id='_1_WAR_contactsportlet_unfollowButton']"));
		selenium.waitForText("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User02, Social02')]",
			"User02, Social02");
		assertEquals(RuntimeVariables.replace("User02, Social02"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User02, Social02')]"));
		Thread.sleep(1000);
		selenium.clickAt("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User02, Social02')]",
			RuntimeVariables.replace("User02, Social02"));
		selenium.waitForText("//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a",
			"Social02 Office02 User02");
		assertEquals(RuntimeVariables.replace("Social02 Office02 User02"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a"));
		assertEquals(RuntimeVariables.replace("socialoffice02@liferay.com"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[contains(@class, 'contacts-center-home-content')]"));
		assertEquals(RuntimeVariables.replace("Follow"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_followButton']"));
		assertFalse(selenium.isVisible(
				"//button[@id='_1_WAR_contactsportlet_unfollowButton']"));
		selenium.waitForText("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User03, Social03')]",
			"User03, Social03");
		assertEquals(RuntimeVariables.replace("User03, Social03"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User03, Social03')]"));
		Thread.sleep(1000);
		selenium.clickAt("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User03, Social03')]",
			RuntimeVariables.replace("User03, Social03"));
		selenium.waitForVisible("//div[contains(@class, 'contacts-profile')]");
		selenium.waitForText("//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a",
			"Social03 Office03 User03");
		assertEquals(RuntimeVariables.replace("Social03 Office03 User03"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a"));
		assertEquals(RuntimeVariables.replace("socialoffice03@liferay.com"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[contains(@class, 'contacts-center-home-content')]"));
		assertEquals(RuntimeVariables.replace("Follow"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_followButton']"));
		assertFalse(selenium.isVisible(
				"//button[@id='_1_WAR_contactsportlet_unfollowButton']"));
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("You are following 0 people."),
			selenium.getText("link=You are following 0 people."));
		selenium.clickAt("link=You are following 0 people.",
			RuntimeVariables.replace("You are following 0 people."));
		selenium.waitForTextNotPresent("User01, Social01");
		assertFalse(selenium.isTextPresent("User01, Social01"));
		assertFalse(selenium.isTextPresent("User02, Social02"));
		assertFalse(selenium.isTextPresent("User03, Social03"));
	}
}