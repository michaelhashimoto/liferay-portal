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

package com.liferay.portalweb.portlet.shopping.category;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.shopping.category.addcategories.AddCategoriesTests;
import com.liferay.portalweb.portlet.shopping.category.addcategory.AddCategoryTests;
import com.liferay.portalweb.portlet.shopping.category.addcategorynamedoublebackslash.AddCategoryNameDoubleBackSlashTests;
import com.liferay.portalweb.portlet.shopping.category.addcategorynamedoubleforwardslash.AddCategoryNameDoubleForwardSlashTests;
import com.liferay.portalweb.portlet.shopping.category.addcategorynamenull.AddCategoryNameNullTests;
import com.liferay.portalweb.portlet.shopping.category.addsubcategories.AddSubcategoriesTests;
import com.liferay.portalweb.portlet.shopping.category.addsubcategory.AddSubcategoryTests;
import com.liferay.portalweb.portlet.shopping.category.deletecategory.DeleteCategoryTests;
import com.liferay.portalweb.portlet.shopping.category.editcategory.EditCategoryTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CategoryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddCategoriesTests.suite());
		testSuite.addTest(AddCategoryTests.suite());
		testSuite.addTest(AddCategoryNameDoubleBackSlashTests.suite());
		testSuite.addTest(AddCategoryNameDoubleForwardSlashTests.suite());
		testSuite.addTest(AddCategoryNameNullTests.suite());
		testSuite.addTest(AddSubcategoriesTests.suite());
		testSuite.addTest(AddSubcategoryTests.suite());
		testSuite.addTest(DeleteCategoryTests.suite());
		testSuite.addTest(EditCategoryTests.suite());

		return testSuite;
	}

}