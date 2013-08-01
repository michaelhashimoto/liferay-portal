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

package com.liferay.portalweb.socialofficesite.home.announcement.sousdeleteannouncementsentrysitesite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_DeleteAnnouncementsEntrySiteSiteTest extends BaseTestCase {
	public void testSOUs_DeleteAnnouncementsEntrySiteSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard");
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
		selenium.waitForVisible("//td[2]/span/a/span");
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//td[2]/span/a/span"));
		selenium.clickAt("//td[2]/span/a/span",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this[\\s\\S]$"));
		selenium.waitForVisible("link=Manage Entries");
		selenium.clickAt("link=Manage Entries",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_84_distributionScope']",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForVisible("//form/div[2]");
		assertEquals(RuntimeVariables.replace("No entries were found."),
			selenium.getText("//form/div[2]"));
	}
}