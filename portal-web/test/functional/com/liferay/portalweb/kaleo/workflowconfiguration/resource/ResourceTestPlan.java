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

package com.liferay.portalweb.kaleo.workflowconfiguration.resource;

import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrydefaultnoworkflow.ConfigureBlogsEntryDefaultNoWorkflowTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrydefaultsingleapprover.ConfigureBlogsEntryDefaultSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configureblogsentrysingleapprover.ConfigureBlogsEntrySingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurecommentsdefaultnoworkflow.ConfigureCommentsDefaultNoWorkflowTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurecommentsdefaultsingleapprover.ConfigureCommentsDefaultSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurecommentssingleapprover.ConfigureCommentsSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurembmessagedefaultnoworkflow.ConfigureMBMessageDefaultNoWorkflowTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurembmessagedefaultsingleapprover.ConfigureMBMessageDefaultSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurembmessagesingleapprover.ConfigureMBMessageSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurepagerevisiondefaultnoworkflow.ConfigurePageRevisionDefaultNoWorkflowTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurepagerevisiondefaultsingleapprover.ConfigurePageRevisionDefaultSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurepagerevisionsingleapprover.ConfigurePageRevisionSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurewebcontentdefaultnoworkflow.ConfigureWebContentDefaultNoWorkflowTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurewebcontentdefaultsingleapprover.ConfigureWebContentDefaultSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurewebcontentsingleapprover.ConfigureWebContentSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurewikipagedefaultnoworkflow.ConfigureWikiPageDefaultNoWorkflowTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurewikipagedefaultsingleapprover.ConfigureWikiPageDefaultSingleApproverTests;
import com.liferay.portalweb.kaleo.workflowconfiguration.resource.configurewikipagesingleapprover.ConfigureWikiPageSingleApproverTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ResourceTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ConfigureBlogsEntryDefaultNoWorkflowTests.suite());
		testSuite.addTest(
			ConfigureBlogsEntryDefaultSingleApproverTests.suite());
		testSuite.addTest(ConfigureBlogsEntrySingleApproverTests.suite());
		testSuite.addTest(ConfigureCommentsDefaultNoWorkflowTests.suite());
		testSuite.addTest(ConfigureCommentsDefaultSingleApproverTests.suite());
		testSuite.addTest(ConfigureCommentsSingleApproverTests.suite());
		testSuite.addTest(ConfigureMBMessageDefaultNoWorkflowTests.suite());
		testSuite.addTest(ConfigureMBMessageDefaultSingleApproverTests.suite());
		testSuite.addTest(ConfigureMBMessageSingleApproverTests.suite());
		testSuite.addTest(ConfigurePageRevisionDefaultNoWorkflowTests.suite());
		testSuite.addTest(
			ConfigurePageRevisionDefaultSingleApproverTests.suite());
		testSuite.addTest(ConfigurePageRevisionSingleApproverTests.suite());
		testSuite.addTest(ConfigureWebContentDefaultNoWorkflowTests.suite());
		testSuite.addTest(
			ConfigureWebContentDefaultSingleApproverTests.suite());
		testSuite.addTest(ConfigureWebContentSingleApproverTests.suite());
		testSuite.addTest(ConfigureWikiPageDefaultNoWorkflowTests.suite());
		testSuite.addTest(ConfigureWikiPageDefaultSingleApproverTests.suite());
		testSuite.addTest(ConfigureWikiPageSingleApproverTests.suite());

		return testSuite;
	}

}