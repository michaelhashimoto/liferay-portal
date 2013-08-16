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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.messageboard;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.AddSiteTest;
import com.liferay.portalweb.portal.controlpanel.sites.site.addsite.TearDownSiteTest;
import com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.blogsentry.User_ViewUserStatisticsUnsubscribeBlogsEntry2Test;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.AddUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.adduser.TearDownUserTest;
import com.liferay.portalweb.portal.controlpanel.users.user.edituserpassword.EditUserPasswordTest;
import com.liferay.portalweb.portal.controlpanel.users.user.editusersite.EditUserSiteTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.User_SignOutTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmbsite.AddPageMBSiteTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmbsite.AddPortletMBSiteTest;
import com.liferay.portalweb.portlet.userstatistics.portlet.addportletussite.AddPageUSSiteTest;
import com.liferay.portalweb.portlet.userstatistics.portlet.addportletussite.AddPortletUSSiteTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageBoardsMessageTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSiteTest.class);
		testSuite.addTestSuite(AddPageMBSiteTest.class);
		testSuite.addTestSuite(AddPortletMBSiteTest.class);
		testSuite.addTestSuite(AddPageUSSiteTest.class);
		testSuite.addTestSuite(AddPortletUSSiteTest.class);
		testSuite.addTestSuite(EnableSocialActivityMBMessageSiteTest.class);
		testSuite.addTestSuite(ConfigurePortletShowHeaderTextOffTest.class);
		testSuite.addTestSuite(ConfigurePortletShowTotalsOffTest.class);
		testSuite.addTestSuite(ConfigurePortletAddCounter1MBMessageTest.class);
		testSuite.addTestSuite(ConfigurePortletAddCounter2SubscriptionsTest.class);
		testSuite.addTestSuite(ConfigurePortletAddCounter3VotesTest.class);
		testSuite.addTestSuite(AddMessageBoardThreadSiteTest.class);
		testSuite.addTestSuite(ViewUserStatisticsAddMessageBoardThreadTest.class);
		testSuite.addTestSuite(AddUserTest.class);
		testSuite.addTestSuite(EditUserPasswordTest.class);
		testSuite.addTestSuite(EditUserSiteTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(User_SignInTest.class);
		testSuite.addTestSuite(User_ReadMessageBoardThreadSiteTest.class);
		testSuite.addTestSuite(User_ViewUserStatisticsReadMessageBoardThreadTest.class);
		testSuite.addTestSuite(User_SubscribeMessageBoardThreadSiteTest.class);
		testSuite.addTestSuite(User_ViewUserStatisticsSubscribeMessageBoardThreadTest.class);
		testSuite.addTestSuite(User_VoteMessageBoardThreadSiteTest.class);
		testSuite.addTestSuite(User_ViewUserStatisticsVoteMessageBoardThreadTest.class);
		testSuite.addTestSuite(User_ReplyMessageBoardThreadSiteTest.class);
		testSuite.addTestSuite(User_ViewUserStatisticsReplyMessageBoardThreadTest.class);
		testSuite.addTestSuite(User_UnsubscribeMessageBoardThreadSiteTest.class);
		testSuite.addTestSuite(User_ViewUserStatisticsUnsubscribeBlogsEntry2Test.class);
		testSuite.addTestSuite(User_SignOutTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownSiteTest.class);
		testSuite.addTestSuite(TearDownUserTest.class);

		return testSuite;
	}
}