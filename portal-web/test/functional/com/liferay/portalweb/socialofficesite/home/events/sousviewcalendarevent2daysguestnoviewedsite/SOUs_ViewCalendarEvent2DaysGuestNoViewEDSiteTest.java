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

package com.liferay.portalweb.socialofficesite.home.events.sousviewcalendarevent2daysguestnoviewedsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewCalendarEvent2DaysGuestNoViewEDSiteTest
	extends BaseTestCase {
	public void testSOUs_ViewCalendarEvent2DaysGuestNoViewEDSite()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
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
		assertEquals(RuntimeVariables.replace("Events"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]"));
		assertTrue(selenium.isPartialText("//h2[contains(.,'Events')]", "Events"));
		assertEquals(RuntimeVariables.replace("Today's Events"),
			selenium.getText(
				"//section[contains(@id,'eventsdisplayportlet')]/div/div/div/h2[1]"));
		assertEquals(RuntimeVariables.replace("Upcoming Events"),
			selenium.getText(
				"//section[contains(@id,'eventsdisplayportlet')]/div/div/div/h2[2]"));
		assertEquals(RuntimeVariables.replace("Calendar Event Title"),
			selenium.getText("xPath=(//span[@class='event-name']/a)[1]"));
		assertEquals(RuntimeVariables.replace(
				"Calendar Future Day1 Event Title"),
			selenium.getText("xPath=(//span[@class='event-name']/a)[2]"));
		assertEquals(RuntimeVariables.replace(
				"Calendar Future Day3 Event Title"),
			selenium.getText("xPath=(//span[@class='event-name']/a)[3]"));
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//span[@class='event-name']/a)[4]"));
		assertFalse(selenium.isTextPresent("Calendar Future Day2 Event Title"));
	}
}