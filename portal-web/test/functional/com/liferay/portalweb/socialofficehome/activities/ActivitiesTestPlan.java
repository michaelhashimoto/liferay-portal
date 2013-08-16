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

package com.liferay.portalweb.socialofficehome.activities;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.activities.activitiesblockedsouser.ActivitiesBlockedSOUserTestPlan;
import com.liferay.portalweb.socialofficehome.activities.activitiesprofileimage.ActivitiesProfileImageTestPlan;
import com.liferay.portalweb.socialofficehome.activities.activitiessites.ActivitiesSitesTestPlan;
import com.liferay.portalweb.socialofficehome.activities.dashboardactivity.DashboardActivityTestPlan;
import com.liferay.portalweb.socialofficehome.activities.mbentryactivity.MBEntryActivityTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ActivitiesTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ActivitiesBlockedSOUserTestPlan.suite());
		testSuite.addTest(ActivitiesProfileImageTestPlan.suite());
		testSuite.addTest(ActivitiesSitesTestPlan.suite());
		testSuite.addTest(DashboardActivityTestPlan.suite());
		testSuite.addTest(MBEntryActivityTestPlan.suite());

		return testSuite;
	}

}