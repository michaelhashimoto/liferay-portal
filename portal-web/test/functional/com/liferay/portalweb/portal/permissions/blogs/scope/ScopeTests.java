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

package com.liferay.portalweb.portal.permissions.blogs.scope;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
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
public class ScopeTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(SA_AddUserScopeTest.class);
		testSuite.addTestSuite(SA_AddScopeRoleTest.class);
		testSuite.addTestSuite(SA_DefineScopeRoleTest.class);
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(SA_AddScopeSitePageTest.class);
		testSuite.addTestSuite(SA_AddPortletScopeSiteTest.class);
		testSuite.addTestSuite(SA_AssignScopeMemberToScopeSiteTest.class);
		testSuite.addTestSuite(SA_AssignUserRolesTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(LoginUsersTest.class);
		testSuite.addTestSuite(Scope_LoginTest.class);
		testSuite.addTestSuite(Scope_AddGuestSiteScopeEntryTest.class);
		testSuite.addTestSuite(Scope_AddScopeSiteScopeEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(SA_LimitScopePermissionsScopeSiteTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Scope_LoginTest.class);
		testSuite.addTestSuite(Scope_AssertCannotAddSiteScopeEntryTest.class);
		testSuite.addTestSuite(Scope_AddScopeSiteScopeEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryTest.class);
		testSuite.addTestSuite(TearDownBlogsRolesTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}