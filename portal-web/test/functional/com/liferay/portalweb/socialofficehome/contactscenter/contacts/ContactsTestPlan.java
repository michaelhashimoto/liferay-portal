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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.addasconnectionccusermultiple.AddAsConnectionCCUserMultipleTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.addcontactcc.AddContactCCTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.blockccconnection.BlockCCConnectionTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.blockccuser.BlockCCUserTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.blockccusermultiple.BlockCCUserMultipleTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.editcontactcc.EditContactCCTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.followccusermultiple.FollowCCUserMultipleTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.removeasconnectionccusermultiple.RemoveAsConnectionCCUserMultipleTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.searchconnectiondropdownconnectionscc.SearchConnectionDropDownConnectionsCCTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.searchfollowingdropdownfollowingcc.SearchFollowingDropDownFollowingCCTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.searchuserdropdownallcc.SearchUserDropDownAllCCTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.sousaddasconnectionccuser.SOUs_AddAsConnectionCCUserTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.sousfollowccuser.SOUs_FollowCCUserTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.sousremoveasconnectionccuser.SOUs_RemoveAsConnectionCCUserTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.sousunfollowccuser.SOUs_UnfollowCCUserTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.sousviewccuserprofile.SOUs_ViewCCUserProfileTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.unblockccuser.UnblockCCUserTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.unblockccusermultiple.UnblockCCUserMultipleTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.unfollowccusermultiple.UnfollowCCUserMultipleTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.viewccuserprofile.ViewCCUserProfileTests;
import com.liferay.portalweb.socialofficehome.contactscenter.contacts.viewcontactmycontactscc.ViewContactMyContactsCCTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ContactsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddAsConnectionCCUserMultipleTests.suite());
		testSuite.addTest(AddContactCCTests.suite());
		testSuite.addTest(BlockCCConnectionTests.suite());
		testSuite.addTest(BlockCCUserTests.suite());
		testSuite.addTest(BlockCCUserMultipleTests.suite());
		testSuite.addTest(EditContactCCTests.suite());
		testSuite.addTest(FollowCCUserMultipleTests.suite());
		testSuite.addTest(RemoveAsConnectionCCUserMultipleTests.suite());
		testSuite.addTest(SearchConnectionDropDownConnectionsCCTests.suite());
		testSuite.addTest(SearchFollowingDropDownFollowingCCTests.suite());
		testSuite.addTest(SearchUserDropDownAllCCTests.suite());
		testSuite.addTest(SOUs_AddAsConnectionCCUserTests.suite());
		testSuite.addTest(SOUs_FollowCCUserTests.suite());
		testSuite.addTest(SOUs_RemoveAsConnectionCCUserTests.suite());
		testSuite.addTest(SOUs_UnfollowCCUserTests.suite());
		testSuite.addTest(SOUs_ViewCCUserProfileTests.suite());
		testSuite.addTest(UnblockCCUserTests.suite());
		testSuite.addTest(UnblockCCUserMultipleTests.suite());
		testSuite.addTest(UnfollowCCUserMultipleTests.suite());
		testSuite.addTest(ViewCCUserProfileTests.suite());
		testSuite.addTest(ViewContactMyContactsCCTests.suite());

		return testSuite;
	}

}