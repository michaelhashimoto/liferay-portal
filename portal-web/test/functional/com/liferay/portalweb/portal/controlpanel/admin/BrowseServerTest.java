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

package com.liferay.portalweb.portal.controlpanel.admin;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class BrowseServerTest extends BaseTestCase {
	public void testBrowseServer() throws Exception {
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
		selenium.clickAt("link=Server Administration",
			RuntimeVariables.replace("Server Administration"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent("link=Resources");
		selenium.clickAt("//input[@value='Execute']",
			RuntimeVariables.replace("Execute"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Log Levels",
			RuntimeVariables.replace("Log Levels"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Update Categories"));
		assertTrue(selenium.isElementPresent("link=Add Category"));
		selenium.clickAt("link=Update Categories",
			RuntimeVariables.replace("Update Categories"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Showing 1 - 20"));
		assertTrue(selenium.isTextPresent("com.ecyrd.jspwiki"));
		selenium.clickAt("link=Next", RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Showing 21 - 40"));
		assertTrue(selenium.isTextPresent("com.liferay.portal.convert"));
		selenium.clickAt("link=Properties",
			RuntimeVariables.replace("Properties"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=System Properties"));
		assertTrue(selenium.isElementPresent("link=Portal Properties"));
		selenium.clickAt("link=System Properties",
			RuntimeVariables.replace("System Properties"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Showing 1 - 20"));
		assertTrue(selenium.isTextPresent(
				"com.liferay.portal.kernel.util.StreamUtil.buffer.size"));
		selenium.clickAt("link=Next", RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Showing 21 - 40"));
		assertEquals(RuntimeVariables.replace("System Properties"),
			selenium.getText(
				"//ul[2]/li[contains(@class,'aui-selected')]/span/a"));
		selenium.clickAt("link=Portal Properties",
			RuntimeVariables.replace("Portal Properties"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Showing 1 - 20"));
		assertTrue(selenium.isTextPresent("admin.email.from.address"));
		selenium.clickAt("link=Next", RuntimeVariables.replace("Next"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Showing 21 - 40"));
		assertTrue(selenium.isTextPresent("aim.password"));
		selenium.clickAt("link=Data Migration",
			RuntimeVariables.replace("Data Migration"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=File Uploads",
			RuntimeVariables.replace("File Uploads"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Configure the file upload settings."));
		assertTrue(selenium.isElementPresent("//input[@value='Save']"));
		selenium.clickAt("link=Mail", RuntimeVariables.replace("Mail"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Configure the mail server settings."));
		assertTrue(selenium.isElementPresent("//input[@value='Save']"));
		selenium.clickAt("link=External Services",
			RuntimeVariables.replace("External Services"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Enabling OpenOffice integration provides document conversion functionality."));
		assertTrue(selenium.isElementPresent(
				"//input[@id='_137_openOfficeEnabledCheckbox']"));
		assertTrue(selenium.isElementPresent("//input[@value='Save']"));
		selenium.clickAt("link=Shutdown", RuntimeVariables.replace("Shutdown"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//input[@value='Shutdown']"));
	}
}