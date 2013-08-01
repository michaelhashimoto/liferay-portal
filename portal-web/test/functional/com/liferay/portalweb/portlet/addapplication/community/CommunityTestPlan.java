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

package com.liferay.portalweb.portlet.addapplication.community;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.addapplication.community.searchbookmarks.SearchBookmarksTests;
import com.liferay.portalweb.portlet.addapplication.community.searchdirectory.SearchDirectoryTests;
import com.liferay.portalweb.portlet.addapplication.community.searchinvitation.SearchInvitationTests;
import com.liferay.portalweb.portlet.addapplication.community.searchmycommunities.SearchMyCommunitiesTests;
import com.liferay.portalweb.portlet.addapplication.community.searchpagecomments.SearchPageCommentsTests;
import com.liferay.portalweb.portlet.addapplication.community.searchpageflags.SearchPageFlagsTests;
import com.liferay.portalweb.portlet.addapplication.community.searchpageratings.SearchPageRatingsTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CommunityTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(SearchBookmarksTests.suite());
		testSuite.addTest(SearchDirectoryTests.suite());
		testSuite.addTest(SearchInvitationTests.suite());
		testSuite.addTest(SearchMyCommunitiesTests.suite());
		testSuite.addTest(SearchPageCommentsTests.suite());
		testSuite.addTest(SearchPageFlagsTests.suite());
		testSuite.addTest(SearchPageRatingsTests.suite());

		return testSuite;
	}

}