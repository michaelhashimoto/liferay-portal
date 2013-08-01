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

package com.liferay.portalweb.socialofficehome.sites.privatesite.sousfavoritesite1typeprivate;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ConfirmInviteSite1TypePrivateTest extends BaseTestCase {
	public void testSOUs_ConfirmInviteSite1TypePrivate()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.mouseOver("//span[@class='notification-count']");
		selenium.waitForElementPresent(
			"//div[contains(@class, 'user-notification-events-container')]");
		assertTrue(selenium.isVisible(
				"//div[contains(@class, 'user-notification-events-container')]"));
		assertTrue(selenium.isPartialText(
				"//div[contains(@class, 'user-notification-event-content')]/div[2]/div",
				"Joe Bloggs invited you to join"));
		assertEquals(RuntimeVariables.replace("Private Site1 Name"),
			selenium.getText(
				"//div[contains(@class, 'user-notification-event-content')]/div[2]/div/a[2]"));
		assertEquals(RuntimeVariables.replace("Confirm"),
			selenium.getText("//div[@class='notification-entry']/div[2]/span/a"));
		selenium.clickAt("//div[@class='notification-entry']/div[2]/span/a",
			RuntimeVariables.replace("Confirm"));
		selenium.waitForNotText("//span[@class='notification-count']", "1");
		assertEquals(RuntimeVariables.replace("0"),
			selenium.getText("//span[@class='notification-count']"));
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//li[contains(@class, 'selected')]/a/span");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li[contains(@class, 'selected')]/a/span"));
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isPartialText(
				"//select[@id='_5_WAR_soportlet_tabs1']", "My Sites"));
		selenium.select("//select[@id='_5_WAR_soportlet_tabs1']",
			RuntimeVariables.replace("My Sites"));
		selenium.waitForNotPartialText("//ul[contains(@class, 'site-list')]/",
			"liferay.com");
		assertFalse(selenium.isPartialText(
				"//ul[contains(@class, 'site-list')]/", "liferay.com"));
		assertEquals(RuntimeVariables.replace("Private Site1 Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
	}
}