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

package com.liferay.portalweb.portal.dbupgrade.sampledata525.shopping.coupon;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCommunityShoppingCouponTest extends BaseTestCase {
	public void testAddCommunityShoppingCoupon() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/home/");
		selenium.waitForElementPresent("link=Communities I Own");
		selenium.clickAt("link=Communities I Own",
			RuntimeVariables.replace("Communities I Own"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Community']",
			RuntimeVariables.replace("Add Community"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_29_name']",
			RuntimeVariables.replace("Shopping Coupon Community"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request processed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isTextPresent("Shopping Coupon Community"));
	}
}