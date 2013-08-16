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

package com.liferay.portalweb.socialofficehome.privatemessaging.message.sous2deletepmmessage;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUser1Test;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUser2Test;
import com.liferay.portalweb.socialoffice.users.user.addsouser.TearDownSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUser1PasswordTest;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUser2PasswordTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SelectRegularRolesSOUser1Test;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SelectRegularRolesSOUser2Test;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs1_SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs1_SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs2_SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs2_SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignOutSOTest;
import com.liferay.portalweb.socialofficehome.privatemessaging.message.addpmmessage.TearDownPMMessageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs2_DeletePMMessageTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSOUser1Test.class);
		testSuite.addTestSuite(SelectRegularRolesSOUser1Test.class);
		testSuite.addTestSuite(EditSOUser1PasswordTest.class);
		testSuite.addTestSuite(AddSOUser2Test.class);
		testSuite.addTestSuite(SelectRegularRolesSOUser2Test.class);
		testSuite.addTestSuite(EditSOUser2PasswordTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs1_SignInSOTest.class);
		testSuite.addTestSuite(SOUs1_AddAsConnectionCCSOUser2Test.class);
		testSuite.addTestSuite(SOUs1_SignOutSOTest.class);
		testSuite.addTestSuite(SOUs2_SignInSOTest.class);
		testSuite.addTestSuite(SOUs2_ConfirmNotificationsAddConnectionTest.class);
		testSuite.addTestSuite(SOUs2_SignOutSOTest.class);
		testSuite.addTestSuite(SOUs1_SignInSOTest.class);
		testSuite.addTestSuite(SOUs1_AddPMMessageTest.class);
		testSuite.addTestSuite(SOUs1_SignOutSOTest.class);
		testSuite.addTestSuite(SOUs2_SignInSOTest.class);
		testSuite.addTestSuite(SOUs2_ViewPMMessageTest.class);
		testSuite.addTestSuite(SOUs2_DeletePMMessageTest.class);
		testSuite.addTestSuite(SOUs2_ViewDeletePMMessageTest.class);
		testSuite.addTestSuite(SOUs2_SignOutSOTest.class);
		testSuite.addTestSuite(SOUs1_SignInSOTest.class);
		testSuite.addTestSuite(SOUs1_ViewDeletePMMessageTest.class);
		testSuite.addTestSuite(SOUs1_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(TearDownPMMessageTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);

		return testSuite;
	}
}