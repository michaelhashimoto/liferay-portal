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

package com.liferay.portalweb.asset.documentsandmedia.dmimage;

import com.liferay.portalweb.asset.documentsandmedia.dmimage.addnewdmfolderimageapactions.AddNewDMFolderImageAPActionsTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.deletedmfolderimageap.DeleteDMFolderImageAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.selectexistingdmfolderimageapactions.SelectExistingDMFolderImageAPActionsTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.viewconfigureportletabstractsdmimageap.ViewConfigurePortletAbstractsDMImageAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.viewconfigureportletavailabledmimageap.ViewConfigurePortletAvailableDMImageAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.viewconfigureportletcurrentdmimageap.ViewConfigurePortletCurrentDMImageAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.viewconfigureportletfullcontentdmimageap.ViewConfigurePortletFullContentDMImageAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.viewconfigureportlettabledmimageap.ViewConfigurePortletTableDMImageAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.viewconfigureportlettitlelistdmimageap.ViewConfigurePortletTitleListDMImageAPTests;
import com.liferay.portalweb.asset.documentsandmedia.dmimage.viewdmfolderimageviewcountap.ViewDMFolderImageViewCountAPTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMImageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddNewDMFolderImageAPActionsTests.suite());
		testSuite.addTest(DeleteDMFolderImageAPTests.suite());
		testSuite.addTest(SelectExistingDMFolderImageAPActionsTests.suite());
		testSuite.addTest(ViewConfigurePortletAbstractsDMImageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletAvailableDMImageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletCurrentDMImageAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletFullContentDMImageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletTableDMImageAPTests.suite());
		testSuite.addTest(ViewConfigurePortletTitleListDMImageAPTests.suite());
		testSuite.addTest(ViewDMFolderImageViewCountAPTests.suite());

		return testSuite;
	}

}