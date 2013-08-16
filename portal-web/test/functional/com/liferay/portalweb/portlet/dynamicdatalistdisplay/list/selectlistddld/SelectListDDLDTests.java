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

package com.liferay.portalweb.portlet.dynamicdatalistdisplay.list.selectlistddld;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.list.addlistddld.AddPageDDLDTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.list.addlistddld.AddPortletDDLDTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.list.addlistddld.TearDownDataDefinitionTest;
import com.liferay.portalweb.portlet.dynamicdatalistdisplay.list.addlistddld.TearDownListTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectListDDLDTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDDLDTest.class);
		testSuite.addTestSuite(AddPortletDDLDTest.class);
		testSuite.addTestSuite(AddDataDefinitionTest.class);
		testSuite.addTestSuite(AddListTest.class);
		testSuite.addTestSuite(SelectListDDLDTest.class);
		testSuite.addTestSuite(ViewSelectListDDLDTest.class);
		testSuite.addTestSuite(TearDownListTest.class);
		testSuite.addTestSuite(TearDownDataDefinitionTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}