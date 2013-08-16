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

package com.liferay.portalweb.portlet.documentsandmedia.dmfolder;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolder.AddDMFolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfoldernameduplicate.AddDMFolderNameDuplicateTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfoldernamenull.AddDMFolderNameNullTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfoldernamespace.AddDMFolderNameSpaceTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfoldernamesymbol.AddDMFolderNameSymbolTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolders.AddDMFoldersTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmsubfolder.AddDMSubfolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmsubfoldernamedocumentname.AddDMSubfolderNameDocumentNameTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmsubfoldernameimagename.AddDMSubfolderNameImageNameTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmsubfolders.AddDMSubfoldersTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.deletedmfolder.DeleteDMFolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.deletedmsubfolder.DeleteDMSubfolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.editdmfolder.EditDMFolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.editdmsubfolder.EditDMSubfolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.movedmsubfoldertofolder2.MoveDMSubfolderToFolder2Tests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMFolderTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDMSubfolderNameImageNameTests.suite());
		testSuite.addTest(AddDMFolderTests.suite());
		testSuite.addTest(AddDMFolderNameDuplicateTests.suite());
		testSuite.addTest(AddDMFolderNameNullTests.suite());
		testSuite.addTest(AddDMFolderNameSpaceTests.suite());
		testSuite.addTest(AddDMFolderNameSymbolTests.suite());
		testSuite.addTest(AddDMFoldersTests.suite());
		testSuite.addTest(AddDMSubfolderTests.suite());
		testSuite.addTest(AddDMSubfolderNameDocumentNameTests.suite());
		testSuite.addTest(AddDMSubfolderNameImageNameTests.suite());
		testSuite.addTest(AddDMSubfoldersTests.suite());
		testSuite.addTest(DeleteDMFolderTests.suite());
		testSuite.addTest(DeleteDMSubfolderTests.suite());
		testSuite.addTest(EditDMFolderTests.suite());
		testSuite.addTest(EditDMSubfolderTests.suite());
		testSuite.addTest(MoveDMSubfolderToFolder2Tests.suite());

		return testSuite;
	}

}