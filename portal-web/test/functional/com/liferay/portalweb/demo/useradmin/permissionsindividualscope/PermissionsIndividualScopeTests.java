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

package com.liferay.portalweb.demo.useradmin.permissionsindividualscope;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addmemberssiteguestuser.AddMembersSiteGuestUser2Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUser1Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUser2Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUser1PasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUser2PasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User1_SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User1_SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User2_SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User2_SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPageDMTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPortletDMTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PermissionsIndividualScopeTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUser1Test.class);
		testSuite.addTestSuite(EditUser1PasswordTest.class);
		testSuite.addTestSuite(AddUser2Test.class);
		testSuite.addTestSuite(EditUser2PasswordTest.class);
		testSuite.addTestSuite(AddMembersSiteGuestUser2Test.class);
		testSuite.addTestSuite(AddPageDMTest.class);
		testSuite.addTestSuite(AddPortletDMTest.class);
		testSuite.addTestSuite(AddFolder1Test.class);
		testSuite.addTestSuite(AddFolder1Image1Test.class);
		testSuite.addTestSuite(AddFolder2Test.class);
		testSuite.addTestSuite(ConfigureViewPermissionFolder2Test.class);
		testSuite.addTestSuite(AddFolder2Image2Test.class);
		testSuite.addTestSuite(AddFolder2Image3ViewableBySiteMemberTest.class);
		testSuite.addTestSuite(AddFolder2SubfolderViewableByOwnerTest.class);
		testSuite.addTestSuite(AddFolder2SubfolderImage4ViewableBySiteMemberTest.class);
		testSuite.addTestSuite(SearchFolderImageTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_AssertNotViewableFolder2Test.class);
		testSuite.addTestSuite(Guest_SearchFolderImageTest.class);
		testSuite.addTestSuite(User1_SignInTest.class);
		testSuite.addTestSuite(User1_AssertNotViewableFolder2Image3Test.class);
		testSuite.addTestSuite(User1_SearchFolderImageTest.class);
		testSuite.addTestSuite(User1_SignOutTest.class);
		testSuite.addTestSuite(User2_SignInTest.class);
		testSuite.addTestSuite(User2_AssertViewableFolder2Image3Test.class);
		testSuite.addTestSuite(User2_AssertNotViewableFolder2SubfolderTest.class);
		testSuite.addTestSuite(User2_SearchFolderImageTest.class);
		testSuite.addTestSuite(User2_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownDLDocumentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);

		return testSuite;
	}
}