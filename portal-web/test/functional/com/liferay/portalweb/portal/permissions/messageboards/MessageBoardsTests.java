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

package com.liferay.portalweb.portal.permissions.messageboards;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmbsite.AddPageMBSiteTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmbsite.AddPortletMBSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageBoardsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(SA_AddMATest.class);
		testSuite.addTestSuite(SA_AddMARoleTest.class);
		testSuite.addTestSuite(SA_DefineMARoleTest.class);
		testSuite.addTestSuite(SA_AddMemberTest.class);
		testSuite.addTestSuite(SA_AddMemberRoleTest.class);
		testSuite.addTestSuite(SA_DefineMemberRoleTest.class);
		testSuite.addTestSuite(SA_AssignUserRolesTest.class);
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddPageMBSiteTest.class);
		testSuite.addTestSuite(AddPortletMBSiteTest.class);
		testSuite.addTestSuite(SA_AddSiteMembersTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(LoginUsersTest.class);
		testSuite.addTestSuite(MA_LoginTest.class);
		testSuite.addTestSuite(MA_AddCategoryTest.class);
		testSuite.addTestSuite(MA_AddThreadTest.class);
		testSuite.addTestSuite(MA_AssertActionsTest.class);
		testSuite.addTestSuite(MA_DeleteMessageTest.class);
		testSuite.addTestSuite(MA_DeleteCategoryTest.class);
		testSuite.addTestSuite(MA_AddCategoryTest.class);
		testSuite.addTestSuite(MA_AddThreadTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertActionsTest.class);
		testSuite.addTestSuite(Member_ViewMessageTest.class);
		testSuite.addTestSuite(Member_ReplyMessageTest.class);
		testSuite.addTestSuite(Member_AddThreadTest.class);
		testSuite.addTestSuite(Member_EditThreadTest.class);
		testSuite.addTestSuite(Member_DeleteMessageTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewTest.class);
		testSuite.addTestSuite(Guest_AssertActionsTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownRoleTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}