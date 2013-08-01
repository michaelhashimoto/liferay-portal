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

package com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.publishdraftdmfolderdocument;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.adddmfolderdocument.AddDMFolderTest;
import com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.adddmfolderdocument.TearDownDMFolderTest;
import com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.saveasdraftdmfolderdocument.SaveAsDraftDMFolderDocumentTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PublishDraftDMFolderDocumentTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddDMFolderTest.class);
		testSuite.addTestSuite(SaveAsDraftDMFolderDocumentTest.class);
		testSuite.addTestSuite(PublishDraftDMFolderDocumentTest.class);
		testSuite.addTestSuite(ViewPublishDraftDMFolderDocumentTest.class);
		testSuite.addTestSuite(TearDownDMFolderTest.class);

		return testSuite;
	}
}