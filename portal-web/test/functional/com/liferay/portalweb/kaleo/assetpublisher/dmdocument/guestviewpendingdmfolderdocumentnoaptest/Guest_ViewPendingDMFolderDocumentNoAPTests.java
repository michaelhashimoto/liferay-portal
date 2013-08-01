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

package com.liferay.portalweb.kaleo.assetpublisher.dmdocument.guestviewpendingdmfolderdocumentnoaptest;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolder.AddDMFolderTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolder.TearDownDMFolderTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPageDMTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPortletDMTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_ViewPendingDMFolderDocumentNoAPTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDMTest.class);
		testSuite.addTestSuite(AddPortletDMTest.class);
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddDMFolderTest.class);
		testSuite.addTestSuite(EditDMFolderWorkflowSingleApproverTest.class);
		testSuite.addTestSuite(AddDMFolderDocumentTest.class);
		testSuite.addTestSuite(ViewPendingDMFolderDocumentTest.class);
		testSuite.addTestSuite(ViewPendingDMFolderDocumentNoAPTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewPendingDMFolderDocumentNoAPTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(AssignToMeTaskDMFolderDocumentTest.class);
		testSuite.addTestSuite(ApproveTaskDMFolderDocumentTest.class);
		testSuite.addTestSuite(ViewApprovedDMFolderDocumentTest.class);
		testSuite.addTestSuite(ViewApprovedDMFolderDocumentAPTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewApprovedDMFolderDocumentAPTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownDMFolderTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}