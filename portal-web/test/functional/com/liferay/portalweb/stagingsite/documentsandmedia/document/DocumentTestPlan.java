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

package com.liferay.portalweb.stagingsite.documentsandmedia.document;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.adddmdocumentsitestaginglocallivedm.AddDMDocumentSiteStagingLocalLiveDMTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.adddmdocumentsitestaginglocallivenodm.AddDMDocumentSiteStagingLocalLiveNoDMTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.deletedmdocumentsitestaginglocallivedmaction.DeleteDMDocumentSiteStagingLocalLiveDMActionTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.deletelivepagesitestaginglocallivedm.DeleteLivePageSiteStagingLocalLiveDMTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.deletesitestaginglocallivedmdmdocumentaction.DeleteSiteStagingLocalLiveDMDMDocumentActionTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowdmdocumentdock.PublishToLiveNowDMDocumentDockTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowdmdocumentnodatadock.PublishToLiveNowDMDocumentNoDataDockTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowdmdocumentnodmdock.PublishToLiveNowDMDocumentNoDMDockTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowdmdocumentnopagesdock.PublishToLiveNowDMDocumentNoPagesDockTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowpagedmdock.PublishToLiveNowPageDMDockTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowpagedmnopagesdock.PublishToLiveNowPageDMNoPagesDockTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowportletdmdock.PublishToLiveNowPortletDMDockTests;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.viewactivatedeactivatesitestaginglocallivedm.ViewActivateDeactivateSiteStagingLocalLiveDMTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDMDocumentSiteStagingLocalLiveDMTests.suite());
		testSuite.addTest(AddDMDocumentSiteStagingLocalLiveNoDMTests.suite());
		testSuite.addTest(
			DeleteDMDocumentSiteStagingLocalLiveDMActionTests.suite());
		testSuite.addTest(DeleteLivePageSiteStagingLocalLiveDMTests.suite());
		testSuite.addTest(
			DeleteSiteStagingLocalLiveDMDMDocumentActionTests.suite());
		testSuite.addTest(PublishToLiveNowDMDocumentDockTests.suite());
		testSuite.addTest(PublishToLiveNowDMDocumentNoDataDockTests.suite());
		testSuite.addTest(PublishToLiveNowDMDocumentNoDMDockTests.suite());
		testSuite.addTest(PublishToLiveNowDMDocumentNoPagesDockTests.suite());
		testSuite.addTest(PublishToLiveNowPageDMDockTests.suite());
		testSuite.addTest(PublishToLiveNowPageDMNoPagesDockTests.suite());
		testSuite.addTest(PublishToLiveNowPortletDMDockTests.suite());
		testSuite.addTest(
			ViewActivateDeactivateSiteStagingLocalLiveDMTests.suite());

		return testSuite;
	}

}