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
public class ViewGraphsTest extends BaseTestCase {
	public void testViewGraphs() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Currency Converter Test Page");
		selenium.clickAt("link=Currency Converter Test Page",
			RuntimeVariables.replace("Currency Converter Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForElementPresent("//input[@value='Convert']");
		selenium.clickAt("//input[@value='Convert']",
			RuntimeVariables.replace("Convert"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=1y", RuntimeVariables.replace("1y"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//td/img"));
		selenium.clickAt("link=2y", RuntimeVariables.replace("2y"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//td/img"));
		selenium.clickAt("link=3m", RuntimeVariables.replace("3m"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//td/img"));
	}
}