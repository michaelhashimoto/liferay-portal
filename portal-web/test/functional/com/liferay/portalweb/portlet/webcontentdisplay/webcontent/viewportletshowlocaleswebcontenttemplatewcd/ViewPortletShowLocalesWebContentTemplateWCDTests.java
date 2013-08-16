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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewportletshowlocaleswebcontenttemplatewcd;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcwebcontent.addwcwebcontent.TearDownWCWebContentTest;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.language.AddPageLanguageTest;
import com.liferay.portalweb.portlet.language.AddPortletLanguageTest;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPageWCDTest;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPortletWCDTest;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletenablecommentratings.TearDownPortletSetupTest;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletshowavailablelocales.ConfigurePortletShowAvailableLocalesTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletShowLocalesWebContentTemplateWCDTests
	extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageWCDTest.class);
		testSuite.addTestSuite(AddPortletWCDTest.class);
		testSuite.addTestSuite(AddPageLanguageTest.class);
		testSuite.addTestSuite(AddPortletLanguageTest.class);
		testSuite.addTestSuite(ConfigurePortletShowAvailableLocalesTest.class);
		testSuite.addTestSuite(AddStructureLocalizedTest.class);
		testSuite.addTestSuite(AddTemplateLocalizedTest.class);
		testSuite.addTestSuite(AddWCWebContentTemplateWCDTest.class);
		testSuite.addTestSuite(LocalizeWCWebContentTemplateWCDTest.class);
		testSuite.addTestSuite(ViewPortletShowLocalesWebContentTemplateWCDTest.class);
		testSuite.addTestSuite(TearDownLanguageTest.class);
		testSuite.addTestSuite(TearDownPortletSetupTest.class);
		testSuite.addTestSuite(TearDownWCWebContentTest.class);
		testSuite.addTestSuite(TearDownTemplateTest.class);
		testSuite.addTestSuite(TearDownStructureTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}