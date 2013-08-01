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

package com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent;

import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentassignedtome.ViewWebContentAssignedToMeTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentassignedtomyroles.ViewWebContentAssignedToMyRolesTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentcompleted.ViewWebContentCompletedTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentrejected.ViewWebContentRejectedTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentresubmitted.ViewWebContentResubmittedTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentversion2assignedtome.ViewWebContentVersion2AssignedToMeTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentversion2assignedtomyroles.ViewWebContentVersion2AssignedToMyRolesTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentversion2completed.ViewWebContentVersion2CompletedTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentversion2rejected.ViewWebContentVersion2RejectedTests;
import com.liferay.portalweb.kaleo.webcontentdisplay.wcwebcontent.viewwebcontentversion2resubmitted.ViewWebContentVersion2ResubmittedTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WCWebContentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewWebContentAssignedToMeTests.suite());
		testSuite.addTest(ViewWebContentAssignedToMyRolesTests.suite());
		testSuite.addTest(ViewWebContentCompletedTests.suite());
		testSuite.addTest(ViewWebContentRejectedTests.suite());
		testSuite.addTest(ViewWebContentResubmittedTests.suite());
		testSuite.addTest(ViewWebContentVersion2AssignedToMeTests.suite());
		testSuite.addTest(ViewWebContentVersion2AssignedToMyRolesTests.suite());
		testSuite.addTest(ViewWebContentVersion2CompletedTests.suite());
		testSuite.addTest(ViewWebContentVersion2RejectedTests.suite());
		testSuite.addTest(ViewWebContentVersion2ResubmittedTests.suite());

		return testSuite;
	}

}