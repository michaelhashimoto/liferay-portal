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

package com.liferay.portalweb.plugins.testlocalized;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class TestLocalizedTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageTLTest.class);
		testSuite.addTestSuite(AddPortletTLTest.class);
		testSuite.addTestSuite(ViewPortletChineseLocalizedTest.class);
		testSuite.addTestSuite(ViewPortletFrenchLocalizedTest.class);
		testSuite.addTestSuite(ViewPortletSpanishLocalizedTest.class);
		testSuite.addTestSuite(ViewPortletEnglishLocalizedTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}