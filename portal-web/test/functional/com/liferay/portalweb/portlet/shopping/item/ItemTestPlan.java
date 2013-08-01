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

package com.liferay.portalweb.portlet.shopping.item;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.shopping.item.addcategoryitem.AddCategoryItemTests;
import com.liferay.portalweb.portlet.shopping.item.addcategoryitemnamenull.AddCategoryItemNameNullTests;
import com.liferay.portalweb.portlet.shopping.item.addcategoryitems.AddCategoryItemsTests;
import com.liferay.portalweb.portlet.shopping.item.addcategoryitemskunull.AddCategoryItemSKUNullTests;
import com.liferay.portalweb.portlet.shopping.item.addtoshoppingcartcategoryitem.AddToShoppingCartCategoryItemTests;
import com.liferay.portalweb.portlet.shopping.item.addtoshoppingcartcategoryitems.AddToShoppingCartCategoryItemsTests;
import com.liferay.portalweb.portlet.shopping.item.deletecategoryitem.DeleteCategoryItemTests;
import com.liferay.portalweb.portlet.shopping.item.editcategoryitem.EditCategoryItemTests;
import com.liferay.portalweb.portlet.shopping.item.guestviewpermissionsshoppingitemguestviewoff.Guest_ViewPermissionsShoppingItemGuestViewOffTests;
import com.liferay.portalweb.portlet.shopping.item.movecategory1itemtocategory2.MoveCategory1ItemToCategory2Tests;
import com.liferay.portalweb.portlet.shopping.item.searchcategoryitem.SearchCategoryItemTests;
import com.liferay.portalweb.portlet.shopping.item.updatecartcategoryitemquantity.UpdateCartCategoryItemQuantityTests;
import com.liferay.portalweb.portlet.shopping.item.updatecartcategoryitemquantity0.UpdateCartCategoryItemQuantity0Tests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ItemTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddCategoryItemTests.suite());
		testSuite.addTest(AddCategoryItemNameNullTests.suite());
		testSuite.addTest(AddCategoryItemsTests.suite());
		testSuite.addTest(AddCategoryItemSKUNullTests.suite());
		testSuite.addTest(AddToShoppingCartCategoryItemTests.suite());
		testSuite.addTest(AddToShoppingCartCategoryItemsTests.suite());
		testSuite.addTest(DeleteCategoryItemTests.suite());
		testSuite.addTest(EditCategoryItemTests.suite());
		testSuite.addTest(
			Guest_ViewPermissionsShoppingItemGuestViewOffTests.suite());
		testSuite.addTest(MoveCategory1ItemToCategory2Tests.suite());
		testSuite.addTest(SearchCategoryItemTests.suite());
		testSuite.addTest(UpdateCartCategoryItemQuantityTests.suite());
		testSuite.addTest(UpdateCartCategoryItemQuantity0Tests.suite());

		return testSuite;
	}

}