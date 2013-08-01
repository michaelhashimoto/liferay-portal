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

package com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.deleterecordddld;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.list.addlistddld.AddPageDDLDTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.list.addlistddld.AddPortletDDLDTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.AddDMDocumentTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.AddDataDefinitionTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.AddListTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.AddRecordDDLDTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.SelectListDDLDTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.TearDownDMContentTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.TearDownDataDefinitionTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.record.addrecordddld.TearDownListTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteRecordDDLDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDDLDTest.class);
		testSuite.addTestSuite(AddPortletDDLDTest.class);
		testSuite.addTestSuite(AddDataDefinitionTest.class);
		testSuite.addTestSuite(AddListTest.class);
		testSuite.addTestSuite(AddDMDocumentTest.class);
		testSuite.addTestSuite(SelectListDDLDTest.class);
		testSuite.addTestSuite(AddRecordDDLDTest.class);
		testSuite.addTestSuite(DeleteRecordDDLDTest.class);
		testSuite.addTestSuite(ViewDeleteRecordDDLDTest.class);
		testSuite.addTestSuite(TearDownListTest.class);
		testSuite.addTestSuite(TearDownDataDefinitionTest.class);
		testSuite.addTestSuite(TearDownDMContentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}