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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.shopping.order;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddToShoppingCartCategoryItemTest extends BaseTestCase {
	public void testAddToShoppingCartCategoryItem() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/shopping-order-community/");
		selenium.waitForVisible("link=Shopping Order Page");
		selenium.clickAt("link=Shopping Order Page",
			RuntimeVariables.replace("Shopping Order Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[1]/a", RuntimeVariables.replace("Category Test"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Item Test"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace(
				"//input[@value='Add to Shopping Cart']"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isPartialText("//td[2]/a", "Item Test"));
		assertTrue(selenium.isPartialText("//td[2]/a", "This is an item test."));
		assertTrue(selenium.isPartialText("//td[2]/a", "Availability:"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText(
				"//div[.='In Stock' and @class='portlet-msg-success']"));
		assertTrue(selenium.isPartialText("//td[2]/a",
				"Price for 1 Items and Above:"));
		assertTrue(selenium.isPartialText("//td[2]/a", "$"));
		assertTrue(selenium.isPartialText("//td[2]/a", "9.99"));
	}
}