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

package com.liferay.portalweb.socialoffice.users.user.configuredefaultrolesouser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewSODashboardTest extends BaseTestCase {
	public void testSOUs_ViewSODashboard() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//li/a[contains(.,'Dashboard')]"));
		selenium.mouseOver("//li/a[contains(.,'Dashboard')]");
		selenium.clickAt("//li/a[contains(.,'Dashboard')]",
			RuntimeVariables.replace("Dashboard"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//a[@class='profile-name']"));
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//nav/ul/li/a/span"));
		assertEquals(RuntimeVariables.replace("Contacts Center"),
			selenium.getText("//nav/ul/li[2]/a/span"));
		assertEquals(RuntimeVariables.replace("Microblogs"),
			selenium.getText("//nav/ul/li[3]/a/span"));
		assertEquals(RuntimeVariables.replace("Messages"),
			selenium.getText("//nav/ul/li[4]/a/span"));
		assertEquals(RuntimeVariables.replace("My Documents"),
			selenium.getText("//nav/ul/li[5]/a"));
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText("//li[6]/a/span"));
		selenium.open("/user/socialoffice01/so/dashboard");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//a[@class='profile-name']"));
		assertEquals(RuntimeVariables.replace("Dashboard"),
			selenium.getText("//nav/ul/li/a/span"));
		assertEquals(RuntimeVariables.replace("Contacts Center"),
			selenium.getText("//nav/ul/li[2]/a/span"));
		assertEquals(RuntimeVariables.replace("Microblogs"),
			selenium.getText("//nav/ul/li[3]/a/span"));
		assertEquals(RuntimeVariables.replace("Messages"),
			selenium.getText("//nav/ul/li[4]/a/span"));
		assertEquals(RuntimeVariables.replace("My Documents"),
			selenium.getText("//nav/ul/li[5]/a"));
		assertEquals(RuntimeVariables.replace("Tasks"),
			selenium.getText("//li[6]/a/span"));
	}
}