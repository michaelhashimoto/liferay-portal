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

package com.liferay.portalweb.portal.permissions.controlpanel;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ControlPanelTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ControlPanelTest.class);
		testSuite.addTestSuite(CreateRolesTest.class);
		testSuite.addTestSuite(DefineCARolesTest.class);
		testSuite.addTestSuite(CA_PortalRolesTest.class);
		testSuite.addTestSuite(CA_AnnouncementsRolesTest.class);
		testSuite.addTestSuite(CA_BlogsRolesTest.class);
		testSuite.addTestSuite(CA_DocumentLibraryRolesTest.class);
		testSuite.addTestSuite(CA_ImageGalleryRolesTest.class);
		testSuite.addTestSuite(CA_MessageBoardsRolesTest.class);
		testSuite.addTestSuite(CA_WebContentDisplayRolesTest.class);
		testSuite.addTestSuite(CA_WebContentListRolesTest.class);
		testSuite.addTestSuite(CA_WebContentRolesTest.class);
		testSuite.addTestSuite(CA_WebContentSearchRolesTest.class);
		testSuite.addTestSuite(DefineMemberRolesTest.class);
		testSuite.addTestSuite(Member_AnnouncementsRolesTest.class);
		testSuite.addTestSuite(Member_BlogsRolesTest.class);
		testSuite.addTestSuite(Member_DocumentLibraryRolesTest.class);
		testSuite.addTestSuite(Member_ImageGalleryRolesTest.class);
		testSuite.addTestSuite(Member_MessageBoardsRolesTest.class);
		testSuite.addTestSuite(Member_WebContentRolesTest.class);
		testSuite.addTestSuite(DefinePublisherRolesTest.class);
		testSuite.addTestSuite(Publisher_PortalRolesTest.class);
		testSuite.addTestSuite(Publisher_WebContentRolesTest.class);
		testSuite.addTestSuite(DefineWriterRolesTest.class);
		testSuite.addTestSuite(Writer_PortalRolesTest.class);
		testSuite.addTestSuite(Writer_WebContentDisplayRolesTest.class);
		testSuite.addTestSuite(Writer_WebContentListRolesTest.class);
		testSuite.addTestSuite(Writer_WebContentRolesTest.class);
		testSuite.addTestSuite(Writer_WebContentSearchRolesTest.class);
		testSuite.addTestSuite(AddCATest.class);
		testSuite.addTestSuite(AddMemberTest.class);
		testSuite.addTestSuite(AddPortletMemberTest.class);
		testSuite.addTestSuite(AddPublisherTest.class);
		testSuite.addTestSuite(AddScopeTest.class);
		testSuite.addTestSuite(AddWriterTest.class);
		testSuite.addTestSuite(AssignMembersTest.class);
		testSuite.addTestSuite(AddScopeCommunityTest.class);
		testSuite.addTestSuite(AddScopeCommunityPageTest.class);
		testSuite.addTestSuite(AssignScopeMemberToScopeCommunityTest.class);
		testSuite.addTestSuite(LoginUsersTest.class);
		testSuite.addTestSuite(LogoutTest.class);

		return testSuite;
	}
}