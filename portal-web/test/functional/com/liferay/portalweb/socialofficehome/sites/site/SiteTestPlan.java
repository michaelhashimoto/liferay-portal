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

package com.liferay.portalweb.socialofficehome.sites.site;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.site.addsitesdefaultpagenone.AddSitesDefaultPageNoneTests;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.AddSitesSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSitesTests;
import com.liferay.portalweb.socialofficehome.sites.site.addsiteviewccuser.AddSiteViewCCUserTests;
import com.liferay.portalweb.socialofficehome.sites.site.deletesite.DeleteSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.searchdeletesite.SearchDeleteSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.searchdmfolderdocumentdeletesite.SearchDMFolderDocumentDeleteSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.searchmbthreaddeletesite.SearchMBThreadDeleteSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.searchsitesdirectory.SearchSitesDirectoryTests;
import com.liferay.portalweb.socialofficehome.sites.site.searchsitessite.SearchSitesSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.sousfavoritesite1.SOUs_FavoriteSite1Tests;
import com.liferay.portalweb.socialofficehome.sites.site.sousjoinsitessite.SOUs_JoinSitesSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.sousleavesite.SOUs_LeaveSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.soussearchsitessite.SOUs_SearchSitesSiteTests;
import com.liferay.portalweb.socialofficehome.sites.site.sousviewsiteslinksauserprofile.SOUs_ViewSitesLinkSAUserProfileTests;
import com.liferay.portalweb.socialofficehome.sites.site.viewpaginationsitesdirectory.ViewPaginationSitesDirectoryTests;
import com.liferay.portalweb.socialofficehome.sites.site.viewsitesdirectory.ViewSitesDirectoryTests;
import com.liferay.portalweb.socialofficehome.sites.site.viewsitesdirectorymysites.ViewSitesDirectoryMySitesTests;
import com.liferay.portalweb.socialofficehome.sites.site.viewsitessite.ViewSitesSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSitesDefaultPageNoneTests.suite());
		testSuite.addTest(AddSitesSiteTests.suite());
		testSuite.addTest(AddSitesSitesTests.suite());
		testSuite.addTest(AddSiteViewCCUserTests.suite());
		testSuite.addTest(DeleteSiteTests.suite());
		testSuite.addTest(SearchDeleteSiteTests.suite());
		testSuite.addTest(SearchDMFolderDocumentDeleteSiteTests.suite());
		testSuite.addTest(SearchMBThreadDeleteSiteTests.suite());
		testSuite.addTest(SearchSitesDirectoryTests.suite());
		testSuite.addTest(SearchSitesSiteTests.suite());
		testSuite.addTest(SOUs_FavoriteSite1Tests.suite());
		testSuite.addTest(SOUs_JoinSitesSiteTests.suite());
		testSuite.addTest(SOUs_LeaveSiteTests.suite());
		testSuite.addTest(SOUs_SearchSitesSiteTests.suite());
		testSuite.addTest(SOUs_ViewSitesLinkSAUserProfileTests.suite());
		testSuite.addTest(ViewPaginationSitesDirectoryTests.suite());
		testSuite.addTest(ViewSitesDirectoryTests.suite());
		testSuite.addTest(ViewSitesDirectoryMySitesTests.suite());
		testSuite.addTest(ViewSitesSiteTests.suite());

		return testSuite;
	}

}