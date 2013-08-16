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

package com.liferay.portalweb.portal.tags.tagsadmin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewTagOrderTest extends BaseTestCase {
	public void testViewTagOrder() throws Exception {
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
		selenium.clickAt("link=Tags", RuntimeVariables.replace("Tags"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//div[@class='lfr-header-row-content']/div/span[@title='Actions']/ul/li/strong/a/span"));
		assertEquals("Add Tag",
			selenium.getValue(
				"//div[contains(@class,'tags-admin-actions')]/span/span/input[contains(@id,'addTagButton')]"));
		assertEquals("Permissions",
			selenium.getValue(
				"//div[contains(@class,'tags-admin-actions')]/span/span/input[contains(@id,'tagsPermissionsButton')]"));
		assertTrue(selenium.isVisible(
				"//div[@class='lfr-header-row-content']/div/span/span/span/input[contains(@id,'tagsAdminSearchInput')]"));
		assertEquals(RuntimeVariables.replace("Tags"),
			selenium.getText(
				"//div[contains(@class,'tags-admin-list-container-content')]/div[1]"));
		assertTrue(selenium.isVisible(
				"//div[contains(@class,'tags-admin-list-container-content')]/div[2]"));
		assertEquals(RuntimeVariables.replace("blue"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[1]"));
		assertEquals(RuntimeVariables.replace("blue car"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[2]"));
		assertEquals(RuntimeVariables.replace("blue green"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[3]"));
		assertEquals(RuntimeVariables.replace("green"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[4]"));
		assertEquals(RuntimeVariables.replace("green tree"),
			selenium.getText(
				"//div[@class='tags-admin-list lfr-component']/ul/li[5]"));
	}
}