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

package com.liferay.portalweb.portlet.messageboards.mbthread.movembcategorythreadtocategory;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.messageboards.mbcategory.addmbcategory.AddMBCategory1Test;
import com.liferay.portalweb.portlet.messageboards.mbcategory.addmbcategory.AddMBCategory2Test;
import com.liferay.portalweb.portlet.messageboards.mbcategory.addmbcategory.TearDownMBCategoryTest;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategory1ThreadTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPageMBTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPortletMBTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveMBCategoryThreadToCategoryTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(AddMBCategory1Test.class);
		testSuite.addTestSuite(AddMBCategory2Test.class);
		testSuite.addTestSuite(PostNewMBCategory1ThreadTest.class);
		testSuite.addTestSuite(MoveMBCategoryThreadToCategoryTest.class);
		testSuite.addTestSuite(TearDownMBCategoryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}