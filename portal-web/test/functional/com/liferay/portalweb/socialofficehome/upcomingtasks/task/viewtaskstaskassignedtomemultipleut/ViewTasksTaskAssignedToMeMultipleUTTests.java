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

package com.liferay.portalweb.socialofficehome.upcomingtasks.task.viewtaskstaskassignedtomemultipleut;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.tasks.task.addtaskstaskassignedtome.TearDownTasksTaskTest;
import com.liferay.portalweb.socialofficehome.tasks.task.addtaskstaskassignedtomemultiple.AddTasksTask1AssignedToMeTest;
import com.liferay.portalweb.socialofficehome.tasks.task.addtaskstaskassignedtomemultiple.AddTasksTask2AssignedToMeTest;
import com.liferay.portalweb.socialofficehome.tasks.task.addtaskstaskassignedtomemultiple.AddTasksTask3AssignedToMeTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewTasksTaskAssignedToMeMultipleUTTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddTasksTask1AssignedToMeTest.class);
		testSuite.addTestSuite(AddTasksTask2AssignedToMeTest.class);
		testSuite.addTestSuite(AddTasksTask3AssignedToMeTest.class);
		testSuite.addTestSuite(ViewTasksTaskAssignedToMeMultipleUTTest.class);
		testSuite.addTestSuite(TearDownTasksTaskTest.class);

		return testSuite;
	}
}