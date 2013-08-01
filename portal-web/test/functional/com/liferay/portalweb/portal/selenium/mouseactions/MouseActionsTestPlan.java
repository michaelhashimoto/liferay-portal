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

package com.liferay.portalweb.portal.selenium.mouseactions;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.selenium.mouseactions.doubleclick.DoubleClickTests;
import com.liferay.portalweb.portal.selenium.mouseactions.draganddrop.DragAndDropTests;
import com.liferay.portalweb.portal.selenium.mouseactions.keydown.KeyDownTests;
import com.liferay.portalweb.portal.selenium.mouseactions.mousedown.MouseDownTests;
import com.liferay.portalweb.portal.selenium.mouseactions.mouseover.MouseOverTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MouseActionsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(DoubleClickTests.suite());
		testSuite.addTest(DragAndDropTests.suite());
		testSuite.addTest(KeyDownTests.suite());
		testSuite.addTest(MouseDownTests.suite());
		testSuite.addTest(MouseOverTests.suite());

		return testSuite;
	}

}