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

package com.liferay.portalweb.portlet.currencyconverter;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConvertCurrencyTest extends BaseTestCase {
	public void testConvertCurrency() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Currency Converter Test Page");
		selenium.clickAt("link=Currency Converter Test Page",
			RuntimeVariables.replace("Currency Converter Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent("//input[@name='_16_number']");
		selenium.type("//input[@name='_16_number']",
			RuntimeVariables.replace("2.5"));
		selenium.waitForPartialText("//select[@name='_16_from']", "KRW");
		selenium.select("//select[@name='_16_from']",
			RuntimeVariables.replace("KRW"));
		assertTrue(selenium.isPartialText("//select[@name='_16_to']", "BHD"));
		selenium.select("//select[@name='_16_to']",
			RuntimeVariables.replace("BHD"));
		selenium.clickAt("//input[@value='Convert']",
			RuntimeVariables.replace("Convert"));
		selenium.waitForPageToLoad("30000");
		assertEquals("2.5", selenium.getValue("//input[@name='_16_number']"));
		assertTrue(selenium.isTextPresent("KRW"));
		assertTrue(selenium.isTextPresent("BHD"));
		assertTrue(selenium.isVisible("//td/img"));
	}
}