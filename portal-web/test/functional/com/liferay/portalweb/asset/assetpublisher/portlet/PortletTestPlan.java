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

package com.liferay.portalweb.asset.assetpublisher.portlet;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletapsite.AddPortletAPSiteTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletmultipleap.AddPortletMultipleAPTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletapdisplaypage.ConfigurePortletAPDisplayPageTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletapenableratings.ConfigurePortletAPEnableRatingsTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletaporderbycolumnratings.ConfigurePortletAPOrderByColumnRatingsTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletapscopeblogspage.ConfigurePortletAPScopeBlogsPageTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletapsetasdefault.ConfigurePortletAPSetAsDefaultTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletassetselectiondynamic.ConfigurePortletAssetSelectionDynamicTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletassetselectionmanual.ConfigurePortletAssetSelectionManualTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletavailableblogsentry.ConfigurePortletAvailableBlogsEntryTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletavailablebookmarksentry.ConfigurePortletAvailableBookmarksEntryTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletavailabledmdocument.ConfigurePortletAvailableDMDocumentTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletavailablembmessage.ConfigurePortletAvailableMBMessageTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletavailablewebcontent.ConfigurePortletAvailableWebContentTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletavailablewikipage.ConfigurePortletAvailableWikiPageTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletcurrentblogsentry.ConfigurePortletCurrentBlogsEntryTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletcurrentbookmarksentry.ConfigurePortletCurrentBookmarksEntryTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletcurrentdmdocument.ConfigurePortletCurrentDMDocumentTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletcurrentmbmessage.ConfigurePortletCurrentMBMessageTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletcurrentwebcontent.ConfigurePortletCurrentWebContentTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletcurrentwikipage.ConfigurePortletCurrentWikiPageTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletdisplaystyleabstracts.ConfigurePortletDisplayStyleAbstractsTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletdisplaystylefullcontent.ConfigurePortletDisplayStyleFullContentTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletdisplaystyletable.ConfigurePortletDisplayStyleTableTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletdisplaystyletitlelist.ConfigurePortletDisplayStyleTitleListTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletmaximumitemstodisplay2.ConfigurePortletMaximumItemsToDisplay2Tests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletmaximumitemstodisplay5.ConfigurePortletMaximumItemsToDisplay5Tests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletpaginationtyperegular.ConfigurePortletPaginationTypeRegularTests;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletpaginationtypesimple.ConfigurePortletPaginationTypeSimpleTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddPortletAPTests.suite());
		testSuite.addTest(AddPortletAPSiteTests.suite());
		testSuite.addTest(AddPortletMultipleAPTests.suite());
		testSuite.addTest(ConfigurePortletAPDisplayPageTests.suite());
		testSuite.addTest(ConfigurePortletAPEnableRatingsTests.suite());
		testSuite.addTest(ConfigurePortletAPOrderByColumnRatingsTests.suite());
		testSuite.addTest(ConfigurePortletAPScopeBlogsPageTests.suite());
		testSuite.addTest(ConfigurePortletAPSetAsDefaultTests.suite());
		testSuite.addTest(ConfigurePortletAssetSelectionDynamicTests.suite());
		testSuite.addTest(ConfigurePortletAssetSelectionManualTests.suite());
		testSuite.addTest(ConfigurePortletAvailableBlogsEntryTests.suite());
		testSuite.addTest(ConfigurePortletAvailableBookmarksEntryTests.suite());
		testSuite.addTest(ConfigurePortletAvailableDMDocumentTests.suite());
		testSuite.addTest(ConfigurePortletAvailableMBMessageTests.suite());
		testSuite.addTest(ConfigurePortletAvailableWebContentTests.suite());
		testSuite.addTest(ConfigurePortletAvailableWikiPageTests.suite());
		testSuite.addTest(ConfigurePortletCurrentBlogsEntryTests.suite());
		testSuite.addTest(ConfigurePortletCurrentBookmarksEntryTests.suite());
		testSuite.addTest(ConfigurePortletCurrentDMDocumentTests.suite());
		testSuite.addTest(ConfigurePortletCurrentMBMessageTests.suite());
		testSuite.addTest(ConfigurePortletCurrentWebContentTests.suite());
		testSuite.addTest(ConfigurePortletCurrentWikiPageTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleAbstractsTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleFullContentTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleTableTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleTitleListTests.suite());
		testSuite.addTest(ConfigurePortletDisplayStyleTitleListTests.suite());
		testSuite.addTest(ConfigurePortletMaximumItemsToDisplay2Tests.suite());
		testSuite.addTest(ConfigurePortletMaximumItemsToDisplay5Tests.suite());
		testSuite.addTest(ConfigurePortletPaginationTypeRegularTests.suite());
		testSuite.addTest(ConfigurePortletPaginationTypeSimpleTests.suite());

		return testSuite;
	}

}