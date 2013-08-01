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

package com.liferay.portalweb.portal.permissions.documentlibrary.content.documenttype;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documenttype.delete.DeleteDocumentTypeTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documenttype.permissions.DocumentTypePermissionsTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documenttype.update.UpdateDocumentTypeTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documenttype.view.ViewDocumentTypeTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentTypeTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DeleteDocumentTypeTests.suite());
		testSuite.addTest(DocumentTypePermissionsTests.suite());
		testSuite.addTest(UpdateDocumentTypeTests.suite());
		testSuite.addTest(ViewDocumentTypeTests.suite());

		return testSuite;
	}

}