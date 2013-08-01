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

package com.liferay.portalweb.kaleo.messageboards.mbthreadmessage;

import com.liferay.portalweb.kaleo.messageboards.mbthreadmessage.viewmbthreadmessageassignedtome.ViewMBThreadMessageAssignedToMeTests;
import com.liferay.portalweb.kaleo.messageboards.mbthreadmessage.viewmbthreadmessageassignedtomyroles.ViewMBThreadMessageAssignedToMyRolesTests;
import com.liferay.portalweb.kaleo.messageboards.mbthreadmessage.viewmbthreadmessagecompleted.ViewMBThreadMessageCompletedTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MBThreadMessageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewMBThreadMessageAssignedToMeTests.suite());
		testSuite.addTest(ViewMBThreadMessageAssignedToMyRolesTests.suite());
		testSuite.addTest(ViewMBThreadMessageCompletedTests.suite());

		return testSuite;
	}

}