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

package com.liferay.portalweb.portlet.mediagallery.dmfolder;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldermg.AddDMFolderMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldernameduplicatemg.AddDMFolderNameDuplicateMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldernameinvalidmg.AddDMFolderNameInvalidMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldernamenullmg.AddMGFolderNameNullMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldersmg.AddDMFoldersMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldermg.AddDMSubfolderMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldernameimagenamemg.AddDMSubfolderNameImageNameMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldersmg.AddDMSubfoldersMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.editdmfoldermg.EditDMFolderMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.editdmsubfoldermg.EditDMSubfolderMGTests;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.movedmsubfoldertofoldermg.MoveDMSubfolderToFolderMGTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMFolderTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDMFolderMGTests.suite());
		testSuite.addTest(AddDMFolderNameDuplicateMGTests.suite());
		testSuite.addTest(AddDMFolderNameInvalidMGTests.suite());
		testSuite.addTest(AddMGFolderNameNullMGTests.suite());
		testSuite.addTest(AddDMFoldersMGTests.suite());
		testSuite.addTest(AddDMSubfolderMGTests.suite());
		testSuite.addTest(AddDMSubfolderNameImageNameMGTests.suite());
		testSuite.addTest(AddDMSubfoldersMGTests.suite());
		testSuite.addTest(EditDMFolderMGTests.suite());
		testSuite.addTest(EditDMSubfolderMGTests.suite());
		testSuite.addTest(MoveDMSubfolderToFolderMGTests.suite());

		return testSuite;
	}

}