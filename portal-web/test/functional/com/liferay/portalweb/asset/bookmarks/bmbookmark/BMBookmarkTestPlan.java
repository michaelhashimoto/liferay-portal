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

package com.liferay.portalweb.asset.bookmarks.bmbookmark;

import com.liferay.portalweb.asset.bookmarks.bmbookmark.addnewbmfolderbookmarkapactions.AddNewBMFolderBookmarkAPActionsTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.deletebmfolderbookmarkap.DeleteBMFolderBookmarkAPTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.selectexistingbmfolderbookmarkapactions.SelectExistingBMFolderBookmarkAPActionsTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.viewportletabstractsbmfolderbookmarkap.ViewPortletAbstractsBMFolderBookmarkAPTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.viewportletavailablebookmarksentryap.ViewPortletAvailableBookmarksEntryAPTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.viewportletcurrentbookmarksentryap.ViewPortletCurrentBookmarksEntryAPTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.viewportletfullcontentbmfolderbookmarkap.ViewPortletFullContentBMFolderBookmarkAPTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.viewportlettablebmfolderbookmarkap.ViewPortletTableBMFolderBookmarkAPTests;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.viewportlettitlelistbmfolderbookmarkap.ViewPortletTitleListBMFolderBookmarkAPTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BMBookmarkTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddNewBMFolderBookmarkAPActionsTests.suite());
		testSuite.addTest(DeleteBMFolderBookmarkAPTests.suite());
		testSuite.addTest(SelectExistingBMFolderBookmarkAPActionsTests.suite());
		testSuite.addTest(ViewPortletAbstractsBMFolderBookmarkAPTests.suite());
		testSuite.addTest(ViewPortletAvailableBookmarksEntryAPTests.suite());
		testSuite.addTest(ViewPortletCurrentBookmarksEntryAPTests.suite());
		testSuite.addTest(
			ViewPortletFullContentBMFolderBookmarkAPTests.suite());
		testSuite.addTest(ViewPortletTableBMFolderBookmarkAPTests.suite());
		testSuite.addTest(ViewPortletTitleListBMFolderBookmarkAPTests.suite());

		return testSuite;
	}

}