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

package com.liferay.portalweb.portal.ldap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EnableLDAPTest extends BaseTestCase {
	public void testEnableLDAP() throws Exception {
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
		assertTrue(selenium.isPartialText(
				"//a[@id='_130_authenticationLink']", "Authentication"));
		selenium.clickAt("//a[@id='_130_authenticationLink']",
			RuntimeVariables.replace("Authentication"));
		selenium.waitForVisible("link=LDAP");
		selenium.clickAt("link=LDAP", RuntimeVariables.replace("LDAP"));
		selenium.waitForVisible("//input[@id='_130_ldap.auth.enabledCheckbox']");
		assertFalse(selenium.isChecked(
				"//input[@id='_130_ldap.auth.enabledCheckbox']"));
		selenium.clickAt("//input[@id='_130_ldap.auth.enabledCheckbox']",
			RuntimeVariables.replace("Enabled"));
		assertTrue(selenium.isChecked(
				"//input[@id='_130_ldap.auth.enabledCheckbox']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("link=LDAP", RuntimeVariables.replace("LDAP"));
		assertTrue(selenium.isChecked(
				"//input[@id='_130_ldap.auth.enabledCheckbox']"));
	}
}