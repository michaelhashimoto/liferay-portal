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

package com.liferay.portalweb.plugins.webform;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownArchivedSetupTest extends BaseTestCase {
	public void testTearDownArchivedSetup() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Web Form Test Page",
					RuntimeVariables.replace("Web Form Test Page"));
				selenium.waitForPageToLoad("30000");
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
				selenium.waitForVisible("//a[@id='_86_rjus']/span");
				assertEquals(RuntimeVariables.replace("Archive/Restore Setup"),
					selenium.getText("//a[@id='_86_rjus']/span"));
				selenium.click(RuntimeVariables.replace(
						"//a[@id='_86_rjus']/span"));
				selenium.waitForPageToLoad("30000");

				boolean archiveSetup1Present = selenium.isElementPresent(
						"//div[@class='portlet-msg-info']");

				if (archiveSetup1Present) {
					label = 2;

					continue;
				}

				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[@id='_86_ocerSearchContainer_1_menu_delete']");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[@id='_86_ocerSearchContainer_1_menu_delete']"));
				selenium.click(RuntimeVariables.replace(
						"//a[@id='_86_ocerSearchContainer_1_menu_delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean archiveSetup2Present = selenium.isElementPresent(
						"//div[@class='portlet-msg-info']");

				if (archiveSetup2Present) {
					label = 3;

					continue;
				}

				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[@id='_86_ocerSearchContainer_1_menu_delete']");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[@id='_86_ocerSearchContainer_1_menu_delete']"));
				selenium.click(RuntimeVariables.replace(
						"//a[@id='_86_ocerSearchContainer_1_menu_delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean archiveSetup3Present = selenium.isElementPresent(
						"//div[@class='portlet-msg-info']");

				if (archiveSetup3Present) {
					label = 4;

					continue;
				}

				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible("//a[@id='_86_ctvk']");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//a[@id='_86_ctvk']"));
				selenium.click(RuntimeVariables.replace("//a[@id='_86_ctvk']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean archiveSetup4Present = selenium.isElementPresent(
						"//div[@class='portlet-msg-info']");

				if (archiveSetup4Present) {
					label = 5;

					continue;
				}

				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible("//a[@id='_86_ctvk']");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//a[@id='_86_ctvk']"));
				selenium.click(RuntimeVariables.replace("//a[@id='_86_ctvk']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean archiveSetup5Present = selenium.isElementPresent(
						"//div[@class='portlet-msg-info']");

				if (archiveSetup5Present) {
					label = 6;

					continue;
				}

				Thread.sleep(5000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[@id='_86_ocerSearchContainer_1_menu_delete']");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[@id='_86_ocerSearchContainer_1_menu_delete']"));
				selenium.click(RuntimeVariables.replace(
						"//a[@id='_86_ocerSearchContainer_1_menu_delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}