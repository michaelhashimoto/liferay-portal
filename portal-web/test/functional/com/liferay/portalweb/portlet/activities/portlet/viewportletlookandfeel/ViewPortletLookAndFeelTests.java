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

package com.liferay.portalweb.portlet.activities.portlet.viewportletlookandfeel;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.activities.portlet.addportletactivities.AddPageActivitiesTest;
import com.liferay.portalweb.portlet.activities.portlet.addportletactivities.AddPortletActivitiesTest;
import com.liferay.portalweb.portlet.activities.portlet.addportletactivities.TearDownMyCommunityPrivatePageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletLookAndFeelTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageActivitiesTest.class);
		testSuite.addTestSuite(AddPortletActivitiesTest.class);
		testSuite.addTestSuite(ViewPortletLookAndFeelTest.class);
		testSuite.addTestSuite(TearDownMyCommunityPrivatePageTest.class);

		return testSuite;
	}
}