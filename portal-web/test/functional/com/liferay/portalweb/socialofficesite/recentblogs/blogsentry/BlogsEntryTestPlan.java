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

package com.liferay.portalweb.socialofficesite.recentblogs.blogsentry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.configurerbselectionmethodusers.ConfigureRBSelectionMethodUsersTests;
import com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.sousviewblogsentryguestnoviewrbsite.SOUs_ViewBlogsEntryGuestNoViewRBSiteTests;
import com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.viewblogsentrymultiplerbsite.ViewBlogsEntryMultipleRBSiteTests;
import com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.viewblogsentryrbsite.ViewBlogsEntryRBSiteTests;
import com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.viewdeleteblogsentryrbsite.ViewDeleteBlogsEntryRBSiteTests;
import com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.vieweditblogsentryrbsite.ViewEditBlogsEntryRBSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsEntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ConfigureRBSelectionMethodUsersTests.suite());
		testSuite.addTest(SOUs_ViewBlogsEntryGuestNoViewRBSiteTests.suite());
		testSuite.addTest(ViewBlogsEntryMultipleRBSiteTests.suite());
		testSuite.addTest(ViewBlogsEntryRBSiteTests.suite());
		testSuite.addTest(ViewDeleteBlogsEntryRBSiteTests.suite());
		testSuite.addTest(ViewEditBlogsEntryRBSiteTests.suite());

		return testSuite;
	}

}