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
public class SOUs2_ViewActivitiesFollowingNoneTest extends BaseTestCase {
	public void testSOUs2_ViewActivitiesFollowingNone()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice02/so/dashboard");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title']/span)[contains(.,'Activities')]"));
		assertEquals(RuntimeVariables.replace("Following"),
			selenium.getText("link=Following"));
		selenium.clickAt("link=Following", RuntimeVariables.replace("Following"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("There are no recent activities."),
			selenium.getText("xPath=(//div[@class='portlet-msg-info'])[2]"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='activity-title']"));
		assertTrue(selenium.isElementNotPresent("//div[@class='activity-body']"));
		assertFalse(selenium.isTextPresent(
				"Joe Bloggs added a new task for Social01 Office01 User01."));
		assertFalse(selenium.isTextPresent("Joe Bloggs added a new task."));
		assertFalse(selenium.isTextPresent(
				"Joe Bloggs uploaded a new document, DM Folder Document Title, in Joe Bloggs."));
		assertFalse(selenium.isTextPresent("#Microblogs Post"));
		assertFalse(selenium.isTextPresent("[@socialoffice01]"));
	}
}