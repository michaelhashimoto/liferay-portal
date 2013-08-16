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

package com.liferay.portalweb.portal;

import com.liferay.portalweb.portal.login.LoginTests;
import com.liferay.portalweb.portal.theme.ThemeTests;
import com.liferay.portalweb.portal.theme.setupthemes.SetupThemesTests;
import com.liferay.portalweb.portal.util.ThemeIds;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ThemesTestSuite extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new NamedTestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(SetupThemesTests.suite());

		for (int i = 0; i < ThemeIds.getCount(); i++) {
			testSuite.addTest(ThemeTests.suite());
		}

		testSuite.addTestSuite(StopSeleniumTest.class);

		return testSuite;
	}

}