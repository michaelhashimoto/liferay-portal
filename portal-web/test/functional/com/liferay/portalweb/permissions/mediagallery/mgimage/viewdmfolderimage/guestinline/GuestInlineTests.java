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

package com.liferay.portalweb.permissions.mediagallery.mgimage.viewdmfolderimage.guestinline;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldermg.AddDMFolderMGTest;
import com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldermg.TearDownDMFolderMGTest;
import com.liferay.portalweb.portlet.mediagallery.dmimage.adddmfolderimagemg.AddDMFolderImageMGTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.addportletmg.AddPageMGTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.addportletmg.AddPortletMGTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowactions.ConfigurePortletMGShowActionsTest;
import com.liferay.portalweb.portlet.mediagallery.portlet.configureportletmgshowfoldermenu.ConfigurePortletMGShowFolderMenuTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class GuestInlineTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageMGTest.class);
		testSuite.addTestSuite(AddPortletMGTest.class);
		testSuite.addTestSuite(ConfigurePortletMGShowFolderMenuTest.class);
		testSuite.addTestSuite(ConfigurePortletMGShowActionsTest.class);
		testSuite.addTestSuite(AddDMFolderMGTest.class);
		testSuite.addTestSuite(AddDMFolderImageMGTest.class);
		testSuite.addTestSuite(ViewGuestInlineMGFolderImageViewTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewDMFolderImageURLMGTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(RemoveGuestInlineMGFolderImageViewTest.class);
		testSuite.addTestSuite(Guest_ViewDMFolderImageURLNoMGTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownDMFolderMGTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}