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

package com.liferay.portalweb.portal.selenium.assertions;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.selenium.assertions.assertchecked.AssertCheckedTests;
import com.liferay.portalweb.portal.selenium.assertions.assertelementpresent.AssertElementPresentTests;
import com.liferay.portalweb.portal.selenium.assertions.assertpartialtext.AssertPartialTextTests;
import com.liferay.portalweb.portal.selenium.assertions.assertselectedlabel.AssertSelectedLabelTests;
import com.liferay.portalweb.portal.selenium.assertions.asserttext.AssertTextTests;
import com.liferay.portalweb.portal.selenium.assertions.asserttextpresent.AssertTextPresentTests;
import com.liferay.portalweb.portal.selenium.assertions.assertvalue.AssertValueTests;
import com.liferay.portalweb.portal.selenium.assertions.assertvisible.AssertVisibleTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertionsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AssertCheckedTests.suite());
		testSuite.addTest(AssertElementPresentTests.suite());
		testSuite.addTest(AssertPartialTextTests.suite());
		testSuite.addTest(AssertSelectedLabelTests.suite());
		testSuite.addTest(AssertTextTests.suite());
		testSuite.addTest(AssertTextPresentTests.suite());
		testSuite.addTest(AssertValueTests.suite());
		testSuite.addTest(AssertVisibleTests.suite());

		return testSuite;
	}

}