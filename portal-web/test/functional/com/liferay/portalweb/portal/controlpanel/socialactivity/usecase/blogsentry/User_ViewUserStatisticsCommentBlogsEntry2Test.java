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

package com.liferay.portalweb.portal.controlpanel.socialactivity.usecase.blogsentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_ViewUserStatisticsCommentBlogsEntry2Test extends BaseTestCase {
	public void testUser_ViewUserStatisticsCommentBlogsEntry2()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.clickAt("link=User Statistics Test Page",
			RuntimeVariables.replace("User Statistics Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//tr[contains(.,'Joe Bloggs')]//span[@class='user-name']",
			"Joe Bloggs");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"//tr[contains(.,'Joe Bloggs')]//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Rank: 1"),
			selenium.getText("xPath=(//div[@class='user-rank'])[1]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 4"),
			selenium.getText(
				"//tr[contains(.,'Joe Bloggs')]//div[@class='contribution-score']"));
		assertEquals(RuntimeVariables.replace("Participation Score: 5"),
			selenium.getText(
				"//tr[contains(.,'Joe Bloggs')]//div[@class='participation-score']"));
		assertEquals(RuntimeVariables.replace("User's Blog Entries: 2"),
			selenium.getText(
				"//tr[contains(.,'Joe Bloggs')]//div[@class='social-counter-user.blogs']"));
		assertEquals(RuntimeVariables.replace("userfn userln"),
			selenium.getText(
				"//tr[contains(.,'userfn userln')]//span[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Rank: 2"),
			selenium.getText("xPath=(//div[@class='user-rank'])[2]"));
		assertEquals(RuntimeVariables.replace("Contribution Score: 0"),
			selenium.getText(
				"//tr[contains(.,'userfn userln')]//div[@class='contribution-score']"));
		assertEquals(RuntimeVariables.replace("Participation Score: 7"),
			selenium.getText(
				"//tr[contains(.,'userfn userln')]//div[@class='participation-score']"));
		assertTrue(selenium.isElementPresent(
				"//tr[contains(.,'userfn userln')]//div[@class='social-counter-user.comments']"));
		assertEquals(RuntimeVariables.replace("User's Subscriptions: 1"),
			selenium.getText(
				"//tr[contains(.,'userfn userln')]//div[@class='social-counter-user.subscriptions']"));
	}
}