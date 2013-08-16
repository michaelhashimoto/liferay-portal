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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.viewcontactmycontactscc;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewContactMyContactsCCTest extends BaseTestCase {
	public void testViewContactMyContactsCC() throws Exception {
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
		selenium.type("//input[@id='_1_WAR_contactsportlet_name']",
			RuntimeVariables.replace("social"));
		selenium.waitForText("//div[contains(@class,'lfr-contact-name')]/a",
			"Social01 Office01 Contact01");
		assertEquals(RuntimeVariables.replace("Social01 Office01 Contact01"),
			selenium.getText(
				"xPath=(//div[contains(@class,'lfr-contact-name')]/a)[contains(.,'Social01 Office01 Contact01')]"));
		assertEquals(RuntimeVariables.replace(
				"socialofficecontact01@liferay.com"),
			selenium.getText(
				"xPath=(//div[contains(@class,'lfr-contact-extra')])[contains(.,'socialofficecontact01@liferay.com')]"));
		assertEquals(RuntimeVariables.replace("User01, Social01"),
			selenium.getText(
				"xPath=(//div[contains(@class,'lfr-contact-name')]/a)[contains(.,'User01, Social01')]"));
		assertEquals(RuntimeVariables.replace("socialoffice01@liferay.com"),
			selenium.getText(
				"xPath=(//div[contains(@class,'lfr-contact-extra')])[contains(.,'socialoffice01@liferay.com')]"));
		assertTrue(selenium.isVisible(
				"//select[@id='_1_WAR_contactsportlet_filterBy']"));
		selenium.select("//select[@id='_1_WAR_contactsportlet_filterBy']",
			RuntimeVariables.replace("My Contacts"));
		Thread.sleep(1000);
		selenium.waitForElementNotPresent(
			"xPath=(//div[contains(@class,'lfr-contact-name')]/a)[contains(.,'User01, Social01')]");
		assertEquals(RuntimeVariables.replace("Social01 Office01 Contact01"),
			selenium.getText(
				"xPath=(//div[contains(@class,'lfr-contact-name')]/a)[contains(.,'Social01 Office01 Contact01')]"));
		assertEquals(RuntimeVariables.replace(
				"socialofficecontact01@liferay.com"),
			selenium.getText(
				"xPath=(//div[contains(@class,'lfr-contact-extra')])[contains(.,'socialofficecontact01@liferay.com')]"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//div[contains(@class,'lfr-contact-name')]/a)[contains(.,'User01, Social01')]"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//div[contains(@class,'lfr-contact-extra')])[contains(.,'socialoffice01@liferay.com')]"));
		assertFalse(selenium.isTextPresent("User01, Social01"));
		assertFalse(selenium.isTextPresent("socialoffice01@liferay.com"));
		assertEquals(RuntimeVariables.replace("View my 1 contacts."),
			selenium.getText("link=View my 1 contacts."));
	}
}