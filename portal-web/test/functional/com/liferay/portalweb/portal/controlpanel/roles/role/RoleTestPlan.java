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

package com.liferay.portalweb.portal.controlpanel.roles.role;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.roles.role.addorgrole.AddOrgRoleTests;
import com.liferay.portalweb.portal.controlpanel.roles.role.addregrole.AddRegRoleTests;
import com.liferay.portalweb.portal.controlpanel.roles.role.addsiterole.AddSiteRoleTests;
import com.liferay.portalweb.portal.controlpanel.roles.role.assignmembersorgroleuser.AssignMembersOrgRoleUserTests;
import com.liferay.portalweb.portal.controlpanel.roles.role.assignmembersregroleuser.AssignMembersRegRoleUserTests;
import com.liferay.portalweb.portal.controlpanel.roles.role.assignmemberssiteroleuser.AssignMembersSiteRoleUserTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RoleTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddOrgRoleTests.suite());
		testSuite.addTest(AddRegRoleTests.suite());
		testSuite.addTest(AddSiteRoleTests.suite());
		testSuite.addTest(AssignMembersOrgRoleUserTests.suite());
		testSuite.addTest(AssignMembersRegRoleUserTests.suite());
		testSuite.addTest(AssignMembersSiteRoleUserTests.suite());

		return testSuite;
	}

}