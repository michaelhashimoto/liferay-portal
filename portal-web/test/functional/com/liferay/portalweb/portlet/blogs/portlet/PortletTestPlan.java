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

package com.liferay.portalweb.portlet.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogs.AddPortletBlogsTests;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogsduplicate.AddPortletBlogsDuplicateTests;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogsorganization.AddPortletBlogsOrganizationTests;
import com.liferay.portalweb.portlet.blogs.portlet.addportletblogssite.AddPortletBlogsSiteTests;
import com.liferay.portalweb.portlet.blogs.portlet.configureportletblogsscopecurrentpage.ConfigurePortletBlogsScopeCurrentPageTests;
import com.liferay.portalweb.portlet.blogs.portlet.configureportletdisplaystyleabstract.ConfigurePortletDisplayStyleAbstractTests;
import com.liferay.portalweb.portlet.blogs.portlet.configureportletdisplaystylefullcontent.ConfigurePortletDisplayStyleFullContentTests;
import com.liferay.portalweb.portlet.blogs.portlet.configureportletdisplaystyletitle.ConfigurePortletDisplayStyleTitleTests;
import com.liferay.portalweb.portlet.blogs.portlet.configureportletremoveallpermissions.ConfigurePortletRemoveAllPermissionTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletBlogsTests.suite());
		testSuite.addTest(AddPortletBlogsDuplicateTests.suite());
		testSuite.addTest(AddPortletBlogsOrganizationTests.suite());
		testSuite.addTest(AddPortletBlogsSiteTests.suite());
		testSuite.addTest(ConfigurePortletBlogsScopeCurrentPageTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleAbstractTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleFullContentTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleTitleTests.suite());
		testSuite.addTest(ConfigurePortletRemoveAllPermissionTests.suite());

		return testSuite;
	}

}