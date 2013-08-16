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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.addportletscopedefaultwcwebcontentwcd;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPageWCD1Test;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPageWCD2Test;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPageWCD3Test;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPortletWCD1Test;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPortletWCD2Test;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.addportletwcd.AddPortletWCD3Test;
import com.liferay.portalweb.portlet.webcontentdisplay.portlet.configureportletscopecurrentpage.ConfigurePortletScopeCurrentPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPortletScopeDefaultWCWebContentWCDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageWCD1Test.class);
		testSuite.addTestSuite(AddPortletWCD1Test.class);
		testSuite.addTestSuite(AddPageWCD2Test.class);
		testSuite.addTestSuite(AddPortletWCD2Test.class);
		testSuite.addTestSuite(AddPageWCD3Test.class);
		testSuite.addTestSuite(AddPortletWCD3Test.class);
		testSuite.addTestSuite(ConfigurePortletScopeDefaultTest.class);
		testSuite.addTestSuite(ConfigurePortletScopeCurrentPageTest.class);
		testSuite.addTestSuite(ConfigurePortletScopePage2Test.class);
		testSuite.addTestSuite(AddPortletScopeDefaultWCWebContentWCDTest.class);
		testSuite.addTestSuite(ViewScopeDefaultWCWebContentDefaultTest.class);
		testSuite.addTestSuite(ViewScopeDefaultWCWebContentNullCurrentPageTest.class);
		testSuite.addTestSuite(ViewScopeDefaultWCWebContentNullPage2Test.class);
		testSuite.addTestSuite(ViewScopeDefaultWebContentListDefaultTest.class);
		testSuite.addTestSuite(ViewScopeDefaultWebContentListCurrentPageTest.class);
		testSuite.addTestSuite(ViewScopeDefaultWebContentListPage2Test.class);
		testSuite.addTestSuite(ViewScopeDefaultWCWebContentListDefaultCPTest.class);
		testSuite.addTestSuite(ViewScopeDefaultWCWebContentListCurrentPageCPTest.class);
		testSuite.addTestSuite(TearDownPortletScopeTest.class);
		testSuite.addTestSuite(TearDownScopeWebContentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}