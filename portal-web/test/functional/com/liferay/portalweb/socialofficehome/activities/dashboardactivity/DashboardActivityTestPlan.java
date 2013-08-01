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

package com.liferay.portalweb.socialofficehome.activities.dashboardactivity;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.activities.dashboardactivity.viewdashboardactivityactivities.ViewDashboardActivityActivitiesTests;
import com.liferay.portalweb.socialofficehome.activities.dashboardactivity.viewdmfolderdocumentactivities.ViewDMFolderDocumentActivitiesTests;
import com.liferay.portalweb.socialofficehome.activities.dashboardactivity.viewresolvetaskassignedtomeactivitiesme.ViewResolveTaskAssignedToMeActivitiesMeTests;
import com.liferay.portalweb.socialofficehome.activities.dashboardactivity.viewresolvetaskstaskactivitiesconnections.ViewResolveTasksTaskActivitiesConnectionsTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DashboardActivityTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewDashboardActivityActivitiesTests.suite());
		testSuite.addTest(ViewDMFolderDocumentActivitiesTests.suite());
		testSuite.addTest(ViewResolveTaskAssignedToMeActivitiesMeTests.suite());
		testSuite.addTest(
			ViewResolveTasksTaskActivitiesConnectionsTests.suite());

		return testSuite;
	}

}