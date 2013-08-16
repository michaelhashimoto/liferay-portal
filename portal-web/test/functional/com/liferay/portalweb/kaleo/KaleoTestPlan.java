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

package com.liferay.portalweb.kaleo;

import com.liferay.portalweb.kaleo.assetpublisher.AssetPublisherTestPlan;
import com.liferay.portalweb.kaleo.blogs.BlogsTestPlan;
import com.liferay.portalweb.kaleo.messageboards.MessageBoardsTestPlan;
import com.liferay.portalweb.kaleo.mysubmissions.MySubmissionsTestPlan;
import com.liferay.portalweb.kaleo.myworkflowtasks.MyWorkflowTasksTestPlan;
import com.liferay.portalweb.kaleo.pagecomments.PageCommentsTestPlan;
import com.liferay.portalweb.kaleo.webcontent.WebContentTestPlan;
import com.liferay.portalweb.kaleo.webcontentdisplay.WebContentDisplayTestPlan;
import com.liferay.portalweb.kaleo.wiki.WikiTestPlan;
import com.liferay.portalweb.kaleo.workflow.WorkflowTestPlan;
import com.liferay.portalweb.kaleo.workflowconfiguration.WorkflowConfigurationTestPlan;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AssetPublisherTestPlan.suite());
		testSuite.addTest(BlogsTestPlan.suite());
		testSuite.addTest(MessageBoardsTestPlan.suite());
		testSuite.addTest(MySubmissionsTestPlan.suite());
		testSuite.addTest(MyWorkflowTasksTestPlan.suite());
		testSuite.addTest(PageCommentsTestPlan.suite());
		testSuite.addTest(WebContentTestPlan.suite());
		testSuite.addTest(WebContentDisplayTestPlan.suite());
		testSuite.addTest(WikiTestPlan.suite());
		testSuite.addTest(WorkflowTestPlan.suite());
		testSuite.addTest(WorkflowConfigurationTestPlan.suite());

		return testSuite;
	}

}