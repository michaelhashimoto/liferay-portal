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

package com.liferay.portalweb.stagingsite.documentsandmedia.document.publishtolivenowpagedmdock;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.stagingsite.documentsandmedia.document.adddmdocumentsitestaginglocallivedm.ActivateSiteStagingLocalLiveDMTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PublishToLiveNowPageDMDockTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(ActivateSiteStagingLocalLiveDMTest.class);
		testSuite.addTestSuite(AddPublicPageDMSiteStagingLocalLiveDMTest.class);
		testSuite.addTestSuite(AddPublicPagePortletDMSiteStagingLocalLiveDMTest.class);
		testSuite.addTestSuite(AddDMDocumentSiteStagingLocalLiveDMTest.class);
		testSuite.addTestSuite(PublishToLiveNowPageDMDockTest.class);
		testSuite.addTestSuite(ViewPublishToLiveNowPageDMDockTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}