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
public class Guest_ViewPrivatePagesSiteBWCTest extends BaseTestCase {
	public void testGuest_ViewPrivatePagesSiteBWC() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.openWindow("http://www.baker.com:8080",
			RuntimeVariables.replace("home"));
		selenium.waitForPopUp("home", RuntimeVariables.replace(""));
		selenium.selectWindow("home");
		Thread.sleep(5000);
		Thread.sleep(5000);
		selenium.waitForVisible("//a[@class='logo custom-logo']");
		assertTrue(selenium.isVisible("//a[@class='logo custom-logo']"));
		assertTrue(selenium.isElementPresent("//img[@height='156']"));
		assertTrue(selenium.isElementPresent("//img[@width='320']"));
		assertTrue(selenium.isElementNotPresent(
				"//a[@class='logo default-logo']"));
		assertTrue(selenium.isElementPresent(
				"//body[@class='green yui3-skin-sam controls-visible page-maximized signed-out public-page site']"));
		assertTrue(selenium.isVisible("link=Home"));
		assertTrue(selenium.isVisible("link=Arenas"));
		assertTrue(selenium.isElementNotPresent("link=Accommodations"));
		assertTrue(selenium.isElementNotPresent("link=Maps"));
		assertEquals(RuntimeVariables.replace("Welcome to Brazil"),
			selenium.getText("//footer[@id='footer']"));
		Thread.sleep(5000);
		Thread.sleep(5000);
		selenium.close();
		selenium.selectWindow("null");
	}
}