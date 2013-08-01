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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.messageboard;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletShowTotalsOffTest extends BaseTestCase {
	public void testConfigurePortletShowTotalsOff() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/site-name/");
				selenium.clickAt("link=User Statistics Test Page",
					RuntimeVariables.replace("User Statistics Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("User Statistics"),
					selenium.getText("//span[@class='portlet-title-text']"));
				selenium.clickAt("//span[@class='portlet-title-text']",
					RuntimeVariables.replace("User Statistics"));
				selenium.waitForElementPresent("//div[@class='yui3-dd-shim']");
				assertEquals(RuntimeVariables.replace("Options"),
					selenium.getText("//span[@title='Options']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
					RuntimeVariables.replace("Options"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
				selenium.click(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
				selenium.waitForVisible(
					"//iframe[@id='_180_configurationIframeDialog']");
				selenium.selectFrame(
					"//iframe[@id='_180_configurationIframeDialog']");
				selenium.waitForVisible("//input[@id='_86_showTotalsCheckbox']");

				boolean showTotalsChecked = selenium.isChecked(
						"//input[@id='_86_showTotalsCheckbox']");

				if (!showTotalsChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_86_showTotalsCheckbox']",
					RuntimeVariables.replace("Show Totals"));

			case 2:
				assertFalse(selenium.isChecked(
						"//input[@id='_86_showTotalsCheckbox']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"You have successfully updated the setup."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertFalse(selenium.isChecked(
						"//input[@id='_86_showTotalsCheckbox']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}