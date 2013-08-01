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

package com.liferay.portalweb.socialofficeprofile.profile.sousviewactivitiessitetypeprivateprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewActivitiesSiteTypePrivateProfileTest extends BaseTestCase {
	public void testSOUs_ViewActivitiesSiteTypePrivateProfile()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("You have 1 connections."),
			selenium.getText("link=You have 1 connections."));
		selenium.clickAt("link=You have 1 connections.",
			RuntimeVariables.replace("You have 1 connections."));
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
		assertEquals(RuntimeVariables.replace("Disconnect"),
			selenium.getText(
				"//button[@id='_1_WAR_contactsportlet_removeConnectionButton']"));
		assertFalse(selenium.isVisible(
				"//button[@id='_1_WAR_contactsportlet_addConnectionButton']"));
		selenium.clickAt("//div[contains(@class, 'contacts-profile')]/div/div[2]/div/a",
			RuntimeVariables.replace("Joe Bloggs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"xPath=(//div[@class='lfr-contact-name'])[contains(.,'Joe Bloggs')]"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//div[@class='lfr-contact-extra']"));
		assertFalse(selenium.isTextPresent(
				"Joe updated a wiki page, FrontPage, in Private Site Name."));
		assertFalse(selenium.isTextPresent(
				"Joe wrote a new blog entry, Blogs Entry Title, in Private Site Name."));
		assertFalse(selenium.isTextPresent(
				"Joe wrote a new message board post, MB Thread Message Subject, in Private Site Name."));
		assertFalse(selenium.isTextPresent(
				"Joe uploaded a new document, DM Document Title, in Private Site Name."));
		assertFalse(selenium.isTextPresent(
				"Joe added a new calendar event, Calendar Event Title, in Private Site Name."));
		assertFalse(selenium.isTextPresent("Wiki FrontPage"));
		assertFalse(selenium.isTextPresent("Blogs Entry"));
		assertFalse(selenium.isTextPresent("MB Thread Message"));
		assertFalse(selenium.isTextPresent("DM Document"));
		assertFalse(selenium.isTextPresent("Calendar Event"));
		assertFalse(selenium.isTextPresent("Private Site Name"));
	}
}