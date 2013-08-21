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

package com.liferay.portalweb.socialofficesite.documents.dmdocument.viewdmdocumentlatestversionsite;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialoffice.users.user.addsouser.AddSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.addsouser.TearDownSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.editsouserpassword.EditSOUserPasswordTest;
import com.liferay.portalweb.socialoffice.users.user.selectregularrolessouser.SelectRegularRolesSOUserTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SOUs_SignOutSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignInSOTest;
import com.liferay.portalweb.socialoffice.users.user.signinso.SignOutSOTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.AddSitesSiteTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.TearDownSOSitesTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMDocumentLatestVersionSiteTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSOUserTest.class);
		testSuite.addTestSuite(SelectRegularRolesSOUserTest.class);
		testSuite.addTestSuite(EditSOUserPasswordTest.class);
		testSuite.addTestSuite(AddSitesSiteTest.class);
		testSuite.addTestSuite(AddSiteRoleDocumentEditorTest.class);
		testSuite.addTestSuite(DefinePermissionsDocumentEditorTest.class);
		testSuite.addTestSuite(SelectSiteSOUserTest.class);
		testSuite.addTestSuite(SelectDocumentEditorRoleSOUserTest.class);
		testSuite.addTestSuite(AddDMDocumentSiteTest.class);
		testSuite.addTestSuite(ViewDMDocumentSiteTest.class);
		testSuite.addTestSuite(AddDMDocumentComment1SiteTest.class);
		testSuite.addTestSuite(SignOutSOTest.class);
		testSuite.addTestSuite(SOUs_SignInSOTest.class);
		testSuite.addTestSuite(SOUs_EditDMDocumentMinorSiteTest.class);
		testSuite.addTestSuite(SOUs_AddDMDocumentComment2SiteTest.class);
		testSuite.addTestSuite(SOUs_EditDMDocumentComment2SiteTest.class);
		testSuite.addTestSuite(SOUs_EditDMDocumentMajorSiteTest.class);
		testSuite.addTestSuite(SOUs_AddDMDocumentComment3SiteTest.class);
		testSuite.addTestSuite(SOUs_EditDMDocumentComment3SiteTest.class);
		testSuite.addTestSuite(SOUs_ViewDMDocumentOriginalSiteTest.class);
		testSuite.addTestSuite(SOUs_RevertDMDocumentMinorEditSiteTest.class);
		testSuite.addTestSuite(SOUs_DeleteDMDocumentMajorEditSiteTest.class);
		testSuite.addTestSuite(SOUs_SignOutSOTest.class);
		testSuite.addTestSuite(SignInSOTest.class);
		testSuite.addTestSuite(ViewDMDocumentLatestVersionSiteTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);
		testSuite.addTestSuite(TearDownRoleTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);

		return testSuite;
	}
}