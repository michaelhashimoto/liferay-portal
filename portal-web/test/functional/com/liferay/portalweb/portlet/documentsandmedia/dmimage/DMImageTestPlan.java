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

package com.liferay.portalweb.portlet.documentsandmedia.dmimage;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.adddmfolderimage.AddDMFolderImageTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.adddmfolderimagefilenull.AddDMFolderImageFileNullTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.adddmfolderimages.AddDMFolderImagesTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.adddmfolderimagetitleduplicate.AddDMFolderImageTitleDuplicateTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.adddmfolderimagetitlenull.AddDMFolderImageTitleNullTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.adddmsubfolderimage.AddDMSubfolderImageTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.deletedmfolderimageactions.DeleteDMFolderImageActionsTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.deletedmsubfolderimageactions.DeleteDMSubfolderImageActionsTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.editdmfolderimagedetails.EditDMFolderImageDetailsTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.editdmsubfolderimagedetails.EditDMSubfolderImageDetailsTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.movedmfolder1imagetofolder2.MoveDMFolder1ImageToFolder2Tests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.searchdmfolderimage.SearchDMFolderImageTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmimage.searchdmfolderimagefolderdetails.SearchDMFolderImageFolderDetailsTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMImageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDMFolderImageTests.suite());
		testSuite.addTest(AddDMFolderImageFileNullTests.suite());
		testSuite.addTest(AddDMFolderImagesTests.suite());
		testSuite.addTest(AddDMFolderImageTitleDuplicateTests.suite());
		testSuite.addTest(AddDMFolderImageTitleNullTests.suite());
		testSuite.addTest(AddDMSubfolderImageTests.suite());
		testSuite.addTest(DeleteDMFolderImageActionsTests.suite());
		testSuite.addTest(DeleteDMSubfolderImageActionsTests.suite());
		testSuite.addTest(EditDMFolderImageDetailsTests.suite());
		testSuite.addTest(EditDMSubfolderImageDetailsTests.suite());
		testSuite.addTest(MoveDMFolder1ImageToFolder2Tests.suite());
		testSuite.addTest(SearchDMFolderImageTests.suite());
		testSuite.addTest(SearchDMFolderImageFolderDetailsTests.suite());

		return testSuite;
	}

}