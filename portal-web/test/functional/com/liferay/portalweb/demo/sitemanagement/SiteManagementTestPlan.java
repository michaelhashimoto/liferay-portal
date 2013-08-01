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

package com.liferay.portalweb.demo.sitemanagement;

import com.liferay.portalweb.demo.sitemanagement.brazilianworldcup.BrazilianWorldCupTests;
import com.liferay.portalweb.demo.sitemanagement.staginglocallive.StagingLocalLiveTests;
import com.liferay.portalweb.demo.sitemanagement.staginglocalliveworkflow.StagingLocalLiveWorkflowTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteManagementTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(BrazilianWorldCupTests.suite());
		testSuite.addTest(StagingLocalLiveTests.suite());
		testSuite.addTest(StagingLocalLiveWorkflowTests.suite());
		return testSuite;
	}

}