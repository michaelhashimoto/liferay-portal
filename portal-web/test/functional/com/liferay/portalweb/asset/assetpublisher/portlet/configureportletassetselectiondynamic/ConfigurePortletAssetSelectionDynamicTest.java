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

package com.liferay.portalweb.asset.assetpublisher.portlet.configureportletassetselectiondynamic;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletAssetSelectionDynamicTest extends BaseTestCase {
	public void testConfigurePortletAssetSelectionDynamic()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
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
		selenium.waitForVisible(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.selectFrame(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("//select[@id='_86_selectionStyle']");
		selenium.select("//select[@id='_86_selectionStyle']",
			RuntimeVariables.replace("Dynamic"));
		selenium.waitForText("//div[@class='lfr-panel-title']/span", "Source");
		selenium.click(RuntimeVariables.replace("//input[@value='Save']"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("Dynamic",
			selenium.getSelectedLabel("//select[@id='_86_selectionStyle']"));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("xPath=(//div[@class='lfr-panel-title'])[1]/span"));
		assertEquals(RuntimeVariables.replace("Filter"),
			selenium.getText("xPath=(//div[@class='lfr-panel-title'])[2]/span"));
		assertEquals(RuntimeVariables.replace("Custom User Attributes"),
			selenium.getText("xPath=(//div[@class='lfr-panel-title'])[3]/span"));
		assertEquals(RuntimeVariables.replace("Ordering and Grouping"),
			selenium.getText("xPath=(//div[@class='lfr-panel-title'])[4]/span"));
		assertEquals(RuntimeVariables.replace("Display Settings"),
			selenium.getText("xPath=(//div[@class='lfr-panel-title'])[5]/span"));
		selenium.selectFrame("relative=top");
	}
}