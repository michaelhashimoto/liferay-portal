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

package com.liferay.portalweb.portlet.blogs.portlet.configureportletremoveallpermissions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletRemoveAllPermissionTest extends BaseTestCase {
	public void testConfigurePortletRemoveAllPermission()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible("//iframe[@id='_33_configurationIframeDialog']");
		selenium.selectFrame("//iframe[@id='_33_configurationIframeDialog']");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("link=Permissions");
		selenium.clickAt("link=Permissions",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForVisible("//td[4]/input");
		assertTrue(selenium.isChecked("//td[4]/input"));
		selenium.clickAt("//td[4]/input", RuntimeVariables.replace("Guest View"));
		assertFalse(selenium.isChecked("//td[4]/input"));
		assertTrue(selenium.isChecked("//tr[4]/td[2]/input"));
		selenium.clickAt("//tr[4]/td[2]/input",
			RuntimeVariables.replace("Owner Add to Page"));
		assertFalse(selenium.isChecked("//tr[4]/td[2]/input"));
		assertTrue(selenium.isChecked("//tr[4]/td[3]/input"));
		selenium.clickAt("//tr[4]/td[3]/input",
			RuntimeVariables.replace("Owner Configuration"));
		assertFalse(selenium.isChecked("//tr[4]/td[3]/input"));
		assertTrue(selenium.isChecked("//tr[4]/td[4]/input"));
		selenium.clickAt("//tr[4]/td[4]/input",
			RuntimeVariables.replace("Owner View"));
		assertFalse(selenium.isChecked("//tr[4]/td[4]/input"));
		assertTrue(selenium.isChecked("//tr[4]/td[5]/input"));
		selenium.clickAt("//tr[4]/td[5]/input",
			RuntimeVariables.replace("Owner Permissions"));
		assertFalse(selenium.isChecked("//tr[4]/td[5]/input"));
		assertTrue(selenium.isChecked("//tr[7]/td[4]/input"));
		selenium.clickAt("//tr[7]/td[4]/input",
			RuntimeVariables.replace("Site Member View"));
		assertFalse(selenium.isChecked("//tr[7]/td[4]/input"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request completed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible("//iframe[@id='_33_configurationIframeDialog']");
		selenium.selectFrame("//iframe[@id='_33_configurationIframeDialog']");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("link=Permissions");
		selenium.clickAt("link=Permissions",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForVisible("//td[4]/input");
		assertFalse(selenium.isChecked("//td[4]/input"));
		assertFalse(selenium.isChecked("//tr[4]/td[2]/input"));
		assertFalse(selenium.isChecked("//tr[4]/td[3]/input"));
		assertFalse(selenium.isChecked("//tr[4]/td[4]/input"));
		assertFalse(selenium.isChecked("//tr[4]/td[5]/input"));
		assertFalse(selenium.isChecked("//tr[7]/td[4]/input"));
		selenium.selectFrame("relative=top");
	}
}