/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.controlpanel.socialactivity.messageboard;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SitesSAMessageBoardDefaultValueTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSAMessageBoardSitesTest.class);
		testSuite.addTestSuite(AddSAMessageBoardSitesPublicPageTest.class);
		testSuite.addTestSuite(ConfigureCPSAMessageBoardTest.class);
		testSuite.addTestSuite(AddPortletUserStatisticsTest.class);
		testSuite.addTestSuite(ConfigurePortletUserStatisticsTest.class);
		testSuite.addTestSuite(AddPortletMessageBoardTest.class);
		testSuite.addTestSuite(AddMessageBoardThreadTest.class);
		testSuite.addTestSuite(ReplyMessageBoardThreadTest.class);
		testSuite.addTestSuite(AddNewUserTest.class);
		testSuite.addTestSuite(AssignMembersSitesTest.class);
		testSuite.addTestSuite(User_LoginUserTest.class);
		testSuite.addTestSuite(User_VoteThreadTest.class);
		testSuite.addTestSuite(User_LogoutUserTest.class);
		testSuite.addTestSuite(LoginTest.class);
		testSuite.addTestSuite(TearDownMessageBoardThreadTest.class);
		testSuite.addTestSuite(TearDownSitesTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}