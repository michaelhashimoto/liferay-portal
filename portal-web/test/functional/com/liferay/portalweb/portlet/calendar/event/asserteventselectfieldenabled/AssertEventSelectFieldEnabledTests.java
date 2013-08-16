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

package com.liferay.portalweb.portlet.calendar.event.asserteventselectfieldenabled;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.calendar.event.addevent.TearDownEventTest;
import com.liferay.portalweb.portlet.calendar.portlet.addportletcalendar.AddPageCalendarTest;
import com.liferay.portalweb.portlet.calendar.portlet.addportletcalendar.AddPortletCalendarTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertEventSelectFieldEnabledTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageCalendarTest.class);
		testSuite.addTestSuite(AddPortletCalendarTest.class);
		testSuite.addTestSuite(AssertEventSelectFieldEnabledTest.class);
		testSuite.addTestSuite(TearDownEventTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}