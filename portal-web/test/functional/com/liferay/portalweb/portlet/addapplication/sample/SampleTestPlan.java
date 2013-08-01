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

package com.liferay.portalweb.portlet.addapplication.sample;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.addapplication.sample.searchhellovelocity.SearchHelloVelocityTests;
import com.liferay.portalweb.portlet.addapplication.sample.searchhelloworld.SearchHelloWorldTests;
import com.liferay.portalweb.portlet.addapplication.sample.searchiframe.SearchIFrameTests;
import com.liferay.portalweb.portlet.addapplication.sample.searchwebproxy.SearchWebProxyTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(SearchHelloVelocityTests.suite());
		testSuite.addTest(SearchHelloWorldTests.suite());
		testSuite.addTest(SearchIFrameTests.suite());
		testSuite.addTest(SearchWebProxyTests.suite());

		return testSuite;
	}

}