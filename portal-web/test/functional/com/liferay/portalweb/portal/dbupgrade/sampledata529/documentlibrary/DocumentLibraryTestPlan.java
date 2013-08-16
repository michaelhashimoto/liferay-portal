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

package com.liferay.portalweb.portal.dbupgrade.sampledata529.documentlibrary;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.documentlibrary.document.DocumentTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.documentlibrary.documentlock.DocumentLockTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.documentlibrary.documentversion.DocumentVersionTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.documentlibrary.folder.FolderTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.documentlibrary.shortcut.ShortcutTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentLibraryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DocumentTests.suite());
		testSuite.addTest(DocumentLockTests.suite());
		testSuite.addTest(DocumentVersionTests.suite());
		testSuite.addTest(FolderTests.suite());
		testSuite.addTest(ShortcutTests.suite());

		return testSuite;
	}

}