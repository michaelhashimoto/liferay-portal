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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.address.Address606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcements.Announcements606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.announcementsdelivery.AnnouncementsDelivery606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.bookmarks.Bookmarks606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.calendar.Calendar606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.community.Community606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.documentlibrary.DocumentLibrary606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.expando.Expando606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.groups.Groups606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.login.LoginTests;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.organizations.Organizations606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.polls.Polls606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.portletpermissions.PortletPermissions606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.shopping.Shopping606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.social.Social606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingcommunity.StagingCommunity606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.stagingorganization.StagingOrganization606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.tags.Tags606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.webcontent.WebContent606LatestTestPlan;
import com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.wiki.Wiki606LatestTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewSampleData606LatestTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Address606LatestTestPlan.suite());
		testSuite.addTest(Announcements606LatestTestPlan.suite());
		testSuite.addTest(AnnouncementsDelivery606LatestTestPlan.suite());
		testSuite.addTest(Bookmarks606LatestTestPlan.suite());
		testSuite.addTest(Calendar606LatestTestPlan.suite());
		testSuite.addTest(Community606LatestTestPlan.suite());
		testSuite.addTest(DocumentLibrary606LatestTestPlan.suite());
		testSuite.addTest(Expando606LatestTestPlan.suite());
		testSuite.addTest(Groups606LatestTestPlan.suite());
		testSuite.addTest(Organizations606LatestTestPlan.suite());
		testSuite.addTest(Polls606LatestTestPlan.suite());
		testSuite.addTest(PortletPermissions606LatestTestPlan.suite());
		testSuite.addTest(Shopping606LatestTestPlan.suite());
		testSuite.addTest(Social606LatestTestPlan.suite());
		testSuite.addTest(StagingCommunity606LatestTestPlan.suite());
		testSuite.addTest(StagingOrganization606LatestTestPlan.suite());
		testSuite.addTest(Tags606LatestTestPlan.suite());
		testSuite.addTest(WebContent606LatestTestPlan.suite());
		testSuite.addTest(Wiki606LatestTestPlan.suite());

		return testSuite;
	}

}