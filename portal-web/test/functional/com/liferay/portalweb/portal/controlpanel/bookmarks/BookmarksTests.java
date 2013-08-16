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

package com.liferay.portalweb.portal.controlpanel.bookmarks;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddFolderTest.class);
		testSuite.addTestSuite(AddSubfolderTest.class);
		testSuite.addTestSuite(AddEntryTest.class);
		testSuite.addTestSuite(AddSecondEntryTest.class);
		testSuite.addTestSuite(AssertEntriesTest.class);
		testSuite.addTestSuite(SearchEntriesTest.class);
		testSuite.addTestSuite(SearchNullEntriesTest.class);
		testSuite.addTestSuite(MoveEntryTest.class);
		testSuite.addTestSuite(DeleteEntryTest.class);
		testSuite.addTestSuite(EditFolderTest.class);
		testSuite.addTestSuite(EditSubfolderTest.class);
		testSuite.addTestSuite(EditEntryTest.class);
		testSuite.addTestSuite(CombineToParentFolderTest.class);
		testSuite.addTestSuite(AddNullFolderTest.class);
		testSuite.addTestSuite(AddNullSubfolderTest.class);
		testSuite.addTestSuite(AddNullEntryTest.class);
		testSuite.addTestSuite(AddNullURLTest.class);
		testSuite.addTestSuite(AddNullTitleTest.class);
		testSuite.addTestSuite(AddIncorrectURLTest.class);
		testSuite.addTestSuite(TearDownBookmarkFolderCPTest.class);
		testSuite.addTestSuite(ImportLARTest.class);
		testSuite.addTestSuite(AssertImportLARTest.class);
		testSuite.addTestSuite(TearDownBookmarkFolderCPTest.class);

		return testSuite;
	}
}