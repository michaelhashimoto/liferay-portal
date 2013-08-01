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

package com.liferay.portalweb.portlet.shopping.order.checkoutordershippingemailaddressinvalid;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCheckoutOrderShippingEmailAddressInvalidTest
	extends BaseTestCase {
	public void testViewCheckoutOrderShippingEmailAddressInvalid()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Orders", RuntimeVariables.replace("Orders"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("No orders were found."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertFalse(selenium.isTextPresent("testliferay.com"));
		assertFalse(selenium.isTextPresent("1234 Sesame Street"));
		assertFalse(selenium.isTextPresent("Gotham City"));
		assertFalse(selenium.isTextPresent("CA"));
		assertFalse(selenium.isTextPresent("90028"));
		assertFalse(selenium.isTextPresent("USA"));
		assertFalse(selenium.isTextPresent("626-589-1453"));
		assertFalse(selenium.isTextPresent("Visa"));
		assertFalse(selenium.isTextPresent("4111111111111111"));
		assertFalse(selenium.isTextPresent("2014"));
		assertFalse(selenium.isTextPresent("Shopping Category Item Comments"));
	}
}