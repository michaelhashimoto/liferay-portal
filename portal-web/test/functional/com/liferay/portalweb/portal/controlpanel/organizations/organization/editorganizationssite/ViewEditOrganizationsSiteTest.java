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

package com.liferay.portalweb.portal.controlpanel.organizations.organization.editorganizationssite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEditOrganizationsSiteTest extends BaseTestCase {
	public void testViewEditOrganizationsSite() throws Exception {
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
		selenium.clickAt("link=Sites", RuntimeVariables.replace("Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Organization"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Name"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[1]/th[1]"));
		assertEquals(RuntimeVariables.replace("Type"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[1]/th[2]"));
		assertEquals(RuntimeVariables.replace("Members"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[1]/th[3]"));
		assertEquals(RuntimeVariables.replace("Active"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[1]/th[4]"));
		assertEquals(RuntimeVariables.replace("Pending Requests"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[1]/th[5]"));
		assertEquals(RuntimeVariables.replace("Tags"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[1]/th[6]"));
		assertTrue(selenium.isPartialText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[3]/td[1]",
				"Organization1 Name"));
		assertEquals(RuntimeVariables.replace("Private"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("1 Organization"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Yes"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[3]/td[4]"));
		selenium.clickAt("//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[3]/td[1]/a",
			RuntimeVariables.replace("Organization1 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Settings"),
			selenium.getText("//h1[@class='portlet-title']/span"));
		assertEquals(RuntimeVariables.replace("Organization1 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isPartialText(
				"//div[@id='_165_details']/fieldset/div/div/div",
				"Organization1 Name"));
		assertEquals("Private",
			selenium.getSelectedLabel("//select[@id='_165_type']"));
		assertTrue(selenium.isChecked("//input[@id='_165_activeCheckbox']"));
		selenium.clickAt("link=\u00ab Back",
			RuntimeVariables.replace("\u00ab Back"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[4]/td[1]",
				"Organization2 Name"));
		assertEquals(RuntimeVariables.replace("Private"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[4]/td[2]"));
		assertEquals(RuntimeVariables.replace("1 Organization"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[4]/td[3]"));
		assertEquals(RuntimeVariables.replace("Yes"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[4]/td[4]"));
		selenium.clickAt("//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[4]/td[1]/a",
			RuntimeVariables.replace("Organization2 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Settings"),
			selenium.getText("//h1[@class='portlet-title']/span"));
		assertEquals(RuntimeVariables.replace("Organization2 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isPartialText(
				"//div[@id='_165_details']/fieldset/div/div/div",
				"Organization2 Name"));
		assertEquals("Private",
			selenium.getSelectedLabel("//select[@id='_165_type']"));
		assertTrue(selenium.isChecked("//input[@id='_165_activeCheckbox']"));
		selenium.clickAt("link=\u00ab Back",
			RuntimeVariables.replace("\u00ab Back"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[5]/td[1]",
				"Organization3 Name"));
		assertEquals(RuntimeVariables.replace("Private"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[5]/td[2]"));
		assertEquals(RuntimeVariables.replace("1 Organization"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[5]/td[3]"));
		assertEquals(RuntimeVariables.replace("Yes"),
			selenium.getText(
				"//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[5]/td[4]"));
		selenium.clickAt("//div[@id='_134_groupsSearchContainer']/div/table/tbody/tr[5]/td[1]/a",
			RuntimeVariables.replace("Organization3 Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Site Settings"),
			selenium.getText("//h1[@class='portlet-title']/span"));
		assertEquals(RuntimeVariables.replace("Organization3 Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isPartialText(
				"//div[@id='_165_details']/fieldset/div/div/div",
				"Organization3 Name"));
		assertEquals("Private",
			selenium.getSelectedLabel("//select[@id='_165_type']"));
		assertTrue(selenium.isChecked("//input[@id='_165_activeCheckbox']"));
	}
}