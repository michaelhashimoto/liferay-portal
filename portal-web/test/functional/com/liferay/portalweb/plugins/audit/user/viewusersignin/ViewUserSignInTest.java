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

package com.liferay.portalweb.plugins.audit.user.viewusersignin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewUserSignInTest extends BaseTestCase {
	public void testViewUserSignIn() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Audit Reports", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent(
			"_1_WAR_auditportlet_toggle_id_audit_event_searchkeywords");
		selenium.type("_1_WAR_auditportlet_toggle_id_audit_event_searchkeywords",
			RuntimeVariables.replace("selen01"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("selen01 lenn nium01"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Logout"),
			selenium.getText("//td[5]/a"));
		assertEquals(RuntimeVariables.replace("selen01 lenn nium01"),
			selenium.getText("//tr[4]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Login"),
			selenium.getText("//tr[4]/td[5]/a"));
	}
}