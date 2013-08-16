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

package com.liferay.portalweb.socialofficehome.notifications.notification;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.notifications.notification.requestccaddasconnection.RequestCCAddConnnectionTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.requestprofileaddasconnection.RequestProfileAddConnnectionTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.sousconfirmnotificationjoinprivatesite.SOUs_ConfirmNotificationJoinPrivateSiteTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.sousconfirmnotificationjoinprivrstrsite.SOUs_ConfirmNotificationJoinPrivRstrSiteTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.sousconfirmnotificationjoinpubrstrsite.SOUs_ConfirmNotificationJoinPubRstrSiteTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.sousconfirmnotificationjoinsite.SOUs_ConfirmNotificationJoinSiteTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.sousviewnotificationannouncementsite.SOUs_ViewNotificationAnnouncementSiteTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.sousviewnotificationtask.SOUs_ViewNotificationTaskTests;
import com.liferay.portalweb.socialofficehome.notifications.notification.viewnotificationspaginated.ViewNotificationsPaginatedTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class NotificationTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(RequestCCAddConnnectionTests.suite());
		testSuite.addTest(RequestProfileAddConnnectionTests.suite());
		testSuite.addTest(SOUs_ConfirmNotificationJoinPrivateSiteTests.suite());
		testSuite.addTest(
			SOUs_ConfirmNotificationJoinPrivRstrSiteTests.suite());
		testSuite.addTest(SOUs_ConfirmNotificationJoinPubRstrSiteTests.suite());
		testSuite.addTest(SOUs_ConfirmNotificationJoinSiteTests.suite());
		testSuite.addTest(SOUs_ViewNotificationAnnouncementSiteTests.suite());
		testSuite.addTest(SOUs_ViewNotificationTaskTests.suite());
		testSuite.addTest(ViewNotificationsPaginatedTests.suite());

		return testSuite;
	}

}