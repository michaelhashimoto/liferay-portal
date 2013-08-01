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

package com.liferay.portalweb.demo.fundamentals.socialequityblogs;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUserPasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.AddBlogsEntryTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.TearDownBlogsEntryTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPageBlogsTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogsTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialEquityBlogsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(EnableSocialActivityBlogsEntryTest.class);
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(AddPageUserStatisticsTest.class);
		testSuite.addTestSuite(AddPortletUserStatisticsTest.class);
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(EditUserPasswordTest.class);
		testSuite.addTestSuite(ViewUSStatisticNoActivityTest.class);
		testSuite.addTestSuite(AddBlogsEntryTest.class);
		testSuite.addTestSuite(ViewUSStatisticSAAddBlogsEntryTest.class);
		testSuite.addTestSuite(AddBlogsEntryComment1Test.class);
		testSuite.addTestSuite(ViewUSStatisticSAAddBlogsEntryComment1Test.class);
		testSuite.addTestSuite(AddBlogsEntryComment2Test.class);
		testSuite.addTestSuite(ViewUSStatisticSAAddBlogsEntryComment2Test.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_AddBlogsEntryComment3Test.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(ViewUSStatisticSAAddBlogsEntryComment3Test.class);
		testSuite.addTestSuite(TearDownBlogsEntryTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}