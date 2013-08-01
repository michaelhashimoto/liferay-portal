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

package com.liferay.portalweb.portlet.pagecomments.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.pagecomments.portlet.addportletduplicate.AddPortletDuplicateTests;
import com.liferay.portalweb.portlet.pagecomments.portlet.addportletpc.AddPortletPCTests;
import com.liferay.portalweb.portlet.pagecomments.portlet.editportletname.EditPortletNameTests;
import com.liferay.portalweb.portlet.pagecomments.portlet.removeportlet.RemovePortletTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletDuplicateTests.suite());
		testSuite.addTest(AddPortletPCTests.suite());
		testSuite.addTest(EditPortletNameTests.suite());
		testSuite.addTest(RemovePortletTests.suite());

		return testSuite;
	}

}