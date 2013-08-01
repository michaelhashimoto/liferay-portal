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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcstructure.AddWCStructureTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcstructures.AddWCStructuresTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcsubstructures.AddWCSubstructuresTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.advancedsearchwcstructure.AdvancedSearchWCStructureTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.editwcsubstructuresdefaultvalues.EditWCSubStructuresDefaultValuesTests;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.searchwcstructure.SearchWCStructureTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WCStructureTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddWCStructureTests.suite());
		testSuite.addTest(AddWCStructuresTests.suite());
		testSuite.addTest(AddWCSubstructuresTests.suite());
		testSuite.addTest(AdvancedSearchWCStructureTests.suite());
		testSuite.addTest(EditWCSubStructuresDefaultValuesTests.suite());
		testSuite.addTest(SearchWCStructureTests.suite());

		return testSuite;
	}

}