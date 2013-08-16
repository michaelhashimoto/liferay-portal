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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcements.announcementsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAnnouncementsEntryTest extends BaseTestCase {
	public void testViewAnnouncementsEntry() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open(
			"/web/announcements-entry-community/announcements-entry-page");
		selenium.waitForVisible("link=Announcements Entry Page");
		selenium.clickAt("link=Announcements Entry Page",
			RuntimeVariables.replace("Announcements Entry Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Announcements Entry Name"),
			selenium.getText("//h3[@class='entry-title']/a"));
		assertTrue(selenium.isPartialText(
				"//div[contains(@class,'entry-content')]",
				"Announcements Entry Content"));
		selenium.clickAt("//h3[@class='entry-title']/a",
			RuntimeVariables.replace("Announcements Entry Name"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertTrue(selenium.isVisible("//img[@alt='Liferay']"));
	}
}