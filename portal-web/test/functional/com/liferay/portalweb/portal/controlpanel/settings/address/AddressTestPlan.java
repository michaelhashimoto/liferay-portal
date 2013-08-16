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

package com.liferay.portalweb.portal.controlpanel.settings.address;

import com.liferay.portalweb.portal.BaseTestSuite;
import com.liferay.portalweb.portal.controlpanel.settings.address.addsettingsaddress.AddSettingsAddressTests;
import com.liferay.portalweb.portal.controlpanel.settings.address.addsettingsaddresscitynull.AddSettingsAddressCityNullTests;
import com.liferay.portalweb.portal.controlpanel.settings.address.addsettingsaddresses.AddSettingsAddressesTests;
import com.liferay.portalweb.portal.controlpanel.settings.address.addsettingsaddressstreetnull.AddSettingsAddressStreetNullTests;
import com.liferay.portalweb.portal.controlpanel.settings.address.addsettingsaddresszipnull.AddSettingsAddressZipNullTests;
import com.liferay.portalweb.portal.controlpanel.settings.address.deletesettingsaddress.DeleteSettingsAddressTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddressTestPlan extends BaseTestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(AddSettingsAddressTests.suite());
		testSuite.addTest(AddSettingsAddressCityNullTests.suite());
		testSuite.addTest(AddSettingsAddressesTests.suite());
		testSuite.addTest(AddSettingsAddressStreetNullTests.suite());
		testSuite.addTest(AddSettingsAddressZipNullTests.suite());
		testSuite.addTest(DeleteSettingsAddressTests.suite());

		return testSuite;
	}

}