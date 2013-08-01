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

package com.liferay.portalweb.portal.permissions.imagegallery.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteAdmin_MoveImageTest extends BaseTestCase {
	public void testSiteAdmin_MoveImage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Folder"),
			selenium.getText(
				"//a[@title='Media Gallery Permissions Test Folder - ']"));
		selenium.clickAt("//a[@title='Media Gallery Permissions Test Folder - ']",
			RuntimeVariables.replace("Media Gallery Permissions Test Folder"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Subfolder"),
			selenium.getText(
				"//a[@title='Media Gallery Permissions Test Subfolder - ']"));
		selenium.clickAt("//a[@title='Media Gallery Permissions Test Subfolder - ']",
			RuntimeVariables.replace("Media Gallery Permissions Test Subfolder"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Permissions Image Test"),
			selenium.getText("//a[@title='Permissions Image Test - ']"));
		selenium.clickAt("//a[@title='Permissions Image Test - ']",
			RuntimeVariables.replace("Permissions Image Test"));
		selenium.waitForVisible("//img[@title='View']");
		selenium.clickAt("//img[@title='View']",
			RuntimeVariables.replace("View"));
		selenium.waitForVisible("//button[contains(.,'Move')]");
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText("//button[contains(.,'Move')]"));
		selenium.clickAt("//button[contains(.,'Move')]",
			RuntimeVariables.replace("Move"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Media Gallery");
		selenium.waitForVisible("link=Home");
		selenium.clickAt("link=Home", RuntimeVariables.replace("Home"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("link=Media Gallery Permissions Test Folder 2");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Folder 2"),
			selenium.getText("link=Media Gallery Permissions Test Folder 2"));
		selenium.clickAt("link=Media Gallery Permissions Test Folder 2",
			RuntimeVariables.replace("Media Gallery Permissions Test Folder 2"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//li[@class='last']");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Subfolder 2"),
			selenium.getText("//td[contains(.,'Test Subfolder 2')]/a"));
		selenium.clickAt("//td[contains(.,'Test Subfolder 2')]/a",
			RuntimeVariables.replace(
				"Media Gallery Permissions Test Subfolder 2"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//li[@class='last']");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Subfolder 2"),
			selenium.getText("//li[@class='last']"));
		selenium.click("//input[@value='Choose This Folder']");
		selenium.selectWindow("null");
		selenium.waitForText("//a[contains(.,'Test Subfolder 2')]",
			"Media Gallery Permissions Test Subfolder 2");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Subfolder 2"),
			selenium.getText("//a[contains(.,'Test Subfolder 2')]"));
		selenium.waitForVisible("//input[@value='Move']");
		selenium.clickAt("//input[@value='Move']",
			RuntimeVariables.replace("Move"));
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Folder 2"),
			selenium.getText(
				"//a[@title='Media Gallery Permissions Test Folder 2 - ']"));
		selenium.clickAt("//a[@title='Media Gallery Permissions Test Folder 2 - ']",
			RuntimeVariables.replace("Media Gallery Permissions Test Folder 2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Media Gallery Permissions Test Subfolder 2"),
			selenium.getText(
				"//a[@title='Media Gallery Permissions Test Subfolder 2 - ']"));
		selenium.clickAt("//a[@title='Media Gallery Permissions Test Subfolder 2 - ']",
			RuntimeVariables.replace(
				"Media Gallery Permissions Test Subfolder 2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Permissions Image Test"),
			selenium.getText("//a[@title='Permissions Image Test - ']"));
	}
}