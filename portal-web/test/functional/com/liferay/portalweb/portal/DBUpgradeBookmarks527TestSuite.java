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

import com.liferay.portalweb.portal.dbupgrade.sampledata527.bookmarks.BookmarksTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata527.login.LoginTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata527.serveradministration.executegeneratecustomroles.ExecuteGenerateCustomRolesTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DBUpgradeBookmarks527TestSuite extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new NamedTestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(BookmarksTestPlan.suite());
		testSuite.addTest(ExecuteGenerateCustomRolesTests.suite());

		testSuite.addTestSuite(StopSeleniumTest.class);

		return testSuite;
	}

}