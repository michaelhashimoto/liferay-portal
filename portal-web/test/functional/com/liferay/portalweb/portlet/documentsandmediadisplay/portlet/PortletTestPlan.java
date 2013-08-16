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

package com.liferay.portalweb.portlet.documentsandmediadisplay.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.addportletdmd.AddPortletDMDTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.addportletsdmd.AddPortletsDMDTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshowactions.ConfigurePortletDMDShowActionsTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshowfoldermenu.ConfigurePortletDMDShowFolderMenuTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshownavigationlinks.ConfigurePortletDMDShowNavigationLinksTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshowsearch.ConfigurePortletDMDShowSearchTests;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.removeportletdmd.RemovePortletDMDTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletDMDTests.suite());
		testSuite.addTest(AddPortletsDMDTests.suite());
		testSuite.addTest(ConfigurePortletDMDShowActionsTests.suite());
		testSuite.addTest(ConfigurePortletDMDShowFolderMenuTests.suite());
		testSuite.addTest(ConfigurePortletDMDShowNavigationLinksTests.suite());
		testSuite.addTest(ConfigurePortletDMDShowSearchTests.suite());
		testSuite.addTest(RemovePortletDMDTests.suite());

		return testSuite;
	}

}