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

package com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.addrecordspreadsheetview;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinitionboolean.TearDownDataDefinitionTest;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.addrecord.AddDMDocumentTest;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.addrecord.AddDataDefinitionTest;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.addrecord.AddListTest;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.addrecord.TearDownDMContentTest;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.addrecord.TearDownListTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddRecordSpreadsheetViewTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddDataDefinitionTest.class);
		testSuite.addTestSuite(AddListTest.class);
		testSuite.addTestSuite(AddDMDocumentTest.class);
		testSuite.addTestSuite(AddRecordSpreadsheetViewTest.class);
		testSuite.addTestSuite(ViewRecordSpreadsheetViewTest.class);
		testSuite.addTestSuite(TearDownListTest.class);
		testSuite.addTestSuite(TearDownDataDefinitionTest.class);
		testSuite.addTestSuite(TearDownDMContentTest.class);

		return testSuite;
	}
}