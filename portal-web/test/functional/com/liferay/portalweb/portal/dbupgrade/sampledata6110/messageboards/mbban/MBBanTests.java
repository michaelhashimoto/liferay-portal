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

package com.liferay.portalweb.portal.dbupgrade.sampledata6110.messageboards.mbban;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MBBanTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddCommunityMBBanTest.class);
		testSuite.addTestSuite(AddUserMBBanTest.class);
		testSuite.addTestSuite(AssignMembersCommunityUserActionTest.class);
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(AddMBCategoryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(MB_SignInTest.class);
		testSuite.addTestSuite(MB_AddMBCategoryThreadTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(BanThisUserTest.class);
		testSuite.addTestSuite(ViewBannedUsersUserTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(MB_SignInTest.class);
		testSuite.addTestSuite(MB_ViewMBPortletBanTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);

		return testSuite;
	}
}