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
public class UnfollowCCUserMultipleTest extends BaseTestCase {
	public void testUnfollowCCUserMultiple() throws Exception {
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
		selenium.waitForText("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User02, Social02')]",
			"User02, Social02");
		assertEquals(RuntimeVariables.replace("User02, Social02"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User02, Social02')]"));
		selenium.waitForText("xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User03, Social03')]",
			"User03, Social03");
		assertEquals(RuntimeVariables.replace("User03, Social03"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User03, Social03')]"));
		assertFalse(selenium.isChecked(
				"xPath=(//div[@class='lfr-contact-checkbox']/input)[1]"));
		selenium.clickAt("xPath=(//div[@class='lfr-contact-checkbox']/input)[1]",
			RuntimeVariables.replace("Checkbox"));
		assertTrue(selenium.isChecked(
				"xPath=(//div[@class='lfr-contact-checkbox']/input)[1]"));
		selenium.waitForVisible("xPath=(//div[@class='lfr-contact-thumb'])[4]");
		assertTrue(selenium.isVisible(
				"xPath=(//div[@class='lfr-contact-thumb'])[4]"));
		assertFalse(selenium.isChecked(
				"xPath=(//div[@class='lfr-contact-checkbox']/input)[2]"));
		selenium.clickAt("xPath=(//div[@class='lfr-contact-checkbox']/input)[2]",
			RuntimeVariables.replace("Checkbox"));
		assertTrue(selenium.isChecked(
				"xPath=(//div[@class='lfr-contact-checkbox']/input)[2]"));
		selenium.waitForVisible("xPath=(//div[@class='lfr-contact-thumb'])[5]");
		assertTrue(selenium.isVisible(
				"xPath=(//div[@class='lfr-contact-thumb'])[5]"));
		assertFalse(selenium.isChecked(
				"xPath=(//div[@class='lfr-contact-checkbox']/input)[3]"));
		selenium.clickAt("xPath=(//div[@class='lfr-contact-checkbox']/input)[3]",
			RuntimeVariables.replace("Checkbox"));
		assertTrue(selenium.isChecked(
				"xPath=(//div[@class='lfr-contact-checkbox']/input)[3]"));
		selenium.waitForVisible("xPath=(//div[@class='lfr-contact-thumb'])[6]");
		assertTrue(selenium.isVisible(
				"xPath=(//div[@class='lfr-contact-thumb'])[6]"));
		assertEquals(RuntimeVariables.replace("Unfollow"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_unfollowButton']"));
		selenium.clickAt("//button[@id='_1_WAR_contactsportlet_unfollowButton']",
			RuntimeVariables.replace("Unfollow"));
		selenium.waitForVisible("//span[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"You are not following this user anymore."),
			selenium.getText("//span[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("User01, Social01"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User01, Social01')]"));
		assertTrue(selenium.isVisible(
				"xPath=(//div[@class='lfr-contact-thumb'])[4]"));
		assertEquals(RuntimeVariables.replace("User02, Social02"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User02, Social02')]"));
		assertTrue(selenium.isVisible(
				"xPath=(//div[@class='lfr-contact-thumb'])[5]"));
		assertEquals(RuntimeVariables.replace("User03, Social03"),
			selenium.getText(
				"xPath=(//div[contains(@class, 'lfr-contact-name')]/a)[contains(.,'User03, Social03')]"));
		assertTrue(selenium.isVisible(
				"xPath=(//div[@class='lfr-contact-thumb'])[6]"));
		assertEquals(RuntimeVariables.replace("Follow"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_followButton']"));
		assertFalse(selenium.isVisible(
				"//button[@id='_1_WAR_contactsportlet_unfollowButton']"));
	}
}