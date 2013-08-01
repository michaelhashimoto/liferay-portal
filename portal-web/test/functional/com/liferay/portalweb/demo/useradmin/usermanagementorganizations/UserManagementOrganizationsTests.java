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

package com.liferay.portalweb.demo.useradmin.usermanagementorganizations;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UserManagementOrganizationsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(AssignUserOrganizationLiferayTest.class);
		testSuite.addTestSuite(ViewOrganizationLiferayTest.class);
		testSuite.addTestSuite(AddOrganizationTest.class);
		testSuite.addTestSuite(EditOrganizationNameTest.class);
		testSuite.addTestSuite(AddOrganizationSiteTest.class);
		testSuite.addTestSuite(AddOrganizationCategorizationTest.class);
		testSuite.addTestSuite(AddOrganizationAddressTest.class);
		testSuite.addTestSuite(AddOrganizationPhoneNumberTest.class);
		testSuite.addTestSuite(AddOrganizationInvalidEmailTest.class);
		testSuite.addTestSuite(AddOrganizationInvalidURLTest.class);
		testSuite.addTestSuite(AddOrganizationServicesTest.class);
		testSuite.addTestSuite(AddOrganizationCommentsTest.class);
		testSuite.addTestSuite(AddOrganizationReminderTest.class);
		testSuite.addTestSuite(ViewOrganizationTest.class);
		testSuite.addTestSuite(SearchOrganizationCategorizationTest.class);
		testSuite.addTestSuite(AddSubOrganization1Test.class);
		testSuite.addTestSuite(DeleteSubOrganization1Test.class);
		testSuite.addTestSuite(AddSubOrganization2Test.class);
		testSuite.addTestSuite(AssignUserSubOrganization2Test.class);
		testSuite.addTestSuite(DeleteSubOrganization2Test.class);
		testSuite.addTestSuite(AssignUserOrganizationTest.class);
		testSuite.addTestSuite(ViewSiteOrganizationTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);
		testSuite.addTestSuite(TearDownOrganizationTest.class);

		return testSuite;
	}
}