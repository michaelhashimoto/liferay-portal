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

package com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentdmd.AddDMDocumentDMDTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentsdmd.AddDMDocumentsDMDTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmfolderdocumentdmd.AddDMFolderDocumentDMDTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmfolderdocumentsdmd.AddDMFolderDocumentsDMDTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.deletedmdocumentsdmdactions.DeleteDMDocumentsDMDActionsTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.searchdmfolderdocumentdmd.SearchDMFolderDocumentDMDTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMDocumentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDMDocumentDMDTests.suite());
		testSuite.addTest(AddDMDocumentsDMDTests.suite());
		testSuite.addTest(AddDMFolderDocumentDMDTests.suite());
		testSuite.addTest(AddDMFolderDocumentsDMDTests.suite());
		testSuite.addTest(DeleteDMDocumentsDMDActionsTests.suite());
		testSuite.addTest(SearchDMFolderDocumentDMDTests.suite());

		return testSuite;
	}

}