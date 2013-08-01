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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.addcontactcc;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddContactCCTest extends BaseTestCase {
	public void testAddContactCC() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Add Contact",
			selenium.getValue("//input[@value='Add Contact']"));
		selenium.clickAt("//input[@value='Add Contact']",
			RuntimeVariables.replace("Add Contact"));
		selenium.waitForVisible(
			"//input[@id='_1_WAR_contactsportlet_fullName']");
		selenium.type("//input[@id='_1_WAR_contactsportlet_fullName']",
			RuntimeVariables.replace("Social01 Office01 Contact01"));
		selenium.type("//input[@id='_1_WAR_contactsportlet_emailAddress']",
			RuntimeVariables.replace("socialofficecontact01@liferay.com"));
		selenium.type("//textarea[@id='_1_WAR_contactsportlet_comments']",
			RuntimeVariables.replace("Social01 Office01 Contact01 Comments"));
		Thread.sleep(1000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForVisible("//span[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"You have successfully added a new contact."),
			selenium.getText("//span[@class='portlet-msg-success']"));
	}
}