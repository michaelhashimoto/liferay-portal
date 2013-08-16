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

package com.liferay.portalweb.portal.controlpanel.sites.siteportlet.addsitepublicpageschildpageportlets;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpages.AddSitePublicPage1CPTest;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpages.AddSitePublicPage2CPTest;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpages.AddSitePublicPage3CPTest;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpageschildpage.AddSitePublicPage1ChildPageCPTest;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpageschildpage.AddSitePublicPage2ChildPageCPTest;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpageschildpage.AddSitePublicPage3ChildPageCPTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSitePublicPagesChildPagePortletsTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddSitePublicPage1CPTest.class);
		testSuite.addTestSuite(AddSitePublicPage1ChildPageCPTest.class);
		testSuite.addTestSuite(AddSitePublicPage2CPTest.class);
		testSuite.addTestSuite(AddSitePublicPage2ChildPageCPTest.class);
		testSuite.addTestSuite(AddSitePublicPage3CPTest.class);
		testSuite.addTestSuite(AddSitePublicPage3ChildPageCPTest.class);
		testSuite.addTestSuite(AddPortletWCDPage1SiteTest.class);
		testSuite.addTestSuite(AddPortletLanguagePage1SiteTest.class);
		testSuite.addTestSuite(AddPortletAPPage1SiteTest.class);
		testSuite.addTestSuite(ViewPortletsPage1SiteTest.class);
		testSuite.addTestSuite(AddPortletRAPage1ChildPageSiteTest.class);
		testSuite.addTestSuite(ViewPortletsPage1ChildPageSiteTest.class);
		testSuite.addTestSuite(AddPortletWCDPage2SiteTest.class);
		testSuite.addTestSuite(AddPortletLanguagePage2SiteTest.class);
		testSuite.addTestSuite(AddPortletAPPage2SiteTest.class);
		testSuite.addTestSuite(ViewPortletsPage2SiteTest.class);
		testSuite.addTestSuite(AddPortletRAPage2ChildPageSiteTest.class);
		testSuite.addTestSuite(ViewPortletsPage2ChildPageSiteTest.class);
		testSuite.addTestSuite(AddPortletWCDPage3SiteTest.class);
		testSuite.addTestSuite(AddPortletLanguagePage3SiteTest.class);
		testSuite.addTestSuite(AddPortletAPPage3SiteTest.class);
		testSuite.addTestSuite(ViewPortletsPage3SiteTest.class);
		testSuite.addTestSuite(AddPortletRAPage3ChildPageSiteTest.class);
		testSuite.addTestSuite(ViewPortletsPage3ChildPageSiteTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}