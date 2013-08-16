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

package com.liferay.portalweb.socialoffice.users;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialoffice.users.organizations.OrganizationsTestPlan;
import com.liferay.portalweb.socialoffice.users.sites.SitesTestPlan;
import com.liferay.portalweb.socialoffice.users.teams.TeamsTestPlan;
import com.liferay.portalweb.socialoffice.users.user.UserTestPlan;
import com.liferay.portalweb.socialoffice.users.usergroups.UsergroupTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UsersTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(OrganizationsTestPlan.suite());
		testSuite.addTest(SitesTestPlan.suite());
		testSuite.addTest(TeamsTestPlan.suite());
		testSuite.addTest(UserTestPlan.suite());
		testSuite.addTest(UsergroupTestPlan.suite());

		return testSuite;
	}

}