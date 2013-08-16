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

package com.liferay.portalweb.demo.useradmin.usermanagementuserprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddUserGroup2Test extends BaseTestCase {
	public void testAddUserGroup2() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=User Groups",
			RuntimeVariables.replace("User Groups"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("link=Add"));
		selenium.clickAt("link=Add", RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//input[@id='_127_name']");
		selenium.type("//input[@id='_127_name']",
			RuntimeVariables.replace("User Group 2"));
		selenium.type("//textarea[@id='_127_description']",
			RuntimeVariables.replace("This is a selenium user group."));
		assertTrue(selenium.isPartialText(
				"//select[@id='_127_publicLayoutSetPrototypeId']",
				"Community Site"));
		selenium.select("//select[@id='_127_publicLayoutSetPrototypeId']",
			RuntimeVariables.replace("Community Site"));
		selenium.waitForVisible(
			"//input[@id='_127_publicLayoutSetPrototypeLinkEnabledCheckbox']");
		assertTrue(selenium.isChecked(
				"//input[@id='_127_publicLayoutSetPrototypeLinkEnabledCheckbox']"));
		selenium.clickAt("//input[@id='_127_publicLayoutSetPrototypeLinkEnabledCheckbox']",
			RuntimeVariables.replace("Enable propagation of changes"));
		assertFalse(selenium.isChecked(
				"//input[@id='_127_publicLayoutSetPrototypeLinkEnabledCheckbox']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("User Group 2"),
			selenium.getText("//tr[4]/td[2]/a"));
	}
}