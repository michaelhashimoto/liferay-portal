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

package com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.acceptmemberrequestsitepublicrestrict.AcceptMemberRequestSitePublicRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.addsitessitetypepublicrestricted.AddSitesSiteTypePublicRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.deletesitetypepublicrestricted.DeleteSiteTypePublicRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.denymemberrequestsitetypepublicrestrict.DenyMemberRequestSiteTypePublicRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.searchdeletesitetypepublicrestricted.SearchDeleteSiteTypePublicRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.searchdocumentdeletesitepublicrestrict.SearchDocumentDeleteSitePublicRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.searchsitessitetypepublicrestricted.SearchSitesSiteTypePublicRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.searchthreaddeletesitepublicrestrict.SearchThreadDeleteSitePublicRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.sousfavoritesite1typepublicrestricted.SOUs_FavoriteSite1TypePublicRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.sousleavesitetypepublicrestricted.SOUs_LeaveSiteTypePublicRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.soussearchsitessitetypepublicrestricted.SOUs_SearchSitesSiteTypePublicRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.viewsitessitetypepublicrestricted.ViewSitesSiteTypePublicRestrictedTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PublicRestrictedSiteTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AcceptMemberRequestSitePublicRestrictTests.suite());
		testSuite.addTest(AddSitesSiteTypePublicRestrictedTests.suite());
		testSuite.addTest(DeleteSiteTypePublicRestrictedTests.suite());
		testSuite.addTest(DenyMemberRequestSiteTypePublicRestrictTests.suite());
		testSuite.addTest(SearchDeleteSiteTypePublicRestrictedTests.suite());
		testSuite.addTest(SearchDocumentDeleteSitePublicRestrictTests.suite());
		testSuite.addTest(SearchSitesSiteTypePublicRestrictedTests.suite());
		testSuite.addTest(SearchThreadDeleteSitePublicRestrictTests.suite());
		testSuite.addTest(SOUs_FavoriteSite1TypePublicRestrictedTests.suite());
		testSuite.addTest(SOUs_LeaveSiteTypePublicRestrictedTests.suite());
		testSuite.addTest(
			SOUs_SearchSitesSiteTypePublicRestrictedTests.suite());
		testSuite.addTest(ViewSitesSiteTypePublicRestrictedTests.suite());

		return testSuite;
	}

}