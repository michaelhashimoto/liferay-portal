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

package com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry;

import com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.regrole.RegRoleTests;
import com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.regroleinline.RegRoleInlineTests;
import com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.siterole.SiteRoleTests;
import com.liferay.portalweb.permissions.blogs.blogsentry.deleteblogsentry.siteroleinline.SiteRoleInlineTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteBlogsEntryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(RegRoleInlineTests.suite());
		testSuite.addTest(RegRoleTests.suite());
		testSuite.addTest(SiteRoleInlineTests.suite());
		testSuite.addTest(SiteRoleTests.suite());

		return testSuite;
	}

}