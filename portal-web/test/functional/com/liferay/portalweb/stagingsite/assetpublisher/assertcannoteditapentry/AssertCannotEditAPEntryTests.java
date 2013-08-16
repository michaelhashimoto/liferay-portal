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

package com.liferay.portalweb.stagingsite.assetpublisher.assertcannoteditapentry;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletapsite.AddPageAPSiteTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletapsite.AddPortletAPSiteTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpage.AddSitesPublicPageTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPageBlogsSiteTest;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPortletBlogsSiteTest;
import com.liferay.portalweb.stagingsite.assetpublisher.asserteditapentry.AssertEditAPEntryTest;
import com.liferay.portalweb.stagingsite.sites.site.activatestaging.ActivateStagingTest;
import com.liferay.portalweb.stagingsite.sites.site.deactivatestaging.DeactivateStagingTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertCannotEditAPEntryTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddSitesPublicPageTest.class);
		testSuite.addTestSuite(AddPageAPSiteTest.class);
		testSuite.addTestSuite(AddPortletAPSiteTest.class);
		testSuite.addTestSuite(AddPageBlogsSiteTest.class);
		testSuite.addTestSuite(AddPortletBlogsSiteTest.class);
		testSuite.addTestSuite(AddBlogsEntryTest.class);
		testSuite.addTestSuite(AssertEditAPEntryTest.class);
		testSuite.addTestSuite(ActivateStagingTest.class);
		testSuite.addTestSuite(AssertCannotEditAPEntryTest.class);
		testSuite.addTestSuite(DeactivateStagingTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}