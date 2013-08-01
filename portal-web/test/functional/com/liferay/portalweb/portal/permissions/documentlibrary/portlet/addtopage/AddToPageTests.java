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

package com.liferay.portalweb.portal.permissions.documentlibrary.portlet.addtopage;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.AddMemberRoleTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.AddMemberTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.AssignUserRolesTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.LoginUsersTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.Member_LoginTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.RemoveRolePowerUserTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.TearDownRolesTest;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.TearDownUserTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddToPageTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddMemberTest.class);
		testSuite.addTestSuite(AddMemberRoleTest.class);
		testSuite.addTestSuite(DefineMemberRoleTest.class);
		testSuite.addTestSuite(RemoveRolePowerUserTest.class);
		testSuite.addTestSuite(AssignUserRolesTest.class);
		testSuite.addTestSuite(AddPageDLTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(LoginUsersTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AssertCannotAddToPageTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(ConfigureServerAdminCleanPermissionsTest.class);
		testSuite.addTestSuite(AddPermissionSitePageUpdateTest.class);
		testSuite.addTestSuite(AddPermissionAddToPageTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Member_LoginTest.class);
		testSuite.addTestSuite(Member_AddPortletDLTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownRolesTest.class);

		return testSuite;
	}
}