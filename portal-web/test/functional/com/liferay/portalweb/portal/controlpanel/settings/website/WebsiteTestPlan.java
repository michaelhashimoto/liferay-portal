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

package com.liferay.portalweb.portal.controlpanel.settings.website;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.settings.website.addsettingswebsite.AddSettingsWebsiteTests;
import com.liferay.portalweb.portal.controlpanel.settings.website.addsettingswebsites.AddSettingsWebsitesTests;
import com.liferay.portalweb.portal.controlpanel.settings.website.addsettingswebsiteurlinvalid.AddSettingsWebsiteUrlInvalidTests;
import com.liferay.portalweb.portal.controlpanel.settings.website.deletesettingswebsite.DeleteSettingsWebsiteTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class WebsiteTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSettingsWebsiteTests.suite());
		testSuite.addTest(AddSettingsWebsitesTests.suite());
		testSuite.addTest(AddSettingsWebsiteUrlInvalidTests.suite());
		testSuite.addTest(DeleteSettingsWebsiteTests.suite());

		return testSuite;
	}

}