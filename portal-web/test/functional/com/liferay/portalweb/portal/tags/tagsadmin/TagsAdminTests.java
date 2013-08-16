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

package com.liferay.portalweb.portal.tags.tagsadmin;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class TagsAdminTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddTagTest.class);
		testSuite.addTestSuite(AddAmpersandTagTest.class);
		testSuite.addTestSuite(AddApostropheTagTest.class);
		testSuite.addTestSuite(AddAsteriskTagTest.class);
		testSuite.addTestSuite(AddAtTagTest.class);
		testSuite.addTestSuite(AddBackSlashTagTest.class);
		testSuite.addTestSuite(AddBracketTagTest.class);
		testSuite.addTestSuite(AddCompareCharacterTagTest.class);
		testSuite.addTestSuite(AddCurlyBraceTagTest.class);
		testSuite.addTestSuite(AddColonTagTest.class);
		testSuite.addTestSuite(AddCommaTagTest.class);
		testSuite.addTestSuite(AddDuplicateTagTest.class);
		testSuite.addTestSuite(AddEqualSignTagTest.class);
		testSuite.addTestSuite(AddForwardSlashTagTest.class);
		testSuite.addTestSuite(AddNullTagTest.class);
		testSuite.addTestSuite(AddPercentTagTest.class);
		testSuite.addTestSuite(AddPlusTagTest.class);
		testSuite.addTestSuite(AddPoundTagTest.class);
		testSuite.addTestSuite(AddQuestionTagTest.class);
		testSuite.addTestSuite(AddQuoteTagTest.class);
		testSuite.addTestSuite(AddSemiColonTagTest.class);
		testSuite.addTestSuite(AddTildeTagTest.class);
		testSuite.addTestSuite(EditTagNameTest.class);
		testSuite.addTestSuite(AddPropertiesTest.class);
		testSuite.addTestSuite(ViewEditBodyCancelTest.class);
		testSuite.addTestSuite(DeleteTagTest.class);
		testSuite.addTestSuite(AddTag1Test.class);
		testSuite.addTestSuite(AddTag2Test.class);
		testSuite.addTestSuite(AddTag3Test.class);
		testSuite.addTestSuite(AddTag4Test.class);
		testSuite.addTestSuite(AddTag5Test.class);
		testSuite.addTestSuite(ViewTagOrderTest.class);
		testSuite.addTestSuite(SearchTagsTest.class);
		testSuite.addTestSuite(TearDownTagTest.class);

		return testSuite;
	}
}