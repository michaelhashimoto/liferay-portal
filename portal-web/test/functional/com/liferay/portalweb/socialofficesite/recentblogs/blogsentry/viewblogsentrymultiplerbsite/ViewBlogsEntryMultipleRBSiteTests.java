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

package com.liferay.portalweb.socialofficesite.recentblogs.blogsentry.viewblogsentrymultiplerbsite;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.AddSitesSiteTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.TearDownSOSitesTest;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrysite.AddBlogsEntry1SiteTest;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrysite.AddBlogsEntry2SiteTest;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrysite.AddBlogsEntry3SiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewBlogsEntryMultipleRBSiteTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSitesSiteTest.class);
		testSuite.addTestSuite(AddBlogsEntry1SiteTest.class);
		testSuite.addTestSuite(AddBlogsEntry2SiteTest.class);
		testSuite.addTestSuite(AddBlogsEntry3SiteTest.class);
		testSuite.addTestSuite(ViewBlogsEntryMultipleRBSiteTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);

		return testSuite;
	}
}