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

package com.liferay.portalweb.portal.controlpanel.organizations;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.OrganizationTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.OrganizationAddressTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationcomment.OrganizationCommentTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationemailaddress.OrganizationEmailAddressTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationpage.OrganizationPageTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationphonenumber.OrganizationPhoneNumberTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationservice.OrganizationServiceTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationteam.OrganizationTeamTestPlan;
import com.liferay.portalweb.portal.controlpanel.organizations.organizationwebsite.OrganizationWebsiteTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(OrganizationTestPlan.suite());
		testSuite.addTest(OrganizationCommentTestPlan.suite());
		testSuite.addTest(OrganizationAddressTestPlan.suite());
		testSuite.addTest(OrganizationEmailAddressTestPlan.suite());
		testSuite.addTest(OrganizationPageTestPlan.suite());
		testSuite.addTest(OrganizationPhoneNumberTestPlan.suite());
		testSuite.addTest(OrganizationServiceTestPlan.suite());
		testSuite.addTest(OrganizationTeamTestPlan.suite());
		testSuite.addTest(OrganizationWebsiteTestPlan.suite());

		return testSuite;
	}

}