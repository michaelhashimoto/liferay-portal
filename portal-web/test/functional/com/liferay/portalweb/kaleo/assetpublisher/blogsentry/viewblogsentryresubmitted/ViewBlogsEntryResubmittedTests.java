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

package com.liferay.portalweb.kaleo.assetpublisher.blogsentry.viewblogsentryresubmitted;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTest;
import com.liferay.portalweb.kaleo.assetpublisher.blogsentry.viewblogsentryassignedtome.AddAPBlogsEntryTest;
import com.liferay.portalweb.kaleo.assetpublisher.blogsentry.viewblogsentryassignedtome.AssignToMeBlogsEntryActionsTest;
import com.liferay.portalweb.kaleo.assetpublisher.blogsentry.viewblogsentryrejected.RejectBlogsEntryActionsTest;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrydefaultnoworkflow.TearDownWorkflowConfigurationTest;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrysingleapprover.ConfigureBlogsEntrySingleApproverTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.blogs.blogsentry.addblogsentrycp.TearDownBlogsEntryCPTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryResubmittedTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddAPBlogsEntryTest.class);
		testSuite.addTestSuite(AssignToMeBlogsEntryActionsTest.class);
		testSuite.addTestSuite(RejectBlogsEntryActionsTest.class);
		testSuite.addTestSuite(ResubmitBlogsEntryActionsTest.class);
		testSuite.addTestSuite(ViewBlogsEntryResubmittedTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(ViewBlogsEntryResubmittedGuestTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryCPTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(ConfigureBlogsEntrySingleApproverTest.class);
		testSuite.addTestSuite(TearDownWorkflowConfigurationTest.class);

		return testSuite;
	}
}