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

package com.liferay.portalweb.kaleo.assetpublisher.mbmessage;

import com.liferay.portalweb.kaleo.assetpublisher.mbmessage.viewmessageassignedtome.ViewMessageAssignedToMeTests;
import com.liferay.portalweb.kaleo.assetpublisher.mbmessage.viewmessageassignedtomyroles.ViewMessageAssignedToMyRolesTests;
import com.liferay.portalweb.kaleo.assetpublisher.mbmessage.viewmessagecompleted.ViewMessageCompletedTests;
import com.liferay.portalweb.kaleo.assetpublisher.mbmessage.viewmessagerejected.ViewMessageRejectedTests;
import com.liferay.portalweb.kaleo.assetpublisher.mbmessage.viewmessageresubmitted.ViewMessageResubmittedTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MBMessageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewMessageAssignedToMeTests.suite());
		testSuite.addTest(ViewMessageAssignedToMyRolesTests.suite());
		testSuite.addTest(ViewMessageCompletedTests.suite());
		testSuite.addTest(ViewMessageRejectedTests.suite());
		testSuite.addTest(ViewMessageResubmittedTests.suite());

		return testSuite;
	}

}