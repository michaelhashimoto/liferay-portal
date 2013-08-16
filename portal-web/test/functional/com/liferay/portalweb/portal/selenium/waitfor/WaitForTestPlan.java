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

package com.liferay.portalweb.portal.selenium.waitfor;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.selenium.waitfor.waitforelementpresent.WaitForElementPresentTests;
import com.liferay.portalweb.portal.selenium.waitfor.waitforpartialtext.WaitForPartialTextTests;
import com.liferay.portalweb.portal.selenium.waitfor.waitforselectedlabel.WaitForSelectedLabelTests;
import com.liferay.portalweb.portal.selenium.waitfor.waitfortext.WaitForTextTests;
import com.liferay.portalweb.portal.selenium.waitfor.waitfortextpresent.WaitForTextPresentTests;
import com.liferay.portalweb.portal.selenium.waitfor.waitforvalue.WaitForValueTests;
import com.liferay.portalweb.portal.selenium.waitfor.waitforvisible.WaitForVisibleTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WaitForTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(WaitForElementPresentTests.suite());
		testSuite.addTest(WaitForPartialTextTests.suite());
		testSuite.addTest(WaitForSelectedLabelTests.suite());
		testSuite.addTest(WaitForTextTests.suite());
		testSuite.addTest(WaitForTextPresentTests.suite());
		testSuite.addTest(WaitForValueTests.suite());
		testSuite.addTest(WaitForVisibleTests.suite());

		return testSuite;
	}

}