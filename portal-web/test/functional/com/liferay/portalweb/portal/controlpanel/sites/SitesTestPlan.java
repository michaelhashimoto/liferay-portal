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

package com.liferay.portalweb.portal.controlpanel.sites;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.lar.LARTestPlan;
import com.liferay.portalweb.portal.controlpanel.sites.site.SiteTestPlan;
import com.liferay.portalweb.portal.controlpanel.sites.sitepage.SitePageTestPlan;
import com.liferay.portalweb.portal.controlpanel.sites.siteportlet.SitePortletTestPlan;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.SiteTeamTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SitesTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LARTestPlan.suite());
		testSuite.addTest(SiteTestPlan.suite());
		testSuite.addTest(SitePageTestPlan.suite());
		testSuite.addTest(SitePortletTestPlan.suite());
		testSuite.addTest(SiteTeamTestPlan.suite());

		return testSuite;
	}

}