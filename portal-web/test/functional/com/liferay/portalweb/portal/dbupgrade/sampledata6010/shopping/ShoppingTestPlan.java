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

package com.liferay.portalweb.portal.dbupgrade.sampledata6010.shopping;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.shopping.category.CategoryTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.shopping.coupon.CouponTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.shopping.item.ItemTests;
import com.liferay.portalweb.portal.dbupgrade.sampledata6010.shopping.order.OrderTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(CategoryTests.suite());
		testSuite.addTest(CouponTests.suite());
		testSuite.addTest(ItemTests.suite());
		testSuite.addTest(OrderTests.suite());

		return testSuite;
	}

}