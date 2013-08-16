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

package com.liferay.portalweb.portal.controlpanel.users.useraddress;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddress.AddUserAddressTests;
import com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddresscitynull.AddUserAddressCityNullTests;
import com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddresses.AddUserAddressesTests;
import com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddressstreetnull.AddUserAddressStreetNullTests;
import com.liferay.portalweb.portal.controlpanel.users.useraddress.adduseraddresszipnull.AddUserAddressZipNullTests;
import com.liferay.portalweb.portal.controlpanel.users.useraddress.searchuseraddresscp.SearchUserAddressCPTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UserAddressTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddUserAddressTests.suite());
		testSuite.addTest(AddUserAddressCityNullTests.suite());
		testSuite.addTest(AddUserAddressesTests.suite());
		testSuite.addTest(AddUserAddressStreetNullTests.suite());
		testSuite.addTest(AddUserAddressZipNullTests.suite());
		testSuite.addTest(SearchUserAddressCPTests.suite());

		return testSuite;
	}

}