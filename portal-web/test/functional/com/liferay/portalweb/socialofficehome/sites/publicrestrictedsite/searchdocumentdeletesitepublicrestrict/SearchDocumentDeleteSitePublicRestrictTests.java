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

package com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.searchdocumentdeletesitepublicrestrict;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.roles.role.addregrole.TearDownRoleTest;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.addsouser.TearDownSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUserPasswordTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SelectRegularRolesSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignOutSOTest;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.acceptmemberrequestsitepublicrestrict.AcceptMemberRequestSitePublicRestrictTest;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.acceptmemberrequestsitepublicrestrict.SOUs_SendMemberRequestSitePublicRestrictTest;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.addsitessitetypepublicrestricted.AddSitesSiteTypePublicRestrictedTest;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.deletesitetypepublicrestricted.DeleteSiteTypePublicRestrictedTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.TearDownSOSitesTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchDocumentDeleteSitePublicRestrictTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSOUserTest.class);
		testSuite.addTestSuite(SelectRegularRolesSOUserTest.class);
		testSuite.addTestSuite(EditSOUserPasswordTest.class);
		testSuite.addTestSuite(AddSiteRoleDocumentUploaderTest.class);
		testSuite.addTestSuite(DefinePermissionsDocumentUploaderTest.class);
		testSuite.addTestSuite(AddSitesSiteTypePublicRestrictedTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_SendMemberRequestSitePublicRestrictTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(AcceptMemberRequestSitePublicRestrictTest.class);
		testSuite.addTestSuite(SelectDocumentUploaderRoleSOUserTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_AddDMFolderSitePublicRestrictedTest.class);
		testSuite.addTestSuite(SOUs_AddFolderDocumentSitePublicRestrictTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(DeleteSiteTypePublicRestrictedTest.class);
		testSuite.addTestSuite(AddPageSearchSOTest.class);
		testSuite.addTestSuite(AddPortletSearchSOTest.class);
		testSuite.addTestSuite(SearchDocumentDeleteSitePublicRestrictTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);
		testSuite.addTestSuite(TearDownRoleTest.class);
		testSuite.addTestSuite(TearDownPageSearchSOTest.class);

		return testSuite;
	}
}