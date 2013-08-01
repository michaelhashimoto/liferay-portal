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

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewemailnotificationaccountcreated;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEmailNotificationAccountCreatedTest extends BaseTestCase {
	public void testViewEmailNotificationAccountCreated()
		throws Exception {
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
		selenium.waitForVisible("//a[@id='_130_emailNotificationsLink']");
		selenium.clickAt("//a[@id='_130_emailNotificationsLink']",
			RuntimeVariables.replace("Email Notifications"));
		selenium.clickAt("link=Account Created Notification",
			RuntimeVariables.replace("Account Created Notification"));
		selenium.waitForElementPresent(
			"//input[@name='_130_settings--admin.email.user.added.enabled--Checkbox']");
		assertTrue(selenium.isElementPresent(
				"//input[@name='_130_settings--admin.email.user.added.enabled--Checkbox']"));
		assertTrue(selenium.isTextPresent("Subject"));
		assertTrue(selenium.isTextPresent("Body"));
	}
}