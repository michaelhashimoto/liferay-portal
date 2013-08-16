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

package com.liferay.portalweb.plugins.socialnetworking;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialNetworkingTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageSNTest.class);
		testSuite.addTestSuite(AddPortletFriendsTest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(AddPortletFATest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(AddPortletMapTest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(AddPortletMeetupsTest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(AddPortletMembersTest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(AddPortletMATest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(AddPortletSummaryTest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(AddPortletWallTest.class);
		testSuite.addTestSuite(RemovePortletSNTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}