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

package com.liferay.portalweb.portlet.directory.organizations;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portlet.directory.organizations.advancedsearchorganization.AdvancedSearchOrganizationTests;
import com.liferay.portalweb.portlet.directory.organizations.searchorganization.SearchOrganizationTests;
import com.liferay.portalweb.portlet.directory.organizations.vieworganizationuser.ViewOrganizationUserTests;
import com.liferay.portalweb.portlet.directory.organizations.viewsuborganization.ViewSuborganizationTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationsTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AdvancedSearchOrganizationTests.suite());
		testSuite.addTest(SearchOrganizationTests.suite());
		testSuite.addTest(ViewOrganizationUserTests.suite());
		testSuite.addTest(ViewSuborganizationTests.suite());

		return testSuite;
	}

}