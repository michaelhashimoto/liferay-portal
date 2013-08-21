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

package com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewWelcomePageTest extends BaseTestCase {
	public void testSOUs_ViewWelcomePage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//a[contains(.,'Dashboard')]"));
		selenium.clickAt("//a[contains(.,'Dashboard')]",
			RuntimeVariables.replace("Dashboard"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//a[@class='logo default-logo']"));
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("link=Dashboard"));
		assertEquals(RuntimeVariables.replace("Contacts Center"),
			selenium.getText("link=Contacts Center"));
		assertEquals(RuntimeVariables.replace("Microblogs"),
			selenium.getText("link=Microblogs"));
		assertEquals(RuntimeVariables.replace("Messages"),
			selenium.getText("link=Messages"));
		assertEquals(RuntimeVariables.replace("My Documents"),
			selenium.getText("link=My Documents"));
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText("link=Tasks"));
		assertEquals(RuntimeVariables.replace("Welcome"),
			selenium.getText("link=Welcome"));
		selenium.clickAt("link=Welcome", RuntimeVariables.replace("Welcome"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Language"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Language')]"));
		assertEquals(RuntimeVariables.replace("My Sites"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'My Sites')]"));
		assertEquals(RuntimeVariables.replace("Dictionary"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Dictionary')]"));
		assertEquals(RuntimeVariables.replace("Calendar"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Calendar')]"));
		assertEquals(RuntimeVariables.replace("Directory"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title'])[contains(.,'Directory')]"));
	}
}