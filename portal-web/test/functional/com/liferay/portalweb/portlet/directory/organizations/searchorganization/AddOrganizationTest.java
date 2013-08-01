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

package com.liferay.portalweb.portlet.directory.organizations.searchorganization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationTest extends BaseTestCase {
	public void testAddOrganization() throws Exception {
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
		selenium.clickAt("link=Add", RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Regular Organization"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
			RuntimeVariables.replace("Regular Organization"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_125_name']",
			RuntimeVariables.replace("Test Organization"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("//a[@id='_125_addressesLink']",
			RuntimeVariables.replace("Addresses"));
		selenium.waitForVisible("//input[contains(@id,'addressStreet1')]");
		selenium.type("//input[contains(@id,'addressStreet1')]",
			RuntimeVariables.replace("12345 Test Street"));
		selenium.select("//select[contains(@id,'addressType')]",
			RuntimeVariables.replace("Billing"));
		selenium.type("//input[contains(@id,'addressZip')]",
			RuntimeVariables.replace("11111"));
		selenium.type("//input[contains(@id,'addressCity')]",
			RuntimeVariables.replace("Diamond Bar"));
		selenium.clickAt("//input[contains(@id,'addressPrimary')]",
			RuntimeVariables.replace("Primary"));
		selenium.waitForPartialText("//select[contains(@id,'addressCountry')]",
			"United States");
		selenium.select("//select[contains(@id,'addressCountry')]",
			RuntimeVariables.replace("United States"));
		selenium.clickAt("//input[contains(@id,'addressMailing') and contains(@type,'checkbox')]",
			RuntimeVariables.replace("Mailing"));
		selenium.waitForPartialText("//select[contains(@id,'addressRegion')]",
			"California");
		selenium.select("//select[contains(@id,'addressRegion')]",
			RuntimeVariables.replace("California"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}