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

package com.liferay.portalweb.socialofficesite.home.events;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.home.events.sousviewcalendarevent2daysguestnoviewedsite.SOUs_ViewCalendarEvent2DaysGuestNoViewEDSiteTests;
import com.liferay.portalweb.socialofficesite.home.events.viewcalendareventsedsite.ViewCalendarEventsEDSiteTests;
import com.liferay.portalweb.socialofficesite.home.events.viewdeletecalendarfuture2dayseventedsite.ViewDeleteCalendarEventFuture2DaysEDSiteTests;
import com.liferay.portalweb.socialofficesite.home.events.vieweditcalendarfuture2dayseventedsite.ViewEditCalendarEventFuture2DaysEDSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EventsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(
			SOUs_ViewCalendarEvent2DaysGuestNoViewEDSiteTests.suite());
		testSuite.addTest(ViewCalendarEventsEDSiteTests.suite());
		testSuite.addTest(
			ViewDeleteCalendarEventFuture2DaysEDSiteTests.suite());
		testSuite.addTest(ViewEditCalendarEventFuture2DaysEDSiteTests.suite());

		return testSuite;
	}

}