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

package com.liferay.portalweb.portlet.breadcrumb.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.breadcrumb.portlet.addportletbreadcrumb.AddPortletBreadcrumbTests;
import com.liferay.portalweb.portlet.breadcrumb.portlet.addportletchildpage.AddPortletChildPageTests;
import com.liferay.portalweb.portlet.breadcrumb.portlet.addportletmultiple.AddPortletMultipleTests;
import com.liferay.portalweb.portlet.breadcrumb.portlet.configureportletdisplaystyle1.ConfigurePortletDisplayStyle1Tests;
import com.liferay.portalweb.portlet.breadcrumb.portlet.configureportletdisplaystyle2.ConfigurePortletDisplayStyle2Tests;
import com.liferay.portalweb.portlet.breadcrumb.portlet.removeportlet.RemovePortletTests;
import com.liferay.portalweb.portlet.breadcrumb.portlet.viewportletbreadcrumb.ViewPortletBreadcrumbTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletBreadcrumbTests.suite());
		testSuite.addTest(AddPortletChildPageTests.suite());
		testSuite.addTest(AddPortletMultipleTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyle1Tests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyle2Tests.suite());
		testSuite.addTest(RemovePortletTests.suite());
		testSuite.addTest(ViewPortletBreadcrumbTests.suite());

		return testSuite;
	}

}