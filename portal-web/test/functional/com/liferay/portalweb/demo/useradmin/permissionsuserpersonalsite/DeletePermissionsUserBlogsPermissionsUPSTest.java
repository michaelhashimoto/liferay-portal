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

package com.liferay.portalweb.demo.useradmin.permissionsuserpersonalsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeletePermissionsUserBlogsPermissionsUPSTest extends BaseTestCase {
	public void testDeletePermissionsUserBlogsPermissionsUPS()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("User"),
			selenium.getText("//tr[13]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[13]/td[4]/span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//tr[13]/td[4]/span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Define Permissions"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//tr[14]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText("//tr[14]/td[2]"));
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText("//tr[14]/td[3]"));
		assertEquals(RuntimeVariables.replace("User Personal Site"),
			selenium.getText("//tr[14]/td[4]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//tr[14]/td[5]/span/a/span"));
		selenium.clickAt("//tr[14]/td[5]/span/a/span",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("The permission was deleted."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertNotEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText("//tr[14]/td[3]"));
	}
}