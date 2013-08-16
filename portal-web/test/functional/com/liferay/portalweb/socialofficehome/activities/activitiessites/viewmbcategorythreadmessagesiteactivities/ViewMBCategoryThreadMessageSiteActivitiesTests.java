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

package com.liferay.portalweb.socialofficehome.activities.activitiessites.viewmbcategorythreadmessagesiteactivities;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.AddSitesSiteTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.TearDownSOSitesTest;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite.AddMBCategory1SiteTest;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite.AddMBCategory2SiteTest;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite.PostNewMBCategory1ThreadMessageSiteTest;
import com.liferay.portalweb.socialofficesite.forums.mbthread.postnewmbcategorythreadmessagesite.PostNewMBCategory2ThreadMessageSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBCategoryThreadMessageSiteActivitiesTests
	extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSitesSiteTest.class);
		testSuite.addTestSuite(AddMBCategory1SiteTest.class);
		testSuite.addTestSuite(AddMBCategory2SiteTest.class);
		testSuite.addTestSuite(PostNewMBCategory1ThreadMessageSiteTest.class);
		testSuite.addTestSuite(PostNewMBCategory2ThreadMessageSiteTest.class);
		testSuite.addTestSuite(ViewMBCategoryThreadMessageSiteActivitiesTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);

		return testSuite;
	}
}