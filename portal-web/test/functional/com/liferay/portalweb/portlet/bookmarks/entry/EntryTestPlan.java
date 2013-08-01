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

package com.liferay.portalweb.portlet.bookmarks.entry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.bookmarks.entry.addfolderentry.AddFolderEntryTests;
import com.liferay.portalweb.portlet.bookmarks.entry.addfolderentrymultiple.AddFolderEntryMultipleTests;
import com.liferay.portalweb.portlet.bookmarks.entry.addfolderentrynamenull.AddFolderEntryNameNullTests;
import com.liferay.portalweb.portlet.bookmarks.entry.addfolderentryurlinvalid.AddFolderEntryURLInvalidTests;
import com.liferay.portalweb.portlet.bookmarks.entry.addfolderentryurlnull.AddFolderEntryURLNullTests;
import com.liferay.portalweb.portlet.bookmarks.entry.addsubfolderentry.AddSubfolderEntryTests;
import com.liferay.portalweb.portlet.bookmarks.entry.deletefolderentry.DeleteFolderEntryTests;
import com.liferay.portalweb.portlet.bookmarks.entry.editfolderentry.EditFolderEntryTests;
import com.liferay.portalweb.portlet.bookmarks.entry.guestviewpermissionsbookmarksentryguestviewoff.Guest_ViewPermissionsBookmarksEntryGuestViewOffTests;
import com.liferay.portalweb.portlet.bookmarks.entry.movefolderentrytofolder.MoveFolderEntryToFolderTests;
import com.liferay.portalweb.portlet.bookmarks.entry.movefolderentrytosubfolder.MoveFolderEntryToSubfolderTests;
import com.liferay.portalweb.portlet.bookmarks.entry.movesubfolderentrytofolder.MoveSubfolderEntryToFolderTests;
import com.liferay.portalweb.portlet.bookmarks.entry.movesubfolderentrytosubfolder.MoveSubfolderEntryToSubfolderTests;
import com.liferay.portalweb.portlet.bookmarks.entry.searchfolderentry.SearchFolderEntryTests;
import com.liferay.portalweb.portlet.bookmarks.entry.viewfolderentrymyentries.ViewFolderEntryMyEntriesTests;
import com.liferay.portalweb.portlet.bookmarks.entry.viewfolderentryrecententries.ViewFolderEntryRecentEntriesTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddFolderEntryTests.suite());
		testSuite.addTest(AddFolderEntryMultipleTests.suite());
		testSuite.addTest(AddFolderEntryNameNullTests.suite());
		testSuite.addTest(AddFolderEntryURLInvalidTests.suite());
		testSuite.addTest(AddFolderEntryURLNullTests.suite());
		testSuite.addTest(AddSubfolderEntryTests.suite());
		testSuite.addTest(DeleteFolderEntryTests.suite());
		testSuite.addTest(EditFolderEntryTests.suite());
		testSuite.addTest(
			Guest_ViewPermissionsBookmarksEntryGuestViewOffTests.suite());
		testSuite.addTest(MoveFolderEntryToFolderTests.suite());
		testSuite.addTest(MoveFolderEntryToSubfolderTests.suite());
		testSuite.addTest(MoveSubfolderEntryToFolderTests.suite());
		testSuite.addTest(MoveSubfolderEntryToSubfolderTests.suite());
		testSuite.addTest(SearchFolderEntryTests.suite());
		testSuite.addTest(ViewFolderEntryMyEntriesTests.suite());
		testSuite.addTest(ViewFolderEntryRecentEntriesTests.suite());

		return testSuite;
	}

}