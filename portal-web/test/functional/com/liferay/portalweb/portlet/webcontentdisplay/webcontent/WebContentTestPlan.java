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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.addportletscopecurrentpagewcwebcontentwcd.AddPortletScopeCurrentPageWCWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.addportletscopedefaultwcwebcontentwcd.AddPortletScopeDefaultWCWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.deletethisversionwcwebcontentwcdactions.DeleteThisVersionWCWebContentWCDActionsTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.editwcwebcontentwcddetails.EditWCWebContentWCDDetailsTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.expirethisversionwcwebcontentwcddetails.ExpireThisVersionWCWebContentWCDDetailsTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.localizewcwebcontenttemplatewcd.LocalizeWCWebContentTemplateWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.localizewcwebcontentwcd.LocalizeWCWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.ratewcwebcontentwcd.RateWCWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.searchwcwebcontentwcd.SearchWCWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.selectportletscopepage2wcwebcontentwcd.SelectPortletScopePage2WCWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.selectwcwebcontentwcd.SelectWCWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewlocalizewebcontentlanguagewcd.ViewLocalizeWebContentLanguageWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewlocalizewebcontenttemplatelanguagewcd.ViewLocalizeWebContentTemplateLanguageWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewportletshowlocaleswebcontenttemplatewcd.ViewPortletShowLocalesWebContentTemplateWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewportletshowlocaleswebcontentwcd.ViewPortletShowLocalesWebContentWCDTests;
import com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewwcwebcontentscopeglobalwcd.ViewWCWebContentScopeGlobalWCDTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebContentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(
			AddPortletScopeCurrentPageWCWebContentWCDTests.suite());
		testSuite.addTest(AddPortletScopeDefaultWCWebContentWCDTests.suite());
		testSuite.addTest(DeleteThisVersionWCWebContentWCDActionsTests.suite());
		testSuite.addTest(EditWCWebContentWCDDetailsTests.suite());
		testSuite.addTest(ExpireThisVersionWCWebContentWCDDetailsTests.suite());
		testSuite.addTest(LocalizeWCWebContentTemplateWCDTests.suite());
		testSuite.addTest(LocalizeWCWebContentWCDTests.suite());
		testSuite.addTest(RateWCWebContentWCDTests.suite());
		testSuite.addTest(SearchWCWebContentWCDTests.suite());
		testSuite.addTest(SelectPortletScopePage2WCWebContentWCDTests.suite());
		testSuite.addTest(SelectWCWebContentWCDTests.suite());
		testSuite.addTest(ViewLocalizeWebContentLanguageWCDTests.suite());
		testSuite.addTest(
			ViewLocalizeWebContentTemplateLanguageWCDTests.suite());
		testSuite.addTest(
			ViewPortletShowLocalesWebContentTemplateWCDTests.suite());
		testSuite.addTest(ViewPortletShowLocalesWebContentWCDTests.suite());
		testSuite.addTest(ViewWCWebContentScopeGlobalWCDTests.suite());

		return testSuite;
	}

}