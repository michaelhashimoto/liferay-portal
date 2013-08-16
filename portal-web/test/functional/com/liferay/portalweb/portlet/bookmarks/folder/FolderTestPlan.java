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

package com.liferay.portalweb.portlet.bookmarks.folder;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.bookmarks.folder.addfolder.AddFolderTests;
import com.liferay.portalweb.portlet.bookmarks.folder.addfoldermultiple.AddFolderMultipleTests;
import com.liferay.portalweb.portlet.bookmarks.folder.addfoldernamenull.AddFolderNameNullTests;
import com.liferay.portalweb.portlet.bookmarks.folder.addsubfolder.AddSubfolderTests;
import com.liferay.portalweb.portlet.bookmarks.folder.combinesubfoldertofolder.CombineSubfolderToFolderTests;
import com.liferay.portalweb.portlet.bookmarks.folder.deletefolder.DeleteFolderTests;
import com.liferay.portalweb.portlet.bookmarks.folder.deletesubfolder.DeleteSubfolderTests;
import com.liferay.portalweb.portlet.bookmarks.folder.editfolder.EditFolderTests;
import com.liferay.portalweb.portlet.bookmarks.folder.editsubfolder.EditSubfolderTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class FolderTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddFolderTests.suite());
		testSuite.addTest(AddFolderMultipleTests.suite());
		testSuite.addTest(AddFolderNameNullTests.suite());
		testSuite.addTest(AddSubfolderTests.suite());
		testSuite.addTest(CombineSubfolderToFolderTests.suite());
		testSuite.addTest(DeleteFolderTests.suite());
		testSuite.addTest(DeleteSubfolderTests.suite());
		testSuite.addTest(EditFolderTests.suite());
		testSuite.addTest(EditSubfolderTests.suite());

		return testSuite;
	}

}