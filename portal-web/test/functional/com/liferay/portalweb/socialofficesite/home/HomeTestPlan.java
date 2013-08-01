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

package com.liferay.portalweb.socialofficesite.home;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.home.activities.ActivitiesTestPlan;
import com.liferay.portalweb.socialofficesite.home.announcement.AnnouncementTestPlan;
import com.liferay.portalweb.socialofficesite.home.bookmarks.BookmarksTestPlan;
import com.liferay.portalweb.socialofficesite.home.events.EventsTestPlan;
import com.liferay.portalweb.socialofficesite.home.homelar.HomeLARTestPlan;
import com.liferay.portalweb.socialofficesite.home.rss.RSSTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class HomeTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ActivitiesTestPlan.suite());
		testSuite.addTest(AnnouncementTestPlan.suite());
		testSuite.addTest(BookmarksTestPlan.suite());
		testSuite.addTest(EventsTestPlan.suite());
		testSuite.addTest(HomeLARTestPlan.suite());
		testSuite.addTest(RSSTestPlan.suite());

		return testSuite;
	}

}