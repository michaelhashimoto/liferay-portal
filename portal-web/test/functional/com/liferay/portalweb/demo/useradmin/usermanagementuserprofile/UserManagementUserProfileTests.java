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

package com.liferay.portalweb.demo.useradmin.usermanagementuserprofile;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UserManagementUserProfileTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ConfigureServerAdministrationMailTest.class);
		testSuite.addTestSuite(GmailServer_TearDownEmailTest.class);
		testSuite.addTestSuite(AddUser1Test.class);
		testSuite.addTestSuite(Gmail_ViewCPEmailTest.class);
		testSuite.addTestSuite(AssignUser1SitesTest.class);
		testSuite.addTestSuite(AssignUser1RolesTest.class);
		testSuite.addTestSuite(AddUser2Test.class);
		testSuite.addTestSuite(AddUserGroup1Test.class);
		testSuite.addTestSuite(AddUserGroup2Test.class);
		testSuite.addTestSuite(AssignUser1UserGroup1Test.class);
		testSuite.addTestSuite(AssignUser2UserGroup2Test.class);
		testSuite.addTestSuite(AddCustomFieldTest.class);
		testSuite.addTestSuite(EditUser1CustomFieldTest.class);
		testSuite.addTestSuite(DeactivateUser2Test.class);
		testSuite.addTestSuite(ReactivateUser2Test.class);
		testSuite.addTestSuite(ExportUserTest.class);
		testSuite.addTestSuite(GmailServer_TearDownEmailTest.class);
		testSuite.addTestSuite(TearDownServerTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownUserGroupTest.class);
		testSuite.addTestSuite(TearDownCustomFieldTest.class);
		testSuite.addTestSuite(EvaluateUserCSVFileTest.class);

		return testSuite;
	}
}