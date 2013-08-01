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

package com.liferay.portalweb.stagingsite.sites.pagevariation.addpagevariation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletHWPageVariationTest extends BaseTestCase {
	public void testViewPortletHWPageVariation() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Site Name");
		selenium.clickAt("link=Site Name", RuntimeVariables.replace("Site Name"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//body[contains(@class,'live-view')]"));
		assertTrue(selenium.isElementNotPresent(
				"//body[contains(@class,'local-staging')]"));
		assertTrue(selenium.isPartialText("//li[2]/span/a", "Staging"));
		selenium.clickAt("//li[2]/span/a", RuntimeVariables.replace("Staging"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Main Variation"),
			selenium.getText("//form/div/ul/li[1]/span/a"));
		assertEquals(RuntimeVariables.replace("Page Variation Name"),
			selenium.getText("//form/div/ul/li[2]/span/span"));
		assertTrue(selenium.isVisible("//section"));
		assertEquals(RuntimeVariables.replace("Main Variation"),
			selenium.getText("//form/div/ul/li[1]/span/a"));
		selenium.clickAt("//form/div/ul/li[1]/span/a",
			RuntimeVariables.replace("Main Variation"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("//section"));
	}
}