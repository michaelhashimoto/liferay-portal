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

package com.liferay.portalweb.asset.webcontent.wcwebcontent;

import com.liferay.portalweb.asset.webcontent.wcwebcontent.addnewwcwebcontentapactions.AddNewWCWebContentAPActionsTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.addwcwebcontent2displaypageap.AddWCWebContent2DisplayPageAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.addwcwebcontent2displaypageap2.AddWCWebContent2DisplayPageAP2Tests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.deletewcwebcontentap.DeleteWCWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.ratewcwebcontentap.RateWCWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.selectexistingwcwebcontentapactions.SelectExistingWCWebContentAPActionsTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewconfigureportletabstractswebcontentap.ViewConfigurePortletAbstractsWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewconfigureportletavailablewebcontentap.ViewConfigurePortletAvailableWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewconfigureportletcurrentwebcontentap.ViewConfigurePortletCurrentWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewconfigureportletfullcontentwebcontentap.ViewConfigurePortletFullContentWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewconfigureportlettablewebcontentap.ViewConfigurePortletTableWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewconfigureportlettitlelistwebcontentap.ViewConfigurePortletTitleListWebContentAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewwcwebcontentscopeglobalap.ViewWCWebContentScopeGlobalAPTests;
import com.liferay.portalweb.asset.webcontent.wcwebcontent.viewwcwebcontentviewcountap.ViewWCWebContentViewCountAPTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WCWebContentTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddNewWCWebContentAPActionsTests.suite());
		testSuite.addTest(AddWCWebContent2DisplayPageAPTests.suite());
		testSuite.addTest(AddWCWebContent2DisplayPageAP2Tests.suite());
		testSuite.addTest(DeleteWCWebContentAPTests.suite());
		testSuite.addTest(RateWCWebContentAPTests.suite());
		testSuite.addTest(SelectExistingWCWebContentAPActionsTests.suite());
		testSuite.addTest(
			ViewConfigurePortletAbstractsWebContentAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletAvailableWebContentAPTests.suite());
		testSuite.addTest(ViewConfigurePortletCurrentWebContentAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletFullContentWebContentAPTests.suite());
		testSuite.addTest(ViewConfigurePortletTableWebContentAPTests.suite());
		testSuite.addTest(
			ViewConfigurePortletTitleListWebContentAPTests.suite());
		testSuite.addTest(ViewWCWebContentScopeGlobalAPTests.suite());
		testSuite.addTest(ViewWCWebContentViewCountAPTests.suite());

		return testSuite;
	}

}