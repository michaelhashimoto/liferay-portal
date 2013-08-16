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

package com.liferay.portalweb.stagingsite.sites.event;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.stagingsite.sites.event.addeventrepeatdailysptl.AddEventRepeatDailySPTLTests;
import com.liferay.portalweb.stagingsite.sites.event.addeventrepeatmonthlysptl.AddEventRepeatMonthlySPTLTests;
import com.liferay.portalweb.stagingsite.sites.event.addeventrepeatneversptl.AddEventRepeatNeverSPTLTests;
import com.liferay.portalweb.stagingsite.sites.event.addeventrepeatweeklysptl.AddEventRepeatWeeklySPTLTests;
import com.liferay.portalweb.stagingsite.sites.event.addeventrepeatyearlysptl.AddEventRepeatYearlySPTLTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EventTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddEventRepeatDailySPTLTests.suite());
		testSuite.addTest(AddEventRepeatMonthlySPTLTests.suite());
		testSuite.addTest(AddEventRepeatNeverSPTLTests.suite());
		testSuite.addTest(AddEventRepeatWeeklySPTLTests.suite());
		testSuite.addTest(AddEventRepeatYearlySPTLTests.suite());

		return testSuite;
	}

}