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

package com.liferay.portalweb.socialofficehome.sites.privatesite;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.privatesite.addsitessitetypeprivate.AddSitesSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.deletesitetypeprivate.DeleteSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.searchdeletesitetypeprivate.SearchDeleteSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.searchdmfolderdocumentdeletesitetypeprivate.SearchDMFolderDocumentDeleteSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.searchmbthreaddeletesitetypeprivate.SearchMBThreadDeleteSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.searchsitessitetypeprivate.SearchSitesSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.sousconfirminvitesitetypeprivate.SOUs_ConfirmInviteSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.sousfavoritesite1typeprivate.SOUs_FavoriteSite1TypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.sousignoreinvitesitetypeprivate.SOUs_IgnoreInviteSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.soussearchsitessitetypeprivate.SOUs_SearchSitesSiteTypePrivateTests;
import com.liferay.portalweb.socialofficehome.sites.privatesite.viewsitessitetypeprivate.ViewSitesSiteTypePrivateTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PrivateSiteTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSitesSiteTypePrivateTests.suite());
		testSuite.addTest(DeleteSiteTypePrivateTests.suite());
		testSuite.addTest(SearchDeleteSiteTypePrivateTests.suite());
		testSuite.addTest(
			SearchDMFolderDocumentDeleteSiteTypePrivateTests.suite());
		testSuite.addTest(SearchMBThreadDeleteSiteTypePrivateTests.suite());
		testSuite.addTest(SearchSitesSiteTypePrivateTests.suite());
		testSuite.addTest(SOUs_ConfirmInviteSiteTypePrivateTests.suite());
		testSuite.addTest(SOUs_FavoriteSite1TypePrivateTests.suite());
		testSuite.addTest(SOUs_IgnoreInviteSiteTypePrivateTests.suite());
		testSuite.addTest(SOUs_SearchSitesSiteTypePrivateTests.suite());
		testSuite.addTest(ViewSitesSiteTypePrivateTests.suite());

		return testSuite;
	}

}