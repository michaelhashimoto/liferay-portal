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

package com.liferay.portalweb.portal.dbupgrade.transfersampledatalatest.blogs.pagescopelarportlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.AddCustomSiteBlogsPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.AddPage1BlogsPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.AddPage1PortletBlogsPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.AddPage2BlogsPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.AddPage2PortletBlogsPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.AddPage3BlogsPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.AddPage3PortletBlogsPageScopeTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.ConfigurePortlet1BlogsScopeDefaultTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.ConfigurePortlet2BlogsScopeLayoutCurrentPageTest;
import com.liferay.portalweb.portal.dbupgrade.sampledatalatest.blogs.pagescope.ConfigurePortlet3BlogsScopeLayoutPage2Test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PageScopeLARPortletTests extends BaseTestSuite {
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
		testSuite.addTestSuite(ImportExportPortletLARDefaultBlogsPageScopeTest.class);
		testSuite.addTestSuite(ImportExportPortletLARPage2BlogsPageScopeTest.class);

		return testSuite;
	}
}