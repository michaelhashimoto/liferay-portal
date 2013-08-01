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

package com.liferay.portalweb.portlet.shopping;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.shopping.archivesetup.ArchiveSetupTestPlan;
import com.liferay.portalweb.portlet.shopping.category.CategoryTestPlan;
import com.liferay.portalweb.portlet.shopping.coupon.CouponTestPlan;
import com.liferay.portalweb.portlet.shopping.item.ItemTestPlan;
import com.liferay.portalweb.portlet.shopping.order.OrderTestPlan;
import com.liferay.portalweb.portlet.shopping.portlet.PortletTestPlan;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(ArchiveSetupTestPlan.suite());
		testSuite.addTest(CategoryTestPlan.suite());
		testSuite.addTest(CouponTestPlan.suite());
		testSuite.addTest(ItemTestPlan.suite());
		testSuite.addTest(OrderTestPlan.suite());
		testSuite.addTest(PortletTestPlan.suite());

		return testSuite;
	}

}