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

package com.liferay.portalweb.portal.controlpanel.users.useraddress.searchuseraddresscp;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddress.AddUserAddressTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchUserAddressCPTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(AddUserAddressTest.class);
		testSuite.addTestSuite(SearchUserAddressCityCPTest.class);
		testSuite.addTestSuite(SearchUserAddressCountryCPTest.class);
		testSuite.addTestSuite(SearchUserAddressRegionCPTest.class);
		testSuite.addTestSuite(SearchUserAddressStreetCPTest.class);
		testSuite.addTestSuite(SearchUserAddressZipCPTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);

		return testSuite;
	}
}