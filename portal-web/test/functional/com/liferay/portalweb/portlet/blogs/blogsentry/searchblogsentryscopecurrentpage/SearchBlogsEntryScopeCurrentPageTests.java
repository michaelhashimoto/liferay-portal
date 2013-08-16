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

package com.liferay.portalweb.portlet.blogs.blogsentry.searchblogsentryscopecurrentpage;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPageBlogs1Test;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPageBlogs2Test;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogs1Test;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogs2Test;
import com.liferay.portalweb.portlet.blogs.portlet.configureportletblogsscopecurrentpage.ConfigurePortletBlogs1ScopeCurrentPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchBlogsEntryScopeCurrentPageTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageBlogs1Test.class);
		testSuite.addTestSuite(AddPortletBlogs1Test.class);
		testSuite.addTestSuite(ConfigurePortletBlogs1ScopeCurrentPageTest.class);
		testSuite.addTestSuite(AddBlogsEntryPage1Test.class);
		testSuite.addTestSuite(AddPageBlogs2Test.class);
		testSuite.addTestSuite(AddPortletBlogs2Test.class);
		testSuite.addTestSuite(AddBlogsEntryPage2Test.class);
		testSuite.addTestSuite(SearchBlogsEntry1ScopeCurrentPage1Test.class);
		testSuite.addTestSuite(SearchBlogsEntry1QuotesScopeCurrentPage1Test.class);
		testSuite.addTestSuite(SearchBlogsEntry2ScopeCurrentPage1Test.class);
		testSuite.addTestSuite(SearchBlogsEntry2QuotesScopeCurrentPage1Test.class);
		testSuite.addTestSuite(TearDownBlogsEntryPage1Test.class);
		testSuite.addTestSuite(TearDownBlogsEntryPage2Test.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}