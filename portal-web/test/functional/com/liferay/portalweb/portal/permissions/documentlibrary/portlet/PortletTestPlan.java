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

package com.liferay.portalweb.portal.permissions.documentlibrary.portlet;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.accessincontrolpanel.AccessInControlPanelTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.addtopage.AddToPageTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.configuration.ConfigurationTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.permissions.PermissionsTests;
import com.liferay.portalweb.portal.permissions.documentlibrary.portlet.view.ViewTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AccessInControlPanelTests.suite());
		testSuite.addTest(AddToPageTests.suite());
		testSuite.addTest(ConfigurationTests.suite());
		testSuite.addTest(PermissionsTests.suite());
		testSuite.addTest(ViewTests.suite());

		return testSuite;
	}

}