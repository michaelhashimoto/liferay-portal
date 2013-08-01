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

package com.liferay.portalweb.plugins.googlemaps.portlet.configureportletmapsinputenabled;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletMapsInputEnabledTest extends BaseTestCase {
	public void testConfigurePortletMapsInputEnabled()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.click(RuntimeVariables.replace("link=Google Maps Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Google Maps"),
			selenium.getText("//span[@class='portlet-title-text']"));
		selenium.clickAt("//span[@class='portlet-title-text']",
			RuntimeVariables.replace("Google Maps"));
		selenium.waitForElementPresent("//div[@class='yui3-dd-shim']");
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a"));
		selenium.click(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
		selenium.waitForVisible(
			"//iframe[contains(@id,'_1_WAR_googlemapsportlet_INSTANCE')]");
		selenium.selectFrame(
			"//iframe[contains(@id,'_1_WAR_googlemapsportlet_INSTANCE')]");
		selenium.waitForVisible("//input[@id='_86_mapInputEnabledCheckbox']");
		assertFalse(selenium.isChecked(
				"//input[@id='_86_mapInputEnabledCheckbox']"));
		selenium.clickAt("//input[@id='_86_mapInputEnabledCheckbox']",
			RuntimeVariables.replace("Map Input Enabled"));
		assertTrue(selenium.isChecked(
				"//input[@id='_86_mapInputEnabledCheckbox']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"You have successfully updated the setup.");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isChecked(
				"//input[@id='_86_mapInputEnabledCheckbox']"));
		selenium.selectFrame("relative=top");
	}
}