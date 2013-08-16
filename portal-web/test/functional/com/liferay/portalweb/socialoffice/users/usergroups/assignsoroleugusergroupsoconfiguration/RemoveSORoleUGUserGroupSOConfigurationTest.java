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

package com.liferay.portalweb.socialoffice.users.usergroups.assignsoroleugusergroupsoconfiguration;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemoveSORoleUGUserGroupSOConfigurationTest extends BaseTestCase {
	public void testRemoveSORoleUGUserGroupSOConfiguration()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Social Office Configurations",
			RuntimeVariables.replace("Social Office Configurations"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//li/span/a[contains(.,'User Groups')]",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"//input[contains(@id,'soconfigurationsportlet_keywords')]");
		selenium.type("//input[contains(@id,'soconfigurationsportlet_keywords')]",
			RuntimeVariables.replace("UG UserGroup Name"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("UG UserGroup Name"),
			selenium.getText(
				"//td[contains(@id,'soconfigurationsportlet_userGroupsSearchContainer_col-name_row-1')]"));
		assertTrue(selenium.isChecked(
				"//input[contains(@name,'soconfigurationsportlet_allRowIds')]"));
		selenium.clickAt("//input[contains(@name,'soconfigurationsportlet_allRowIds')]",
			RuntimeVariables.replace("Select All"));
		assertFalse(selenium.isChecked(
				"//input[contains(@name,'soconfigurationsportlet_allRowIds')]"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}