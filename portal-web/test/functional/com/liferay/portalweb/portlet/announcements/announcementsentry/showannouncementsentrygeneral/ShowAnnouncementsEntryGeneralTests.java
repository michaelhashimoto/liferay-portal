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

package com.liferay.portalweb.portlet.announcements.announcementsentry.showannouncementsentrygeneral;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.announcements.portlet.addportletannouncements.AddPageAnnouncementsTest;
import com.liferay.portalweb.portlet.announcements.portlet.addportletannouncements.AddPortletAnnouncementsTest;
import com.liferay.portalweb.portlet.myaccount.timezone.selecttimezonepacificstandardtime.SelectTimeZonePacificStandardTimeTest;
import com.liferay.portalweb.portlet.myaccount.timezone.selecttimezonepacificstandardtime.TearDownTimeZoneTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ShowAnnouncementsEntryGeneralTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(SelectTimeZonePacificStandardTimeTest.class);
		testSuite.addTestSuite(AddPageAnnouncementsTest.class);
		testSuite.addTestSuite(AddPortletAnnouncementsTest.class);
		testSuite.addTestSuite(AddAnnouncementsEntryGeneralTest.class);
		testSuite.addTestSuite(MarkAsReadAnnouncementsEntryGeneralTest.class);
		testSuite.addTestSuite(ShowAnnouncementsEntryGeneralTest.class);
		testSuite.addTestSuite(TearDownAnnouncementsEntryTest.class);
		testSuite.addTestSuite(TearDownTimeZoneTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}