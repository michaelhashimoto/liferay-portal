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

package com.liferay.portalweb.demo.sitemanagement.brazilianworldcup;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_SignInPublicPagesSiteBWCTest extends BaseTestCase {
	public void testSA_SignInPublicPagesSiteBWC() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.openWindow("http://www.able.com:8080",
			RuntimeVariables.replace("home"));
		selenium.waitForPopUp("home", RuntimeVariables.replace(""));
		selenium.selectWindow("home");
		Thread.sleep(5000);
		Thread.sleep(5000);
		selenium.waitForVisible("link=Sign In");
		selenium.clickAt("link=Sign In", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("_58_login");
		selenium.type("_58_login",
			RuntimeVariables.replace("brazil2014admin@brazil2014.com"));
		selenium.type("_58_password", RuntimeVariables.replace("test1"));
		selenium.waitForVisible("_58_rememberMeCheckbox");
		selenium.click("_58_rememberMeCheckbox");
		selenium.waitForVisible("//input[@value='Sign In']");
		selenium.clickAt("//input[@value='Sign In']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		Thread.sleep(5000);
		selenium.close();
		selenium.selectWindow("null");
	}
}