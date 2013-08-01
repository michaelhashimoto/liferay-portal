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

package com.liferay.portalweb.portal.controlpanel.virtualhosting;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class VirtualHostingTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddVirtualHostingCommunityTest.class);
		testSuite.addTestSuite(AddVirtualHostingPublicPageTest.class);
		testSuite.addTestSuite(AddVirtualHostingPrivatePageTest.class);
		testSuite.addTestSuite(EditFriendlyURLSlashesTest.class);
		testSuite.addTestSuite(EditFriendlyURLTest.class);
		testSuite.addTestSuite(AssertPublicPageFriendlyURLTest.class);
		testSuite.addTestSuite(AssertPrivatePageFriendlyURLTest.class);
		testSuite.addTestSuite(RestoreFriendlyURLTest.class);
		testSuite.addTestSuite(EditPublicPageURLTest.class);
		testSuite.addTestSuite(AssertPublicPageHostURLTest.class);
		testSuite.addTestSuite(RestorePublicPageURLTest.class);
		testSuite.addTestSuite(EditPrivatePageURLTest.class);
		testSuite.addTestSuite(AssertPrivatePageHostURLTest.class);
		testSuite.addTestSuite(RestorePrivatePageURLTest.class);
		testSuite.addTestSuite(TearDownCommunityTest.class);

		return testSuite;
	}
}