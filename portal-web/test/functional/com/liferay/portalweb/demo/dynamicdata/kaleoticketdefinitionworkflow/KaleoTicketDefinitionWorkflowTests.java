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

package com.liferay.portalweb.demo.dynamicdata.kaleoticketdefinitionworkflow;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTicketDefinitionWorkflowTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageKaleoFormsTest.class);
		testSuite.addTestSuite(AddPortletKaleoFormsTest.class);
		testSuite.addTestSuite(AddUserJavascriptDeveloperTest.class);
		testSuite.addTestSuite(AddUserKaleoDeveloperTest.class);
		testSuite.addTestSuite(AddUserQAEngineerTest.class);
		testSuite.addTestSuite(AddUserQAManagerTest.class);
		testSuite.addTestSuite(AddUserProjectManagerTest.class);
		testSuite.addTestSuite(AddUserCodeReviewerTest.class);
		testSuite.addTestSuite(AddRoleJavascriptDeveloperTest.class);
		testSuite.addTestSuite(AddRoleKaleoDeveloperTest.class);
		testSuite.addTestSuite(AddRoleQAEngineerTest.class);
		testSuite.addTestSuite(AddRoleQAManagerTest.class);
		testSuite.addTestSuite(AddRoleProjectManagerTest.class);
		testSuite.addTestSuite(AddRoleCodeReviewerTest.class);
		testSuite.addTestSuite(DefineRoleJavascriptDeveloperTest.class);
		testSuite.addTestSuite(DefineRoleKaleoDeveloperTest.class);
		testSuite.addTestSuite(DefineRoleQAEngineerTest.class);
		testSuite.addTestSuite(DefineRoleQAManagerTest.class);
		testSuite.addTestSuite(DefineRoleProjectManagerTest.class);
		testSuite.addTestSuite(DefineRoleCodeReviewerTest.class);
		testSuite.addTestSuite(AssignRoleJavascriptDeveloperTest.class);
		testSuite.addTestSuite(AssignRoleKaleoDeveloperTest.class);
		testSuite.addTestSuite(AssignRoleQAEngineerTest.class);
		testSuite.addTestSuite(AssignRoleQAManagerTest.class);
		testSuite.addTestSuite(AssignRoleProjectManagerTest.class);
		testSuite.addTestSuite(AssignRoleCodeReviewerTest.class);
		testSuite.addTestSuite(SignInUsersTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(AddDataDefinitionTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldPriorityTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldComponentTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldSummaryTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldAffectsVersionsTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldDescriptionTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldAttachmentsTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldTestedRevisionTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldTestedStatusTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldPullRequestURLTest.class);
		testSuite.addTestSuite(EditDataDefinitionFieldStatusTest.class);
		testSuite.addTestSuite(AddTemplateTicketCreationTest.class);
		testSuite.addTestSuite(AddTemplateDeveloperViewTest.class);
		testSuite.addTestSuite(AddTemplateQAViewTest.class);
		testSuite.addTestSuite(AddTemplateProjectManagerViewTest.class);
		testSuite.addTestSuite(AddTemplateCodeReviewViewTest.class);
		testSuite.addTestSuite(AddWorkflowDefinitionTest.class);
		testSuite.addTestSuite(AddProcessKFTest.class);
		testSuite.addTestSuite(AddTaskKaleoTicketKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(KD_SignInTest.class);
		testSuite.addTestSuite(KD_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(KD_CompleteFormInProgressTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(CR_SignInTest.class);
		testSuite.addTestSuite(CR_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(CR_CompleteFormResolveTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(QAE_SignInTest.class);
		testSuite.addTestSuite(QAE_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(QAE_CompleteFormCloseTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(QAM_SignInTest.class);
		testSuite.addTestSuite(QAM_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(QAM_ViewTaskKaleoTicketClosedKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(PM_SignInTest.class);
		testSuite.addTestSuite(PM_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(PM_CompletedTaskKaleoTicketKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(ViewCompletedTaskKaleoTicketKFTest.class);
		testSuite.addTestSuite(AddTaskJavascriptTicketKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(JD_SignInTest.class);
		testSuite.addTestSuite(JD_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(JD_CompleteFormInReviewTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(CR_SignInTest.class);
		testSuite.addTestSuite(CR_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(CR_RollbackTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(JD_SignInTest.class);
		testSuite.addTestSuite(JD_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(JD_SubmitTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(CR_SignInTest.class);
		testSuite.addTestSuite(CR_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(CR_CompleteFormResolveTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(QAE_SignInTest.class);
		testSuite.addTestSuite(QAE_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(QAE_CompleteFormFailedTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(QAM_SignInTest.class);
		testSuite.addTestSuite(QAM_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(QAM_ViewTaskJavascriptTicketFailedKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(JD_SignInTest.class);
		testSuite.addTestSuite(JD_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(JD_CompleteFormInReviewTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(CR_SignInTest.class);
		testSuite.addTestSuite(CR_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(CR_CompleteFormResolveTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(QAE_SignInTest.class);
		testSuite.addTestSuite(QAE_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(QAE_CompleteFormCloseTaskKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(QAM_SignInTest.class);
		testSuite.addTestSuite(QAM_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(QAM_ViewTaskJavascriptTicketClosedKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(PM_SignInTest.class);
		testSuite.addTestSuite(PM_AssignToMeTaskKFTest.class);
		testSuite.addTestSuite(PM_CompletedTaskJavascriptTicketKFTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(ViewCompletedTaskJavascriptTicketKFTest.class);

		return testSuite;
	}
}