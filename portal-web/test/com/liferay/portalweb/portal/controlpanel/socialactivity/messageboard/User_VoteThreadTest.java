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
public class User_VoteThreadTest extends BaseTestCase {
	public void testUser_VoteThread() throws Exception {
		selenium.open(
			"/web/mb-community-name/mb-community-social-activity-mb-public-page");
		loadRequiredJavaScriptModules();
		selenium.clickAt("link=MB Community Social Activity MB Public Page",
			RuntimeVariables.replace(
				"MB Community Social Activity MB Public Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		selenium.clickAt("link=Root Thread",
			RuntimeVariables.replace("Root Thread"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Rate this as good.")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Rate this as good.",
			RuntimeVariables.replace("Rate this as good."));
		assertEquals(RuntimeVariables.replace("\u00ab Back"),
			selenium.getText("link=\u00ab Back"));
		selenium.clickAt("link=\u00ab Back",
			RuntimeVariables.replace("\u00ab Back"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[1]/a/span[2]"));
		assertEquals(RuntimeVariables.replace("exact:Rank: 1"),
			selenium.getText("//td/div[1]/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 5"),
			selenium.getText("//td/div[1]/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Participation Score: 12"),
			selenium.getText("//td/div[1]/div/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Message Board Posts: 2"),
			selenium.getText("//td/div[3]"));
		assertEquals(RuntimeVariables.replace("User's Subscriptions: 1"),
			selenium.getText("//td/div[4]"));
		assertEquals(RuntimeVariables.replace("User User"),
			selenium.getText("//tr[2]/td/div[1]/a/span[2]"));
		assertEquals(RuntimeVariables.replace("exact:Rank: 2"),
			selenium.getText("//tr[2]/td/div[1]/div/div[1]/"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 0"),
			selenium.getText("//tr[2]/td/div[1]/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Participation Score: 2"),
			selenium.getText("//tr[2]/td/div[1]/div/div[3]"));
		assertTrue(selenium.isElementPresent("//tr[2]/td/div[3]"));
	}
}