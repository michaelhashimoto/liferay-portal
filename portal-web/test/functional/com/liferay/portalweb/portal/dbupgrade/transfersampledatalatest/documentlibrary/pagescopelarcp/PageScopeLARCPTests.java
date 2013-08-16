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

package com.liferay.portalweb.portal.dbupgrade.transfersampledatalatest.documentlibrary.pagescopelarcp;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.AddCustomSiteDLPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.AddPage1DLTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.AddPage1PortletDLTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.AddPage2DLTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.AddPage2PortletDLTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.AddPage3DLTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.AddPage3PortletDLTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ConfigurePage1PortletDLScopeDefaultTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ConfigurePage2PortletDLScopeLayoutCurrentPageTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ConfigurePage2PortletEntriesPerPage5Test;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.documentlibrary.pagescope.ConfigurePage3PortletDLScopeLayoutPage2Test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PageScopeLARCPTests extends BaseTestSuite {
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
		testSuite.addTestSuite(ConfigurePage2PortletEntriesPerPage5Test.class);
		testSuite.addTestSuite(ImportExportCPLARDefaultDLPageScopeTest.class);
		testSuite.addTestSuite(ImportExportCPLARPage2DLPageScopeTest.class);

		return testSuite;
	}
}