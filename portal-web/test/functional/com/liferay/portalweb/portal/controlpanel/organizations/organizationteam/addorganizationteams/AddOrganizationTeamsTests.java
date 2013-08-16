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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationteams;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganizationTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.TearDownOrganizationTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.editorganizationsite.EditOrganizationSiteTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationteam.AddOrganizationTeam1Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationteam.AddOrganizationTeam2Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.addorganizationteam.AddOrganizationTeam3Test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationTeamsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddOrganizationTest.class);
		testSuite.addTestSuite(EditOrganizationSiteTest.class);
		testSuite.addTestSuite(AddOrganizationTeam1Test.class);
		testSuite.addTestSuite(AddOrganizationTeam2Test.class);
		testSuite.addTestSuite(AddOrganizationTeam3Test.class);
		testSuite.addTestSuite(ViewOrganizationTeamsTest.class);
		testSuite.addTestSuite(TearDownOrganizationTest.class);

		return testSuite;
	}
}