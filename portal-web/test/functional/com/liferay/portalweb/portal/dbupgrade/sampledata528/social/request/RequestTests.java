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

package com.liferay.portalweb.portal.dbupgrade.sampledata528.social.request;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RequestTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUserSRqTest.class);
		testSuite.addTestSuite(AddUserSRqPasswordTest.class);
		testSuite.addTestSuite(AddUserSRq2Test.class);
		testSuite.addTestSuite(AddUserSRq2PasswordTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SRq_SignInTest.class);
		testSuite.addTestSuite(SRq_AddPageSummaryTest.class);
		testSuite.addTestSuite(SRq_AddPortletSummaryTest.class);
		testSuite.addTestSuite(SRq_AddPageRequestsTest.class);
		testSuite.addTestSuite(SRq_AddPortletRequestsTest.class);
		testSuite.addTestSuite(SRq_AddPageFriendsTest.class);
		testSuite.addTestSuite(SRq_AddPortletFriendsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SRq2_SignInTest.class);
		testSuite.addTestSuite(SRq2_AddAsFriendTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SRq_SignInTest.class);
		testSuite.addTestSuite(SRq_ViewRequestsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);

		return testSuite;
	}
}