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

package com.liferay.portalweb.portlet.shopping.item.guestviewpermissionsshoppingitemguestviewoff;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignInTest;
import com.liferay.portalweb.portal.controlpanel.users.user.signin.SignOutTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.shopping.portlet.addportletshopping.AddPageShoppingTest;
import com.liferay.portalweb.portlet.shopping.portlet.addportletshopping.AddPortletShoppingTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class Guest_ViewPermissionsShoppingItemGuestViewOffTests
	extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageShoppingTest.class);
		testSuite.addTestSuite(AddPortletShoppingTest.class);
		testSuite.addTestSuite(AddShoppingItemTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewShoppingItemTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(PermissionsShoppingItemGuestViewOffTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewPermissionsShoppingItemGuestViewOffTest.class);
		testSuite.addTestSuite(SignInTest.class);
		testSuite.addTestSuite(TearDownShoppingItemTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}