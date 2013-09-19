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

package com.liferay.portalweb.socialofficesite.home.activities.viewactivitiessitesactivitiessite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewActivitiesSitesActivitiesSiteTest extends BaseTestCase {
	public void testViewActivitiesSitesActivitiesSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("xpath=(//div[@class='activity-user-name'])[1]");
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[1]"));
		assertEquals(RuntimeVariables.replace("Added a new bookmark."),
			selenium.getText("xpath=(//div[@class='activity-action'])[1]"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[1]",
				"Bookmarks Entry Name"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[1]",
				"Bookmarks Entry Description"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"Made 2 updates to a wiki page in the Main wiki."),
			selenium.getText("xpath=(//div[@class='activity-action'])[2]"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[2]", "FrontPage"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[2]",
				"Wiki FrontPage Content Edit"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[3]"));
		assertEquals(RuntimeVariables.replace("Wrote a new blog entry."),
			selenium.getText("xpath=(//div[@class='activity-action'])[3]"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[3]", "Blogs Entry Title"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[3]",
				"Blogs Entry Content"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[4]"));
		assertEquals(RuntimeVariables.replace(
				"Wrote a new forum post in MB Category Name."),
			selenium.getText("xpath=(//div[@class='activity-action'])[4]"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[4]",
				"MB Category Thread Message Subject"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[4]",
				"MB Category Thread Message Body"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[5]"));
		assertEquals(RuntimeVariables.replace(
				"Uploaded a new document in the DM Folder Name folder."),
			selenium.getText("xpath=(//div[@class='activity-action'])[5]"));
		assertTrue(selenium.isPartialText(
				"//div[@class='document-container']", "DM Folder Document Title"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xpath=(//div[@class='activity-user-name'])[6]"));
		assertEquals(RuntimeVariables.replace("Added a new calendar event."),
			selenium.getText("xpath=(//div[@class='activity-action'])[6]"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[5]",
				"Calendar Event Title"));
		assertTrue(selenium.isPartialText(
				"xpath=(//div[@class='activity-body'])[5]",
				"Calendar Event Description"));
	}
}