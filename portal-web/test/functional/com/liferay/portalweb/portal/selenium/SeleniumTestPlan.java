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

package com.liferay.portalweb.portal.selenium;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.selenium.alerts.AlertsTestPlan;
import com.liferay.portalweb.portal.selenium.assertions.AssertionsTestPlan;
import com.liferay.portalweb.portal.selenium.browsercommands.BrowserCommandsTestPlan;
import com.liferay.portalweb.portal.selenium.clicking.ClickingTestPlan;
import com.liferay.portalweb.portal.selenium.javascript.JavascriptTestPlan;
import com.liferay.portalweb.portal.selenium.list.ListTestPlan;
import com.liferay.portalweb.portal.selenium.mouseactions.MouseActionsTestPlan;
import com.liferay.portalweb.portal.selenium.selection.SelectionTestPlan;
import com.liferay.portalweb.portal.selenium.typing.TypingTestPlan;
import com.liferay.portalweb.portal.selenium.waitfor.WaitForTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SeleniumTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AlertsTestPlan.suite());
		testSuite.addTest(AssertionsTestPlan.suite());
		testSuite.addTest(BrowserCommandsTestPlan.suite());
		testSuite.addTest(ClickingTestPlan.suite());
		testSuite.addTest(JavascriptTestPlan.suite());
		testSuite.addTest(ListTestPlan.suite());
		testSuite.addTest(MouseActionsTestPlan.suite());
		testSuite.addTest(SelectionTestPlan.suite());
		testSuite.addTest(TypingTestPlan.suite());
		testSuite.addTest(WaitForTestPlan.suite());

		return testSuite;
	}

}