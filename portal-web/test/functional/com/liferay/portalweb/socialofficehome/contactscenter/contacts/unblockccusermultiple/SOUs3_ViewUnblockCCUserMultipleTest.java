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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.unblockccusermultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs3_ViewUnblockCCUserMultipleTest extends BaseTestCase {
	public void testSOUs3_ViewUnblockCCUserMultiple() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice03/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("You have 0 connections."),
			selenium.getText("link=You have 0 connections."));
		selenium.type("//input[@id='_1_WAR_contactsportlet_name']",
			RuntimeVariables.replace("test@liferay.com"));
		selenium.waitForText("//div[contains(@class, 'lfr-contact-name')]/a",
			"Bloggs, Joe");
		assertEquals(RuntimeVariables.replace("Bloggs, Joe"),
			selenium.getText("//div[contains(@class, 'lfr-contact-name')]/a"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//div[contains(@class, 'lfr-contact-extra')]"));
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@class, 'lfr-contact-name')]/a",
			RuntimeVariables.replace("Bloggs, Joe"));
		selenium.waitForVisible("//div[contains(@class, 'contacts-profile')]");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText(
				"//div[contains(@class, 'contacts-profile')]/div/div[2]/div[3]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[contains(@class, 'contacts-center-home-content')]"));
		selenium.waitForVisible(
			"//button[@id='_1_WAR_contactsportlet_addConnectionButton']");
		assertEquals(RuntimeVariables.replace("Connect"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_addConnectionButton']"));
		assertEquals(RuntimeVariables.replace("Follow"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_followButton']"));
		assertEquals(RuntimeVariables.replace("Block"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_blockButton']"));
	}
}