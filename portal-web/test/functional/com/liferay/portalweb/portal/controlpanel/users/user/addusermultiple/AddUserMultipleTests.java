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

package com.liferay.portalweb.portal.controlpanel.users.user.addusermultiple;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUser1Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUser2Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUser3Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.ViewUser1NoTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.ViewUser1Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.ViewUser2NoTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.ViewUser2Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.ViewUser3NoTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.ViewUser3Test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserMultipleTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUser1Test.class);
		testSuite.addTestSuite(AddUser2Test.class);
		testSuite.addTestSuite(AddUser3Test.class);
		testSuite.addTestSuite(ViewUser1Test.class);
		testSuite.addTestSuite(ViewUser2Test.class);
		testSuite.addTestSuite(ViewUser3Test.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(ViewUser1NoTest.class);
		testSuite.addTestSuite(ViewUser2NoTest.class);
		testSuite.addTestSuite(ViewUser3NoTest.class);

		return testSuite;
	}
}