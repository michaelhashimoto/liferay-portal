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
public class User_ViewOffPermissionsBlogsUSPTest extends BaseTestCase {
	public void testUser_ViewOffPermissionsBlogsUSP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/usersn/home/");
		selenium.waitForVisible(
			"xPath=(//div[@class='portlet-body']/section)[3]");
		assertTrue(selenium.isElementNotPresent(
				"//div[@class='subscribe']/span[2]/a/span"));
		assertTrue(selenium.isElementNotPresent(
				"//input[@value='Add Blog Entry']"));
		assertTrue(selenium.isElementNotPresent("//input[@value='Permissions']"));
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//a[@class='menu-button']/span"));
		selenium.clickAt("//a[@class='menu-button']/span",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible("//a[@id='_145_addApplication']");
		assertTrue(selenium.isPartialText("//a[@id='_145_addApplication']",
				"More"));
		selenium.clickAt("//a[@id='_145_addApplication']",
			RuntimeVariables.replace("More"));
		selenium.waitForVisible("//input[@id='layout_configuration_content']");
		assertTrue(selenium.isElementNotPresent("//div[@title='Blogs']"));
	}
}