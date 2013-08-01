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

package com.liferay.portalweb.asset.messageboards.mbthread.viewportletmaximumitems5mbcategorymessage6ap;

import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPageAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.addportletap.AddPortletAPTest;
import com.liferay.portalweb.asset.assetpublisher.portlet.configureportletmaximumitemstodisplay5.ConfigurePortletMaximumItemsToDisplay5Test;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.messageboards.mbcategory.addmbcategory.AddMBCategoryTest;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread1Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread2Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread3Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread4Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread5Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread6Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbthread.TearDownMBThreadTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPageMBTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPortletMBTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletMaximumItems5MBCategoryMessage6APTests
	extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageAPTest.class);
		testSuite.addTestSuite(AddPortletAPTest.class);
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(AddMBCategoryTest.class);
		testSuite.addTestSuite(PostNewMBCategoryThread1Test.class);
		testSuite.addTestSuite(PostNewMBCategoryThread2Test.class);
		testSuite.addTestSuite(PostNewMBCategoryThread3Test.class);
		testSuite.addTestSuite(PostNewMBCategoryThread4Test.class);
		testSuite.addTestSuite(PostNewMBCategoryThread5Test.class);
		testSuite.addTestSuite(PostNewMBCategoryThread6Test.class);
		testSuite.addTestSuite(ViewMBCategoryThreadMessage6APTest.class);
		testSuite.addTestSuite(ConfigurePortletMaximumItemsToDisplay5Test.class);
		testSuite.addTestSuite(ViewPortletMaximumItems5MBCategoryMessage6APTest.class);
		testSuite.addTestSuite(TearDownMBThreadTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}