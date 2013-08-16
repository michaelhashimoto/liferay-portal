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

package com.liferay.portalweb.portlet.translator;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class TranslatorTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageTranslatorTest.class);
		testSuite.addTestSuite(AddPortletTranslatorTest.class);
		testSuite.addTestSuite(TranslateEnglishChineseCTest.class);
		testSuite.addTestSuite(TranslateEnglishChineseTTest.class);
		testSuite.addTestSuite(TranslateEnglishDutchTest.class);
		testSuite.addTestSuite(TranslateEnglishFrenchTest.class);
		testSuite.addTestSuite(TranslateEnglishGermanTest.class);
		testSuite.addTestSuite(TranslateEnglishItalianTest.class);
		testSuite.addTestSuite(TranslateEnglishJapaneseTest.class);
		testSuite.addTestSuite(TranslateEnglishPortugueseTest.class);
		testSuite.addTestSuite(TranslateEnglishSpanishTest.class);
		testSuite.addTestSuite(TranslateChineseCEnglishTest.class);
		testSuite.addTestSuite(TranslateChineseTEnglishTest.class);
		testSuite.addTestSuite(TranslateDutchEnglishTest.class);
		testSuite.addTestSuite(TranslateFrenchEnglishTest.class);
		testSuite.addTestSuite(TranslateFrenchGermanTest.class);
		testSuite.addTestSuite(TranslateGermanEnglishTest.class);
		testSuite.addTestSuite(TranslateGermanFrenchTest.class);
		testSuite.addTestSuite(TranslateItalianEnglishTest.class);
		testSuite.addTestSuite(TranslateJapaneseEnglishTest.class);
		testSuite.addTestSuite(TranslatePortugueseEnglishTest.class);
		testSuite.addTestSuite(TranslateSpanishEnglishTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}