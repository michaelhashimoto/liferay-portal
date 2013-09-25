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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousdeleterepostmicroblogscontent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_DeleteRepostMicroblogsContentTest extends BaseTestCase {
	public void testSOUs_DeleteRepostMicroblogsContent()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard");
		selenium.waitForVisible("link=Me");
		selenium.clickAt("link=Me", RuntimeVariables.replace("Me"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='activity-action']");
		assertEquals(RuntimeVariables.replace(
				"Reposted a microblog entry from Joe Bloggs."),
			selenium.getText("//div[@class='activity-action']"));
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='user-name']");
		assertEquals(RuntimeVariables.replace(
				"Social01 Office01 User01 Reposted From Joe Bloggs"),
			selenium.getText("//div[@class='user-name']"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("//div[@class='content']"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//span[@class='action delete']/a"));
		selenium.clickAt("//span[@class='action delete']/a",
			RuntimeVariables.replace("Delete"));
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete this post[\\s\\S]$"));
		selenium.waitForTextNotPresent("Microblogs Post");
	}
}