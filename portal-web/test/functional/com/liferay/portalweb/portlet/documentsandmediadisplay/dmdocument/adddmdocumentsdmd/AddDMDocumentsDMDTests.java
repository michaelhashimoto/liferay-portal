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

package com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentsdmd;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentdmd.AddDMDocument1DMDTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentdmd.AddDMDocument2DMDTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentdmd.AddDMDocument3DMDTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentdmd.TearDownDMDocumentDMDTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.addportletdmd.AddPageDMDTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.addportletdmd.AddPortletDMDTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshowactions.ConfigurePortletDMDShowActionsTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshowfoldermenu.ConfigurePortletDMDShowFolderMenuTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshownavigationlinks.ConfigurePortletDMDShowNavigationLinksTest;
import com.liferay.portalweb.portlet.documentsandmediadisplay.portlet.configureportletdmdshowsearch.ConfigurePortletDMDShowSearchTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDMDocumentsDMDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDMDTest.class);
		testSuite.addTestSuite(AddPortletDMDTest.class);
		testSuite.addTestSuite(ConfigurePortletDMDShowFolderMenuTest.class);
		testSuite.addTestSuite(ConfigurePortletDMDShowActionsTest.class);
		testSuite.addTestSuite(ConfigurePortletDMDShowNavigationLinksTest.class);
		testSuite.addTestSuite(ConfigurePortletDMDShowSearchTest.class);
		testSuite.addTestSuite(AddDMDocument1DMDTest.class);
		testSuite.addTestSuite(AddDMDocument2DMDTest.class);
		testSuite.addTestSuite(AddDMDocument3DMDTest.class);
		testSuite.addTestSuite(ViewDMDocumentsDMDTest.class);
		testSuite.addTestSuite(TearDownDMDocumentDMDTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}