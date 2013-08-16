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

package com.liferay.portalweb.stagingorganization.blogs;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(DefinePermissionsBlogsManagePagesOrganizationUserTest.class);
		testSuite.addTestSuite(AddOrganizationTest.class);
		testSuite.addTestSuite(AddOrganizationSiteTest.class);
		testSuite.addTestSuite(AddUserOrganizationUserTest.class);
		testSuite.addTestSuite(AddUserOrganizationContentReviewerTest.class);
		testSuite.addTestSuite(AddUserOrganizationAdministratorTest.class);
		testSuite.addTestSuite(ActivateStagingOrganizationSiteTest.class);
		testSuite.addTestSuite(ConfigureBlogsEntrySingleApproverOrganizationSiteTest.class);
		testSuite.addTestSuite(LogoutTest.class);
		testSuite.addTestSuite(OU_LoginTest.class);
		testSuite.addTestSuite(OU_AddStagedPageOrganizationSiteTest.class);
		testSuite.addTestSuite(OU_AddStagedPortletOrganizationSiteTest.class);
		testSuite.addTestSuite(OU_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertNoPagePrePublishOrganizationSiteTest.class);
		testSuite.addTestSuite(OA_LoginTest.class);
		testSuite.addTestSuite(OA_PublishToLiveStagedPageOrganizationSiteTest.class);
		testSuite.addTestSuite(OA_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertPagePresentOrganizationSiteTest.class);
		testSuite.addTestSuite(OU_LoginTest.class);
		testSuite.addTestSuite(OU_AddStagedBlogsEntryOrganizationSiteTest.class);
		testSuite.addTestSuite(OU_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertNoBlogsEntryPreApprovalOrganizationSiteTest.class);
		testSuite.addTestSuite(OCR_LoginTest.class);
		testSuite.addTestSuite(OCR_AssignToMeStagedBlogsEntryOrganizationSiteActionsTest.class);
		testSuite.addTestSuite(OCR_ApproveStagedBlogsEntryOrganizationSiteActionsTest.class);
		testSuite.addTestSuite(OCR_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertNoBlogsEntryPrePublishOrganizationSiteTest.class);
		testSuite.addTestSuite(OA_LoginTest.class);
		testSuite.addTestSuite(OA_PublishToLiveStagedBlogsEntryOrganizationSiteTest.class);
		testSuite.addTestSuite(OA_LogoutTest.class);
		testSuite.addTestSuite(Guest_AssertBlogsEntryOrganizationSiteTest.class);
		testSuite.addTestSuite(LoginTest.class);
		testSuite.addTestSuite(TearDownWorkflowConfigurationOrganizationSiteTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryOrganizationSiteTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownPermissionsTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);
		testSuite.addTestSuite(TearDownOrganizationTest.class);

		return testSuite;
	}
}