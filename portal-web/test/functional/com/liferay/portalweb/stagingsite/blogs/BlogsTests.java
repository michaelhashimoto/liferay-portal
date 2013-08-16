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

package com.liferay.portalweb.stagingsite.blogs;

import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrysingleapprover.ConfigureBlogsEntrySingleApproverTest;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrysingleapprover.TearDownWorkflowConfigurationTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.TearDownBlogsEntryTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(DefinePermissionsBlogsManagePagesPowerUserTest.class);
		testSuite.addTestSuite(AddUserPowerUserTest.class);
		testSuite.addTestSuite(AddUserPortalContentReviewerTest.class);
		testSuite.addTestSuite(AddUserAdministratorTest.class);
		testSuite.addTestSuite(ActivateStagingTest.class);
		testSuite.addTestSuite(ConfigureBlogsEntrySingleApproverTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(PU_LoginTest.class);
		testSuite.addTestSuite(PU_AddStagedPageTest.class);
		testSuite.addTestSuite(PU_AddStagedPortletTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(Guest_AssertNoPagePrePublishTest.class);
		testSuite.addTestSuite(Administrator_LoginTest.class);
		testSuite.addTestSuite(Administrator_PublishToLiveStagedPageTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(Guest_AssertPagePresentTest.class);
		testSuite.addTestSuite(PU_LoginTest.class);
		testSuite.addTestSuite(PU_AddStagedBlogsEntryTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(Guest_AssertNoBlogsEntryPreApprovalTest.class);
		testSuite.addTestSuite(PCR_LoginTest.class);
		testSuite.addTestSuite(PCR_AssignToMeStagedBlogsEntryActionsTest.class);
		testSuite.addTestSuite(PCR_ApproveStagedBlogsEntryActionsTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(Guest_AssertNoBlogsEntryPrePublishTest.class);
		testSuite.addTestSuite(Administrator_LoginTest.class);
		testSuite.addTestSuite(Administrator_PublishToLiveStagedBlogsEntryTest.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(Guest_AssertBlogsEntryTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(DeactivateStagingTest.class);
		testSuite.addTestSuite(TearDownWorkflowConfigurationTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownPermissionsTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}