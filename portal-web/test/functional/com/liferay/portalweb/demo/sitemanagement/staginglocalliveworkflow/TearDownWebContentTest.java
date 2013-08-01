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

package com.liferay.portalweb.demo.sitemanagement.staginglocalliveworkflow;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownWebContentTest extends BaseTestCase {
	public void testTearDownWebContent() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/community-site-test/home");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//strong/a",
					RuntimeVariables.replace("liferay.com"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Community Site Test')]/a");
				assertEquals(RuntimeVariables.replace("Community Site Test"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Community Site Test')]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Community Site Test')]/a"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Web Content",
					RuntimeVariables.replace("Web Content"));
				selenium.waitForPageToLoad("30000");

				boolean webContentPresent = selenium.isElementPresent(
						"_15_rowIds");

				if (!webContentPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace("Select All"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected web content[\\s\\S]$"));

			case 2:
				selenium.clickAt("link=Templates",
					RuntimeVariables.replace("Templates"));
				selenium.waitForPageToLoad("30000");

				boolean templatePresent = selenium.isElementPresent(
						"_15_rowIds");

				if (!templatePresent) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace("Select All"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected templates[\\s\\S]$"));

			case 3:
				selenium.clickAt("link=Structures",
					RuntimeVariables.replace("Structures"));
				selenium.waitForPageToLoad("30000");

				boolean structurePresent = selenium.isElementPresent(
						"_15_rowIds");

				if (!structurePresent) {
					label = 4;

					continue;
				}

				selenium.clickAt("//input[@name='_15_allRowIds']",
					RuntimeVariables.replace("Select All"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete the selected structures[\\s\\S]$"));

			case 4:
			case 100:
				label = -1;
			}
		}
	}
}