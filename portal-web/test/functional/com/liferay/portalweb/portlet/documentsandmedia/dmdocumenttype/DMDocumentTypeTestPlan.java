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

package com.liferay.portalweb.portlet.documentsandmedia.dmdocumenttype;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocumenttype.adddmdocumenttype.AddDMDocumentTypeTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocumenttype.adddmdocumenttypes.AddDMDocumentTypesTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocumenttype.deletedmdocumenttype.DeleteDMDocumentTypeTests;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocumenttype.editdmdocumenttype.EditDMDocumentTypeTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMDocumentTypeTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDMDocumentTypeTests.suite());
		testSuite.addTest(AddDMDocumentTypesTests.suite());
		testSuite.addTest(DeleteDMDocumentTypeTests.suite());
		testSuite.addTest(EditDMDocumentTypeTests.suite());

		return testSuite;
	}

}