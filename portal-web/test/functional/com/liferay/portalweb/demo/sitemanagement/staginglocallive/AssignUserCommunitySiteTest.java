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

package com.liferay.portalweb.demo.sitemanagement.staginglocallive;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssignUserCommunitySiteTest extends BaseTestCase {
	public void testAssignUserCommunitySite() throws Exception {
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
		selenium.clickAt("link=Users and Organizations",
			RuntimeVariables.replace("Users and Organizations"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_125_keywords']",
			RuntimeVariables.replace("selen01"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("selen01"),
			selenium.getText("//td[2]/a"));
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("selen01"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//a[@id='_125_sitesLink']", "Sites"));
		selenium.clickAt("//a[@id='_125_sitesLink']",
			RuntimeVariables.replace("Sites"));
		selenium.waitForVisible("//div[@id='_125_sites']/span/a/span");
		assertEquals(RuntimeVariables.replace("Select"),
			selenium.getText("//div[@id='_125_sites']/span/a/span"));
		selenium.clickAt("//div[@id='_125_sites']/span/a/span",
			RuntimeVariables.replace("Select"));
		Thread.sleep(5000);
		selenium.selectWindow("name=group");
		selenium.waitForVisible("//tr[contains(.,'Site Name')]/td[1]/a");
		assertEquals(RuntimeVariables.replace("Site Name"),
			selenium.getText("//tr[contains(.,'Site Name')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Site Name')]/td[1]/a",
			RuntimeVariables.replace("Site Name"));
		Thread.sleep(5000);
		selenium.selectWindow("null");
		assertEquals(RuntimeVariables.replace("Site Name"),
			selenium.getText("//table/tr/td[1]"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}