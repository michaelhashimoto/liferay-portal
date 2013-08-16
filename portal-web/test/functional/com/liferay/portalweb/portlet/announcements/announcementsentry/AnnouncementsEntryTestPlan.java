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

package com.liferay.portalweb.portlet.announcements.announcementsentry;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.announcements.announcementsentry.addannouncementsentrycontentnull.AddAnnouncementsEntryContentNullTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.addannouncementsentrygeneral.AddAnnouncementsEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.addannouncementsentrypriorityimportant.AddAnnouncementsEntryPriorityImportantTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.addannouncementsentryprioritynormal.AddAnnouncementsEntryPriorityNormalTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.deleteannouncementsentrygeneral.DeleteAnnouncementsEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.editannouncementsentrygeneral.EditAnnouncementsEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.hideannouncementsentrygeneral.HideAnnouncementsEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.markasreadannouncementsentrygeneral.MarkAsReadAnnouncementsEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.showannouncementsentrygeneral.ShowAnnouncementsEntryGeneralTests;
import com.liferay.portalweb.portlet.announcements.announcementsentry.viewpriorityorder.ViewPriorityOrderTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AnnouncementsEntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddAnnouncementsEntryContentNullTests.suite());
		testSuite.addTest(AddAnnouncementsEntryGeneralTests.suite());
		testSuite.addTest(AddAnnouncementsEntryPriorityImportantTests.suite());
		testSuite.addTest(AddAnnouncementsEntryPriorityNormalTests.suite());
		testSuite.addTest(ViewPriorityOrderTests.suite());
		testSuite.addTest(DeleteAnnouncementsEntryGeneralTests.suite());
		testSuite.addTest(EditAnnouncementsEntryGeneralTests.suite());
		testSuite.addTest(HideAnnouncementsEntryGeneralTests.suite());
		testSuite.addTest(MarkAsReadAnnouncementsEntryGeneralTests.suite());
		testSuite.addTest(ShowAnnouncementsEntryGeneralTests.suite());

		return testSuite;
	}

}