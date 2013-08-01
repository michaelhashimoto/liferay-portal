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

package com.liferay.portalweb.portlet.announcements.announcementsentry.markasreadannouncementsentrygeneral;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MarkAsReadAnnouncementsEntryGeneralTest extends BaseTestCase {
	public void testMarkAsReadAnnouncementsEntryGeneral()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Announcements Test Page");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Mark as Read"),
			selenium.getText("//td[@class='control-entry']/a"));
		selenium.clickAt("//td[@class='control-entry']/a",
			RuntimeVariables.replace("Mark as Read"));
		selenium.waitForText("//td[@class='control-entry']/a", "Show");
		assertEquals(RuntimeVariables.replace("Show"),
			selenium.getText("//td[@class='control-entry']/a"));
	}
}