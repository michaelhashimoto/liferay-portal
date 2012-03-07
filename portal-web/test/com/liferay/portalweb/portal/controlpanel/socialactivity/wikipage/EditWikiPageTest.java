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
public class EditWikiPageTest extends BaseTestCase {
	public void testEditWikiPage() throws Exception {
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

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//a[@id='_36_mefv']/span")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//a[@id='_36_mefv']/span",
			RuntimeVariables.replace("Edit"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//td[@id='cke_contents__36_editor']/iframe")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isVisible(
				"//td[@id='cke_contents__36_editor']/iframe"));
		selenium.selectFrame("//td[@id='cke_contents__36_editor']/iframe");
		Thread.sleep(5000);
		selenium.type("//body", RuntimeVariables.replace("Content Edit"));
		selenium.selectFrame("relative=top");
		selenium.click(RuntimeVariables.replace("_36_publishButton"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"Your request completed successfully.")
										.equals(selenium.getText(
								"//section/div/div/div/div[1]"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//section/div/div/div/div[1]"));
		Thread.sleep(5000);
		selenium.clickAt("link=Wiki Community Social Activity Wiki Public Page",
			RuntimeVariables.replace(
				"Wiki Community Social Activity Wiki Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace("Content Edit"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div/a/span[2]"));
		assertEquals(RuntimeVariables.replace("exact:Rank: 1"),
			selenium.getText("//td/div/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 0"),
			selenium.getText("//td/div/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Participation Score: 17"),
			selenium.getText("//td/div/div/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Wiki Pages: 2"),
			selenium.getText("//td/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Wiki Page Updates: 1"),
			selenium.getText("//td/div[4]"));
	}
}