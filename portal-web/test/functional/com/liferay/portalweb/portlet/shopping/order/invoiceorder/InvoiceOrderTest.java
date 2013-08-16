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

package com.liferay.portalweb.portlet.shopping.order.invoiceorder;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class InvoiceOrderTest extends BaseTestCase {
	public void testInvoiceOrder() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Orders", RuntimeVariables.replace("Orders"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[5]"));
		assertEquals(RuntimeVariables.replace("Checkout"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]/a"));
		selenium.clickAt("//tr[@class='portlet-section-body results-row last']/td[4]/a",
			RuntimeVariables.replace("Checkout"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isPartialText("//form[@id='_34_fm']",
				"Shopping Category Item Comments"));
		selenium.clickAt("//input[@value='Invoice']",
			RuntimeVariables.replace("Invoice"));
		selenium.waitForPopUp("Shopping", RuntimeVariables.replace("30000"));
		selenium.selectWindow("title=Shopping");
		selenium.waitForText("//form[@id='_34_fm']/span/strong", "Invoice");
		assertEquals(RuntimeVariables.replace("Invoice"),
			selenium.getText("//form[@id='_34_fm']/span/strong"));
		selenium.close();
		selenium.selectWindow("null");
	}
}