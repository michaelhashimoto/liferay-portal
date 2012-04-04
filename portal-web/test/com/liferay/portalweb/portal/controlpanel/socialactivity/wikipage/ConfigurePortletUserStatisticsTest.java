/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.controlpanel.socialactivity.wikipage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletUserStatisticsTest extends BaseTestCase {
	public void testConfigurePortletUserStatistics() throws Exception {
		selenium.open(
			"/web/wiki-community-name/wiki-community-social-activity-wiki-public-page/");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=Wiki Community Social Activity Wiki Public Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Wiki Community Social Activity Wiki Public Page",
			RuntimeVariables.replace(
				"Wiki Community Social Activity Wiki Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("link=Options"));
		selenium.clickAt("link=Options", RuntimeVariables.replace("Options"));
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText("link=Configuration"));
		selenium.clickAt("link=Configuration",
			RuntimeVariables.replace("Configuration"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("_86_showHeaderTextCheckbox")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("_86_showHeaderTextCheckbox",
			RuntimeVariables.replace("Show Header Text"));
		selenium.clickAt("_86_showTotalsCheckbox",
			RuntimeVariables.replace("Show Totals"));
		selenium.click("_86_displayActivityCounterName0");
		selenium.select("_86_displayActivityCounterName0",
			RuntimeVariables.replace("label=User's Wiki Page Updates"));
		selenium.click(
			"//select[@id='_86_displayActivityCounterName0']/option[3]");
		selenium.click("//fieldset/div[2]/div[1]/span/span/button[1]");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_86_displayActivityCounterName2")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("_86_displayActivityCounterName2");
		selenium.select("_86_displayActivityCounterName2",
			RuntimeVariables.replace("label=User's Attachments"));
		selenium.click(
			"//select[@id='_86_displayActivityCounterName2']/option[2]");
		selenium.click("//fieldset/div[2]/div[1]/span/span/button[1]");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_86_displayActivityCounterName3")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("_86_displayActivityCounterName3");
		selenium.select("_86_displayActivityCounterName3",
			RuntimeVariables.replace("label=User's Comments"));
		selenium.click(
			"//select[@id='_86_displayActivityCounterName3']/option[7]");
		selenium.click("//fieldset/div[2]/div[1]/span/span/button[1]");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_86_displayActivityCounterName4")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("_86_displayActivityCounterName4");
		selenium.select("_86_displayActivityCounterName4",
			RuntimeVariables.replace("label=User's Subscriptions"));
		selenium.click(
			"//select[@id='_86_displayActivityCounterName4']/option[4]");
		selenium.click("//fieldset/div[2]/div[1]/span/span/button[1]");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("_86_displayActivityCounterName5")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("_86_displayActivityCounterName5");
		selenium.select("_86_displayActivityCounterName5",
			RuntimeVariables.replace("label=User's Wiki Pages"));
		selenium.click(
			"//select[@id='_86_displayActivityCounterName5']/option[14]");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"You have successfully updated the setup.")
										.equals(selenium.getText(
								"//div[@id='p_p_id_86_']/div/div/div[1]"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@id='p_p_id_86_']/div/div/div[1]"));
		selenium.selectFrame("relative=up");
		selenium.click("closethick");
	}
}