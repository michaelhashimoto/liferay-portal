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

package com.liferay.portalweb.asset.messageboards.mbthread;

import com.liferay.portalweb.asset.messageboards.mbthread.viewmbcategorythreadmessageviewcountap.ViewMBCategoryThreadMessageViewCountAPTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportletabstractsmbcategorythreadmessageap.ViewPortletAbstractsMBCategoryThreadMessageAPTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportletavailablembcategorythreadmessageap.ViewPortletAvailableMBCategoryThreadMessageAPTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportletcurrentmbcategorythreadmessageap.ViewPortletCurrentMBCategoryThreadMessageAPTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportletfullcontentmbcategorythreadmessageap.ViewPortletFullContentMBCategoryThreadMessageAPTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportletmaximumitems5mbcategorymessage6ap.ViewPortletMaximumItems5MBCategoryMessage6APTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportletpaginationregularmbcategorythread6ap.ViewPortletPaginationRegularMBCategoryThread6APTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportletpaginationsimplembcategorythread6ap.ViewPortletPaginationSimpleMBCategoryThread6APTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportlettablembcategorythreadmessageap.ViewPortletTableMBCategoryThreadMessageAPTests;
import com.liferay.portalweb.asset.messageboards.mbthread.viewportlettitlelistmbcategorythreadmessageap.ViewPortletTitleListMBCategoryThreadMessageAPTests;
import com.liferay.portalweb.portal.BaseTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MBThreadTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ViewMBCategoryThreadMessageViewCountAPTests.suite());
		testSuite.addTest(
			ViewPortletAbstractsMBCategoryThreadMessageAPTests.suite());
		testSuite.addTest(
			ViewPortletAvailableMBCategoryThreadMessageAPTests.suite());
		testSuite.addTest(
			ViewPortletCurrentMBCategoryThreadMessageAPTests.suite());
		testSuite.addTest(
			ViewPortletFullContentMBCategoryThreadMessageAPTests.suite());
		testSuite.addTest(
			ViewPortletMaximumItems5MBCategoryMessage6APTests.suite());
		testSuite.addTest(
			ViewPortletPaginationRegularMBCategoryThread6APTests.suite());
		testSuite.addTest(
			ViewPortletPaginationSimpleMBCategoryThread6APTests.suite());
		testSuite.addTest(
			ViewPortletTableMBCategoryThreadMessageAPTests.suite());
		testSuite.addTest(
			ViewPortletTitleListMBCategoryThreadMessageAPTests.suite());

		return testSuite;
	}

}