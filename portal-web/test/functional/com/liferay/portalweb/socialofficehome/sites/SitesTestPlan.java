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

package com.liferay.portalweb.socialofficehome.sites;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.privaterestrictedsite.PrivateRestrictedSiteTestPlan;
import com.liferay.portalweb.socialofficehome.sites.privatesite.PrivateSiteTestPlan;
import com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.PublicRestrictedSiteTestPlan;
import com.liferay.portalweb.socialofficehome.sites.site.SiteTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SitesTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(PrivateRestrictedSiteTestPlan.suite());
		testSuite.addTest(PrivateSiteTestPlan.suite());
		testSuite.addTest(PublicRestrictedSiteTestPlan.suite());
		testSuite.addTest(SiteTestPlan.suite());

		return testSuite;
	}

}