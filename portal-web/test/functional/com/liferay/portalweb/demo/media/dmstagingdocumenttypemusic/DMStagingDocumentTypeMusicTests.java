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

package com.liferay.portalweb.demo.media.dmstagingdocumenttypemusic;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DMStagingDocumentTypeMusicTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddPageDMSiteTest.class);
		testSuite.addTestSuite(AddPortletDMSiteTest.class);
		testSuite.addTestSuite(ConfigureDMMaximumFileSizeCPTest.class);
		testSuite.addTestSuite(AddDMMetadataSetSongInformationTest.class);
		testSuite.addTestSuite(AddDMDocumentTypeMusicTest.class);
		testSuite.addTestSuite(EditSiteStagingLocalLiveTest.class);
		testSuite.addTestSuite(AddDMMusicSiteStagingTest.class);
		testSuite.addTestSuite(ViewDMMusicSiteStagingTest.class);
		testSuite.addTestSuite(PublishToLiveNowPageDMMusicTest.class);
		testSuite.addTestSuite(ViewPublishToLiveNowPageDMMusicTest.class);
		testSuite.addTestSuite(TearDownSiteStagingTest.class);
		testSuite.addTestSuite(TearDownDMDocumentSiteTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}