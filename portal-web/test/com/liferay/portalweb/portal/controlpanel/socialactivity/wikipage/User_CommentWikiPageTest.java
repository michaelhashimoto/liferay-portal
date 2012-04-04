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
public class User_CommentWikiPageTest extends BaseTestCase {
	public void testUser_CommentWikiPage() throws Exception {
		selenium.open(
			"/web/wiki-community-name/wiki-community-social-activity-wiki-public-page");
		loadRequiredJavaScriptModules();
		selenium.click(RuntimeVariables.replace(
				"link=Wiki Community Social Activity Wiki Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace("Be the first."),
			selenium.getText("link=Be the first."));
		selenium.clickAt("link=Be the first.",
			RuntimeVariables.replace("Be the first."));
		selenium.type("_36_postReplyBody0", RuntimeVariables.replace("User"));
		selenium.click("//div/span[1]/span/input");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"Your request processed successfully.")
										.equals(selenium.getText(
								"//div[9]/div/div[2]/div[1]"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//div[9]/div/div[2]/div[1]"));
		selenium.open(
			"/web/wiki-community-name/wiki-community-social-activity-wiki-public-page");
		loadRequiredJavaScriptModules();
		Thread.sleep(5000);
		selenium.click(RuntimeVariables.replace(
				"link=Wiki Community Social Activity Wiki Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace("User User"),
			selenium.getText("//div/a/span[2]"));
		assertEquals(RuntimeVariables.replace("User"),
			selenium.getText("//div/div[3]/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td/div[1]/a/span[2]"));
		assertEquals(RuntimeVariables.replace("exact:Rank: 1"),
			selenium.getText("//td/div/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 4"),
			selenium.getText("//td/div/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Participation Score: 27"),
			selenium.getText("//td/div/div/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Wiki Pages: 2"),
			selenium.getText("//td/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Attachments: 2"),
			selenium.getText("//td/div[4]"));
		assertEquals(RuntimeVariables.replace("User's Wiki Page Updates: 1"),
			selenium.getText("//td/div[5]"));
		assertEquals(RuntimeVariables.replace("User User"),
			selenium.getText("//tr[2]/td/div[1]/a/span[2]"));
		assertEquals(RuntimeVariables.replace("exact:Rank: 2"),
			selenium.getText("//tr[2]/td/div[1]/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 0"),
			selenium.getText("//tr[2]/td/div[1]/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Participation Score: 15"),
			selenium.getText("//tr[2]/td/div[1]/div/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Comments: 1"),
			selenium.getText("//tr[2]/td/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Subscriptions: 1"),
			selenium.getText("//tr[2]/td/div[4]"));
	}
}