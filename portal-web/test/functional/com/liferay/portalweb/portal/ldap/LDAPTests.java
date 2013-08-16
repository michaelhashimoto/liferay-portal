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

package com.liferay.portalweb.portal.ldap;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.StopSeleniumTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class LDAPTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AssertNoLDAPUsersTest.class);
		testSuite.addTestSuite(AssertNoLDAPGroupsTest.class);
		testSuite.addTestSuite(EnableLDAPTest.class);
		testSuite.addTestSuite(AddLDAPServerTest.class);
		testSuite.addTestSuite(AssertLDAPConnectionTest.class);
		testSuite.addTestSuite(AssertLDAPUsersTest.class);
		testSuite.addTestSuite(AssertLDAPGroupsTest.class);
		testSuite.addTestSuite(LogoutTest.class);
		testSuite.addTestSuite(LoginJaneLDAPTest.class);
		testSuite.addTestSuite(LogoutTest.class);
		testSuite.addTestSuite(LoginLukeLDAPTest.class);
		testSuite.addTestSuite(LogoutTest.class);
		testSuite.addTestSuite(LoginMartinLDAPTest.class);
		testSuite.addTestSuite(LogoutTest.class);
		testSuite.addTestSuite(LoginAdminTest.class);
		testSuite.addTestSuite(AssertLDAPUsersPresentTest.class);
		testSuite.addTestSuite(AssertLDAPGroupsPresentTest.class);
		testSuite.addTestSuite(StopSeleniumTest.class);

		return testSuite;
	}
}