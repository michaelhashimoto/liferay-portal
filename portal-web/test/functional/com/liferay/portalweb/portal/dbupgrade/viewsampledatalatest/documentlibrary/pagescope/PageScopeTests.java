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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.documentlibrary.pagescope;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.Guest_ViewPage1Folder1Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.Guest_ViewPage2Folder2Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.Guest_ViewPage2Folder3Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.Guest_ViewPage2Folder4Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.Guest_ViewPage2Folder5Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.Guest_ViewPage2Folder6Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.Guest_ViewPage2Folder7Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.SignInTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewConfigurePage2PortletEntriesPerPage5Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage1DLFolder1Document1Comment1Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage1DLFolder1Document1Comment2Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage1DLFolder1Document1Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage1DLFolder1Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder2Document2Comment1Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder2Document2Comment2Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder2Document2Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder2Document3Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder2Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder3Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder4Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder5Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder6Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewPage2DLFolder7Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewRatePage1DLFolder1Document1Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ViewRatePage2DLFolder2Document2Test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PageScopeTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
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
		testSuite.addTestSuite(DownloadPage1DLFolder1Document1Test.class);
		testSuite.addTestSuite(DownloadPage2DLFolder2Document2Test.class);
		testSuite.addTestSuite(DownloadPage2DLFolder2Document3Test.class);

		return testSuite;
	}
}