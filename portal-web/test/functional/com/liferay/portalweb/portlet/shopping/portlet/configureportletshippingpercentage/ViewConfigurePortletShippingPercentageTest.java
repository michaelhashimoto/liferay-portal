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

package com.liferay.portalweb.portlet.shopping.portlet.configureportletshippingpercentage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewConfigurePortletShippingPercentageTest extends BaseTestCase {
	public void testViewConfigurePortletShippingPercentage()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForElementPresent(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.selectFrame(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.clickAt("link=Shipping Calculation",
			RuntimeVariables.replace("Shipping Calculation"));
		selenium.waitForVisible("//select[@id='_86_shippingFormula']");
		assertEquals("Percentage",
			selenium.getSelectedLabel("//select[@id='_86_shippingFormula']"));
		assertEquals("0.1", selenium.getValue("//input[@id='_86_shipping0']"));
		assertEquals("0.2", selenium.getValue("//input[@id='_86_shipping1']"));
		assertEquals("0.3", selenium.getValue("//input[@id='_86_shipping2']"));
		assertEquals("0.4", selenium.getValue("//input[@id='_86_shipping3']"));
		assertEquals("0.5", selenium.getValue("//input[@id='_86_shipping4']"));
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Shopping Test Page",
			RuntimeVariables.replace("Shopping Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Cart", RuntimeVariables.replace("Cart"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='taglib-header ']/h1/span", "Cart");
		assertEquals(RuntimeVariables.replace("Cart"),
			selenium.getText("//div[@class='taglib-header ']/h1/span"));
		assertEquals(RuntimeVariables.replace("\u00ab Back"),
			selenium.getText("//div[@class='taglib-header ']/span/a"));
		selenium.waitForVisible(
			"//tr[@class='portlet-section-header results-header']/th[1]");
		assertEquals(RuntimeVariables.replace("SKU"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[1]"));
		assertEquals(RuntimeVariables.replace("Description"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[2]"));
		assertEquals(RuntimeVariables.replace("Quantity"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[3]"));
		assertEquals(RuntimeVariables.replace("Price"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[4]"));
		assertEquals(RuntimeVariables.replace("1111"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[1]"));
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
		assertTrue(selenium.isVisible(
				"//tr[@class='portlet-section-body results-row last']/td[3]"));
		assertEquals("1",
			selenium.getSelectedLabel(
				"//tr[@class='portlet-section-body results-row last']/td[3]/select"));
		assertEquals(RuntimeVariables.replace("$9.99"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row last']/td[4]"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
		assertEquals(RuntimeVariables.replace("Subtotal $9.99"),
			selenium.getText("//div[@class='aui-fieldset-content ']/div[1]/div"));
		assertEquals(RuntimeVariables.replace("Shipping $1.00"),
			selenium.getText("//div[@class='aui-fieldset-content ']/div[2]/div"));
		assertEquals(RuntimeVariables.replace("Coupon Code"),
			selenium.getText(
				"//fieldset[@class='aui-fieldset ']/div/span/span/label"));
		assertTrue(selenium.isVisible(
				"//fieldset[@class='aui-fieldset ']/div/span/span/span/input"));
		assertTrue(selenium.isVisible(
				"//div[@class='portlet-body']/form/img[@alt='visa']"));
		assertTrue(selenium.isVisible(
				"//div[@class='portlet-body']/form/img[@alt='discover']"));
		assertTrue(selenium.isVisible(
				"//div[@class='portlet-body']/form/img[@alt='mastercard']"));
		assertTrue(selenium.isVisible(
				"//div[@class='portlet-body']/form/img[@alt='amex']"));
		assertTrue(selenium.isVisible(
				"//div[@class='aui-button-holder ']/span[1]/span/input"));
		assertTrue(selenium.isVisible(
				"//div[@class='aui-button-holder ']/span[2]/span/input"));
		assertTrue(selenium.isVisible(
				"//div[@class='aui-button-holder ']/span[3]/span/input"));
	}
}