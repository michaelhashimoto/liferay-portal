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

package com.liferay.portalweb.permissions.blogs.blogsentry.addblogsentry.siterole;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.roles.role.addregrole.TearDownRoleTest;
import com.liferay.portalweb.portal.controlpanel.roles.role.addsiterole.AddSiteRoleTest;
import com.liferay.portalweb.portal.controlpanel.roles.role.assignmemberssiteroleuser.AssignMembersSiteRoleUserTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addmemberssiteuser.AddMembersSiteUserTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUserPasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignInTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPageBlogsSiteTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPortletBlogsSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteRoleTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(EditUserPasswordTest.class);
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddPageBlogsSiteTest.class);
		testSuite.addTestSuite(AddPortletBlogsSiteTest.class);
		testSuite.addTestSuite(AddMembersSiteUserTest.class);
		testSuite.addTestSuite(AddSiteRoleTest.class);
		testSuite.addTestSuite(AssignMembersSiteRoleUserTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_AddBlogsEntryNoSiteTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(DefineSiteRoleContentBlogsAddEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_AddBlogsEntrySiteTest.class);
		testSuite.addTestSuite(User_ViewBlogsEntrySiteTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(ViewBlogsEntrySiteTest.class);
		testSuite.addTestSuite(RemoveSiteRoleContentBlogsAddEntryTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_AddBlogsEntryNoSiteTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownRoleTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}