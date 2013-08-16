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

package com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldersmg;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldermg.AddDMFolderMGTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldermg.TearDownDMFolderMGTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldermg.AddDMSubfolder1MGTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldermg.AddDMSubfolder2MGTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldermg.AddDMSubfolder3MGTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldermg.TearDownDMSubfolderMGTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.addportletmg.AddPageMGTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.addportletmg.AddPortletMGTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowactions.ConfigurePortletMGShowActionsTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowfoldermenu.ConfigurePortletMGShowFolderMenuTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshownavigationlinks.ConfigurePortletMGShowNavigationLinksTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowsearch.ViewPortletMGShowSearchCheckedTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDMSubfoldersMGTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageMGTest.class);
		testSuite.addTestSuite(AddPortletMGTest.class);
		testSuite.addTestSuite(ConfigurePortletMGShowActionsTest.class);
		testSuite.addTestSuite(ConfigurePortletMGShowFolderMenuTest.class);
		testSuite.addTestSuite(ConfigurePortletMGShowNavigationLinksTest.class);
		testSuite.addTestSuite(ViewPortletMGShowSearchCheckedTest.class);
		testSuite.addTestSuite(AddDMFolderMGTest.class);
		testSuite.addTestSuite(AddDMSubfolder1MGTest.class);
		testSuite.addTestSuite(AddDMSubfolder2MGTest.class);
		testSuite.addTestSuite(AddDMSubfolder3MGTest.class);
		testSuite.addTestSuite(ViewDMSubfoldersMGTest.class);
		testSuite.addTestSuite(TearDownDMSubfolderMGTest.class);
		testSuite.addTestSuite(TearDownDMFolderMGTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}