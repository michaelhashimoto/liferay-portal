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

package com.liferay.portalweb.asset.blogs.blogsentry.viewblogsentryorderbycolumnratingsap;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletapenableratings.ConfigurePortletAPEnableRatingsTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletaporderbycolumnratings.ConfigurePortletAPOrderByColumnRatingsTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletdisplaystylefullcontent.ConfigurePortletDisplayStyleFullContentTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.AddBlogsEntry1Test;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.AddBlogsEntry2Test;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.TearDownBlogsEntryTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPageBlogsTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogsTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryOrderByColumnRatingsAPTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(ConfigurePortletDisplayStyleFullContentTest.class);
		testSuite.addTestSuite(ConfigurePortletAPEnableRatingsTest.class);
		testSuite.addTestSuite(ConfigurePortletAPOrderByColumnRatingsTest.class);
		testSuite.addTestSuite(AddBlogsEntry1Test.class);
		testSuite.addTestSuite(RateBlogsEntryFiveStarsTest.class);
		testSuite.addTestSuite(AddBlogsEntry2Test.class);
		testSuite.addTestSuite(RateBlogsEntryFourStarsTest.class);
		testSuite.addTestSuite(ViewBlogsEntryOrderByColumnRatingsAPTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}