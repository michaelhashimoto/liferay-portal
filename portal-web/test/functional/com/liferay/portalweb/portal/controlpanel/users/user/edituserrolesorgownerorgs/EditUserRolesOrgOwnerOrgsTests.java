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

package com.liferay.portalweb.portal.controlpanel.users.user.edituserrolesorgownerorgs;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganization1Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganization2Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.AddOrganization3Test;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.addorganization.TearDownOrganizationTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganizationuser.AssignMembersOrganization1UserTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganizationuser.AssignMembersOrganization2UserTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganizationuser.AssignMembersOrganization3UserTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganizationuser.ViewAssignMembersOrganization1UserTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganizationuser.ViewAssignMembersOrganization2UserTest;
import com.liferay.portalweb.portal.controlpanel.organizations.organization.assignmembersorganizationuser.ViewAssignMembersOrganization3UserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EditUserRolesOrgOwnerOrgsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(AddOrganization1Test.class);
		testSuite.addTestSuite(AssignMembersOrganization1UserTest.class);
		testSuite.addTestSuite(ViewAssignMembersOrganization1UserTest.class);
		testSuite.addTestSuite(EditUserRolesOrgOwnerOrg1Test.class);
		testSuite.addTestSuite(ViewEditUserRolesOrgOwnerOrg1Test.class);
		testSuite.addTestSuite(AddOrganization2Test.class);
		testSuite.addTestSuite(AssignMembersOrganization2UserTest.class);
		testSuite.addTestSuite(ViewAssignMembersOrganization2UserTest.class);
		testSuite.addTestSuite(EditUserRolesOrgOwnerOrg2Test.class);
		testSuite.addTestSuite(ViewEditUserRolesOrgOwnerOrg2Test.class);
		testSuite.addTestSuite(AddOrganization3Test.class);
		testSuite.addTestSuite(AssignMembersOrganization3UserTest.class);
		testSuite.addTestSuite(ViewAssignMembersOrganization3UserTest.class);
		testSuite.addTestSuite(EditUserRolesOrgOwnerOrg3Test.class);
		testSuite.addTestSuite(ViewEditUserRolesOrgOwnerOrg3Test.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownOrganizationTest.class);

		return testSuite;
	}
}