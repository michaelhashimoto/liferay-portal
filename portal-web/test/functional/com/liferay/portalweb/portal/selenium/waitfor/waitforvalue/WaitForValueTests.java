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

package com.liferay.portalweb.portal.selenium.waitfor.waitforvalue;

import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WaitForValueTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(WaitForValue1Test.class);
		testSuite.addTestSuite(WaitForValue2Test.class);
		testSuite.addTestSuite(WaitForValue3Test.class);
		testSuite.addTestSuite(WaitForNotValue1Test.class);
		testSuite.addTestSuite(WaitForNotValue2Test.class);
		testSuite.addTestSuite(WaitForNotValue3Test.class);

		return testSuite;
	}
}