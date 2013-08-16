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

package com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.editwcsubstructuresdefaultvalues;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcstructure.AddWCStructure1Test;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcstructure.TearDownWCStructureTest;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcsubstructures.AddWCSubstructure1Test;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcsubstructures.AddWCSubstructure2Test;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcsubstructures.AddWCSubstructure3Test;
import com.liferay.portalweb.portal.controlpanel.webcontent.wcstructure.addwcsubstructures.TearDownWCSubStructuresTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EditWCSubStructuresDefaultValuesTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddWCStructure1Test.class);
		testSuite.addTestSuite(AddWCSubstructure1Test.class);
		testSuite.addTestSuite(EditWCSubstructure1DefaultValuesTest.class);
		testSuite.addTestSuite(ViewEditWCSubstucture1DefaultValueTest.class);
		testSuite.addTestSuite(AddWCSubstructure2Test.class);
		testSuite.addTestSuite(EditWCSubstructure2DefaultValuesTest.class);
		testSuite.addTestSuite(ViewEditWCSubstucture2DefaultValueTest.class);
		testSuite.addTestSuite(AddWCSubstructure3Test.class);
		testSuite.addTestSuite(EditWCSubstructure3DefaultValuesTest.class);
		testSuite.addTestSuite(ViewEditWCSubstucture3DefaultValueTest.class);
		testSuite.addTestSuite(TearDownWCSubStructuresTest.class);
		testSuite.addTestSuite(TearDownWCStructureTest.class);

		return testSuite;
	}
}