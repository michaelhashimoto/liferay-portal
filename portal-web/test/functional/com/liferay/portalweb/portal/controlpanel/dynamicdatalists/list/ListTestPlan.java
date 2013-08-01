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

package com.liferay.portalweb.portal.controlpanel.dynamicdatalists.list;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.list.addlist.AddListTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.list.addlistdatadefinitionnull.AddListDataDefinitionNullTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.list.addlistnameduplicate.AddListNameDuplicateTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.list.addlistnamenull.AddListNameNullTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.list.deletelist.DeleteListTests;
import com.liferay.portalweb.portal.controlpanel.dynamicdatalists.list.editlist.EditListTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ListTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddListTests.suite());
		testSuite.addTest(AddListDataDefinitionNullTests.suite());
		testSuite.addTest(AddListNameDuplicateTests.suite());
		testSuite.addTest(AddListNameNullTests.suite());
		testSuite.addTest(DeleteListTests.suite());
		testSuite.addTest(EditListTests.suite());

		return testSuite;
	}

}