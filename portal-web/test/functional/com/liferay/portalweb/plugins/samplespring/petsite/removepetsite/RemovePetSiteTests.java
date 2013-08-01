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

package com.liferay.portalweb.plugins.samplespring.petsite.removepetsite;

import com.liferay.portalweb.plugins.samplespring.petsite.addpetsite.AddPetSiteTest;
import com.liferay.portalweb.plugins.samplespring.petsite.addpetsite.TearDownPetSiteTest;
import com.liferay.portalweb.plugins.samplespring.portlet.addportletps.AddPagePSTest;
import com.liferay.portalweb.plugins.samplespring.portlet.addportletps.AddPortletPSTest;
import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.util.TearDownPageTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class RemovePetSiteTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPagePSTest.class);
		testSuite.addTestSuite(AddPortletPSTest.class);
		testSuite.addTestSuite(AddPetSiteTest.class);
		testSuite.addTestSuite(RemovePetSiteTest.class);
		testSuite.addTestSuite(TearDownPetSiteTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}
}