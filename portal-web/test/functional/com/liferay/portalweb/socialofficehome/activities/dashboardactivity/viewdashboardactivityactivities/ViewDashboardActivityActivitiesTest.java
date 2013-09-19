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

package com.liferay.portalweb.socialofficehome.activities.dashboardactivity.viewdashboardactivityactivities;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDashboardActivityActivitiesTest extends BaseTestCase {
	public void testViewDashboardActivityActivities() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title']/span)[contains(.,'Activities')]"));
		assertEquals(RuntimeVariables.replace("Me"), selenium.getText("link=Me"));
		selenium.clickAt("link=Me", RuntimeVariables.replace("Me"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("xPath=(//div[@class='activity-user-name'])[1]");
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xPath=(//div[@class='activity-user-name'])[1]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-action'])[1]", "Microblogs Post"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("xPath=(//div[@class='activity-user-name'])[2]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-action'])[2]",
				"Social01 Office01 User01"));
	}
}