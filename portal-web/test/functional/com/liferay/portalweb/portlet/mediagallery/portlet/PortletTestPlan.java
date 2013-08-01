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

package com.liferay.portalweb.portlet.mediagallery.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.mediagallery.portlet.addportletmg.AddPortletMGTests;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowactions.ConfigurePortletMGShowActionsTests;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowfoldermenu.ConfigurePortletMGShowFolderMenuTests;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshownavigationlinks.ConfigurePortletMGShowNavigationLinksTests;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowsearch.ConfigurePortletMGShowSearchTests;
import com.liferay.portalweb.portlet.mediagallery.portlet.removeportletmg.RemovePortletMGTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletMGTests.suite());
		testSuite.addTest(ConfigurePortletMGShowActionsTests.suite());
		testSuite.addTest(ConfigurePortletMGShowFolderMenuTests.suite());
		testSuite.addTest(ConfigurePortletMGShowNavigationLinksTests.suite());
		testSuite.addTest(ConfigurePortletMGShowSearchTests.suite());
		testSuite.addTest(RemovePortletMGTests.suite());

		return testSuite;
	}

}