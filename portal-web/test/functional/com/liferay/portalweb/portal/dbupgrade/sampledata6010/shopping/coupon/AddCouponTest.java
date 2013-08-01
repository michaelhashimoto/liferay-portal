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

package com.liferay.portalweb.portal.dbupgrade.sampledata6010.shopping.coupon;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCouponTest extends BaseTestCase {
	public void testAddCoupon() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Manage"),
			selenium.getText("//li[@id='_145_manageContent']/a/span"));
		selenium.mouseOver("//li[@id='_145_manageContent']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Shopping Coupon Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Shopping Coupon Page",
			RuntimeVariables.replace("Shopping Coupon Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Coupons", RuntimeVariables.replace("Coupons"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Coupon']",
			RuntimeVariables.replace("Add Coupon"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//input[@id='_34_autoCodeCheckbox']"));
		selenium.clickAt("//input[@id='_34_autoCodeCheckbox']",
			RuntimeVariables.replace("Checkbox"));
		assertTrue(selenium.isChecked("//input[@id='_34_autoCodeCheckbox']"));
		selenium.type("//input[@id='_34_name']",
			RuntimeVariables.replace("Coupon Test"));
		selenium.type("//textarea[@id='_34_description']",
			RuntimeVariables.replace("This is a coupon test."));
		selenium.type("//input[@name='_34_discount']",
			RuntimeVariables.replace("0.50"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isTextPresent("Coupon Test\nThis is a coupon test."));
	}
}