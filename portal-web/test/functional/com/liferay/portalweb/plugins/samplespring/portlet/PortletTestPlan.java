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

package com.liferay.portalweb.plugins.samplespring.portlet;

import com.liferay.portalweb.plugins.samplespring.portlet.addportletdu.AddPortletDUTests;
import com.liferay.portalweb.plugins.samplespring.portlet.addportletpets.AddPortletPetsTests;
import com.liferay.portalweb.plugins.samplespring.portlet.addportletpm.AddPortletPMTests;
import com.liferay.portalweb.plugins.samplespring.portlet.addportletps.AddPortletPSTests;
import com.liferay.portalweb.plugins.samplespring.portlet.addportletwelcome.AddPortletWelcomeTests;
import com.liferay.portalweb.plugins.samplespring.portlet.modifydateformatdaymonthdash.ModifyDateFormatDayMonthDashTests;
import com.liferay.portalweb.plugins.samplespring.portlet.modifydateformatdaymonthslash.ModifyDateFormatDayMonthSlashTests;
import com.liferay.portalweb.plugins.samplespring.portlet.modifydateformatmonthdaydash.ModifyDateFormatMonthDayDashTests;
import com.liferay.portalweb.plugins.samplespring.portlet.modifydateformatmonthdayslash.ModifyDateFormatMonthDaySlashTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletDUTests.suite());
		testSuite.addTest(AddPortletPetsTests.suite());
		testSuite.addTest(AddPortletPMTests.suite());
		testSuite.addTest(AddPortletPSTests.suite());
		testSuite.addTest(AddPortletWelcomeTests.suite());
		testSuite.addTest(ModifyDateFormatDayMonthDashTests.suite());
		testSuite.addTest(ModifyDateFormatDayMonthSlashTests.suite());
		testSuite.addTest(ModifyDateFormatMonthDayDashTests.suite());
		testSuite.addTest(ModifyDateFormatMonthDaySlashTests.suite());

		return testSuite;
	}

}