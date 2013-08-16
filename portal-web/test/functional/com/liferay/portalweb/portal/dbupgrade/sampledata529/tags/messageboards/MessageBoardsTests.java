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

package com.liferay.portalweb.portal.dbupgrade.sampledata529.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageBoardsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddCommunityTagsMBTest.class);
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(AddMBCategoryTest.class);
		testSuite.addTestSuite(AddMBMessage1Tag1Test.class);
		testSuite.addTestSuite(AddMBMessage2Tag2Test.class);
		testSuite.addTestSuite(AddMBMessage3Tag3Test.class);
		testSuite.addTestSuite(AddMBMessageATagTest.class);
		testSuite.addTestSuite(AddMBMessageBTagTest.class);
		testSuite.addTestSuite(AddMBMessageCTagTest.class);
		testSuite.addTestSuite(SearchTagsTest.class);
		testSuite.addTestSuite(ViewTagsTest.class);

		return testSuite;
	}
}