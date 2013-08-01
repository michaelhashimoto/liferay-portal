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

package com.liferay.portalweb.portlet.documentsandmedia.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPortletDMTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdmduplicate.AddPortletDMDuplicateTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdmsite.AddPortletDMSiteTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletdocumentsperpage5.ConfigureDMPortletDocumentsPerPage5Tests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletenablecommentratings.ConfigureDMPortletEnableCommentRatingsTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletfoldersperpage5.ConfigureDMPortletFoldersPerPage5Tests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletselectfolder.ConfigureDMPortletSelectFolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletselectsubfolder.ConfigureDMPortletSelectSubfolderTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletshowdocumentcolumns.ConfigureDMPortletShowDocumentColumnsTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletshowfoldersearch.ConfigureDMPortletShowFolderSearchTests;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.removeportletdm.RemovePortletDMTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletDMTests.suite());

		testSuite.addTest(AddPortletDMDuplicateTests.suite());
		testSuite.addTest(AddPortletDMSiteTests.suite());
		testSuite.addTest(ConfigureDMPortletDocumentsPerPage5Tests.suite());
		testSuite.addTest(ConfigureDMPortletEnableCommentRatingsTests.suite());
		testSuite.addTest(ConfigureDMPortletFoldersPerPage5Tests.suite());
		testSuite.addTest(ConfigureDMPortletSelectFolderTests.suite());
		testSuite.addTest(ConfigureDMPortletSelectSubfolderTests.suite());
		testSuite.addTest(ConfigureDMPortletShowDocumentColumnsTests.suite());
		testSuite.addTest(ConfigureDMPortletShowFolderSearchTests.suite());
		testSuite.addTest(RemovePortletDMTests.suite());

		return testSuite;
	}

}