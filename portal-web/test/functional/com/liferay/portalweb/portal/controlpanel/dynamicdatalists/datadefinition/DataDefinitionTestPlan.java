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

package com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionboolean.AddDataDefinitionBooleanTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitiondate.AddDataDefinitionDateTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitiondecimal.AddDataDefinitionDecimalTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitiondocumentlibrary.AddDataDefinitionDocumentLibraryTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionfieldfull.AddDataDefinitionFieldFullTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionfieldnull.AddDataDefinitionFieldNullTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionfileupload.AddDataDefinitionFileUploadTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionnameduplicate.AddDataDefinitionNameDuplicateTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionnamenull.AddDataDefinitionNameNullTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionnumber.AddDataDefinitionNumberTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionradio.AddDataDefinitionRadioTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionselect.AddDataDefinitionSelectTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitiontext.AddDataDefinitionTextTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitiontextbox.AddDataDefinitionTextBoxTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.deletedatadefinition.DeleteDataDefinitionTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.editdatadefinition.EditDataDefinitionTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DataDefinitionTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddDataDefinitionBooleanTests.suite());
		testSuite.addTest(AddDataDefinitionDateTests.suite());
		testSuite.addTest(AddDataDefinitionDecimalTests.suite());
		testSuite.addTest(AddDataDefinitionDocumentLibraryTests.suite());
		testSuite.addTest(AddDataDefinitionFieldFullTests.suite());
		testSuite.addTest(AddDataDefinitionFieldNullTests.suite());
		testSuite.addTest(AddDataDefinitionFileUploadTests.suite());
		testSuite.addTest(AddDataDefinitionNameDuplicateTests.suite());
		testSuite.addTest(AddDataDefinitionNameNullTests.suite());
		testSuite.addTest(AddDataDefinitionNumberTests.suite());
		testSuite.addTest(AddDataDefinitionRadioTests.suite());
		testSuite.addTest(AddDataDefinitionSelectTests.suite());
		testSuite.addTest(AddDataDefinitionTextTests.suite());
		testSuite.addTest(AddDataDefinitionTextBoxTests.suite());
		testSuite.addTest(DeleteDataDefinitionTests.suite());
		testSuite.addTest(EditDataDefinitionTests.suite());

		return testSuite;
	}

}