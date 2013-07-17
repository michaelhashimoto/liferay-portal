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

package com.liferay.portalweb.socialofficehome.events.event.vieweventmultipleed;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEventMultipleEDTest extends BaseTestCase {
	public void testViewEventMultipleED() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForText("xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]",
			"Events");
		assertEquals(RuntimeVariables.replace("Events"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]"));
		assertTrue(selenium.isPartialText("//h2[contains(.,'Events')]", "Events"));
		assertEquals(RuntimeVariables.replace("Calendar Event1 Title"),
			selenium.getText("xPath=(//span[@class='event-name']/a)[1]"));
		selenium.clickAt("xPath=(//span[@class='event-name']/a)[1]",
			RuntimeVariables.replace("Calendar Event1 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Calendar Event1 Title"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Calendar Event1 Description"),
			selenium.getText("//p[contains(.,'Calendar Event1 Description')]"));
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForText("xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]",
			"Events");
		assertEquals(RuntimeVariables.replace("Events"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]"));
		assertTrue(selenium.isPartialText("//h2[contains(.,'Events')]", "Events"));
		assertEquals(RuntimeVariables.replace("Calendar Event2 Title"),
			selenium.getText("xPath=(//span[@class='event-name']/a)[2]"));
		selenium.clickAt("xPath=(//span[@class='event-name']/a)[2]",
			RuntimeVariables.replace("Calendar Event2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Calendar Event2 Title"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Calendar Event2 Description"),
			selenium.getText("//p[contains(.,'Calendar Event2 Description')]"));
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForText("xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]",
			"Events");
		assertEquals(RuntimeVariables.replace("Events"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]"));
		assertTrue(selenium.isPartialText("//h2[contains(.,'Events')]", "Events"));
		assertEquals(RuntimeVariables.replace("Calendar Event3 Title"),
			selenium.getText("xPath=(//span[@class='event-name']/a)[3]"));
		selenium.clickAt("xPath=(//span[@class='event-name']/a)[3]",
			RuntimeVariables.replace("Calendar Event3 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Calendar Event3 Title"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Calendar Event3 Description"),
			selenium.getText("//p[contains(.,'Calendar Event3 Description')]"));
	}
}