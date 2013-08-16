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

package com.liferay.portalweb.portal.dbupgrade.sampledata611.shopping.coupon;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCouponTest extends BaseTestCase {
	public void testViewCoupon() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/shopping-coupon-community/");
		selenium.waitForVisible("link=Shopping Coupon Page");
		selenium.clickAt("link=Shopping Coupon Page",
			RuntimeVariables.replace("Shopping Coupon Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Coupons", RuntimeVariables.replace("Coupons"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Coupon Code"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Coupon Test", selenium.getValue("//input[@id='_34_name']"));
		assertEquals("This is a coupon test.",
			selenium.getValue("//textarea[@id='_34_description']"));
		assertEquals("0.00", selenium.getValue("//input[@name='_34_minOrder']"));
		assertEquals("0.50", selenium.getValue("//input[@name='_34_discount']"));
		assertEquals("Percentage",
			selenium.getSelectedLabel("//select[@name='_34_discountType']"));
	}
}