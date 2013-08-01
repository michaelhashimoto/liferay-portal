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

package com.liferay.portalweb.kaleo.workflow.workflowtask.viewpaginationtaskmbmessage;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPaginationTaskMBMessageTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ConfigureMBMessageSingleApproverTest.class);
		testSuite.addTestSuite(AddMBCategoryTest.class);
		testSuite.addTestSuite(AddMBMessage1Test.class);
		testSuite.addTestSuite(AddMBMessage2Test.class);
		testSuite.addTestSuite(AddMBMessage3Test.class);
		testSuite.addTestSuite(AddMBMessage4Test.class);
		testSuite.addTestSuite(AddMBMessage5Test.class);
		testSuite.addTestSuite(AddMBMessage6Test.class);
		testSuite.addTestSuite(AddMBMessage7Test.class);
		testSuite.addTestSuite(AddMBMessage8Test.class);
		testSuite.addTestSuite(AddMBMessage9Test.class);
		testSuite.addTestSuite(AddMBMessage10Test.class);
		testSuite.addTestSuite(AddMBMessage11Test.class);
		testSuite.addTestSuite(AddMBMessage12Test.class);
		testSuite.addTestSuite(AddMBMessage13Test.class);
		testSuite.addTestSuite(AddMBMessage14Test.class);
		testSuite.addTestSuite(AddMBMessage15Test.class);
		testSuite.addTestSuite(AddMBMessage16Test.class);
		testSuite.addTestSuite(AddMBMessage17Test.class);
		testSuite.addTestSuite(AddMBMessage18Test.class);
		testSuite.addTestSuite(AddMBMessage19Test.class);
		testSuite.addTestSuite(AddMBMessage20Test.class);
		testSuite.addTestSuite(AddMBMessage21Test.class);
		testSuite.addTestSuite(ViewPaginationTaskMBMessage20ItemsPerPageTest.class);
		testSuite.addTestSuite(ViewPaginationTaskMBMessage10ItemsPerPageTest.class);
		testSuite.addTestSuite(ViewPaginationTaskMBMessage5ItemsPerPageTest.class);
		testSuite.addTestSuite(TearDownMBCategoryTest.class);
		testSuite.addTestSuite(TearDownWorkflowConfigurationTest.class);

		return testSuite;
	}
}