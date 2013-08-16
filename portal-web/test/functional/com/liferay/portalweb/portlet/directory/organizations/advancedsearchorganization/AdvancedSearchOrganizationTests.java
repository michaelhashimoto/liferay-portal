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

package com.liferay.portalweb.portlet.directory.organizations.advancedsearchorganization;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.TearDownOrganizationTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.directory.portlet.addportletdirectory.AddPageDirectoryTest;
import com.liferay.portalweb.portlet.directory.portlet.addportletdirectory.AddPortletDirectoryTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AdvancedSearchOrganizationTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDirectoryTest.class);
		testSuite.addTestSuite(AddPortletDirectoryTest.class);
		testSuite.addTestSuite(AddOrganizationTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationCityTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationCityQuotesTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationCountryTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationNameTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationNameQuotesTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationRegionTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationStreetTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationStreetQuotesTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationTypeTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationZipTest.class);
		testSuite.addTestSuite(AdvancedSearchOrganizationZipQuotesTest.class);
		testSuite.addTestSuite(TearDownOrganizationTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}