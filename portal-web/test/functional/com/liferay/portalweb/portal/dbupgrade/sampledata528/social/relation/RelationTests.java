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

package com.liferay.portalweb.portal.dbupgrade.sampledata528.social.relation;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RelationTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUserSRlTest.class);
		testSuite.addTestSuite(AddUserSRlPasswordTest.class);
		testSuite.addTestSuite(AddUserSRl2Test.class);
		testSuite.addTestSuite(AddUserSRl2PasswordTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SRl_SignInTest.class);
		testSuite.addTestSuite(SRl_AddPageSummaryTest.class);
		testSuite.addTestSuite(SRl_AddPortletSummaryTest.class);
		testSuite.addTestSuite(SRl_AddPageRequestsTest.class);
		testSuite.addTestSuite(SRl_AddPortletRequestsTest.class);
		testSuite.addTestSuite(SRl_AddPageFriendsTest.class);
		testSuite.addTestSuite(SRl_AddPortletFriendsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SRl2_SignInTest.class);
		testSuite.addTestSuite(SRl2_AddAsFriendTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SRl_SignInTest.class);
		testSuite.addTestSuite(SRl_ConfirmFriendRequestTest.class);
		testSuite.addTestSuite(SRl_ViewFriendsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);

		return testSuite;
	}
}