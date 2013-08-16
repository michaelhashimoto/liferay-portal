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

package com.liferay.portalweb.portal.login;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class LoginLegacy51xTest extends BaseTestCase {
	public void testLoginLegacy51x() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.setTimeout("180000");
		selenium.open("/web/guest/home");
		selenium.waitForElementPresent("link=Sign In");
		selenium.click(RuntimeVariables.replace("link=Sign In"));
		selenium.waitForPageToLoad("30000");
		selenium.type("login", RuntimeVariables.replace("test@liferay.com"));
		selenium.type("password", RuntimeVariables.replace("test"));
		selenium.click("rememberMeCheckbox");
		selenium.click(RuntimeVariables.replace(
				"document.getElementById('tabs1already-registeredTabsSection').getElementsByTagName('div')[0].getElementsByTagName('form')[0].getElementsByTagName('fieldset')[0].getElementsByTagName('div')[3].getElementsByTagName('input')[0]"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent("//input[@value='I Agree']");
		selenium.click(RuntimeVariables.replace("//input[@value='I Agree']"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace(
				"document.getElementById('my-community-private-pages')"));
		selenium.waitForPageToLoad("30000");
	}
}