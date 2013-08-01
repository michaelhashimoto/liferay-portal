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

package com.liferay.portalweb.portal.permissions.announcements;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_AddAAAnnouncementTest extends BaseTestCase {
	public void testSA_AddAAAnnouncement() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Manage Entries",
			RuntimeVariables.replace("Manage Entries"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_84_distributionScope']",
			RuntimeVariables.replace("label=Announcements Administrator"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Entry']",
			RuntimeVariables.replace("Add Entry"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_84_title']",
			RuntimeVariables.replace("Test AA Announcement"));
		selenium.type("//input[@id='_84_url']",
			RuntimeVariables.replace("http://www.liferay.com"));
		Thread.sleep(1000);
		selenium.waitForVisible("//a[@class='cke_button_unlink cke_disabled']");
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("This is a test AA Announcement."));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Announcements Administrator",
			selenium.getSelectedLabel("//select[@id='_84_distributionScope']"));
		assertEquals(RuntimeVariables.replace("Test AA Announcement"),
			selenium.getText("//tr[contains(.,'Test AA Announcement')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("General"),
			selenium.getText("//tr[contains(.,'Test AA Announcement')]/td[2]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Test AA Announcement')]/td[3]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Test AA Announcement')]/td[4]/a"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'Test AA Announcement')]/td[5]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[contains(.,'Test AA Announcement')]/td[6]/span[@title='Actions']/ul/li/strong/a"));
	}
}