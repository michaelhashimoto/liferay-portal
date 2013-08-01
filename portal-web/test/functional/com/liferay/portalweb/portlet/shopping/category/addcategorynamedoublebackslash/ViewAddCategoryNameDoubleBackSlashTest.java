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

package com.liferay.portalweb.portlet.shopping.category.addcategorynamedoublebackslash;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAddCategoryNameDoubleBackSlashTest extends BaseTestCase {
	public void testViewAddCategoryNameDoubleBackSlash()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Categories",
			RuntimeVariables.replace("Categories"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Categories"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[1]"));
		assertEquals(RuntimeVariables.replace("Cart"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[2]"));
		assertEquals(RuntimeVariables.replace("Orders"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[3]"));
		assertEquals(RuntimeVariables.replace("Coupons"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[4]"));
		assertEquals(RuntimeVariables.replace("Categories"),
			selenium.getText("//div[@class='breadcrumbs']"));
		assertEquals(RuntimeVariables.replace("Categories"),
			selenium.getText("//div[@id='shoppingCategoriesPanel']/div[1]/div"));
		assertEquals("Add Category",
			selenium.getValue(
				"//div[@id='shoppingCategoriesPanel']/div[2]/div[1]/span[1]/span/input"));
		assertEquals("Permissions",
			selenium.getValue(
				"//div[@id='shoppingCategoriesPanel']/div[2]/div[1]/span[2]/span/input"));
		assertEquals(RuntimeVariables.replace("Items"),
			selenium.getText("//div[@id='shoppingItemsPanel']/div[1]/div"));
		assertEquals("Add Item",
			selenium.getValue(
				"//div[@id='shoppingItemsPanel']/div[2]/div/span/span/input"));
		assertFalse(selenium.isTextPresent("Shopping\\\\ Category\\\\ Name\\\\"));
		assertFalse(selenium.isTextPresent(
				"Shopping\\\\ Category\\\\ Description\\\\"));
	}
}