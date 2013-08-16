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

package com.liferay.portalweb.asset.documentsandmedia.dmdocument;

import com.liferay.portalweb.asset.documentsandmedia.dmdocument.addnewdmfolderdocumentapactions.AddNewDMFolderDocumentAPActionsTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.deletedmfolderdocumentap.DeleteDMFolderDocumentAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.ratedmfolderdocumentap.RateDMFolderDocumentAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.selectexistingdmfolderdocumentapactions.SelectExistingDMFolderDocumentAPActionsTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.viewconfigureportletabstractsdmdocumentap.ViewConfigurePortletAbstractsDMDocumentAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.viewconfigureportletavailabledmdocumentap.ViewConfigurePortletAvailableDMDocumentAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.viewconfigureportletcurrentdmdocumentap.ViewConfigurePortletCurrentDMDocumentAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.viewconfigureportletfullcontentdmdocumentap.ViewConfigurePortletFullContentDMDocumentAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.viewconfigureportlettabledmdocumentap.ViewConfigurePortletTableDMDocumentAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmdocument.viewconfigureportlettitlelistdmdocumentap.ViewConfigurePortletTitleListDMDocumentAPTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMDocumentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddNewDMFolderDocumentAPActionsTests.suite());
		testSuite.addTest(DeleteDMFolderDocumentAPTests.suite());
		testSuite.addTest(RateDMFolderDocumentAPTests.suite());
		testSuite.addTest(SelectExistingDMFolderDocumentAPActionsTests.suite());
		testSuite.addTest(
			ViewConfigurePortletAbstractsDMDocumentAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletAvailableDMDocumentAPTests.suite());
		testSuite.addTest(ViewConfigurePortletCurrentDMDocumentAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletFullContentDMDocumentAPTests.suite());
		testSuite.addTest(ViewConfigurePortletTableDMDocumentAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletTitleListDMDocumentAPTests.suite());

		return testSuite;
	}

}