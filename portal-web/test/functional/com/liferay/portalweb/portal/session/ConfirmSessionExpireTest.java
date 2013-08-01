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

package com.liferay.portalweb.portal.session;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfirmSessionExpireTest extends BaseTestCase {
	public void testConfirmSessionExpire() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Session Expiration Test Page",
			RuntimeVariables.replace("Session Expiration Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(60000);
		selenium.waitForVisible("//input[@value='Extend']");
		Thread.sleep(60000);
		selenium.waitForVisible("//div[@class='popup-alert-warning']");
		assertEquals(RuntimeVariables.replace(
				"Warning! Due to inactivity, your session has expired. Please save any data you may have entered before refreshing the page."),
			selenium.getText("//div[@class='popup-alert-warning']"));
		Thread.sleep(5000);
		selenium.clickAt("link=Session Expiration Test Page",
			RuntimeVariables.replace("Session Expiration Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("link=Sign In"));
	}
}