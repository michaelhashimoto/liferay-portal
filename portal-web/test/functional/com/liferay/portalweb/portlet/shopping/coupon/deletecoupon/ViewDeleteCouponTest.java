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

package com.liferay.portalweb.portlet.shopping.coupon.deletecoupon;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDeleteCouponTest extends BaseTestCase {
	public void testViewDeleteCoupon() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Coupons", RuntimeVariables.replace("Coupons"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Categories"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[1]"));
		assertEquals(RuntimeVariables.replace("Cart"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[2]"));
		assertEquals(RuntimeVariables.replace("Orders"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[3]"));
		assertEquals(RuntimeVariables.replace("Coupons"),
			selenium.getText("//ul[@class='aui-tabview-list']/li[4]"));
		assertEquals(RuntimeVariables.replace("Code"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[1]/div/span[1]/span/label"));
		assertTrue(selenium.isVisible(
				"//div[@class='aui-fieldset-content ']/div[1]/div/span[1]/span/span/input"));
		assertTrue(selenium.isVisible(
				"//div[@class='aui-fieldset-content ']/div[1]/div/span[2]/span/span/select"));
		assertEquals(RuntimeVariables.replace("Discount Type"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[2]/div/span/span/label"));
		assertTrue(selenium.isVisible(
				"//div[@class='aui-fieldset-content ']/div[2]/div/span/span/span/select"));
		assertEquals(RuntimeVariables.replace("Active"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[3]/div/span/span/label"));
		assertTrue(selenium.isVisible(
				"//div[@class='aui-fieldset-content ']/div[3]/div/span/span/span/select"));
		assertEquals("Search",
			selenium.getValue(
				"xPath=(//div[@class='aui-button-holder ']/span[1]/span/input)[1]"));
		assertEquals("Add Coupon",
			selenium.getValue(
				"xPath=(//div[@class='aui-button-holder ']/span[2]/span/input)[1]"));
		assertEquals("Delete",
			selenium.getValue(
				"xPath=(//div[@class='aui-button-holder ']/span[1]/span/input)[2]"));
		selenium.waitForVisible("//div[@class='portlet-msg-info']");
		assertEquals(RuntimeVariables.replace("No coupons were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertFalse(selenium.isTextPresent("Shopping Coupon Name"));
		assertFalse(selenium.isTextPresent("Shopping Coupon Description"));
	}
}