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

package com.liferay.portalweb.socialofficehome.activities.dashboardactivity.viewresolvetaskstaskactivitiesconnections;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewResolveTasksTaskActivitiesConnectionsTest extends BaseTestCase {
	public void testViewResolveTasksTaskActivitiesConnections()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"xPath=(//h1[@class='portlet-title']/span)[contains(.,'Activities')]"));
		assertEquals(RuntimeVariables.replace("Connections"),
			selenium.getText("link=Connections"));
		selenium.clickAt("link=Connections",
			RuntimeVariables.replace("Connections"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 resolved a task."),
			selenium.getText("xPath=(//div[@class='activity-title'])[1]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='activity-body'])[1]", "Task Description"));
	}
}