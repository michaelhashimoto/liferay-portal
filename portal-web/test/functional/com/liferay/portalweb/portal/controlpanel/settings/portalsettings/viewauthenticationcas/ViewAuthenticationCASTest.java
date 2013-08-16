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

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationcas;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAuthenticationCASTest extends BaseTestCase {
	public void testViewAuthenticationCAS() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//a[@id='_130_authenticationLink']");
		selenium.clickAt("//a[@id='_130_authenticationLink']",
			RuntimeVariables.replace("Authentication"));
		selenium.clickAt("link=CAS", RuntimeVariables.replace("CAS"));
		selenium.waitForVisible(
			"//input[@name='_130_settings--cas.import.from.ldap--Checkbox']");
		assertTrue(selenium.isElementPresent(
				"//input[@name='_130_settings--cas.import.from.ldap--Checkbox']"));
		assertTrue(selenium.isElementPresent(
				"//input[@name='_130_settings--cas.auth.enabled--Checkbox']"));
		assertTrue(selenium.isTextPresent("Login URL"));
		assertTrue(selenium.isTextPresent("Logout URL"));
		assertTrue(selenium.isTextPresent("Server Name"));
		assertTrue(selenium.isTextPresent("Service URL"));
		assertTrue(selenium.isTextPresent("Service URL"));
	}
}