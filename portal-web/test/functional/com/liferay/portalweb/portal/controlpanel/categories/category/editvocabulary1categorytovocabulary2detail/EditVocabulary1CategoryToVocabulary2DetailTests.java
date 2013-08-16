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

package com.liferay.portalweb.portal.controlpanel.categories.category.editvocabulary1categorytovocabulary2detail;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabulary.TearDownVocabularyTest;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularymultiple.AddVocabulary1Test;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularymultiple.AddVocabulary2Test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EditVocabulary1CategoryToVocabulary2DetailTests
	extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddVocabulary1Test.class);
		testSuite.addTestSuite(AddVocabulary2Test.class);
		testSuite.addTestSuite(AddVocabulary1CategoryTest.class);
		testSuite.addTestSuite(EditVocabulary1CategoryToVocabulary2DetailTest.class);
		testSuite.addTestSuite(ViewEditVocabulary1CategoryToVocabulary2DetailTest.class);
		testSuite.addTestSuite(TearDownVocabularyTest.class);

		return testSuite;
	}
}