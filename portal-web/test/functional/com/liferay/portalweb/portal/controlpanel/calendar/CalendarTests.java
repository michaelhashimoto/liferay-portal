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

package com.liferay.portalweb.portal.controlpanel.calendar;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CalendarTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(SetTimezoneTest.class);
		testSuite.addTestSuite(AddAppointmentEventTest.class);
		testSuite.addTestSuite(AddConcertEventTest.class);
		testSuite.addTestSuite(AddVacationEventTest.class);
		testSuite.addTestSuite(GetAppointmentEventsTest.class);
		testSuite.addTestSuite(GetConcertEventsTest.class);
		testSuite.addTestSuite(GetVacationEventsTest.class);
		testSuite.addTestSuite(EditEventTest.class);
		testSuite.addTestSuite(AddTemporaryEventTest.class);
		testSuite.addTestSuite(DeleteTemporaryEventTest.class);
		testSuite.addTestSuite(AddNullTitleEventTest.class);
		testSuite.addTestSuite(AddInvalidStartDateEventTest.class);
		testSuite.addTestSuite(AddInvalidEndDateEventTest.class);
		testSuite.addTestSuite(AddInvalidDurationEventTest.class);
		testSuite.addTestSuite(AddInvalidRepeatEventTest.class);
		testSuite.addTestSuite(TearDownEventCPTest.class);
		testSuite.addTestSuite(ImportLARTest.class);
		testSuite.addTestSuite(AssertImportLARTest.class);
		testSuite.addTestSuite(TearDownEventCPTest.class);
		testSuite.addTestSuite(AddRepeatingEventTest.class);
		testSuite.addTestSuite(AddDailyRepeatingEventTest.class);
		testSuite.addTestSuite(AddWeeklyRepeatingEventTest.class);
		testSuite.addTestSuite(AddWeekDayRepeatingEventTest.class);
		testSuite.addTestSuite(AddMonthlyDateRepeatingEventTest.class);
		testSuite.addTestSuite(AddMonthlyDayRepeatingEventTest.class);
		testSuite.addTestSuite(AddYearlyDateRepeatingEventTest.class);
		testSuite.addTestSuite(AddYearlyDayRepeatingEventTest.class);
		testSuite.addTestSuite(TearDownEventCPTest.class);

		return testSuite;
	}
}