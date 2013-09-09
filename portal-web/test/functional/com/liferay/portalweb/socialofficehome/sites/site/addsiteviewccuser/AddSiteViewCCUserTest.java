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

package com.liferay.portalweb.socialofficehome.sites.site.addsiteviewccuser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSiteViewCCUserTest extends BaseTestCase {
	public void testAddSiteViewCCUser() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//input[@id='_1_WAR_contactsportlet_name']"));
		assertTrue(selenium.isVisible(
				"//div[contains(@class, 'contacts-center-home-content')]"));
		selenium.type("//input[@id='_1_WAR_contactsportlet_name']",
			RuntimeVariables.replace("socialoffice01@liferay.com"));
		selenium.waitForText("//div[contains(@class, 'lfr-contact-name')]/a",
			"User01, Social01");
		assertEquals(RuntimeVariables.replace("User01, Social01"),
			selenium.getText("//div[contains(@class, 'lfr-contact-name')]/a"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText("//div[contains(@class, 'lfr-contact-extra')]"));
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@class, 'lfr-contact-name')]/a",
			RuntimeVariables.replace("User01, Social01"));
		selenium.waitForVisible("//div[contains(@class, 'contacts-profile')]");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[contains(@class, 'contacts-center-home-content')]"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//button[contains(.,'Add Site')]/span[2]");
		assertEquals(RuntimeVariables.replace("Add Site"),
			selenium.getText("//button[contains(.,'Add Site')]/span[2]"));
		selenium.clickAt("//button[contains(.,'Add Site')]/span[2]",
			RuntimeVariables.replace("Add Site"));
		selenium.waitForVisible("//label[contains(@for,'_5_WAR_soportlet')]");
		assertTrue(selenium.isVisible(
				"//label[contains(@for,'_5_WAR_soportlet')]"));
		assertTrue(selenium.isVisible("//input[@id='_5_WAR_soportlet_name']"));
		selenium.type("//input[@id='_5_WAR_soportlet_name']",
			RuntimeVariables.replace("Open Site Name"));
		assertTrue(selenium.isVisible(
				"//textarea[@id='_5_WAR_soportlet_description']"));
		selenium.type("//textarea[@id='_5_WAR_soportlet_description']",
			RuntimeVariables.replace("Open Site Description"));
		assertEquals("Next", selenium.getValue("//input[@value='Next']"));
		selenium.clickAt("//input[@value='Next']",
			RuntimeVariables.replace("Next"));
		selenium.waitForVisible(
			"//select[@id='_5_WAR_soportlet_layoutSetPrototypeSelect']");
		assertTrue(selenium.isVisible(
				"//select[@id='_5_WAR_soportlet_layoutSetPrototypeSelect']"));
		selenium.select("//select[@id='_5_WAR_soportlet_layoutSetPrototypeSelect']",
			RuntimeVariables.replace("Default Social Office Site"));
		assertTrue(selenium.isVisible(
				"//select[@id='_5_WAR_soportlet_typeSelect']"));
		selenium.select("//select[@id='_5_WAR_soportlet_typeSelect']",
			RuntimeVariables.replace("Open"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Home')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Calendar')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Documents')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Forums')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Blog')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Wiki')]/input"));
		assertTrue(selenium.isChecked(
				"//div[2]/div/div/div/div/div/div[contains(.,'Members')]/input"));
		assertEquals(RuntimeVariables.replace(
				"Open sites are listed, pages are public, and users are free to join and collaborate."),
			selenium.getText("//div[@class='message']"));
		assertEquals("Save", selenium.getValue("//input[@value='Save']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForNotVisible("//input[@value='Save']");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//button[contains(.,'Add Site')]/span[2]");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[contains(.,'Open Site Name')]/a"));
	}
}