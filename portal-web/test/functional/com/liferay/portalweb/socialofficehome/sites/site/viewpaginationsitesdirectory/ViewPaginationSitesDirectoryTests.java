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

package com.liferay.portalweb.socialofficehome.sites.site.viewpaginationsitesdirectory;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessite.TearDownSOSitesTest;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite10Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite1Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite2Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite3Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite4Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite5Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite6Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite7Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite8Test;
import com.liferay.portalweb.socialofficehome.sites.site.addsitessites.AddSitesSite9Test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPaginationSitesDirectoryTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSitesSite1Test.class);
		testSuite.addTestSuite(AddSitesSite2Test.class);
		testSuite.addTestSuite(AddSitesSite3Test.class);
		testSuite.addTestSuite(AddSitesSite4Test.class);
		testSuite.addTestSuite(AddSitesSite5Test.class);
		testSuite.addTestSuite(AddSitesSite6Test.class);
		testSuite.addTestSuite(AddSitesSite7Test.class);
		testSuite.addTestSuite(AddSitesSite8Test.class);
		testSuite.addTestSuite(AddSitesSite9Test.class);
		testSuite.addTestSuite(AddSitesSite10Test.class);
		testSuite.addTestSuite(ViewPaginationSitesDirectoryTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);
		testSuite.addTestSuite(TearDownSOSitesTest.class);

		return testSuite;
	}
}