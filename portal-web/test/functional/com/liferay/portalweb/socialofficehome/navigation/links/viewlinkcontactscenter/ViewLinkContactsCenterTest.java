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

package com.liferay.portalweb.socialofficehome.navigation.links.viewlinkcontactscenter;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewLinkContactsCenterTest extends BaseTestCase {
	public void testViewLinkContactsCenter() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//div[@class='aui-layout contacts-result']"));
		assertTrue(selenium.isVisible("//div[@class='lfr-contact-checkbox']"));
		assertEquals(RuntimeVariables.replace("Contacts Center"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("You have 0 connections."),
			selenium.getText("//a[contains(.,'You have 0 connections.')]"));
		assertEquals(RuntimeVariables.replace("You are following 0 people."),
			selenium.getText("//a[contains(.,'You are following 0 people.')]"));
		assertTrue(selenium.isPartialText("//a[contains(.,'View all')]",
				"View all"));
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		assertTrue(selenium.isVisible("//div/input[1]"));
		assertEquals(RuntimeVariables.replace("Liferay, Inc."),
			selenium.getText("//li/span[2]/a"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//li[2]/span[2]/a"));
	}
}