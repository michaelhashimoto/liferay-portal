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

package com.liferay.portalweb.socialofficehome.events.event.viewevented;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownEventSOTest extends BaseTestCase {
	public void testTearDownEventSO() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.waitForElementPresent("link=Calendar Test Page");
				selenium.clickAt("link=Calendar Test Page",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Events", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.waitForElementPresent("//span/input");

				boolean event1Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event1Present) {
					label = 2;

					continue;
				}

				Thread.sleep(1000);
				selenium.waitForVisible("//td[6]/span/ul/li/strong/a");
				selenium.clickAt("//td[6]/span/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

			case 2:
				selenium.waitForElementPresent("//span/input");

				boolean event2Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event2Present) {
					label = 3;

					continue;
				}

				selenium.waitForVisible("//td[6]/span/ul/li/strong/a");
				selenium.clickAt("//td[6]/span/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

			case 3:
				selenium.waitForElementPresent("//span/input");

				boolean event3Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event3Present) {
					label = 4;

					continue;
				}

				selenium.waitForVisible("//td[6]/span/ul/li/strong/a");
				selenium.clickAt("//td[6]/span/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

			case 4:
				selenium.waitForElementPresent("//span/input");

				boolean event4Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event4Present) {
					label = 5;

					continue;
				}

				selenium.waitForVisible("//td[6]/span/ul/li/strong/a");
				selenium.clickAt("//td[6]/span/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

			case 5:
				selenium.waitForElementPresent("//span/input");

				boolean event5Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event5Present) {
					label = 6;

					continue;
				}

				selenium.waitForVisible("//td[6]/span/ul/li/strong/a");
				selenium.clickAt("//td[6]/span/ul/li/strong/a",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

			case 6:
			case 100:
				label = -1;
			}
		}
	}
}