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

package com.liferay.portalweb.portal.controlpanel.categories.category;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategory.AddCategoryTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategorymultiple.AddCategoryMultipleTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategorynamenull.AddCategoryNameNullTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategoryproperty.AddCategoryPropertyTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategorytovocabulary.AddCategoryToVocabularyTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategoryviewablebyanyone.AddCategoryViewableByAnyoneTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategoryviewablebyowner.AddCategoryViewableByOwnerTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addcategoryviewablebysitemembers.AddCategoryViewableBySiteMembersTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addsubcategory.AddSubcategoryTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.addsubcategorymultiple.AddSubcategoryMultipleTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.deletecategoryactions.DeleteCategoryActionsTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.deletecategorydetails.DeleteCategoryDetailsTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.deletecategorymultiple.DeleteCategoryMultipleTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.deletesubcategoryactions.DeleteSubcategoryActionsTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.deletesubcategorydetails.DeleteSubcategoryDetailsTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.editcategory.EditCategoryTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.editsubcategory.EditSubcategoryTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.editvocabulary1categorytovocabulary2dad.EditVocabulary1CategoryToVocabulary2DADTests;
import com.liferay.portalweb.portal.controlpanel.categories.category.editvocabulary1categorytovocabulary2detail.EditVocabulary1CategoryToVocabulary2DetailTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class CategoryTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddCategoryTests.suite());
		testSuite.addTest(AddCategoryMultipleTests.suite());
		testSuite.addTest(AddCategoryNameNullTests.suite());
		testSuite.addTest(AddCategoryPropertyTests.suite());
		testSuite.addTest(AddCategoryToVocabularyTests.suite());
		testSuite.addTest(AddCategoryViewableByAnyoneTests.suite());
		testSuite.addTest(AddCategoryViewableByOwnerTests.suite());
		testSuite.addTest(AddCategoryViewableBySiteMembersTests.suite());
		testSuite.addTest(AddSubcategoryTests.suite());
		testSuite.addTest(AddSubcategoryMultipleTests.suite());
		testSuite.addTest(DeleteCategoryActionsTests.suite());
		testSuite.addTest(DeleteCategoryDetailsTests.suite());
		testSuite.addTest(DeleteCategoryMultipleTests.suite());
		testSuite.addTest(DeleteSubcategoryActionsTests.suite());
		testSuite.addTest(DeleteSubcategoryDetailsTests.suite());
		testSuite.addTest(EditCategoryTests.suite());
		testSuite.addTest(EditSubcategoryTests.suite());
		testSuite.addTest(EditVocabulary1CategoryToVocabulary2DADTests.suite());
		testSuite.addTest(
			EditVocabulary1CategoryToVocabulary2DetailTests.suite());

		return testSuite;
	}

}