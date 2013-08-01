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
public class AddCategory1ItemTest extends BaseTestCase {
	public void testAddCategory1Item() throws Exception {
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
				"//tr[@class='portlet-section-body results-row last']/td[1]/a",
				"Shopping Category1 Name"));
		assertTrue(selenium.isPartialText(
				"//tr[@class='portlet-section-body results-row last']/td[1]/a",
				"Shopping Category1 Description"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[1]/a",
			RuntimeVariables.replace(
				"Shopping Category1 Name Shopping Category1 Description"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Item']",
			RuntimeVariables.replace("Add Item"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_34_sku']", RuntimeVariables.replace("1111"));
		selenium.type("//input[@id='_34_name']",
			RuntimeVariables.replace("Shopping Category1 Item Name"));
		selenium.type("//textarea[@id='_34_description']",
			RuntimeVariables.replace("Shopping Category1 Item Description"));
		selenium.type("//textarea[@id='_34_properties']",
			RuntimeVariables.replace("Shopping Category1 Item Properties"));
		assertFalse(selenium.isChecked(
				"//input[@id='_34_requiresShippingCheckbox']"));
		selenium.clickAt("//input[@id='_34_requiresShippingCheckbox']",
			RuntimeVariables.replace("Requires Shipping"));
		assertTrue(selenium.isChecked(
				"//input[@id='_34_requiresShippingCheckbox']"));
		selenium.type("//input[@id='_34_stockQuantity']",
			RuntimeVariables.replace("50"));
		selenium.type("//input[@id='_34_minQuantity0']",
			RuntimeVariables.replace("1"));
		selenium.type("//input[@id='_34_maxQuantity0']",
			RuntimeVariables.replace("1"));
		selenium.type("//input[@id='_34_price0']",
			RuntimeVariables.replace("$9.99"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
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