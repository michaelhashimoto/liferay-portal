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

package com.liferay.portalweb.socialoffice.users.sites.assignrolesosites;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialoffice.users.sites.assignmembersousersites.AddSiteTest;
import com.liferay.portalweb.socialoffice.users.sites.assignmembersousersites.AssignMemberSOUserSitesTest;
import com.liferay.portalweb.socialoffice.users.sites.assignmembersousersites.TearDownSiteTest;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.addsouser.TearDownSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUserPasswordTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.usergroups.assignrolesousergroup.SOUs_ViewSODashboardNoTest;
import com.liferay.portalweb.socialoffice.users.usergroups.assignrolesousergroup.SOUs_ViewSODashboardTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignRoleSOSitesTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSOUserTest.class);
		testSuite.addTestSuite(EditSOUserPasswordTest.class);
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AssignRoleSOSitesTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewSODashboardNoTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(AssignMemberSOUserSitesTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewSODashboardTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(RemoveRoleSOSitesTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewSODashboardNoTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(AssignRoleSOSitesTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewSODashboardTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);

		return testSuite;
	}
}