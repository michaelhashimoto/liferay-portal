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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.editcontactcc;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEditContactCCTest extends BaseTestCase {
	public void testViewEditContactCC() throws Exception {
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
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Social02 Office02 Contact02"),
			selenium.getText("//div[@class='lfr-contact-name']"));
		selenium.clickAt("//div[@class='lfr-contact-name']",
			RuntimeVariables.replace("Social02 Office02 Contact02"));
		selenium.waitForVisible("xPath=(//div[@class='lfr-contact-name'])[2]");
		assertEquals(RuntimeVariables.replace("Social02 Office02 Contact02"),
			selenium.getText("xPath=(//div[@class='lfr-contact-name'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"socialofficecontact02@liferay.com"),
			selenium.getText("xPath=(//div[@class='lfr-contact-extra'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"Social02 Office02 Contact02 Comments"),
			selenium.getText("//div[@class='comments']"));
	}
}