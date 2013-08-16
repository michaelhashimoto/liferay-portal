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

package com.liferay.portalweb.properties.calendar.eventratings.viewcalendareventratingsno;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCalendarEventRatingsNoTest extends BaseTestCase {
	public void testViewCalendarEventRatingsNo() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Calendar Test Page",
			RuntimeVariables.replace("Calendar Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Event"),
			selenium.getText(
				"//table[contains(@data-searchcontainerid,'SearchContainer')]/tbody/tr[3]/td[2]/a"));
		selenium.clickAt("//table[contains(@data-searchcontainerid,'SearchContainer')]/tbody/tr[3]/td[2]/a",
			RuntimeVariables.replace("Test Event"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Your Rating"));
		assertFalse(selenium.isTextPresent("Average (0 Votes)"));
	}
}