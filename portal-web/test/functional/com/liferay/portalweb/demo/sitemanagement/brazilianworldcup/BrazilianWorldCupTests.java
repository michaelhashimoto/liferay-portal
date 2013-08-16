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

package com.liferay.portalweb.demo.sitemanagement.brazilianworldcup;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BrazilianWorldCupTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSiteBWCTest.class);
		testSuite.addTestSuite(AddFriendlyURLVirtualHostsSiteBWCTest.class);
		testSuite.addTestSuite(AddPublicPageHomeSiteBWCTest.class);
		testSuite.addTestSuite(AddPublicPageArenasSiteBWCTest.class);
		testSuite.addTestSuite(AddPrivatePageAccommodationsSiteBWCTest.class);
		testSuite.addTestSuite(AddPrivatePageMapsSiteBWCTest.class);
		testSuite.addTestSuite(AddPublicPageArenasChildPagePernambucoSiteBWCTest.class);
		testSuite.addTestSuite(AddPublicPageArenasChildPageBaixadaSiteBWCTest.class);
		testSuite.addTestSuite(AddPublicPageArenasChildPageMaracanaSiteBWCTest.class);
		testSuite.addTestSuite(EditColorSchemeGreenPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(EditLogoPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(AddJavaScriptCodePublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(Guest_ViewPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(Guest_ViewPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(SignInPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(ViewPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(SignOutPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(AddUserSoccerAdminTest.class);
		testSuite.addTestSuite(AddUserSoccerAdminPasswordTest.class);
		testSuite.addTestSuite(AddMembersSoccerAdminSiteBWCTest.class);
		testSuite.addTestSuite(AssignRoleSiteAdministratorSoccerAdminTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SA_SignInPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(SA_ViewPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(SA_SignOutPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(SA_SignInPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(SA_ViewPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(SA_SignOutPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(ExportLARPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(ExportLARPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(AddSiteLARImportSiteTest.class);
		testSuite.addTestSuite(ImportExportLARPublicPagesSiteBWCTest.class);
		testSuite.addTestSuite(ImportExportLARPrivatePagesSiteBWCTest.class);
		testSuite.addTestSuite(ViewImportExportLARPublicPagesSiteLARImportSiteTest.class);
		testSuite.addTestSuite(ViewImportExportLARPrivatePagesSiteLARImportSiteTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownSitesTest.class);

		return testSuite;
	}
}