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

package com.liferay.portalweb.plugins.googlemaps.portlet.configureportletdirectionsaddress;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewConfigurePortletDirectionsAddressTest extends BaseTestCase {
	public void testViewConfigurePortletDirectionsAddress()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Google Maps Test Page",
			RuntimeVariables.replace("Google Maps Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace(
				"To 205 W. Wacker Dr, Suite 513 Chicago, IL, 60606"),
			selenium.getText("//fieldset/div/div[2]/div/div/div"));
		assertEquals(RuntimeVariables.replace(
				"From 1220 Brea Canyon Road, Diamond Bar, CA, 91789"),
			selenium.getText("//fieldset/div/div/div/div/div"));
	}
}