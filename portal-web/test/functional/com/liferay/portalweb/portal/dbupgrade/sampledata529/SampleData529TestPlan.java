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

package com.liferay.portalweb.portal.dbupgrade.sampledata529;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.address.AddressTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.announcements.AnnouncementsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.announcementsdelivery.AnnouncementsDeliveryTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.bookmarks.BookmarksTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.calendar.CalendarTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.community.CommunityTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.documentlibrary.DocumentLibraryTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.expando.ExpandoTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.groups.GroupsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.organizations.OrganizationsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.phone.PhoneTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.polls.PollsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.portletpermissions.PortletPermissionsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.shopping.ShoppingTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.social.SocialTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.stagingcommunity.StagingCommunityTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.stagingorganization.StagingOrganizationTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.tags.TagsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.webcontent.WebContentTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.website.WebsiteTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata529.wiki.WikiTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleData529TestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddressTestPlan.suite());
		testSuite.addTest(AnnouncementsTestPlan.suite());
		testSuite.addTest(AnnouncementsDeliveryTestPlan.suite());
		testSuite.addTest(BookmarksTestPlan.suite());
		testSuite.addTest(CalendarTestPlan.suite());
		testSuite.addTest(CommunityTestPlan.suite());
		testSuite.addTest(DocumentLibraryTestPlan.suite());
		testSuite.addTest(ExpandoTestPlan.suite());
		testSuite.addTest(GroupsTestPlan.suite());
		testSuite.addTest(OrganizationsTestPlan.suite());
		testSuite.addTest(PhoneTestPlan.suite());
		testSuite.addTest(PollsTestPlan.suite());
		testSuite.addTest(PortletPermissionsTestPlan.suite());
		testSuite.addTest(ShoppingTestPlan.suite());
		testSuite.addTest(StagingCommunityTestPlan.suite());
		testSuite.addTest(StagingOrganizationTestPlan.suite());
		testSuite.addTest(TagsTestPlan.suite());
		testSuite.addTest(WebContentTestPlan.suite());
		testSuite.addTest(WebsiteTestPlan.suite());
		testSuite.addTest(WikiTestPlan.suite());
		testSuite.addTest(SocialTestPlan.suite());

		return testSuite;
	}

}