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

package com.liferay.portalweb.plugins.drools.user.usecase;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.blogs.blogsentry.addblogsentry.TearDownBlogsEntryTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPageBlogsTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogsTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class UseCaseTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageSDTest.class);
		testSuite.addTestSuite(AddPortletSDTest.class);
		testSuite.addTestSuite(AddUser1Test.class);
		testSuite.addTestSuite(AddUser1AddressTest.class);
		testSuite.addTestSuite(AssignMembersUser1SiteTest.class);
		testSuite.addTestSuite(ViewAssignMembersUser1SiteTest.class);
		testSuite.addTestSuite(AddUser2Test.class);
		testSuite.addTestSuite(AddUser2AddressTest.class);
		testSuite.addTestSuite(AssignMembersUser2SiteTest.class);
		testSuite.addTestSuite(ViewAssignMembersUser2SiteTest.class);
		testSuite.addTestSuite(AddUser3Test.class);
		testSuite.addTestSuite(AddUser3AddressTest.class);
		testSuite.addTestSuite(AssignMembersUser3SiteTest.class);
		testSuite.addTestSuite(ViewAssignMembersUser3SiteTest.class);
		testSuite.addTestSuite(AddPageBlogsTest.class);
		testSuite.addTestSuite(AddPortletBlogsTest.class);
		testSuite.addTestSuite(AddBlogsEntry1TagESTest.class);
		testSuite.addTestSuite(AddBlogsEntry2TagISTest.class);
		testSuite.addTestSuite(AddBlogsEntry3TagWCSTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User1_SignInTest.class);
		testSuite.addTestSuite(User1_ViewBlogsEntry1TagESSDTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User2_SignInTest.class);
		testSuite.addTestSuite(User2_ViewBlogsEntry2TagISSDTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User3_SignInTest.class);
		testSuite.addTestSuite(User3_ViewBlogsEntry3TagWCSSDTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownBlogsEntryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);

		return testSuite;
	}
}