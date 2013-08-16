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

package com.liferay.portalweb.socialofficehome.events.event.viewevented;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEventEDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageCalendarSOTest.class);
		testSuite.addTestSuite(AddPortletCalendarSOTest.class);
		testSuite.addTestSuite(AddEventSOTest.class);
		testSuite.addTestSuite(ViewEventEDTest.class);
		testSuite.addTestSuite(TearDownEventSOTest.class);
		testSuite.addTestSuite(TearDownPageCalendarSOTest.class);

		return testSuite;
	}
}