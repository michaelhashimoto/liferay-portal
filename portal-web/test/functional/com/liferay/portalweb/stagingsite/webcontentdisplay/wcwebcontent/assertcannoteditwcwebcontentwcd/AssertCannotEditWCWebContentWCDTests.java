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

package com.liferay.portalweb.stagingsite.webcontentdisplay.wcwebcontent.assertcannoteditwcwebcontentwcd;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.stagingsite.sites.site.activatestaging.ActivateStagingTest;
import com.liferay.portalweb.stagingsite.sites.site.deactivatestaging.DeactivateStagingTest;
import com.liferay.portalweb.stagingsite.webcontentdisplay.wcwebcontent.asserteditwcwebcontentwcd.AssertEditWCWebContentWCDTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertCannotEditWCWebContentWCDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddSitePublicPageTest.class);
		testSuite.addTestSuite(AddPageWCDTest.class);
		testSuite.addTestSuite(AddPortletWCDTest.class);
		testSuite.addTestSuite(AddWCWebContentWCDTest.class);
		testSuite.addTestSuite(AssertEditWCWebContentWCDTest.class);
		testSuite.addTestSuite(ActivateStagingTest.class);
		testSuite.addTestSuite(AssertCannotEditWCWebContentWCDTest.class);
		testSuite.addTestSuite(DeactivateStagingTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}