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

package com.liferay.portalweb.demo.useradmin;

import com.liferay.portalweb.demo.useradmin.permissionsgroupcompanylevel.PermissionsGroupCompanyLevelTests;
import com.liferay.portalweb.demo.useradmin.permissionsindividualscope.PermissionsIndividualScopeTests;
import com.liferay.portalweb.demo.useradmin.permissionssitelevel.PermissionsSiteLevelTests;
import com.liferay.portalweb.demo.useradmin.permissionssitetemplate.PermissionsSiteTemplateTests;
import com.liferay.portalweb.demo.useradmin.permissionsteam.PermissionsTeamTests;
import com.liferay.portalweb.demo.useradmin.permissionsuserpersonalsite.PermissionsUserPersonalSiteTests;
import com.liferay.portalweb.demo.useradmin.usermanagementorganizations.UserManagementOrganizationsTests;
import com.liferay.portalweb.demo.useradmin.usermanagementuserprofile.UserManagementUserProfileTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UserAdminTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(PermissionsGroupCompanyLevelTests.suite());
		testSuite.addTest(PermissionsIndividualScopeTests.suite());
		testSuite.addTest(PermissionsSiteLevelTests.suite());
		testSuite.addTest(PermissionsSiteTemplateTests.suite());
		testSuite.addTest(PermissionsTeamTests.suite());
		testSuite.addTest(PermissionsUserPersonalSiteTests.suite());
		testSuite.addTest(UserManagementOrganizationsTests.suite());
		testSuite.addTest(UserManagementUserProfileTests.suite());
		return testSuite;
	}

}