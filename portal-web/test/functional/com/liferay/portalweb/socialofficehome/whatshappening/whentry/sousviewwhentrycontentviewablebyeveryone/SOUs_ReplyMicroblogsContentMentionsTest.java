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

package com.liferay.portalweb.socialofficehome.whatshappening.whentry.sousviewwhentrycontentviewablebyeveryone;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ReplyMicroblogsContentMentionsTest extends BaseTestCase {
	public void testSOUs_ReplyMicroblogsContentMentions()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.waitForVisible("//nav/ul/li[contains(.,'Microblogs')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("//span[@class='action comment']/a"));
		selenium.clickAt("//span[@class='action comment']/a",
			RuntimeVariables.replace("Comment"));
		selenium.waitForVisible(
			"xPath=(//div[@class='autocomplete textarea'])[2]");
		Thread.sleep(1000);
		selenium.clickAt("xPath=(//div[@class='autocomplete textarea'])[2]",
			RuntimeVariables.replace("Leave a comment..."));
		selenium.waitForVisible("//textarea");
		selenium.clickAt("//textarea",
			RuntimeVariables.replace("Leave a comment..."));
		selenium.sendKeys("//textarea",
			RuntimeVariables.replace("Microblogs Post Comment"));
		selenium.waitForText("xPath=(//span[@class='microblogs-countdown'])[2]",
			"127");
		assertEquals(RuntimeVariables.replace("127"),
			selenium.getText("xPath=(//span[@class='microblogs-countdown'])[2]"));
		selenium.clickAt("xPath=(//input[@value='Post'])[2]",
			RuntimeVariables.replace("Post"));
		selenium.waitForVisible("xpath=(//div[@class='user-name']/span/a)[2]");
		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("xpath=(//div[@class='user-name']/span/a)[2]"));
		assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
			selenium.getText("xpath=(//div[@class='content']/span)[2]"));
	}
}