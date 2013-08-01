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

package com.liferay.portalweb.portlet.shopping.order.checkoutordershippingzipnull;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.shopping.category.addcategory.AddCategoryTest;
import com.liferay.portalweb.portlet.shopping.category.addcategory.TearDownShoppingCategoryTest;
import com.liferay.portalweb.portlet.shopping.item.addcategoryitem.AddCategoryItemTest;
import com.liferay.portalweb.portlet.shopping.item.addtoshoppingcartcategoryitem.AddToShoppingCartCategoryItemTest;
import com.liferay.portalweb.portlet.shopping.item.addtoshoppingcartcategoryitem.TearDownCartTest;
import com.liferay.portalweb.portlet.shopping.order.checkoutorder.TearDownCheckoutOrderTest;
import com.liferay.portalweb.portlet.shopping.portlet.addportletshopping.AddPageShoppingTest;
import com.liferay.portalweb.portlet.shopping.portlet.addportletshopping.AddPortletShoppingTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CheckoutOrderShippingZipNullTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageShoppingTest.class);
		testSuite.addTestSuite(AddPortletShoppingTest.class);
		testSuite.addTestSuite(AddCategoryTest.class);
		testSuite.addTestSuite(AddCategoryItemTest.class);
		testSuite.addTestSuite(AddToShoppingCartCategoryItemTest.class);
		testSuite.addTestSuite(CheckoutOrderShippingZipNullTest.class);
		testSuite.addTestSuite(ViewCheckoutOrderShippingZipNullTest.class);
		testSuite.addTestSuite(TearDownCheckoutOrderTest.class);
		testSuite.addTestSuite(TearDownCartTest.class);
		testSuite.addTestSuite(TearDownShoppingCategoryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}