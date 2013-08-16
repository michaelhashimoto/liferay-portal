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

package com.liferay.portalweb.demo.useradmin.usermanagementorganizations;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewOrganizationTest extends BaseTestCase {
	public void testViewOrganization() throws Exception {
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
		selenium.type("//input[@id='_125_keywords']",
			RuntimeVariables.replace("Test Organization 1 Edited"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Organization 1 Edited"),
			selenium.getText("//a[2]/strong"));
		selenium.click(RuntimeVariables.replace("//a[2]/strong"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Organization 1 Edited"),
			selenium.getText("//h1[@class='header-title']"));
		assertTrue(selenium.isPartialText(
				"//div[@class='section entity-email-addresses']/ul/li",
				"testuser@liferay.com"));
		assertEquals(RuntimeVariables.replace("1-877-543-3729 8888 Local"),
			selenium.getText("//div[@class='section entity-phones']/ul/li"));
		assertEquals(RuntimeVariables.replace("http://www.liferay.com Public"),
			selenium.getText("//div[@class='section entity-websites']/ul/li"));
		assertEquals(RuntimeVariables.replace("Billing"),
			selenium.getText(
				"//div[@class='section entity-addresses']/ul/li/em"));
		assertTrue(selenium.isPartialText(
				"//div[@class='section entity-addresses']/ul/li",
				"1220 Brea Canyon Rd"));
		assertTrue(selenium.isPartialText(
				"//div[@class='section entity-addresses']/ul/li",
				"91789, Walnut"));
		assertTrue(selenium.isPartialText(
				"//div[@class='section entity-comments']",
				"This is a test comment."));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//a[@id='_125_reminderQueriesLink']", "Reminder Queries"));
		selenium.clickAt("//a[@id='_125_reminderQueriesLink']",
			RuntimeVariables.replace("Reminder Queries"));
		selenium.waitForVisible("//textarea[@id='_125_reminderQueries']");
		assertEquals(RuntimeVariables.replace(
				"This is a Reminder Queries Test."),
			selenium.getText("//textarea[@id='_125_reminderQueries']"));
		selenium.select("//select[@id='_125_reminderQueryLanguageId']",
			RuntimeVariables.replace("Japanese (Japan)"));
		Thread.sleep(5000);
		assertEquals("\u65e5\u672c\u8a9e",
			selenium.getValue("//textarea[@id='_125_reminderQueries_temp']"));
	}
}