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

package com.liferay.portalweb.kaleo.webcontent.wcwebcontent;

import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontent.AddWebContentTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentdraft.AddWebContentDraftTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentnoworkflow.AddWebContentNoWorkflowTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentnoworkflowscopepage.AddWebContentNoWorkflowScopePageTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentscopecommunity.AddWebContentScopeCommunityTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentscopeglobal.AddWebContentScopeGlobalTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentscopeguest.AddWebContentScopeGuestTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentscopemycommunity.AddWebContentScopeMyCommunityTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentscopeorganization.AddWebContentScopeOrganizationTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.addwebcontentscopepage.AddWebContentScopePageTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.deletewebcontentassignedtomeactions.DeleteWebContentAssignedToMeActionsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.deletewebcontentassignedtomyrolesactions.DeleteWebContentAssignedToMyRolesActionsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.deletewebcontentcompletedactions.DeleteWebContentCompletedActionsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.deletewebcontentcompleteddrafteditdetails.DeleteWebContentCompletedDraftEditDetailsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.deletewebcontentcompletedediteddetails.DeleteWebContentCompletedEditedDetailsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.deletewebcontentcompletededitedlist.DeleteWebContentCompletedEditedListTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.editwebcontentassignedtomeactions.EditWebContentAssignedToMeActionsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.editwebcontentassignedtomyrolesactions.EditWebContentAssignedToMyRolesActionsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.editwebcontentcompletedactions.EditWebContentCompletedActionsTests;
import com.liferay.portalweb.kaleo.webcontent.wcwebcontent.editwebcontentcompleteddraftactions.EditWebContentCompletedDraftActionsTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WCWebContentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWebContentTests.suite());
		testSuite.addTest(AddWebContentDraftTests.suite());
		testSuite.addTest(AddWebContentNoWorkflowTests.suite());
		testSuite.addTest(AddWebContentNoWorkflowScopePageTests.suite());
		testSuite.addTest(AddWebContentScopeCommunityTests.suite());
		testSuite.addTest(AddWebContentScopeGlobalTests.suite());
		testSuite.addTest(AddWebContentScopeGuestTests.suite());
		testSuite.addTest(AddWebContentScopeMyCommunityTests.suite());
		testSuite.addTest(AddWebContentScopeOrganizationTests.suite());
		testSuite.addTest(AddWebContentScopePageTests.suite());
		testSuite.addTest(DeleteWebContentAssignedToMeActionsTests.suite());
		testSuite.addTest(
			DeleteWebContentAssignedToMyRolesActionsTests.suite());
		testSuite.addTest(DeleteWebContentCompletedActionsTests.suite());
		testSuite.addTest(
			DeleteWebContentCompletedDraftEditDetailsTests.suite());
		testSuite.addTest(DeleteWebContentCompletedEditedDetailsTests.suite());
		testSuite.addTest(DeleteWebContentCompletedEditedListTests.suite());
		testSuite.addTest(EditWebContentAssignedToMeActionsTests.suite());
		testSuite.addTest(EditWebContentAssignedToMyRolesActionsTests.suite());
		testSuite.addTest(EditWebContentCompletedActionsTests.suite());
		testSuite.addTest(EditWebContentCompletedDraftActionsTests.suite());

		return testSuite;
	}

}