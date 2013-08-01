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

package com.liferay.portalweb.portlet.shopping.coupon.addcouponcodenumber;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCouponCodeNumberTest extends BaseTestCase {
	public void testAddCouponCodeNumber() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Coupons", RuntimeVariables.replace("Coupons"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Coupon']",
			RuntimeVariables.replace("Add Coupon"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_34_code']",
			RuntimeVariables.replace("123456789"));
		selenium.type("//input[@id='_34_name']",
			RuntimeVariables.replace("Shopping Coupon Name"));
		selenium.type("//textarea[@id='_34_description']",
			RuntimeVariables.replace("Shopping Coupon Description"));
		selenium.type("//input[@id='_34_discount']",
			RuntimeVariables.replace("0.50"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request failed to complete."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[1]"));
		assertEquals(RuntimeVariables.replace("Please enter a valid code."),
			selenium.getText("xPath=(//div[@class='portlet-msg-error'])[2]"));
	}
}