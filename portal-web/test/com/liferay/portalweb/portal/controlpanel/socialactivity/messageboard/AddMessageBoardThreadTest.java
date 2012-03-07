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

package com.liferay.portalweb.portal.controlpanel.socialactivity.messageboard;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMessageBoardThreadTest extends BaseTestCase {
	public void testAddMessageBoardThread() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=MB Community Social Activity MB Public Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=MB Community Social Activity MB Public Page",
			RuntimeVariables.replace(
				"MB Community Social Activity MB Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		selenium.clickAt("//input[@value='Post New Thread']",
			RuntimeVariables.replace("Post New Thread"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		selenium.type("//input[@id='_19_subject']",
			RuntimeVariables.replace("Root Thread"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//td[@id='cke_contents__19_editor']/iframe")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.selectFrame("//td[@id='cke_contents__19_editor']/iframe");
		selenium.type("//body", RuntimeVariables.replace("Content"));
		selenium.selectFrame("relative=top");
		selenium.selectWindow("null");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"Your request completed successfully.")
										.equals(selenium.getText(
								"//div[@class='portlet-msg-success']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Root Thread"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Content"),
			selenium.getText("//div[@class='thread-body']"));
		selenium.open(
			"/web/mb-community-name/mb-community-social-activity-mb-public-page");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=MB Community Social Activity MB Public Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=MB Community Social Activity MB Public Page",
			RuntimeVariables.replace(
				"MB Community Social Activity MB Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace("Root Thread"),
			selenium.getText("//td/a"));
		assertEquals(RuntimeVariables.replace(""), selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isVisible("//td[5]/a"));
		assertTrue(selenium.isPartialText("//td[6]/a", "By: Joe Bloggs"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div/a/span[2]"));
		assertEquals(RuntimeVariables.replace("exact:Rank: 1"),
			selenium.getText("//td/div[1]/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 0"),
			selenium.getText("//td/div[1]/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Participation Score: 7"),
			selenium.getText("//td/div[1]/div/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Message Board Posts: 1"),
			selenium.getText("//td/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Subscriptions: 1"),
			selenium.getText("//td/div[4]"));
	}
}