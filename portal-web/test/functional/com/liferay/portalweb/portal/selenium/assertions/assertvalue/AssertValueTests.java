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

package com.liferay.portalweb.portal.selenium.assertions.assertvalue;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertValueTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AssertValue1Test.class);
		testSuite.addTestSuite(AssertValue2Test.class);
		testSuite.addTestSuite(AssertValue3Test.class);
		testSuite.addTestSuite(AssertNotValue1Test.class);
		testSuite.addTestSuite(AssertNotValue2Test.class);
		testSuite.addTestSuite(AssertNotValue3Test.class);

		return testSuite;
	}
}