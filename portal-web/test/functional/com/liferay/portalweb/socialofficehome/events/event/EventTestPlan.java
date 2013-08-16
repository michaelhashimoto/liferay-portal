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

package com.liferay.portalweb.socialofficehome.events.event;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.events.event.configureportletdisplaydays2.ConfigurePortletDisplayDays2Tests;
import com.liferay.portalweb.socialofficehome.events.event.viewdeleteevented.ViewDeleteEventEDTests;
import com.liferay.portalweb.socialofficehome.events.event.viewdeleteeventsiteed.ViewDeleteEventSiteEDTests;
import com.liferay.portalweb.socialofficehome.events.event.viewevented.ViewEventEDTests;
import com.liferay.portalweb.socialofficehome.events.event.vieweventmultipleed.ViewEventMultipleEDTests;
import com.liferay.portalweb.socialofficehome.events.event.vieweventmultiplesiteed.ViewEventMultipleSiteEDTests;
import com.liferay.portalweb.socialofficehome.events.event.vieweventsiteed.ViewEventSiteEDTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EventTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ConfigurePortletDisplayDays2Tests.suite());
		testSuite.addTest(ViewDeleteEventEDTests.suite());
		testSuite.addTest(ViewDeleteEventSiteEDTests.suite());
		testSuite.addTest(ViewEventEDTests.suite());
		testSuite.addTest(ViewEventMultipleEDTests.suite());
		testSuite.addTest(ViewEventMultipleSiteEDTests.suite());
		testSuite.addTest(ViewEventSiteEDTests.suite());

		return testSuite;
	}

}