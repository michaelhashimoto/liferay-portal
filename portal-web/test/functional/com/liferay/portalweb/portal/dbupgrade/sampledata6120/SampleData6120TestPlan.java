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

package com.liferay.portalweb.portal.dbupgrade.sampledata6120;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.address.AddressTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.announcements.AnnouncementsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.announcementsdelivery.AnnouncementsDeliveryTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.bookmarks.BookmarksTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.calendar.CalendarTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.community.CommunityTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.documentlibrary.DocumentLibraryTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.expando.ExpandoTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.groups.GroupsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.messageboards.MessageBoardsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.organizations.OrganizationsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.phone.PhoneTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.polls.PollsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.portletpermissions.PortletPermissionsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.shopping.ShoppingTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.social.SocialTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.stagingcommunity.StagingCommunityTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.stagingorganization.StagingOrganizationTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.tags.TagsTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.webcontent.WebContentTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.website.WebsiteTestPlan;
import com.liferay.portalweb.portal.dbupgrade.sampledata6120.wiki.WikiTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleData6120TestPlan extends BaseTestSuite {

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
		testSuite.addTest(MessageBoardsTestPlan.suite());
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