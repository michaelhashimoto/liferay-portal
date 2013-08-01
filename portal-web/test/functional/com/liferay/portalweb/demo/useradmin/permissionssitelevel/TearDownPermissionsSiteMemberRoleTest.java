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

package com.liferay.portalweb.demo.useradmin.permissionssitelevel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownPermissionsSiteMemberRoleTest extends BaseTestCase {
	public void testTearDownPermissionsSiteMemberRole()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_128_keywords']",
			RuntimeVariables.replace("Member"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Member"),
			selenium.getText("//tr[3]/td/a"));
		selenium.clickAt("//tr[3]/td/a", RuntimeVariables.replace("Site Member"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//span/a/span", RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//span/a/span", RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//span/a/span", RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"This role does not have any permissions."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}