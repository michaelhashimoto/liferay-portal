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

package com.liferay.portalweb.portal.controlpanel.categories.vocabulary;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabulary.AddVocabularyTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypeallassettypes.AddVocabularyAssetTypeAllAssetTypesTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypeblogsentry.AddVocabularyAssetTypeBlogsEntryTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypebmentry.AddVocabularyAssetTypeBMEntryTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypecalendarevent.AddVocabularyAssetTypeCalendarEventTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypedldocument.AddVocabularyAssetTypeDLDocumentTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettyperequired.AddVocabularyAssetTypeRequiredTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypeuser.AddVocabularyAssetTypeUserTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypewebcontent.AddVocabularyAssetTypeWebContentTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyassettypewikipage.AddVocabularyAssetTypeWikiPageTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularydisallowmultiplecategories.AddVocabularyDisallowMultipleCategoriesTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularymultiple.AddVocabularyMultipleTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularynamenull.AddVocabularyNameNullTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyviewablebyanyone.AddVocabularyViewableByAnyoneTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyviewablebyowner.AddVocabularyViewableByOwnerTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.addvocabularyviewablebysitemembers.AddVocabularyViewableBySiteMembersTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.closevocabulary.CloseVocabularyTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.deletevocabularyactions.DeleteVocabularyActionsTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.deletevocabularydetails.DeleteVocabularyDetailsTests;
import com.liferay.portalweb.portal.controlpanel.categories.vocabulary.editvocabulary.EditVocabularyTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class VocabularyTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddVocabularyTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeAllAssetTypesTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeBlogsEntryTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeBMEntryTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeCalendarEventTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeDLDocumentTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeRequiredTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeUserTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeWebContentTests.suite());
		testSuite.addTest(AddVocabularyAssetTypeWikiPageTests.suite());
		testSuite.addTest(AddVocabularyDisallowMultipleCategoriesTests.suite());
		testSuite.addTest(AddVocabularyMultipleTests.suite());
		testSuite.addTest(AddVocabularyNameNullTests.suite());
		testSuite.addTest(AddVocabularyViewableByAnyoneTests.suite());
		testSuite.addTest(AddVocabularyViewableByOwnerTests.suite());
		testSuite.addTest(AddVocabularyViewableBySiteMembersTests.suite());
		testSuite.addTest(CloseVocabularyTests.suite());
		testSuite.addTest(DeleteVocabularyActionsTests.suite());
		testSuite.addTest(DeleteVocabularyDetailsTests.suite());
		testSuite.addTest(EditVocabularyTests.suite());

		return testSuite;
	}

}