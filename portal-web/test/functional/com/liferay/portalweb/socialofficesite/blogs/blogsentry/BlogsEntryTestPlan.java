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

package com.liferay.portalweb.socialofficesite.blogs.blogsentry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrycategorysite.AddBlogsEntryCategorySiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrycommentsite.AddBlogsEntryCommentSiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrymultiplesite.AddBlogsEntryMultipleSiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrysite.AddBlogsEntrySiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrytagssite.AddBlogsEntryTagsSiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.deleteblogsentrysite.DeleteBlogsEntrySiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.editblogsentrysite.EditBlogsEntrySiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.editpermissionsblogsentry2guestnoview.EditPermissionsBlogsEntry2GuestNoViewTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.rateblogsentrysite.RateBlogsEntrySiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.sousaddblogsentrysite.SOUs_AddBlogsEntrySiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.sousdeleteblogsentrysite.SOUs_DeleteBlogsEntrySiteTests;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.souseditblogsentrysite.SOUs_EditBlogsEntrySiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class BlogsEntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddBlogsEntryCategorySiteTests.suite());
		testSuite.addTest(AddBlogsEntryCommentSiteTests.suite());
		testSuite.addTest(AddBlogsEntryMultipleSiteTests.suite());
		testSuite.addTest(AddBlogsEntrySiteTests.suite());
		testSuite.addTest(AddBlogsEntryTagsSiteTests.suite());
		testSuite.addTest(DeleteBlogsEntrySiteTests.suite());
		testSuite.addTest(EditBlogsEntrySiteTests.suite());
		testSuite.addTest(EditPermissionsBlogsEntry2GuestNoViewTests.suite());
		testSuite.addTest(RateBlogsEntrySiteTests.suite());
		testSuite.addTest(SOUs_AddBlogsEntrySiteTests.suite());
		testSuite.addTest(SOUs_DeleteBlogsEntrySiteTests.suite());
		testSuite.addTest(SOUs_EditBlogsEntrySiteTests.suite());

		return testSuite;
	}

}