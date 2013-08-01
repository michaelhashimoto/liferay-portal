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

package com.liferay.portalweb.portal.dbupgrade.sampledata611.shopping.item;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCategoryItemTest extends BaseTestCase {
	public void testViewCategoryItem() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/shopping-item-community/");
		selenium.waitForVisible("link=Shopping Item Page");
		selenium.clickAt("link=Shopping Item Page",
			RuntimeVariables.replace("Shopping Item Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Categories",
			RuntimeVariables.replace("Categories"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace("//td[1]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace("//td[2]/a"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1111"),
			selenium.getText("//td[1]/strong"));
		assertTrue(selenium.isPartialText("//td[3]", "Item Test"));
		assertTrue(selenium.isPartialText("//td[3]", "This is an item test."));
		assertTrue(selenium.isPartialText("//td[3]", "Limited: Time Only"));
		assertTrue(selenium.isPartialText("//td[3]",
				"Price for 1 Items and Above: "));
		assertTrue(selenium.isPartialText("//td[3]", "$"));
		assertTrue(selenium.isPartialText("//td[3]", "9.99"));
		assertTrue(selenium.isPartialText("//td[3]", "Availability:"));
		assertEquals(RuntimeVariables.replace("In Stock"),
			selenium.getText(
				"//div[.='In Stock' and @class='portlet-msg-success']"));
	}
}