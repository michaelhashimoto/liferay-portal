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

package com.liferay.portalweb.portlet.shopping.item.addtoshoppingcartcategoryitem;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddToShoppingCartCategoryItem3Test extends BaseTestCase {
	public void testAddToShoppingCartCategoryItem3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[1]/a",
				"Shopping Category Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[1]/a",
				"Shopping Category Description"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[1]/a",
			RuntimeVariables.replace(
				"Shopping Category Name Shopping Category Description"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Category Item3 Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping Category Item3 Description"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]/a",
				"Shopping: Category Item3 Properties"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[2]/a",
			RuntimeVariables.replace(
				"Shopping Category Item3 Name Shopping Category Item3 Description Shopping: Category Item3 Properties"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Shopping Category Item3 Name"),
			selenium.getText("xPath=(//td[@class='lfr-top'])[2]/span/strong"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Shopping Category Item3 Description"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Shopping: Category Item3 Properties"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Price for 1 to 1 Items:"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"9.99"));
		assertTrue(selenium.isPartialText("xPath=(//td[@class='lfr-top'])[2]",
				"Availability:"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.clickAt("//input[@value='Add to Shopping Cart']",
			RuntimeVariables.replace("Add to Shopping Cart"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Cart", RuntimeVariables.replace("Cart"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[2]",
				"Shopping Category Item1 Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[2]",
				"Shopping Category Item1 Description"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[2]",
				"Availability:"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[2]",
				"Price for 1 to 1 Items"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row']/td[2]", "9.99"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-alternate results-row alt']/td[2]",
				"Shopping Category Item2 Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-alternate results-row alt']/td[2]",
				"Shopping Category Item2 Description"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-alternate results-row alt']/td[2]",
				"Availability:"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-alternate results-row alt']/td[2]",
				"Price for 1 to 1 Items"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-alternate results-row alt']/td[2]",
				"9.99"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]",
				"Shopping Category Item3 Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]",
				"Shopping Category Item3 Description"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]",
				"Availability:"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]",
				"Price for 1 to 1 Items"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[2]",
				"9.99"));
	}
}