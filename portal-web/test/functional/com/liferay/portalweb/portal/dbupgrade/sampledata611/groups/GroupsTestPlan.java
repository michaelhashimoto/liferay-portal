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

package com.liferay.portalweb.portal.dbupgrade.sampledata611.groups;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.sampledata611.groups.groupsorgs.GroupsOrgsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata611.groups.groupsroles.GroupsRolesTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata611.groups.groupsusergroups.GroupsUserGroupsTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata611.groups.pagelayout.PageLayoutTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata611.groups.pagescope.PageScopeTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata611.groups.usergroup.UserGroupTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class GroupsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(GroupsOrgsTests.suite());
		testSuite.addTest(GroupsRolesTests.suite());
		testSuite.addTest(GroupsUserGroupsTests.suite());
		testSuite.addTest(PageLayoutTests.suite());
		testSuite.addTest(PageScopeTests.suite());
		testSuite.addTest(UserGroupTests.suite());

		return testSuite;
	}

}