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

package com.liferay.portalweb.socialofficesite.home.events.viewcalendareventsedsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigureDisplayDays4EDSiteTest extends BaseTestCase {
	public void testConfigureDisplayDays4EDSite() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				assertEquals(RuntimeVariables.replace("Sites"),
					selenium.getText("//div[@id='so-sidebar']/h3"));
				assertTrue(selenium.isVisible("//input[@class='search-input']"));
				selenium.type("//input[@class='search-input']",
					RuntimeVariables.replace("Open"));
				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Open Site Name"),
					selenium.getText(
						"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
				selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
					RuntimeVariables.replace("Open Site Name"));
				selenium.waitForPageToLoad("30000");

				boolean configurationVisible = selenium.isVisible(
						"//strong/a[contains(@id,'eventsdisplayportlet')]");

				if (configurationVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				selenium.clickAt("//li[@class='toggle-controls']/a",
					RuntimeVariables.replace("Edit Controls"));
				selenium.waitForVisible(
					"//strong/a[contains(@id,'eventsdisplayportlet')]");

			case 2:
				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Options"),
					selenium.getText(
						"//strong/a[contains(@id,'eventsdisplayportlet')]"));
				selenium.clickAt("//strong/a[contains(@id,'eventsdisplayportlet')]",
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
					RuntimeVariables.replace("4"));
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