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

package com.liferay.portalweb.portlet.shopping.order.checkoutorder;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownCheckoutOrderTest extends BaseTestCase {
	public void testTearDownCheckoutOrder() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Shopping Test Page",
					RuntimeVariables.replace("Shopping Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Orders",
					RuntimeVariables.replace("Orders"));
				selenium.waitForPageToLoad("30000");

				boolean ordersNotPresent = selenium.isElementPresent(
						"//span[@title='Actions']/ul/li/strong/a/span");

				if (!ordersNotPresent) {
					label = 2;

					continue;
				}

				assertFalse(selenium.isChecked("//input[@name='_34_allRowIds']"));
				selenium.clickAt("//input[@name='_34_allRowIds']",
					RuntimeVariables.replace("All Rows Checkbox"));
				assertTrue(selenium.isChecked("//input[@name='_34_allRowIds']"));
				selenium.waitForElementPresent(
					"//tr[contains(@class,'last selected')]");
				selenium.clickAt("//input[@value='Delete']",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected orders[\\s\\S]$"));
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 2:
				assertEquals(RuntimeVariables.replace("No orders were found."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}