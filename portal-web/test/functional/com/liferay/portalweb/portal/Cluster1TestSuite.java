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

package com.liferay.portalweb.portal;

import com.liferay.portalweb.portal.cluster.cluster1.Cluster1aTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1bTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1cTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1dTests;
import com.liferay.portalweb.portal.cluster.cluster1.Cluster1eTests;
import com.liferay.portalweb.portal.login.LoginTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class Cluster1TestSuite extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new NamedTestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Cluster1aTests.suite());
		testSuite.addTest(Cluster1bTests.suite());
		testSuite.addTest(Cluster1cTests.suite());
		testSuite.addTest(Cluster1dTests.suite());
		testSuite.addTest(Cluster1eTests.suite());

		return testSuite;
	}

}