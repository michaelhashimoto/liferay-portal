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

package com.liferay.portalweb.socialoffice.users.user.removeregularrolessouserroles;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.addsouser.TearDownSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUserPasswordTest;
import com.liferay.portalweb.socialoffice.users.user.removeregularrolessouser.SOUs_ViewMyPrivatePagesNoSORoleTest;
import com.liferay.portalweb.socialoffice.users.user.removeregularrolessouser.SOUs_ViewMyPublicPagesNoSORoleTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SOUs_ViewMyProfileTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SOUs_ViewSitesDirectoryTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SOUs_ViewWelcomePageTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouserroles.SelectRegularRolesSOUserRolesTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignOutSOTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RemoveRegularRolesSOUserRolesTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSOUserTest.class);
		testSuite.addTestSuite(EditSOUserPasswordTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewMyPublicPagesNoSORoleTest.class);
		testSuite.addTestSuite(SOUs_ViewMyPrivatePagesNoSORoleTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(SelectRegularRolesSOUserRolesTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewWelcomePageTest.class);
		testSuite.addTestSuite(SOUs_ViewSitesDirectoryTest.class);
		testSuite.addTestSuite(SOUs_ViewMyProfileTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(RemoveRegularRolesSOUserRolesTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_ViewMyPublicPagesNoSORoleTest.class);
		testSuite.addTestSuite(SOUs_ViewMyPrivatePagesNoSORoleTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);

		return testSuite;
	}
}