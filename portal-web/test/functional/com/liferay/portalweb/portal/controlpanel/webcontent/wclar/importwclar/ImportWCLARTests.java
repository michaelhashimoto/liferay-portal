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

package com.liferay.portalweb.portal.controlpanel.webcontent.wclar.importwclar;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcstructure.TearDownWCStructureTest;
import com.liferay.portalweb.portal.controlpanel.webcontent.wctemplate.addwctemplate.TearDownWCTemplateTest;
import com.liferay.portalweb.portal.controlpanel.webcontent.wctemplate.addwctemplatestructure.ViewWCTemplateStructureAddWebContentTest;
import com.liferay.portalweb.portal.controlpanel.webcontent.wctemplate.addwctemplatestructure.ViewWCTemplateStructureTest;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontent.TearDownWCWebContentTest;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontent.ViewWCWebContentTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportWCLARTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ImportWCLARTest.class);
		testSuite.addTestSuite(ViewWCWebContentTest.class);
		testSuite.addTestSuite(ViewWCTemplateStructureTest.class);
		testSuite.addTestSuite(ViewWCTemplateStructureAddWebContentTest.class);
		testSuite.addTestSuite(TearDownWCWebContentTest.class);
		testSuite.addTestSuite(TearDownWCTemplateTest.class);
		testSuite.addTestSuite(TearDownWCStructureTest.class);

		return testSuite;
	}
}