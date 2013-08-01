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

package com.liferay.portalweb.portlet.webcontentdisplay.webcontent.viewwcwebcontentscopeglobalwcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletWCDWCWebContentScopeGlobalTest extends BaseTestCase {
	public void testConfigurePortletWCDWCWebContentScopeGlobal()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Web Content Display Test Page",
					RuntimeVariables.replace("Web Content Display Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Select existing web content or add some web content to be displayed in this portlet."),
					selenium.getText("//div[@class='portlet-msg-info']"));
				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("Options"),
					selenium.getText("//span[@title='Options']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
					RuntimeVariables.replace("Options"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a",
					RuntimeVariables.replace("Configuration"));
				selenium.waitForVisible("//iframe");
				selenium.selectFrame("//iframe");
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/navigation_interaction.js')]");

				boolean advancedVisible = selenium.isVisible(
						"link=Advanced \u00bb");

				if (!advancedVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Advanced \u00bb",
					RuntimeVariables.replace("Advanced"));

			case 2:
				selenium.waitForVisible("//select[@id='_86_groupId']");
				selenium.select("//select[@id='_86_groupId']",
					RuntimeVariables.replace("Global"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Web Content Name"),
					selenium.getText(
						"//td[@id='_86_ocerSearchContainer_col-title_row-1']/a"));
				selenium.clickAt("//td[@id='_86_ocerSearchContainer_col-title_row-1']/a",
					RuntimeVariables.replace("Web Content Name"));
				selenium.waitForText("//div[@class='portlet-msg-info']/span/span",
					"Web Content Name (Modified)");
				assertEquals(RuntimeVariables.replace(
						"Web Content Name (Modified)"),
					selenium.getText(
						"//div[@class='portlet-msg-info']/span/span"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"You have successfully updated the setup."),
					selenium.getText("//div[@class='portlet-msg-success']"));

				boolean basicVisible = selenium.isVisible("link=\u00ab Basic");

				if (!basicVisible) {
					label = 3;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace("Basic"));

			case 3:
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}