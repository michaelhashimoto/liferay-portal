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

package com.liferay.portalweb.socialofficehome.navigation.links;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.navigation.links.viewlinkcontactscenter.ViewLinkContactsCenterTests;
import com.liferay.portalweb.socialofficehome.navigation.links.viewlinkhome.ViewLinkHomeTests;
import com.liferay.portalweb.socialofficehome.navigation.links.viewlinkmicroblogs.ViewLinkMicroblogsTests;
import com.liferay.portalweb.socialofficehome.navigation.links.viewlinkprivatemessaging.ViewLinkPrivateMessagingTests;
import com.liferay.portalweb.socialofficehome.navigation.links.viewlinktasks.ViewLinkTasksTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class LinksTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewLinkContactsCenterTests.suite());
		testSuite.addTest(ViewLinkHomeTests.suite());
		testSuite.addTest(ViewLinkMicroblogsTests.suite());
		testSuite.addTest(ViewLinkPrivateMessagingTests.suite());
		testSuite.addTest(ViewLinkTasksTests.suite());

		return testSuite;
	}

}