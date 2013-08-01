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

package com.liferay.portalweb.portlet.messageboards.mbthread.viewmbcategorythreadpostcount;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.messageboards.mbcategory.addmbcategory.AddMBCategoryTest;
import com.liferay.portalweb.portlet.messageboards.mbcategory.addmbcategory.TearDownMBCategoryTest;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread1Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread2Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.postnewmbcategorythread.PostNewMBCategoryThread3Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.replymbcategorythreadreply.ReplyMBCategoryThread1Reply1Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.replymbcategorythreadreply.ReplyMBCategoryThread1Reply2Test;
import com.liferay.portalweb.portlet.messageboards.mbthread.replymbcategorythreadreply.ReplyMBCategoryThread1Reply3Test;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPageMBTest;
import com.liferay.portalweb.portlet.messageboards.portlet.addportletmb.AddPortletMBTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewMBCategoryThreadPostCountTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(AddMBCategoryTest.class);
		testSuite.addTestSuite(PostNewMBCategoryThread1Test.class);
		testSuite.addTestSuite(PostNewMBCategoryThread2Test.class);
		testSuite.addTestSuite(PostNewMBCategoryThread3Test.class);
		testSuite.addTestSuite(ReplyMBCategoryThread1Reply1Test.class);
		testSuite.addTestSuite(ReplyMBCategoryThread1Reply2Test.class);
		testSuite.addTestSuite(ReplyMBCategoryThread1Reply3Test.class);
		testSuite.addTestSuite(ViewMBCategoryThreadPostCountTest.class);
		testSuite.addTestSuite(TearDownMBCategoryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}