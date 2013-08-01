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

package com.liferay.portalweb.asset.bookmarks.bmbookmark.viewportlettablebmfolderbookmarkap;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletdisplaystyletable.ConfigurePortletDisplayStyleTableTest;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.addnewbmfolderbookmarkapactions.AddBMFolderTest;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.addnewbmfolderbookmarkapactions.AddNewBMFolderBookmarkAPActionsTest;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.addnewbmfolderbookmarkapactions.TearDownBMEntryTest;
import com.liferay.portalweb.asset.bookmarks.bmbookmark.addnewbmfolderbookmarkapactions.TearDownBMFolderTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.bookmarks.portlet.addportletbookmarks.AddPageBookmarksTest;
import com.liferay.portalweb.portlet.bookmarks.portlet.addportletbookmarks.AddPortletBookmarksTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletTableBMFolderBookmarkAPTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddPageBookmarksTest.class);
		testSuite.addTestSuite(AddPortletBookmarksTest.class);
		testSuite.addTestSuite(AddBMFolderTest.class);
		testSuite.addTestSuite(AddNewBMFolderBookmarkAPActionsTest.class);
		testSuite.addTestSuite(ConfigurePortletDisplayStyleTableTest.class);
		testSuite.addTestSuite(ViewPortletTableBMFolderBookmarkAPTest.class);
		testSuite.addTestSuite(TearDownBMFolderTest.class);
		testSuite.addTestSuite(TearDownBMEntryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}