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

package com.liferay.portalweb.portlet.shopping.order.checkoutordershippingstreetnull;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CheckoutOrderShippingStreetNullTest extends BaseTestCase {
	public void testCheckoutOrderShippingStreetNull() throws Exception {
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
				selenium.clickAt("link=Cart", RuntimeVariables.replace("Cart"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isPartialText(
						"//tr[@class='portlet-section-body results-row last']/td[2]",
						"Shopping Category Item Name"));
				assertTrue(selenium.isPartialText(
						"//tr[@class='portlet-section-body results-row last']/td[2]",
						"Shopping Category Item Description"));
				assertTrue(selenium.isPartialText(
						"//tr[@class='portlet-section-body results-row last']/td[2]",
						"Availability:"));
				assertEquals(RuntimeVariables.replace("In Stock"),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertTrue(selenium.isPartialText(
						"//tr[@class='portlet-section-body results-row last']/td[2]",
						"Price for 1 to 1 Items"));
				assertTrue(selenium.isPartialText(
						"//tr[@class='portlet-section-body results-row last']/td[2]",
						"9.99"));
				selenium.clickAt("//input[@value='Checkout']",
					RuntimeVariables.replace("Checkout"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_34_billingStreet']",
					RuntimeVariables.replace("1234 Sesame Street"));
				selenium.type("//input[@id='_34_billingCity']",
					RuntimeVariables.replace("Gotham City"));
				selenium.select("//select[@id='_34_billingStateSel']",
					RuntimeVariables.replace("California"));
				selenium.type("//input[@id='_34_billingZip']",
					RuntimeVariables.replace("90028"));
				selenium.type("//input[@id='_34_billingCountry']",
					RuntimeVariables.replace("USA"));
				selenium.type("//input[@id='_34_billingPhone']",
					RuntimeVariables.replace("626-589-1453"));

				boolean sameAsBillingChecked = selenium.isChecked(
						"_34_shipToBillingCheckbox");

				if (!sameAsBillingChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_34_shipToBillingCheckbox']",
					RuntimeVariables.replace(""));

			case 2:
				assertFalse(selenium.isChecked(
						"//input[@id='_34_shipToBillingCheckbox']"));
				selenium.type("//input[@id='_34_shippingStreet']",
					RuntimeVariables.replace(""));
				selenium.type("//input[@id='_34_shippingCity']",
					RuntimeVariables.replace("Gotham City"));
				selenium.select("//select[@id='_34_shippingStateSel']",
					RuntimeVariables.replace("California"));
				selenium.type("//input[@id='_34_shippingZip']",
					RuntimeVariables.replace("90028"));
				selenium.type("//input[@id='_34_shippingCountry']",
					RuntimeVariables.replace("USA"));
				selenium.type("//input[@id='_34_shippingPhone']",
					RuntimeVariables.replace("626-589-1453"));
				selenium.select("//select[@id='_34_ccType']",
					RuntimeVariables.replace("Visa"));
				selenium.type("//input[@id='_34_ccNumber']",
					RuntimeVariables.replace("4111111111111111"));
				selenium.select("//select[@id='_34_ccExpYear']",
					RuntimeVariables.replace("2014"));
				selenium.type("//textarea[@id='_34_comments']",
					RuntimeVariables.replace("Shopping Category Item Comments"));
				selenium.clickAt("//input[@value='Continue']",
					RuntimeVariables.replace("Continue"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request failed to complete."),
					selenium.getText(
						"xPath=(//div[@class='portlet-msg-error'])[1]"));
				assertEquals(RuntimeVariables.replace(
						"Please enter a valid street."),
					selenium.getText(
						"xPath=(//div[@class='portlet-msg-error'])[2]"));

			case 100:
				label = -1;
			}
		}
	}
}