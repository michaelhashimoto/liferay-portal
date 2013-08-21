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

package com.liferay.portalweb.socialofficehome.events.event.configureportletdisplaydays2;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletDisplayDays2Test extends BaseTestCase {
	public void testConfigurePortletDisplayDays2() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.waitForText("xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]",
					"Events");
				assertEquals(RuntimeVariables.replace("Events"),
					selenium.getText(
						"xPath=(//span[@class='portlet-title-text'])[contains(.,'Events')]"));
				Thread.sleep(1000);
				selenium.clickAt("//a[contains(@id,'toggleDockbar')]",
					RuntimeVariables.replace("Toggle Dockbar"));
				selenium.waitForElementPresent(
					"//body[contains(@class,'show-dockbar')]");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForVisible("//li[@id='_145_toggleControls']");

				boolean EditControlOff = selenium.isElementPresent(
						"//body[contains(@class,'controls-hidden')]");

				if (!EditControlOff) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Edit Controls"),
					selenium.getText("//li[@id='_145_toggleControls']"));
				selenium.clickAt("//li[@id='_145_toggleControls']",
					RuntimeVariables.replace("Edit Controls"));

			case 2:
				assertEquals(RuntimeVariables.replace("Options"),
					selenium.getText(
						"//div[2]/div/div[2]/div/section/header/menu/span/ul/li/strong/a"));
				selenium.clickAt("//div[2]/div/div[2]/div/section/header/menu/span/ul/li/strong/a",
					RuntimeVariables.replace("Options"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
					RuntimeVariables.replace("Configuration"));
				selenium.waitForVisible(
					"//div[@class='yui3-widget-bd aui-panel-bd aui-dialog-bd aui-dialog-iframe-bd']/iframe");
				selenium.selectFrame(
					"//div[@class='yui3-widget-bd aui-panel-bd aui-dialog-bd aui-dialog-iframe-bd']/iframe");
				selenium.waitForVisible(
					"//label[contains(@for,'maxDaysDisplayed')]");
				assertEquals(RuntimeVariables.replace(
						"How many days to display?"),
					selenium.getText(
						"//label[contains(@for,'maxDaysDisplayed')]"));
				selenium.select("//select[@id='_86_maxDaysDisplayed']",
					RuntimeVariables.replace("2"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"You have successfully updated the setup."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}