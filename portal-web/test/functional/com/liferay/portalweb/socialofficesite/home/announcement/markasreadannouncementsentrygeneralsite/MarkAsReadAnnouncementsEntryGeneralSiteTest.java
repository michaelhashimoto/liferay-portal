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

package com.liferay.portalweb.socialofficesite.home.announcement.markasreadannouncementsentrygeneralsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MarkAsReadAnnouncementsEntryGeneralSiteTest extends BaseTestCase {
	public void testMarkAsReadAnnouncementsEntryGeneralSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		assertEquals(RuntimeVariables.replace("Sites"),
			selenium.getText("//div[@id='so-sidebar']/h3"));
		assertTrue(selenium.isVisible("//input[@class='search-input']"));
		selenium.type("//input[@class='search-input']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Mark as Read"),
			selenium.getText("//td[@class='control-entry']/a"));
		selenium.clickAt("//td[@class='control-entry']/a",
			RuntimeVariables.replace("Mark as Read"));
		selenium.waitForText("//td[@class='control-entry']/a", "Show");
		assertEquals(RuntimeVariables.replace("Show"),
			selenium.getText("//td[@class='control-entry']/a"));
		assertEquals(RuntimeVariables.replace("Announcements Entry Title"),
			selenium.getText("//h3[@class='entry-title']/a"));
		assertFalse(selenium.isVisible("//span[@class='entry-scope']"));
		assertFalse(selenium.isVisible(
				"//div[contains(@class,'entry-content entry-type-general')]/p"));
	}
}