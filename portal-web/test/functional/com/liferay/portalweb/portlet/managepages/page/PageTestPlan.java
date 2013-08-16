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

package com.liferay.portalweb.portlet.managepages.page;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.managepages.page.addchildpage.AddChildPageTests;
import com.liferay.portalweb.portlet.managepages.page.addchildpagemultiple.AddChildPageMultipleTests;
import com.liferay.portalweb.portlet.managepages.page.addpage.AddPageTests;
import com.liferay.portalweb.portlet.managepages.page.addpagefriendlyurlreservedwords.AddPageFriendlyURLReservedWordsTests;
import com.liferay.portalweb.portlet.managepages.page.addpagemultiple.AddPageMultipleTests;
import com.liferay.portalweb.portlet.managepages.page.copypagechildpage.CopyPageChildPageTests;
import com.liferay.portalweb.portlet.managepages.page.copypagepage.CopyPagePageTests;
import com.liferay.portalweb.portlet.managepages.page.savepagetypeembedded.SavePageTypeEmbeddedTests;
import com.liferay.portalweb.portlet.managepages.page.savepagetypelinktopage.SavePageTypeLinkToPageTests;
import com.liferay.portalweb.portlet.managepages.page.savepagetypepanel.SavePageTypePanelTests;
import com.liferay.portalweb.portlet.managepages.page.savepagetypeportlet.SavePageTypePortletTests;
import com.liferay.portalweb.portlet.managepages.page.savepagetypeurl.SavePageTypeURLTests;
import com.liferay.portalweb.portlet.managepages.page.setdisplayorder.SetDisplayOrderTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PageTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddChildPageTests.suite());
		testSuite.addTest(AddChildPageMultipleTests.suite());
		testSuite.addTest(AddPageTests.suite());
		testSuite.addTest(AddPageFriendlyURLReservedWordsTests.suite());
		testSuite.addTest(AddPageMultipleTests.suite());
		testSuite.addTest(CopyPageChildPageTests.suite());
		testSuite.addTest(CopyPagePageTests.suite());
		testSuite.addTest(SavePageTypeEmbeddedTests.suite());
		testSuite.addTest(SavePageTypeLinkToPageTests.suite());
		testSuite.addTest(SavePageTypePanelTests.suite());
		testSuite.addTest(SavePageTypePortletTests.suite());
		testSuite.addTest(SavePageTypeURLTests.suite());
		testSuite.addTest(SetDisplayOrderTests.suite());

		return testSuite;
	}

}