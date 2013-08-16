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

package com.liferay.portalweb.portlet.pollsdisplay.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.pollsdisplay.portlet.addportletmultiple.AddPortletMultipleTests;
import com.liferay.portalweb.portlet.pollsdisplay.portlet.addportletpd.AddPortletPDTests;
import com.liferay.portalweb.portlet.pollsdisplay.portlet.removeportlet.RemovePortletTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletMultipleTests.suite());
		testSuite.addTest(AddPortletPDTests.suite());
		testSuite.addTest(RemovePortletTests.suite());

		return testSuite;
	}

}