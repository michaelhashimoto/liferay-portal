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

package com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibraryfolder;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.adddiscussion.AddDocumentDiscussionTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.delete.DeleteDocumentTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.deletediscussion.DeleteDocumentDiscussionTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.permissions.DocumentPermissionsTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.update.UpdateDocumentTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.updatediscussion.UpdateDocumentDiscussionTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibrarydocument.view.ViewDocumentTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentLibraryFolderTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDocumentDiscussionTests.suite());
		testSuite.addTest(DeleteDocumentTests.suite());
		testSuite.addTest(DeleteDocumentDiscussionTests.suite());
		testSuite.addTest(DocumentPermissionsTests.suite());
		testSuite.addTest(UpdateDocumentTests.suite());
		testSuite.addTest(UpdateDocumentDiscussionTests.suite());
		testSuite.addTest(ViewDocumentTests.suite());

		return testSuite;
	}

}