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

package com.liferay.portalweb.portal.controlpanel.users.user.adduserdefaultuserassociationsusergroup;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroup.AddUGUserGroupTest;
import com.liferay.portalweb.portal.controlpanel.usergroups.ugusergroup.addugusergroup.TearDownUGUserGroupTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserDefaultUserAssociationsUserGroupTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(EnterDefaultUserAssociationsUserGroupTest.class);
		testSuite.addTestSuite(AddUGUserGroupTest.class);
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(AssertDefaultUserAssociationsUserGroupTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownUGUserGroupTest.class);
		testSuite.addTestSuite(TearDownSettingsConfigurationTest.class);

		return testSuite;
	}
}