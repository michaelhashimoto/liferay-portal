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

package com.liferay.portalweb.portal.selenium.selection;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.selenium.selection.selectframe.SelectFrameTests;
import com.liferay.portalweb.portal.selenium.selection.selectpopup.SelectPopUpTests;
import com.liferay.portalweb.portal.selenium.selection.selectwindow.SelectWindowTests;
import com.liferay.portalweb.portal.selenium.selection.waitforpopup.WaitForPopupTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectionTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(SelectFrameTests.suite());
		testSuite.addTest(SelectPopUpTests.suite());
		testSuite.addTest(SelectWindowTests.suite());
		testSuite.addTest(WaitForPopupTests.suite());

		return testSuite;
	}

}