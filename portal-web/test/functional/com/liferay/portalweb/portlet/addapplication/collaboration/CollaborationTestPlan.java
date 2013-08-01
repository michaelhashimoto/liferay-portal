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

package com.liferay.portalweb.portlet.addapplication.collaboration;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.addapplication.collaboration.searchblogs.SearchBlogsTests;
import com.liferay.portalweb.portlet.addapplication.collaboration.searchblogsaggregator.SearchBlogsAggregatorTests;
import com.liferay.portalweb.portlet.addapplication.collaboration.searchcalendar.SearchCalendarTests;
import com.liferay.portalweb.portlet.addapplication.collaboration.searchmessageboards.SearchMessageBoardsTests;
import com.liferay.portalweb.portlet.addapplication.collaboration.searchrecentbloggers.SearchRecentBloggersTests;
import com.liferay.portalweb.portlet.addapplication.collaboration.searchwiki.SearchWikiTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CollaborationTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(SearchBlogsTests.suite());
		testSuite.addTest(SearchBlogsAggregatorTests.suite());
		testSuite.addTest(SearchCalendarTests.suite());
		testSuite.addTest(SearchMessageBoardsTests.suite());
		testSuite.addTest(SearchRecentBloggersTests.suite());
		testSuite.addTest(SearchWikiTests.suite());

		return testSuite;
	}

}