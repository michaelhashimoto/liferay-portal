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

package com.liferay.portalweb.portal.controlpanel.sites.siteteam.addsitesteam;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSite1Test;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSite2Test;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSite3Test;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.addsiteteam.AddSite1TeamTest;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.addsiteteam.AddSite2TeamTest;
import com.liferay.portalweb.portal.controlpanel.sites.siteteam.addsiteteam.AddSite3TeamTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSitesTeamTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSite1Test.class);
		testSuite.addTestSuite(AddSite2Test.class);
		testSuite.addTestSuite(AddSite3Test.class);
		testSuite.addTestSuite(AddSite1TeamTest.class);
		testSuite.addTestSuite(AddSite2TeamTest.class);
		testSuite.addTestSuite(AddSite3TeamTest.class);
		testSuite.addTestSuite(ViewSitesTeamTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);

		return testSuite;
	}
}