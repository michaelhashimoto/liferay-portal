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

package com.liferay.portalweb.socialofficehome.events.event.configureportletdisplaydays2;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEventEDDisplayDays1Test extends BaseTestCase {
	public void testViewEventEDDisplayDays1() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForText("xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]",
			"Events");
		assertEquals(RuntimeVariables.replace("Events"),
			selenium.getText(
				"xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]"));
		assertEquals(RuntimeVariables.replace("There are no more events today."),
			selenium.getText("//div[2]/div/div[2]/div/section/div/div/div"));
		assertTrue(selenium.isElementNotPresent("//h2[contains(.,'Events')]"));
		assertTrue(selenium.isElementNotPresent("//span[@class='event-name']/a"));
		assertFalse(selenium.isTextPresent("Calendar Event Title"));
	}
}