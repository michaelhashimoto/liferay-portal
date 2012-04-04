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
public class AddAttachmensTest extends BaseTestCase {
	public void testAddAttachmens() throws Exception {
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

		selenium.click(RuntimeVariables.replace(
				"link=Wiki Community Social Activity Wiki Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//a[@id='_36_bhfa']/span")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("//a[@id='_36_bhfa']/span"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		selenium.click(RuntimeVariables.replace("//div[3]/input"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//form[1]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//form[1]/a",
			RuntimeVariables.replace("Use the new uploader."));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//input[@id='_36_file1']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.type("_36_file1",
			RuntimeVariables.replace(
				"L:\\liferay-portal\\portal-web\\test\\com\\liferay\\portalweb\\portal\\controlpanel\\socialactivity\\wikipage\\dependencies\\1.jpg"));
		selenium.type("_36_file2",
			RuntimeVariables.replace(
				"L:\\liferay-portal\\portal-web\\test\\com\\liferay\\portalweb\\portal\\controlpanel\\socialactivity\\wikipage\\dependencies\\2.jpg"));
		selenium.clickAt("//div/span[1]/span/input",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("1.jpg"),
			selenium.getText("link=1.jpg"));
		assertEquals(RuntimeVariables.replace("3.8k"),
			selenium.getText("//tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("2.jpg"),
			selenium.getText("link=2.jpg"));
		assertEquals(RuntimeVariables.replace("2.8k"),
			selenium.getText("//tr[4]/td[2]"));
		Thread.sleep(5000);
		selenium.clickAt("link=Wiki Community Social Activity Wiki Public Page",
			RuntimeVariables.replace(
				"Wiki Community Social Activity Wiki Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div/a/span[2]"));
		assertEquals(RuntimeVariables.replace("exact:Rank: 1"),
			selenium.getText("//td/div/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 0"),
			selenium.getText("//td/div/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Participation Score: 21"),
			selenium.getText("//td/div/div/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Wiki Pages: 2"),
			selenium.getText("//td/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Attachments: 2"),
			selenium.getText("//td/div[4]"));
		assertEquals(RuntimeVariables.replace("User's Wiki Page Updates: 1"),
			selenium.getText("//td/div[5]"));
	}
}