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

package com.liferay.portalweb.portlet.addapplication;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.addapplication.collaboration.CollaborationTestPlan;
import com.liferay.portalweb.portlet.addapplication.community.CommunityTestPlan;
import com.liferay.portalweb.portlet.addapplication.contentmanagement.ContentManagementTestPlan;
import com.liferay.portalweb.portlet.addapplication.finance.FinanceTestPlan;
import com.liferay.portalweb.portlet.addapplication.news.NewsTestPlan;
import com.liferay.portalweb.portlet.addapplication.sample.SampleTestPlan;
import com.liferay.portalweb.portlet.addapplication.shopping.ShoppingTestPlan;
import com.liferay.portalweb.portlet.addapplication.social.SocialTestPlan;
import com.liferay.portalweb.portlet.addapplication.tools.ToolsTestPlan;
import com.liferay.portalweb.portlet.addapplication.wiki.WikiTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddApplicationTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(CollaborationTestPlan.suite());
		testSuite.addTest(CommunityTestPlan.suite());
		testSuite.addTest(ContentManagementTestPlan.suite());
		testSuite.addTest(FinanceTestPlan.suite());
		testSuite.addTest(NewsTestPlan.suite());
		testSuite.addTest(SampleTestPlan.suite());
		testSuite.addTest(ShoppingTestPlan.suite());
		testSuite.addTest(SocialTestPlan.suite());
		testSuite.addTest(ToolsTestPlan.suite());
		testSuite.addTest(WikiTestPlan.suite());

		return testSuite;
	}

}