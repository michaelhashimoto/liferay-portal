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

package com.liferay.portalweb.kaleo.pagecomments.comment.viewcommentassignedtome;

import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrysingleapprover.TearDownWorkflowConfigurationTest;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurecommentssingleapprover.ConfigureCommentsSingleApproverTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.pagecomments.comment.addcomment.TearDownPageCommentTest;
import com.liferay.portalweb.portlet.pagecomments.portlet.addportletpc.AddPagePCTest;
import com.liferay.portalweb.portlet.pagecomments.portlet.addportletpc.AddPortletPCTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCommentAssignedToMeTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ConfigureCommentsSingleApproverTest.class);
		testSuite.addTestSuite(AddPagePCTest.class);
		testSuite.addTestSuite(AddPortletPCTest.class);
		testSuite.addTestSuite(AddCommentTest.class);
		testSuite.addTestSuite(AssignToMeCommentActionsTest.class);
		testSuite.addTestSuite(ViewCommentAssignedToMeTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewCommentAssignedToMeTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownPageCommentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownWorkflowConfigurationTest.class);

		return testSuite;
	}
}