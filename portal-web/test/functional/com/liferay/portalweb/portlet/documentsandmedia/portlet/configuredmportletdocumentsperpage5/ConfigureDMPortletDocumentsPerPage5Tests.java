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

package com.liferay.portalweb.portlet.documentsandmedia.portlet.configuredmportletdocumentsperpage5;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmfolderdocument.AddDMFolderDocument1Test;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmfolderdocument.AddDMFolderDocument2Test;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmfolderdocument.AddDMFolderDocument3Test;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmfolderdocument.AddDMFolderDocument4Test;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmfolderdocument.AddDMFolderDocument5Test;
import com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmfolderdocument.AddDMFolderDocument6Test;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolder.AddDMFolderTest;
import com.liferay.portalweb.portlet.documentsandmedia.dmfolder.adddmfolder.TearDownDMFolderTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPageDMTest;
import com.liferay.portalweb.portlet.documentsandmedia.portlet.addportletdm.AddPortletDMTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigureDMPortletDocumentsPerPage5Tests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDMTest.class);
		testSuite.addTestSuite(AddPortletDMTest.class);
		testSuite.addTestSuite(AddDMFolderTest.class);
		testSuite.addTestSuite(AddDMFolderDocument1Test.class);
		testSuite.addTestSuite(AddDMFolderDocument2Test.class);
		testSuite.addTestSuite(AddDMFolderDocument3Test.class);
		testSuite.addTestSuite(AddDMFolderDocument4Test.class);
		testSuite.addTestSuite(AddDMFolderDocument5Test.class);
		testSuite.addTestSuite(AddDMFolderDocument6Test.class);
		testSuite.addTestSuite(ConfigureDMPortletDocumentsPerPage20Test.class);
		testSuite.addTestSuite(ViewDMPortletDocumntsPerPage5Test.class);
		testSuite.addTestSuite(ConfigureDMPortletDocumentsPerPage5Test.class);
		testSuite.addTestSuite(ViewDMPortletDocumentsPerPage20Test.class);
		testSuite.addTestSuite(TearDownDMConfigurationTest.class);
		testSuite.addTestSuite(TearDownDMFolderTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}