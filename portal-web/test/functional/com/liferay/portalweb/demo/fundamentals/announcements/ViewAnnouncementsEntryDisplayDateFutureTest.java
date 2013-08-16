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

package com.liferay.portalweb.demo.fundamentals.announcements;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAnnouncementsEntryDisplayDateFutureTest extends BaseTestCase {
	public void testViewAnnouncementsEntryDisplayDateFuture()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Announcements Entry Future Title"));
		assertFalse(selenium.isTextPresent("Announcements Entry Future Content"));
		selenium.open("/web/guest/home/");
		Thread.sleep(60000);
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//h3[@class='entry-title']",
				"Announcements Entry Future Title"));
		assertEquals(RuntimeVariables.replace(
				"Announcements Entry Future Content"),
			selenium.getText(
				"//div[@class=' entry-content entry-type-general']/p"));
	}
}