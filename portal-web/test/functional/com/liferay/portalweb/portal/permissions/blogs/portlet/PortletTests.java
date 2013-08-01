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

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.TearDownBlogsEntryTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPageBlogsTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogsTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(SA_AddPortletMemberTest.class);
		testSuite.addTestSuite(SA_AddPortletRoleTest.class);
		testSuite.addTestSuite(SA_AssignUserRolesTest.class);
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(SA_RemoveViewPortletPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(LoginUsersTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotViewPortletTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowViewPortletPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertViewPortletTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RegInlineBlogsConfigurationNotCheckedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotConfigurePortletTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowConfigurePortletPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertConfigurePortletTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemoveConfigurePortletPermissionsTest.class);
		testSuite.addTestSuite(SA_RegInlineBlogsAddEntryNotCheckedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotAddEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowAddEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AddEntryTest.class);
		testSuite.addTestSuite(Portlet_DeleteOwnEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemoveAddEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_AddTemporaryEntryTest.class);
		testSuite.addTestSuite(SA_RemoveViewEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotViewEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowViewEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertViewEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemoveAddCommentPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotAddCommentTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowAddCommentPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AddCommentTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemoveAddCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_RegInlineBlogsEditCommentNotCheckedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotEditCommentTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowEditCommentPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_EditCommentTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemoveEditCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_RegInlineBlogsDeleteCommentNotCheckedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotDeleteCommentTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowDeleteCommentPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_DeleteCommentTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemoveDeleteCommentPermissionsTest.class);
		testSuite.addTestSuite(SA_RegInlineBlogsEntryPermissionsNotCheckedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotEditEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowPermissionsEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertEditEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemovePermissionsEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_RegInlineBlogsEditEntryNotCheckedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotEditEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowEditEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_EditEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_RemoveEditEntryPermissionsTest.class);
		testSuite.addTestSuite(SA_RegInlineBlogsDeleteEntryNotCheckedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_AssertCannotDeleteEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_AllowDeleteEntryPermissionsTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Portlet_LoginTest.class);
		testSuite.addTestSuite(Portlet_DeleteEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryTest.class);
		testSuite.addTestSuite(TearDownBlogsRolesTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}