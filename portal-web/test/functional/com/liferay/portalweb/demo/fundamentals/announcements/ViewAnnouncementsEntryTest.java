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
public class ViewAnnouncementsEntryTest extends BaseTestCase {
	public void testViewAnnouncementsEntry() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//h3[@class='entry-title']",
				"Announcements Entry Title"));
		assertEquals(RuntimeVariables.replace("Entries"),
			selenium.getText(
				"//li[contains(@class,'aui-state-active')]/span/a[contains(.,'Entries')]"));
		assertEquals(RuntimeVariables.replace("Manage Entries"),
			selenium.getText(
				"//li[contains(@class,'aui-state-default')]/span/a[contains(.,'Manage Entries')]"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//td[@class='edit-entry']/span/a"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//td[@class='delete-entry']/span/a"));
		assertEquals(RuntimeVariables.replace("Mark as Read"),
			selenium.getText("//td[@class='control-entry']/a"));
		assertEquals(RuntimeVariables.replace("General"),
			selenium.getText("//span[@class='entry-scope']"));
		assertEquals(RuntimeVariables.replace("Announcements Entry Content"),
			selenium.getText(
				"//div[@class=' entry-content entry-type-general']/p"));
	}
}