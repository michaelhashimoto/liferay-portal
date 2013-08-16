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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationsteam;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganization1Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganization2Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganization3Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.TearDownOrganizationTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.editorganizationsite.EditOrganization1SiteTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.editorganizationsite.EditOrganization2SiteTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.editorganizationsite.EditOrganization3SiteTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationteam.AddOrganization1TeamTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationteam.AddOrganization2TeamTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationteam.AddOrganization3TeamTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationsTeamTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddOrganization1Test.class);
		testSuite.addTestSuite(AddOrganization2Test.class);
		testSuite.addTestSuite(AddOrganization3Test.class);
		testSuite.addTestSuite(EditOrganization1SiteTest.class);
		testSuite.addTestSuite(EditOrganization2SiteTest.class);
		testSuite.addTestSuite(EditOrganization3SiteTest.class);
		testSuite.addTestSuite(AddOrganization1TeamTest.class);
		testSuite.addTestSuite(AddOrganization2TeamTest.class);
		testSuite.addTestSuite(AddOrganization3TeamTest.class);
		testSuite.addTestSuite(ViewOrganizationsTeamTest.class);
		testSuite.addTestSuite(TearDownOrganizationTest.class);

		return testSuite;
	}
}