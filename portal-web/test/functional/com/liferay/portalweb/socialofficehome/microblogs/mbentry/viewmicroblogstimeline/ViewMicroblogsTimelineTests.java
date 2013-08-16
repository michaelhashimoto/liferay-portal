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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.viewmicroblogstimeline;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentviewablebyeveryone.TearDownWHEntryContentTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMicroblogsTimelineTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddMicroblogsContent1ViewableByConnectionsTest.class);
		testSuite.addTestSuite(AddMicroblogsContent1ViewableByEveryoneTest.class);
		testSuite.addTestSuite(AddMicroblogsContent1ViewableByFollowersTest.class);
		testSuite.addTestSuite(ViewMicroblogsTimelineTest.class);
		testSuite.addTestSuite(TearDownWHEntryContentTest.class);

		return testSuite;
	}
}