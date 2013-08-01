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
public class SignOutPrivatePagesSiteBWCTest extends BaseTestCase {
	public void testSignOutPrivatePagesSiteBWC() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.openWindow("http://www.baker.com:8080",
			RuntimeVariables.replace("home"));
		selenium.waitForPopUp("home", RuntimeVariables.replace(""));
		selenium.selectWindow("home");
		Thread.sleep(5000);
		Thread.sleep(5000);
		selenium.waitForElementPresent("link=Sign Out");
		selenium.click(RuntimeVariables.replace("link=Sign Out"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		Thread.sleep(5000);
		selenium.close();
		selenium.selectWindow("null");
	}
}