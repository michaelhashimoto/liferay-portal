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

package com.liferay.portalweb.asset.assetpublisher.portlet.configureportletavailablebookmarksentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletAvailableBookmarksEntryTest extends BaseTestCase {
	public void testConfigurePortletAvailableBookmarksEntry()
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
		selenium.waitForVisible("//select[@id='_86_anyAssetType']");
		selenium.select("//select[@id='_86_anyAssetType']",
			RuntimeVariables.replace("Select More Than One..."));
		assertEquals("Select More Than One...",
			selenium.getSelectedLabel("//select[@id='_86_anyAssetType']"));
		selenium.waitForVisible("//select[@id='_86_currentClassNameIds']");
		selenium.addSelection("//select[@id='_86_currentClassNameIds']",
			RuntimeVariables.replace("Bookmarks Entry"));
		selenium.waitForVisible(
			"xPath=(//button[@title='Move selected items from Selected to Available.'])[2]");
		selenium.clickAt("xPath=(//button[@title='Move selected items from Selected to Available.'])[2]",
			RuntimeVariables.replace("Right Arrow"));
		selenium.waitForText("//select[@id='_86_availableClassNameIds']",
			"Bookmarks Entry");
		assertEquals(RuntimeVariables.replace("Bookmarks Entry"),
			selenium.getText("//select[@id='_86_availableClassNameIds']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Bookmarks Entry"),
			selenium.getText("//select[@id='_86_availableClassNameIds']"));
		selenium.selectFrame("relative=top");
	}
}