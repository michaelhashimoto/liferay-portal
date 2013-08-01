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

package com.liferay.portalweb.portal.controlpanel.polls;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PollsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddQuestionTest.class);
		testSuite.addTestSuite(AddVoteTest.class);
		testSuite.addTestSuite(ViewQuestionGraphsTest.class);
		testSuite.addTestSuite(AddQuestion2Test.class);
		testSuite.addTestSuite(EditQuestionTest.class);
		testSuite.addTestSuite(ExpireQuestionTest.class);
		testSuite.addTestSuite(AssertExpiredQuestionTest.class);
		testSuite.addTestSuite(AssertDeleteChoiceTest.class);
		testSuite.addTestSuite(AddNullTitlePollTest.class);
		testSuite.addTestSuite(AddNullDescriptionPollTest.class);
		testSuite.addTestSuite(AddNullChoicePollTest.class);
		testSuite.addTestSuite(TearDownQuestionTest.class);

		return testSuite;
	}
}