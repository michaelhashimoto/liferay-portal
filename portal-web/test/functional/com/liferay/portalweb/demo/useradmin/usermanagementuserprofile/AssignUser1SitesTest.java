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
public class AssignUser1SitesTest extends BaseTestCase {
	public void testAssignUser1Sites() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Users and Organizations",
			RuntimeVariables.replace("Users and Organizations"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("selen01"),
			selenium.getText(
				"//div[2]/div[2]/div/div[1]/div/table/tbody/tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"xpath=(//span[@title='Actions']/ul/li/strong/a)[2]"));
		selenium.clickAt("xpath=(//span[@title='Actions']/ul/li/strong/a)[2]",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_125_sitesLink']", "Sites"));
		selenium.clickAt("//a[@id='_125_sitesLink']",
			RuntimeVariables.replace("Sites"));
		selenium.waitForVisible("//div[4]/span/a/span");
		assertEquals(RuntimeVariables.replace("Select"),
			selenium.getText("//div[4]/span/a/span"));
		selenium.clickAt("//div[4]/span/a/span",
			RuntimeVariables.replace("Select"));
		Thread.sleep(5000);
		selenium.selectWindow("Users and Organizations");
		selenium.waitForVisible(
			"//form[@id='_125_fm']/div[3]/div/div/table/tbody/tr[3]/td/a");
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText(
				"//form[@id='_125_fm']/div[3]/div/div/table/tbody/tr[3]/td/a"));
		selenium.clickAt("//form[@id='_125_fm']/div[3]/div/div/table/tbody/tr[3]/td/a",
			RuntimeVariables.replace("Liferay"));
		selenium.selectWindow("null");
		selenium.waitForVisible(
			"//div[@id='_125_sites']/div/div/div/table/tr/td");
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//div[@id='_125_sites']/div/div/div/table/tr/td"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Liferay"),
			selenium.getText("//tr[3]/td[1]"));
	}
}