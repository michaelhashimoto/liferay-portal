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

package com.liferay.portalweb.portal.controlpanel.categories.vocabulary.editvocabulary;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabulary.AddVocabularyTest;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabulary.TearDownVocabularyTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EditVocabularyTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddVocabularyTest.class);
		testSuite.addTestSuite(EditVocabularyTest.class);
		testSuite.addTestSuite(ViewEditVocabularyTest.class);
		testSuite.addTestSuite(TearDownVocabularyTest.class);

		return testSuite;
	}
}