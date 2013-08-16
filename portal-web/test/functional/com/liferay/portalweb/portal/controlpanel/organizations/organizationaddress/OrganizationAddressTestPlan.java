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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.addorganizationaddress.AddOrganizationAddressTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.addorganizationaddresscitynull.AddOrganizationAddressCityNullTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.addorganizationaddresses.AddOrganizationAddressesTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.addorganizationaddressstreetnull.AddOrganizationAddressStreetNullTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.addorganizationaddresszipnull.AddOrganizationAddressZipNullTests;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.advancedsearchorganizationaddress.AdvancedSearchOrganizationAddressTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationAddressTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddOrganizationAddressTests.suite());
		testSuite.addTest(AddOrganizationAddressCityNullTests.suite());
		testSuite.addTest(AddOrganizationAddressesTests.suite());
		testSuite.addTest(AddOrganizationAddressStreetNullTests.suite());
		testSuite.addTest(AddOrganizationAddressZipNullTests.suite());
		testSuite.addTest(AdvancedSearchOrganizationAddressTests.suite());

		return testSuite;
	}

}