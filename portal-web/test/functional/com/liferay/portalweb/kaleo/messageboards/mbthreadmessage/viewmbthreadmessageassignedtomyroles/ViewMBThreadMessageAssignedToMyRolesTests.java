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

package com.liferay.portalweb.kaleo.messageboards.mbthreadmessage.viewmbthreadmessageassignedtomyroles;

import com.liferay.portalweb.kaleo.messageboards.mbthreadmessage.viewmbthreadmessageassignedtome.PostNewMBThreadMessageTest;
import com.liferay.portalweb.kaleo.messageboards.mbthreadmessage.viewmbthreadmessageassignedtome.TearDownMBThreadMessageTest;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrydefaultnoworkflow.TearDownWorkflowConfigurationTest;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurembmessagesingleapprover.ConfigureMBMessageSingleApproverTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPageMBTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPortletMBTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBThreadMessageAssignedToMyRolesTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ConfigureMBMessageSingleApproverTest.class);
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(PostNewMBThreadMessageTest.class);
		testSuite.addTestSuite(ViewMBThreadMessageAssignedToMyRolesTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewMBThreadMessageAssignedToMyRolesTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownMBThreadMessageTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownWorkflowConfigurationTest.class);

		return testSuite;
	}
}