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

package com.liferay.portalweb.portlet.recentbloggers.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.recentbloggers.portlet.addportletrb.AddPortletRBTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.addportletrbduplicate.AddPortletRBDuplicateTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.configureportletrbdisplaystyleusername.ConfigurePortletRBDisplayStyleUserNameTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.configureportletrbdisplaystyleusernameandimage.ConfigurePortletRBDisplayStyleUserNameAndImageTests;
import com.liferay.portalweb.portlet.recentbloggers.portlet.removeportletrb.RemovePortletRBTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletRBTests.suite());
		testSuite.addTest(AddPortletRBDuplicateTests.suite());
		testSuite.addTest(ConfigurePortletRBDisplayStyleUserNameTests.suite());
		testSuite.addTest(
			ConfigurePortletRBDisplayStyleUserNameAndImageTests.suite());
		testSuite.addTest(RemovePortletRBTests.suite());

		return testSuite;
	}

}