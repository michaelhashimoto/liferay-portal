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

package com.liferay.portalweb.socialofficesite.home.events.viewcalendareventsedsite;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.addsouser.TearDownSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUserPasswordTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SelectRegularRolesSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignOutSOTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.AddSitesSiteTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.TearDownSOSitesTest;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventsite.AddCalendarEventFuture1DaysSiteTest;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventsite.AddCalendarEventFuture2DaysSiteTest;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventsite.AddCalendarEventFuture3DaysSiteTest;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventsite.AddCalendarEventFuture4DaysSiteTest;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventsite.AddCalendarEventSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCalendarEventsEDSiteTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSOUserTest.class);
		testSuite.addTestSuite(SelectRegularRolesSOUserTest.class);
		testSuite.addTestSuite(EditSOUserPasswordTest.class);
		testSuite.addTestSuite(AddSitesSiteTest.class);
		testSuite.addTestSuite(AddCalendarEventSiteTest.class);
		testSuite.addTestSuite(AddCalendarEventFuture1DaysSiteTest.class);
		testSuite.addTestSuite(AddCalendarEventFuture2DaysSiteTest.class);
		testSuite.addTestSuite(AddCalendarEventFuture3DaysSiteTest.class);
		testSuite.addTestSuite(AddCalendarEventFuture4DaysSiteTest.class);
		testSuite.addTestSuite(ViewCalendarEventEDSiteTest.class);
		testSuite.addTestSuite(ConfigureDisplayDays2EDSiteTest.class);
		testSuite.addTestSuite(ViewCalendarEventDays2EDSiteTest.class);
		testSuite.addTestSuite(ConfigureDisplayDays3EDSiteTest.class);
		testSuite.addTestSuite(ViewCalendarEventDays3EDSiteTest.class);
		testSuite.addTestSuite(ConfigureDisplayDays4EDSiteTest.class);
		testSuite.addTestSuite(ViewCalendarEventDays4EDSiteTest.class);
		testSuite.addTestSuite(ConfigureDisplayDays5EDSiteTest.class);
		testSuite.addTestSuite(ViewCalendarEventDays5EDSiteTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewCalendarEventDays5EDSiteTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);

		return testSuite;
	}
}