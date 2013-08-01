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

package com.liferay.portalweb.portlet.directory.users.advancedsearchuser;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.directory.portlet.addportletdirectory.AddPageDirectoryTest;
import com.liferay.portalweb.portlet.directory.portlet.addportletdirectory.AddPortletDirectoryTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchUserTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDirectoryTest.class);
		testSuite.addTestSuite(AddPortletDirectoryTest.class);
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(AdvancedSearchUserEmailAddressTest.class);
		testSuite.addTestSuite(AdvancedSearchUserEmailAddressQuotesTest.class);
		testSuite.addTestSuite(AdvancedSearchUserFirstNameTest.class);
		testSuite.addTestSuite(AdvancedSearchUserFirstNameQuotesTest.class);
		testSuite.addTestSuite(AdvancedSearchUserLastNameTest.class);
		testSuite.addTestSuite(AdvancedSearchUserLastNameQuotesTest.class);
		testSuite.addTestSuite(AdvancedSearchUserMiddleNameTest.class);
		testSuite.addTestSuite(AdvancedSearchUserMiddleNameQuotesTest.class);
		testSuite.addTestSuite(AdvancedSearchUserScreenNameTest.class);
		testSuite.addTestSuite(AdvancedSearchUserScreenNameQuotesTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}