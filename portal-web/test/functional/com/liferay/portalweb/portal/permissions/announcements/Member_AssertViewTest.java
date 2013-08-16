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
public class Member_AssertViewTest extends BaseTestCase {
	public void testMember_AssertView() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Guest Announcement"),
			selenium.getText("xpath=(//h3[@class='entry-title']/a)[1]"));
		assertEquals(RuntimeVariables.replace("Test General Announcement"),
			selenium.getText("xpath=(//h3[@class='entry-title']/a)[2]"));
		assertEquals(RuntimeVariables.replace("Mark as Read"),
			selenium.getText("xpath=(//td[@class='control-entry']/a)[1]"));
		assertEquals(RuntimeVariables.replace("Mark as Read"),
			selenium.getText("xpath=(//td[@class='control-entry']/a)[2]"));
		assertEquals(RuntimeVariables.replace("Guest"),
			selenium.getText("xPath=(//span[@class='entry-scope'])[1]"));
		assertEquals(RuntimeVariables.replace("General"),
			selenium.getText("xPath=(//span[@class='entry-scope'])[2]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class=' entry-content entry-type-general'])[1]",
				"This is a test Guest Announcement."));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class=' entry-content entry-type-general'])[2]",
				"This is a test General Announcement."));
		assertFalse(selenium.isTextPresent("Test AA Announcement"));
		assertFalse(selenium.isTextPresent("This is a test AA Announcement."));
		assertFalse(selenium.isTextPresent("Test Member Announcement"));
		assertFalse(selenium.isTextPresent("This is a test Member Announcement"));
	}
}