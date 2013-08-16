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

package com.liferay.portalweb.portlet.amazonrankings.portlet.removeportletar;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.amazonrankings.portlet.addportletar.AddPageARTest;
import com.liferay.portalweb.portlet.amazonrankings.portlet.addportletar.AddPortletARTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RemovePortletARTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageARTest.class);
		testSuite.addTestSuite(AddPortletARTest.class);
		testSuite.addTestSuite(RemovePortletARTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}