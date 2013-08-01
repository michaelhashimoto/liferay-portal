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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PageScopeTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddCustomSiteBlogsPageScopeTest.class);
		testSuite.addTestSuite(AddPage1BlogsPageScopeTest.class);
		testSuite.addTestSuite(AddPage1PortletBlogsPageScopeTest.class);
		testSuite.addTestSuite(AddPage2BlogsPageScopeTest.class);
		testSuite.addTestSuite(AddPage2PortletBlogsPageScopeTest.class);
		testSuite.addTestSuite(AddPage3BlogsPageScopeTest.class);
		testSuite.addTestSuite(AddPage3PortletBlogsPageScopeTest.class);
		testSuite.addTestSuite(ConfigurePortlet1BlogsScopeDefaultTest.class);
		testSuite.addTestSuite(ConfigurePortlet2BlogsScopeLayoutCurrentPageTest.class);
		testSuite.addTestSuite(ConfigurePortlet3BlogsScopeLayoutPage2Test.class);
		testSuite.addTestSuite(AddPage1BlogsEntry1Test.class);
		testSuite.addTestSuite(AddPage1BlogsEntry1Comment1Test.class);
		testSuite.addTestSuite(AddPage1BlogsEntry1Comment2Test.class);
		testSuite.addTestSuite(RatePage1BlogsEntry1Test.class);
		testSuite.addTestSuite(RatePage1BlogsEntry1Comment1Test.class);
		testSuite.addTestSuite(RatePage1BlogsEntry1Comment2Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry2Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry2Comment1Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry2Comment2Test.class);
		testSuite.addTestSuite(RatePage2BlogsEntry2Test.class);
		testSuite.addTestSuite(RatePage2BlogsEntry2Comment1Test.class);
		testSuite.addTestSuite(RatePage2BlogsEntry2Comment2Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry3Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry4Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry5Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry6Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry7Test.class);
		testSuite.addTestSuite(AddPage2BlogsEntry8Test.class);
		testSuite.addTestSuite(ConfigurePortlet2MaximumItemsToDisplay5Test.class);
		testSuite.addTestSuite(PermissionsPage2BlogsEntry8GuestViewOffTest.class);
		testSuite.addTestSuite(ViewPage1BlogsEntry1Test.class);
		testSuite.addTestSuite(ViewPage1BlogsEntry1Comment1Test.class);
		testSuite.addTestSuite(ViewPage1BlogsEntry1Comment2Test.class);
		testSuite.addTestSuite(ViewRatePage1BlogsEntry1Test.class);
		testSuite.addTestSuite(ViewRatePage1BlogsEntry1Comment1Test.class);
		testSuite.addTestSuite(ViewRatePage1BlogsEntry1Comment2Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry2Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry2Comment1Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry2Comment2Test.class);
		testSuite.addTestSuite(ViewRatePage2BlogsEntry2Test.class);
		testSuite.addTestSuite(ViewRatePage2BlogsEntry2Comment1Test.class);
		testSuite.addTestSuite(ViewRatePage2BlogsEntry2Comment2Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry3Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry4Test.class);
		testSuite.addTestSuite(ViewConfigurePortlet2MaximumItemsToDisplay5Test.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewPage1BlogsEntry1Test.class);
		testSuite.addTestSuite(Guest_ViewPage2BlogsEntry2Test.class);
		testSuite.addTestSuite(Guest_ViewPage2BlogsEntry3Test.class);
		testSuite.addTestSuite(Guest_ViewPage2BlogsEntry8Test.class);
		testSuite.addTestSuite(Guest_ViewConfigurePortlet2MaximumItemsToDisplay5Test.class);
		testSuite.addTestSuite(SignInTest.class);

		return testSuite;
	}
}