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

package com.liferay.portalweb.demo.useradmin.permissionssitelevel;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUser1Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUser2Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUser1PasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUser2PasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.editusersite.EditUser2SiteTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User1_SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User1_SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User2_SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User2_SignOutTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPageBlogsSiteTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPortletBlogsSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PermissionsSiteLevelTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUser1Test.class);
		testSuite.addTestSuite(EditUser1PasswordTest.class);
		testSuite.addTestSuite(AddUser2Test.class);
		testSuite.addTestSuite(EditUser2PasswordTest.class);
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddPageBlogsSiteTest.class);
		testSuite.addTestSuite(AddPortletBlogsSiteTest.class);
		testSuite.addTestSuite(AddBlogsEntrySiteTest.class);
		testSuite.addTestSuite(EditUser2SiteTest.class);
		testSuite.addTestSuite(EditSiteMemberRoleTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_AssertNotViewableBlogsAddEntryButtonTest.class);
		testSuite.addTestSuite(Guest_AssertNotViewableBlogsPermissionsButtonTest.class);
		testSuite.addTestSuite(User1_SignInTest.class);
		testSuite.addTestSuite(User1_AssertNotViewableBlogsAddEntryButtonTest.class);
		testSuite.addTestSuite(User1_AssertNotViewableBlogsPermissionsButtonTest.class);
		testSuite.addTestSuite(User1_SignOutTest.class);
		testSuite.addTestSuite(User2_SignInTest.class);
		testSuite.addTestSuite(User2_AssertViewableBlogsAddEntryButtonTest.class);
		testSuite.addTestSuite(User2_AssertViewableBlogsPermissionsButtonTest.class);
		testSuite.addTestSuite(User2_AddBlogsEntrySiteTest.class);
		testSuite.addTestSuite(User2_ViewSiteMemberRolePermissionTest.class);
		testSuite.addTestSuite(User2_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);
		testSuite.addTestSuite(TearDownPermissionsSiteMemberRoleTest.class);

		return testSuite;
	}
}