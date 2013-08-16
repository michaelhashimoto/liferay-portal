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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope;

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
		testSuite.addTestSuite(AddCustomSiteDLPageScopeTest.class);
		testSuite.addTestSuite(AddPage1DLTest.class);
		testSuite.addTestSuite(AddPage1PortletDLTest.class);
		testSuite.addTestSuite(AddPage2DLTest.class);
		testSuite.addTestSuite(AddPage2PortletDLTest.class);
		testSuite.addTestSuite(AddPage3DLTest.class);
		testSuite.addTestSuite(AddPage3PortletDLTest.class);
		testSuite.addTestSuite(ConfigurePage1PortletDLScopeDefaultTest.class);
		testSuite.addTestSuite(ConfigurePage2PortletDLScopeLayoutCurrentPageTest.class);
		testSuite.addTestSuite(ConfigurePage3PortletDLScopeLayoutPage2Test.class);
		testSuite.addTestSuite(AddPage1DLFolder1Test.class);
		testSuite.addTestSuite(AddPage1DLFolder1Document1Test.class);
		testSuite.addTestSuite(AddPage1DLFolder1Document1Comment1Test.class);
		testSuite.addTestSuite(AddPage1DLFolder1Document1Comment2Test.class);
		testSuite.addTestSuite(RatePage1DLFolder1Document1Test.class);
		testSuite.addTestSuite(AddPage2DLFolder2Test.class);
		testSuite.addTestSuite(AddPage2DLFolder3Test.class);
		testSuite.addTestSuite(AddPage2DLFolder4Test.class);
		testSuite.addTestSuite(AddPage2DLFolder5Test.class);
		testSuite.addTestSuite(AddPage2DLFolder6Test.class);
		testSuite.addTestSuite(AddPage2DLFolder7Test.class);
		testSuite.addTestSuite(AddPage2DLFolder2Document2Test.class);
		testSuite.addTestSuite(AddPage2DLFolder2Document3Test.class);
		testSuite.addTestSuite(AddPage2DLFolder2Document2Comment1Test.class);
		testSuite.addTestSuite(AddPage2DLFolder2Document2Comment2Test.class);
		testSuite.addTestSuite(RatePage2DLFolder2Document2Test.class);
		testSuite.addTestSuite(PermissionsPage2DLFolder1GuestViewOffTest.class);
		testSuite.addTestSuite(ConfigurePage2PortletEntriesPerPage5Test.class);
		testSuite.addTestSuite(ViewPage1DLFolder1Test.class);
		testSuite.addTestSuite(ViewPage1DLFolder1Document1Test.class);
		testSuite.addTestSuite(ViewPage1DLFolder1Document1Comment1Test.class);
		testSuite.addTestSuite(ViewPage1DLFolder1Document1Comment2Test.class);
		testSuite.addTestSuite(ViewRatePage1DLFolder1Document1Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder2Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder3Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder4Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder5Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder6Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder7Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder2Document2Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder2Document3Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder2Document2Comment1Test.class);
		testSuite.addTestSuite(ViewPage2DLFolder2Document2Comment2Test.class);
		testSuite.addTestSuite(ViewRatePage2DLFolder2Document2Test.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewPage1Folder1Test.class);
		testSuite.addTestSuite(Guest_ViewPage2Folder2Test.class);
		testSuite.addTestSuite(Guest_ViewPage2Folder3Test.class);
		testSuite.addTestSuite(Guest_ViewPage2Folder4Test.class);
		testSuite.addTestSuite(Guest_ViewPage2Folder5Test.class);
		testSuite.addTestSuite(Guest_ViewPage2Folder6Test.class);
		testSuite.addTestSuite(Guest_ViewPage2Folder7Test.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(ViewConfigurePage2PortletEntriesPerPage5Test.class);

		return testSuite;
	}
}