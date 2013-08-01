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

package com.liferay.portalweb.portal.dbupgrade.sampledata6110.announcements.announcementsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddAnnouncementsEntryTest extends BaseTestCase {
	public void testAddAnnouncementsEntry() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open(
			"/web/announcements-entry-community/announcements-entry-page");
		selenium.waitForVisible("link=Announcements Entry Page");
		selenium.clickAt("link=Announcements Entry Page",
			RuntimeVariables.replace("Announcements Entry Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Manage Entries",
			RuntimeVariables.replace("Manage Entries"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Entry']",
			RuntimeVariables.replace("Add Entry"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_84_title']",
			RuntimeVariables.replace("Announcements Entry Name"));
		selenium.type("//input[@id='_84_url']",
			RuntimeVariables.replace("http://www.liferay.com"));
		selenium.waitForElementPresent(
			"//textarea[@id='_84_editor' and@style='display: none;']");
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//a[@class='cke_button_source cke_on']");
		selenium.waitForVisible("//td[@id='cke_contents__84_editor']/textarea");
		selenium.type("//td[@id='cke_contents__84_editor']/textarea",
			RuntimeVariables.replace("Announcements Entry Content"));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForElementPresent(
			"//textarea[@id='_84_editor' and@style='display: none;']");
		selenium.waitForVisible("//td[@id='cke_contents__84_editor']/iframe");
		selenium.selectFrame("//td[@id='cke_contents__84_editor']/iframe");
		selenium.waitForText("//body", "Announcements Entry Content");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Entries", RuntimeVariables.replace("Entries"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Announcements Entry Name"),
			selenium.getText("//div/h3/a"));
		assertTrue(selenium.isPartialText("//p", "Announcements Entry Content"));
		selenium.clickAt("//div/h3/a",
			RuntimeVariables.replace("Announcements Entry Name"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertTrue(selenium.isVisible("//img[@alt='Liferay']"));
	}
}