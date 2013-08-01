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

package com.liferay.portalweb.demo.useradmin.permissionssitetemplate;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUserPasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.AddBlogsEntryTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.TearDownBlogsEntryTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPageBlogsTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogsTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPageBlogsSiteTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPortletBlogsSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PermissionsSiteTemplateTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(AddBlogsEntryTest.class);
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddPageBlogsSiteTest.class);
		testSuite.addTestSuite(AddPortletBlogsSiteTest.class);
		testSuite.addTestSuite(AddBlogsEntrySiteTest.class);
		testSuite.addTestSuite(AddRegularRoleTest.class);
		testSuite.addTestSuite(DefineScopedRegularRolePermissionsTest.class);
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(EditUserPasswordTest.class);
		testSuite.addTestSuite(AssignUserScopedRegularRoleTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_ViewCannotDeleteEntryTest.class);
		testSuite.addTestSuite(User_ViewCanDeleteEntrySiteTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownRoleTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}