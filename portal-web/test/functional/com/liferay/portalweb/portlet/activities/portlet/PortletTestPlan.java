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

package com.liferay.portalweb.portlet.activities.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.activities.portlet.addportletactivities.AddPortletActivitiesTests;
import com.liferay.portalweb.portlet.activities.portlet.addportletactivitiesdad.AddPortletActivitiesDADTests;
import com.liferay.portalweb.portlet.activities.portlet.addportletactivitiesduplicate.AddPortletActivitiesDuplicateTests;
import com.liferay.portalweb.portlet.activities.portlet.draganddropportletactivities.DragAndDropPortletActivitiesTests;
import com.liferay.portalweb.portlet.activities.portlet.removeportletactivities.RemovePortletActivitiesTests;
import com.liferay.portalweb.portlet.activities.portlet.viewportletlookandfeel.ViewPortletLookAndFeelTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletActivitiesTests.suite());
		testSuite.addTest(AddPortletActivitiesDADTests.suite());
		testSuite.addTest(AddPortletActivitiesDuplicateTests.suite());
		testSuite.addTest(DragAndDropPortletActivitiesTests.suite());
		testSuite.addTest(RemovePortletActivitiesTests.suite());
		testSuite.addTest(ViewPortletLookAndFeelTests.suite());

		return testSuite;
	}

}