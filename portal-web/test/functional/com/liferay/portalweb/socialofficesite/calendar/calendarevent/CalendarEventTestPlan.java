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

package com.liferay.portalweb.socialofficesite.calendar.calendarevent;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventcommentsite.AddCalendarEventCommentSiteTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventduration3hourssite.AddCalendarEventDuration3HoursSiteTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventmultiplesite.AddCalendarEventMultipleSiteTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventsite.AddCalendarEventSiteTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventtagssite.AddCalendarEventTagsSiteTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.deletecalendareventsite.DeleteCalendarEventSiteTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.editcalendareventsite.EditCalendarEventSiteTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.editpermissionscalendarevent2guestnoview.EditPermissionsCalendarEvent2GuestNoViewTests;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.ratecalendareventsite.RateCalendarEventSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CalendarEventTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddCalendarEventCommentSiteTests.suite());
		testSuite.addTest(AddCalendarEventDuration3HoursSiteTests.suite());
		testSuite.addTest(AddCalendarEventMultipleSiteTests.suite());
		testSuite.addTest(AddCalendarEventSiteTests.suite());
		testSuite.addTest(AddCalendarEventTagsSiteTests.suite());
		testSuite.addTest(DeleteCalendarEventSiteTests.suite());
		testSuite.addTest(EditCalendarEventSiteTests.suite());
		testSuite.addTest(
			EditPermissionsCalendarEvent2GuestNoViewTests.suite());
		testSuite.addTest(RateCalendarEventSiteTests.suite());

		return testSuite;
	}

}