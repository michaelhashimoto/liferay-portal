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
public class Guest_AssertViewTest extends BaseTestCase {
	public void testGuest_AssertView() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Test Guest Announcement"));
		assertTrue(selenium.isTextPresent("This is a test Guest Announcement."));
		assertTrue(selenium.isTextPresent("Test General Announcement"));
		assertTrue(selenium.isTextPresent(
				"This is a test General Announcement."));
		assertFalse(selenium.isTextPresent("Test AA Announcement"));
		assertFalse(selenium.isTextPresent("This is a test AA Announcement."));
		assertFalse(selenium.isTextPresent("Test Member Announcement"));
		assertFalse(selenium.isTextPresent("This is a test Member Announcement"));
	}
}