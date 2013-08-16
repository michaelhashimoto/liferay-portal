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

package com.liferay.portalweb.portlet.shopping.item.movecategory1itemtocategory2;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveCategory1ItemToCategory2Test extends BaseTestCase {
	public void testMoveCategory1ItemToCategory2() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Categories",
			RuntimeVariables.replace("Categories"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[1]/a",
				"Shopping Category1 Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[1]/a",
				"Shopping Category1 Description"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[1]/a",
			RuntimeVariables.replace(
				"Shopping Category1 Name Shopping Category1 Description"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Category1 Item"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Category1 Item Description"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping: Category1 Item Properties"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Edit')]",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Shopping Category1 Name"),
			selenium.getText("//a[@id='_34_categoryName']"));
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		selenium.waitForPopUp("Shopping", RuntimeVariables.replace("30000"));
		selenium.selectWindow("Shopping");
		selenium.waitForText("//h1[@class='header-title']", "Categories");
		assertEquals(RuntimeVariables.replace("Categories"),
			selenium.getText("//h1[@class='header-title']"));
		selenium.waitForText("//div[@class='breadcrumbs']/span[1]/a",
			"Categories");
		assertEquals(RuntimeVariables.replace("Categories"),
			selenium.getText("//div[@class='breadcrumbs']/span[1]/a"));
		assertEquals(RuntimeVariables.replace("Shopping Category1 Name"),
			selenium.getText("//div[@class='breadcrumbs']/span[2]/a"));
		selenium.clickAt("//div[@class='breadcrumbs']/span[1]/a",
			RuntimeVariables.replace("Categories"));
		selenium.waitForPageToLoad("30000");
		selenium.click("xPath=(//input[@type='button'])[2]");
		selenium.selectWindow("null");
		selenium.waitForText("//a[@id='_34_categoryName']",
			"Shopping Category2 Name");
		assertEquals(RuntimeVariables.replace("Shopping Category2 Name"),
			selenium.getText("//a[@id='_34_categoryName']"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertFalse(selenium.isTextPresent("Shopping Category1 Item Name"));
		assertFalse(selenium.isTextPresent(
				"Shopping Category1 Item Description"));
		assertFalse(selenium.isTextPresent(
				"Shopping: Category1 Item Properties"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Categories",
			RuntimeVariables.replace("Categories"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-alternate results-row alt last']/td[1]/a",
				"Shopping Category2 Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-alternate results-row alt last']/td[1]/a",
				"Shopping Category2 Description"));
		selenium.clickAt("//tr[@class='portlet-section-alternate results-row alt last']/td[1]/a",
			RuntimeVariables.replace(
				"Shopping Category2 Name Shopping Category2 Description"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Category1 Item"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Category1 Item Description"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping: Category1 Item Properties"));
	}
}