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

package com.liferay.portalweb.asset.blogs.blogsentry;

import com.liferay.portalweb.asset.blogs.blogsentry.addnewblogsentryapactions.AddNewBlogsEntryAPActionsTests;
import com.liferay.portalweb.asset.blogs.blogsentry.deleteblogsentry2.DeleteBlogsEntry2Tests;
import com.liferay.portalweb.asset.blogs.blogsentry.deleteblogsentryap.DeleteBlogsEntryAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.rateblogsentryap.RateBlogsEntryAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.selectexistingblogsentryapactions.SelectExistingBlogsEntryAPActionsTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewblogsentryorderbycolumnratingsap.ViewBlogsEntryOrderByColumnRatingsAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewblogsentryscopecurrentpageap.ViewBlogsEntryScopeCurrentPageAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewblogsentryviewcountap.ViewBlogsEntryViewCountAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewconfigureportletabstractsblogsentryap.ViewConfigurePortletAbstractsBlogsEntryAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewconfigureportletavailableblogsentryap.ViewConfigurePortletAvailableBlogsEntryAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewconfigureportletcurrentblogsentryap.ViewConfigurePortletCurrentBlogsEntryAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewconfigureportletfullcontentblogsentryap.ViewConfigurePortletFullContentBlogsEntryAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewconfigureportlettableblogsentryap.ViewConfigurePortletTableBlogsEntryAPTests;
import com.liferay.portalweb.asset.blogs.blogsentry.viewconfigureportlettitlelistblogsentryap.ViewConfigurePortletTitleListBlogsEntryAPTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsEntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddNewBlogsEntryAPActionsTests.suite());
		testSuite.addTest(DeleteBlogsEntry2Tests.suite());
		testSuite.addTest(DeleteBlogsEntryAPTests.suite());
		testSuite.addTest(RateBlogsEntryAPTests.suite());
		testSuite.addTest(SelectExistingBlogsEntryAPActionsTests.suite());
		testSuite.addTest(ViewBlogsEntryOrderByColumnRatingsAPTests.suite());
		testSuite.addTest(ViewBlogsEntryScopeCurrentPageAPTests.suite());
		testSuite.addTest(ViewBlogsEntryViewCountAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletAbstractsBlogsEntryAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletAvailableBlogsEntryAPTests.suite());
		testSuite.addTest(ViewConfigurePortletCurrentBlogsEntryAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletFullContentBlogsEntryAPTests.suite());
		testSuite.addTest(ViewConfigurePortletTableBlogsEntryAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletTitleListBlogsEntryAPTests.suite());

		return testSuite;
	}

}