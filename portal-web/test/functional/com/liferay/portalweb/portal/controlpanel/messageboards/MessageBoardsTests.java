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

package com.liferay.portalweb.portal.controlpanel.messageboards;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageBoardsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddCategoryTest.class);
		testSuite.addTestSuite(AddSubcategoryTest.class);
		testSuite.addTestSuite(AddMessageTest.class);
		testSuite.addTestSuite(AddReplyMessageTest.class);
		testSuite.addTestSuite(AddSecondReplyMessageTest.class);
		testSuite.addTestSuite(AddThirdReplyMessageTest.class);
		testSuite.addTestSuite(SearchTest.class);
		testSuite.addTestSuite(SplitThreadTest.class);
		testSuite.addTestSuite(AddSecondSubcategoryTest.class);
		testSuite.addTestSuite(AddNullEntryTest.class);
		testSuite.addTestSuite(AddNullTitleTest.class);
		testSuite.addTestSuite(AddDeletableMessageTest.class);
		testSuite.addTestSuite(RecentPostsTest.class);
		testSuite.addTestSuite(AddMoveCategoryTest.class);
		testSuite.addTestSuite(MoveThreadTest.class);
		testSuite.addTestSuite(DeleteMessageTest.class);
		testSuite.addTestSuite(EditCategoryTest.class);
		testSuite.addTestSuite(EditMessageTest.class);
		testSuite.addTestSuite(AddQuestionThreadTest.class);
		testSuite.addTestSuite(AddAnswerThreadTest.class);
		testSuite.addTestSuite(TearDownMBCategoryCPTest.class);
		testSuite.addTestSuite(ImportLARTest.class);
		testSuite.addTestSuite(AssertImportLARTest.class);
		testSuite.addTestSuite(TearDownMBCategoryCPTest.class);

		return testSuite;
	}
}