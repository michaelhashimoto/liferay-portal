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

package com.liferay.portalweb.portlet.calendar.event.addevent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownEventTest extends BaseTestCase {
	public void testTearDownEvent() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Calendar Test Page",
					RuntimeVariables.replace("Calendar Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Events", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.waitForElementPresent("//input[@value='Add Event']");

				boolean event1Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event1Present) {
					label = 2;

					continue;
				}

				Thread.sleep(1000);
				selenium.waitForVisible(
					"//span[@title='Actions']/ul/li/strong/a/span");
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");

			case 2:
				selenium.waitForElementPresent("//span/input");

				boolean event2Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event2Present) {
					label = 3;

					continue;
				}

				Thread.sleep(1000);
				selenium.waitForVisible(
					"//span[@title='Actions']/ul/li/strong/a/span");
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");

			case 3:
				selenium.waitForElementPresent("//span/input");

				boolean event3Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event3Present) {
					label = 4;

					continue;
				}

				Thread.sleep(1000);
				selenium.waitForVisible(
					"//span[@title='Actions']/ul/li/strong/a/span");
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");

			case 4:
				selenium.waitForElementPresent("//span/input");

				boolean event4Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event4Present) {
					label = 5;

					continue;
				}

				Thread.sleep(1000);
				selenium.waitForVisible(
					"//span[@title='Actions']/ul/li/strong/a/span");
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");

			case 5:
				selenium.waitForElementPresent("//span/input");

				boolean event5Present = selenium.isElementPresent(
						"//td[6]/span/ul/li/strong/a");

				if (!event5Present) {
					label = 6;

					continue;
				}

				Thread.sleep(1000);
				selenium.waitForVisible(
					"//span[@title='Actions']/ul/li/strong/a/span");
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this?");

			case 6:
			case 100:
				label = -1;
			}
		}
	}
}