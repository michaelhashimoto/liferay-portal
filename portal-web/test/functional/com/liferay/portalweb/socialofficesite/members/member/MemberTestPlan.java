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

package com.liferay.portalweb.socialofficesite.members.member;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficesite.members.member.sendmemberinvitesousersiterolesite.SendMemberInviteSOUserSiteRoleSiteTests;
import com.liferay.portalweb.socialofficesite.members.member.sousconfirmmemberinvitesite.SOUs_ConfirmMemberInviteSiteTests;
import com.liferay.portalweb.socialofficesite.members.member.sousignorememberinvitesite.SOUs_IgnoreMemberInviteSiteTests;
import com.liferay.portalweb.socialofficesite.members.member.viewmembersouserconnectionsite.ViewMemberSOUserConnectionSiteTests;
import com.liferay.portalweb.socialofficesite.members.member.viewmembersouserfollowingsite.ViewMemberSOUserFollowingSiteTests;
import com.liferay.portalweb.socialofficesite.members.member.viewsousermultiplejoinsite.ViewSOUserMultipleJoinSiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MemberTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(SendMemberInviteSOUserSiteRoleSiteTests.suite());
		testSuite.addTest(SOUs_ConfirmMemberInviteSiteTests.suite());
		testSuite.addTest(SOUs_IgnoreMemberInviteSiteTests.suite());
		testSuite.addTest(ViewMemberSOUserConnectionSiteTests.suite());
		testSuite.addTest(ViewMemberSOUserFollowingSiteTests.suite());
		testSuite.addTest(ViewSOUserMultipleJoinSiteTests.suite());

		return testSuite;
	}

}