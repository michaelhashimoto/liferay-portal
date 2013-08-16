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

package com.liferay.portalweb.socialoffice.users.user;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUserTests;
import com.liferay.portalweb.socialoffice.users.user.assignsorolesousersoconfiguration.AssignSORoleSOUserSOConfigurationTests;
import com.liferay.portalweb.socialoffice.users.user.configuredefaultrolesouser.ConfigureDefaultRoleSOUserTests;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUserPasswordTests;
import com.liferay.portalweb.socialoffice.users.user.removeregularrolessouser.RemoveRegularRolesSOUserTests;
import com.liferay.portalweb.socialoffice.users.user.removeregularrolessouserroles.RemoveRegularRolesSOUserRolesTests;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SelectRegularRolesSOUserTests;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouserroles.SelectRegularRolesSOUserRolesTests;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignInSOTests;
import com.liferay.portalweb.socialoffice.users.user.viewfootertext.ViewFooterTextTests;
import com.liferay.portalweb.socialoffice.users.user.viewsiterolesouser.ViewSiteRoleSOUserTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UserTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSOUserTests.suite());
		testSuite.addTest(AssignSORoleSOUserSOConfigurationTests.suite());
		testSuite.addTest(ConfigureDefaultRoleSOUserTests.suite());
		testSuite.addTest(EditSOUserPasswordTests.suite());
		testSuite.addTest(RemoveRegularRolesSOUserTests.suite());
		testSuite.addTest(RemoveRegularRolesSOUserRolesTests.suite());
		testSuite.addTest(SelectRegularRolesSOUserTests.suite());
		testSuite.addTest(SelectRegularRolesSOUserRolesTests.suite());
		testSuite.addTest(SignInSOTests.suite());
		testSuite.addTest(ViewFooterTextTests.suite());
		testSuite.addTest(ViewSiteRoleSOUserTests.suite());

		return testSuite;
	}

}