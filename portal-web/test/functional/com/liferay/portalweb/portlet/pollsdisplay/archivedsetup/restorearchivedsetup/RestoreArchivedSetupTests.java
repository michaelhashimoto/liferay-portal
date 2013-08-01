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

package com.liferay.portalweb.portlet.pollsdisplay.archivedsetup.restorearchivedsetup;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.pollsdisplay.archivedsetup.savearchivedsetup.SaveArchivedSetupTest;
import com.liferay.portalweb.portlet.pollsdisplay.archivedsetup.savearchivedsetup.TearDownArchivedSetupTest;
import com.liferay.portalweb.portlet.pollsdisplay.portlet.addportletpd.AddPagePDTest;
import com.liferay.portalweb.portlet.pollsdisplay.portlet.addportletpd.AddPortletPDTest;
import com.liferay.portalweb.portlet.pollsdisplay.question.selectquestion.AddQuestionTest;
import com.liferay.portalweb.portlet.pollsdisplay.question.selectquestion.SelectQuestionTest;
import com.liferay.portalweb.portlet.pollsdisplay.question.selectquestion.TearDownQuestionTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RestoreArchivedSetupTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPagePDTest.class);
		testSuite.addTestSuite(AddPortletPDTest.class);
		testSuite.addTestSuite(AddQuestionTest.class);
		testSuite.addTestSuite(SaveArchivedSetupTest.class);
		testSuite.addTestSuite(SelectQuestionTest.class);
		testSuite.addTestSuite(RestoreArchivedSetupTest.class);
		testSuite.addTestSuite(TearDownArchivedSetupTest.class);
		testSuite.addTestSuite(TearDownQuestionTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}