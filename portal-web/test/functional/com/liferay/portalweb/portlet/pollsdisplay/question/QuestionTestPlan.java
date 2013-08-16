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

package com.liferay.portalweb.portlet.pollsdisplay.question;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.pollsdisplay.question.deletequestionselect.DeleteQuestionSelectTests;
import com.liferay.portalweb.portlet.pollsdisplay.question.selectquestion.SelectQuestionTests;
import com.liferay.portalweb.portlet.pollsdisplay.question.selectquestionmultiple.SelectQuestionMultipleTests;
import com.liferay.portalweb.portlet.pollsdisplay.question.selectquestionnull.SelectQuestionNullTests;
import com.liferay.portalweb.portlet.pollsdisplay.question.votequestion.VoteQuestionTests;
import com.liferay.portalweb.portlet.pollsdisplay.question.votequestionnull.VoteQuestionNullTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class QuestionTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DeleteQuestionSelectTests.suite());
		testSuite.addTest(SelectQuestionTests.suite());
		testSuite.addTest(SelectQuestionMultipleTests.suite());
		testSuite.addTest(SelectQuestionNullTests.suite());
		testSuite.addTest(VoteQuestionTests.suite());
		testSuite.addTest(VoteQuestionNullTests.suite());

		return testSuite;
	}

}