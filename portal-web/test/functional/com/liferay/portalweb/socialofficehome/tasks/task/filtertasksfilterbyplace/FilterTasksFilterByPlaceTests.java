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

package com.liferay.portalweb.socialofficehome.tasks.task.filtertasksfilterbyplace;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.socialofficehome.tasks.task.addtaskstaskassignedtome.TearDownTasksTaskTest;
import com.liferay.portalweb.socialofficehome.tasks.task.addtaskstaskassignedtometag.AddTasksTaskAssignedToMeTagTest;
import com.liferay.portalweb.socialofficehome.tasks.task.filtertasksfilterbytags.AddPageTasksTest;
import com.liferay.portalweb.socialofficehome.tasks.task.filtertasksfilterbytags.AddPortletTasksTest;
import com.liferay.portalweb.socialofficehome.tasks.task.filtertasksfilterbytags.AddTasksTaskAssignedToMeTagPortalTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class FilterTasksFilterByPlaceTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageTasksTest.class);
		testSuite.addTestSuite(AddPortletTasksTest.class);
		testSuite.addTestSuite(AddTasksTaskAssignedToMeTagPortalTest.class);
		testSuite.addTestSuite(AddTasksTaskAssignedToMeTagTest.class);
		testSuite.addTestSuite(FilterTasksFilterByPlaceTest.class);
		testSuite.addTestSuite(TearDownTasksTaskTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}