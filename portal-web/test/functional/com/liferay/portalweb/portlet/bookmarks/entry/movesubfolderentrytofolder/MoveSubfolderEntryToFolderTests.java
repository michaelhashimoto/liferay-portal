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

package com.liferay.portalweb.portlet.bookmarks.entry.movesubfolderentrytofolder;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.bookmarks.entry.addfolderentry.TearDownBookmarksEntryTest;
import com.liferay.portalweb.portlet.bookmarks.entry.addsubfolderentry.AddSubfolderEntryTest;
import com.liferay.portalweb.portlet.bookmarks.folder.addfolder.AddFolderTest;
import com.liferay.portalweb.portlet.bookmarks.folder.addfolder.TearDownBookmarksFolderTest;
import com.liferay.portalweb.portlet.bookmarks.folder.addsubfolder.AddSubfolderTest;
import com.liferay.portalweb.portlet.bookmarks.portlet.addportletbookmarks.AddPageBookmarksTest;
import com.liferay.portalweb.portlet.bookmarks.portlet.addportletbookmarks.AddPortletBookmarksTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveSubfolderEntryToFolderTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageBookmarksTest.class);
		testSuite.addTestSuite(AddPortletBookmarksTest.class);
		testSuite.addTestSuite(AddFolderTest.class);
		testSuite.addTestSuite(AddSubfolderTest.class);
		testSuite.addTestSuite(AddSubfolderEntryTest.class);
		testSuite.addTestSuite(MoveSubfolderEntryToFolderTest.class);
		testSuite.addTestSuite(TearDownBookmarksFolderTest.class);
		testSuite.addTestSuite(TearDownBookmarksEntryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}