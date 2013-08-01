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

package com.liferay.portalweb.portal.controlpanel.webcontent;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.webcontent.wclar.WCLARTestPlan;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.WCStructureTestPlan;
import com.liferay.portalweb.portal.controlpanel.webcontent.wctemplate.WCTemplateTestPlan;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.WCWebContentTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebContentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(WCLARTestPlan.suite());
		testSuite.addTest(WCStructureTestPlan.suite());
		testSuite.addTest(WCTemplateTestPlan.suite());
		testSuite.addTest(WCWebContentTestPlan.suite());

		return testSuite;
	}

}