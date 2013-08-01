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

package com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.acceptmemberrequestsiteprivaterestrict.AcceptMemberRequestSitePrivateRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.addsitessitetypeprivaterestricted.AddSitesSiteTypePrivateRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.deletesitetypeprivaterestricted.DeleteSiteTypePrivateRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.denymemberrequestsitetypeprivaterestrict.DenyMemberRequestSiteTypePrivateRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.searchdeletesitetypeprivaterestricted.SearchDeleteSiteTypePrivateRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.searchdocumentdeletesiteprivaterestrict.SearchDocumentDeleteSitePrivateRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.searchsitessitetypeprivaterestricted.SearchSitesSiteTypePrivateRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.searchthreaddeletesiteprivaterestrict.SearchThreadDeleteSitePrivateRestrictTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.sousfavoritesite1typeprivaterestricted.SOUs_FavoriteSite1TypePrivateRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.sousleavesitetypeprivaterestricted.SOUs_LeaveSiteTypePrivateRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.soussearchsitessitetypeprivaterestricted.SOUs_SearchSitesSiteTypePrivateRestrictedTests;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.viewsitessitetypeprivaterestricted.ViewSitesSiteTypePrivateRestrictedTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PrivateRestrictedSiteTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AcceptMemberRequestSitePrivateRestrictTests.suite());
		testSuite.addTest(AddSitesSiteTypePrivateRestrictedTests.suite());
		testSuite.addTest(DeleteSiteTypePrivateRestrictedTests.suite());
		testSuite.addTest(
			DenyMemberRequestSiteTypePrivateRestrictTests.suite());
		testSuite.addTest(SearchDeleteSiteTypePrivateRestrictedTests.suite());
		testSuite.addTest(SearchDocumentDeleteSitePrivateRestrictTests.suite());
		testSuite.addTest(SearchSitesSiteTypePrivateRestrictedTests.suite());
		testSuite.addTest(SearchThreadDeleteSitePrivateRestrictTests.suite());
		testSuite.addTest(SOUs_FavoriteSite1TypePrivateRestrictedTests.suite());
		testSuite.addTest(SOUs_LeaveSiteTypePrivateRestrictedTests.suite());
		testSuite.addTest(
			SOUs_SearchSitesSiteTypePrivateRestrictedTests.suite());
		testSuite.addTest(ViewSitesSiteTypePrivateRestrictedTests.suite());

		return testSuite;
	}

}