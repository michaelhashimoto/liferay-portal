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

package com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroup.AddUGUserGroupTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroupnameasterisk.AddUGUserGroupNameAsteriskTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroupnamecomma.AddUGUserGroupNameCommaTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroupnameduplicate.AddUGUserGroupNameDuplicateTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroupnamenull.AddUGUserGroupNameNullTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroupnamenumber.AddUGUserGroupNameNumberTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroups.AddUGUserGroupsTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.assignmembersugusergroupuser.AssignMembersUGUserGroupUserTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.deleteugusergroupuser.DeleteUGUserGroupUserTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.removemembersugusergroupuser.RemoveMembersUGUserGroupUserTests;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.searchugusergroup.SearchUGUserGroupTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UGUserGroupTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddUGUserGroupTests.suite());
		testSuite.addTest(AddUGUserGroupNameAsteriskTests.suite());
		testSuite.addTest(AddUGUserGroupNameCommaTests.suite());
		testSuite.addTest(AddUGUserGroupNameDuplicateTests.suite());
		testSuite.addTest(AddUGUserGroupNameNullTests.suite());
		testSuite.addTest(AddUGUserGroupNameNumberTests.suite());
		testSuite.addTest(AddUGUserGroupsTests.suite());
		testSuite.addTest(AssignMembersUGUserGroupUserTests.suite());
		testSuite.addTest(DeleteUGUserGroupUserTests.suite());
		testSuite.addTest(RemoveMembersUGUserGroupUserTests.suite());
		testSuite.addTest(SearchUGUserGroupTests.suite());

		return testSuite;
	}

}