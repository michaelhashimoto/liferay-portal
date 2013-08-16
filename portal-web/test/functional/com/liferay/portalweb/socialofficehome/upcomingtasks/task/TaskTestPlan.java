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

package com.liferay.portalweb.socialofficehome.upcomingtasks.task;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.socialofficehome.upcomingtasks.task.sousviewtaskstaskassignedtoconnectionut.SOUs_ViewTasksTaskAssignedToConnectionUTTests;
import com.liferay.portalweb.socialofficehome.upcomingtasks.task.viewdeletetaskstaskassignedtomeut.ViewDeleteTasksTaskAssignedToMeUTTests;
import com.liferay.portalweb.socialofficehome.upcomingtasks.task.viewresolvetaskstaskassignedtomeut.ViewResolveTasksTaskAssignedToMeUTTests;
import com.liferay.portalweb.socialofficehome.upcomingtasks.task.viewtaskstaskassignedtomemultipleut.ViewTasksTaskAssignedToMeMultipleUTTests;
import com.liferay.portalweb.socialofficehome.upcomingtasks.task.viewtaskstaskassignedtomeut.ViewTasksTaskAssignedToMeUTTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(
			SOUs_ViewTasksTaskAssignedToConnectionUTTests.suite());
		testSuite.addTest(ViewDeleteTasksTaskAssignedToMeUTTests.suite());
		testSuite.addTest(ViewResolveTasksTaskAssignedToMeUTTests.suite());
		testSuite.addTest(ViewTasksTaskAssignedToMeMultipleUTTests.suite());
		testSuite.addTest(ViewTasksTaskAssignedToMeUTTests.suite());

		return testSuite;
	}

}