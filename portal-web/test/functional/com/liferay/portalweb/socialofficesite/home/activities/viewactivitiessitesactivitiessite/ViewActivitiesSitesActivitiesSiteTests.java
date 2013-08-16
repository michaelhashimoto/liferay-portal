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

package com.liferay.portalweb.socialofficesite.home.activities.viewactivitiessitesactivitiessite;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.AddSitesSiteTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.TearDownSOSitesTest;
import com.liferay.portalweb.socialofficesite.blogs.blogsentry.addblogsentrysite.AddBlogsEntrySiteTest;
import com.liferay.portalweb.socialofficesite.calendar.calendarevent.addcalendareventsite.AddCalendarEventSiteTest;
import com.liferay.portalweb.socialofficesite.documents.dmdocument.adddmfolderdocumentsite.AddDMFolderDocumentSiteTest;
import com.liferay.portalweb.socialofficesite.documents.dmdocument.adddmfolderdocumentsite.AddDMFolderSiteTest;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite.AddMBCategorySiteTest;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite.PostNewMBCategoryThreadMessageSiteTest;
import com.liferay.portalweb.socialofficesite.home.bookmarks.addbookmarksentrysite.AddBookmarksEntrySiteTest;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.addwikifrontpagesite.AddWikiFrontPageSiteTest;
import com.liferay.portalweb.socialofficesite.wiki.wikipage.editwikifrontpagesite.EditWikiFrontPageSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewActivitiesSitesActivitiesSiteTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSitesSiteTest.class);
		testSuite.addTestSuite(AddCalendarEventSiteTest.class);
		testSuite.addTestSuite(AddDMFolderSiteTest.class);
		testSuite.addTestSuite(AddDMFolderDocumentSiteTest.class);
		testSuite.addTestSuite(AddMBCategorySiteTest.class);
		testSuite.addTestSuite(PostNewMBCategoryThreadMessageSiteTest.class);
		testSuite.addTestSuite(AddBlogsEntrySiteTest.class);
		testSuite.addTestSuite(AddWikiFrontPageSiteTest.class);
		testSuite.addTestSuite(EditWikiFrontPageSiteTest.class);
		testSuite.addTestSuite(AddBookmarksEntrySiteTest.class);
		testSuite.addTestSuite(ViewActivitiesSitesActivitiesSiteTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);

		return testSuite;
	}
}