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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.addmicroblogscontentmultipletagmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddMicroblogsContent1Tag1ViewableByEveryoneTest
	extends BaseTestCase {
	public void testAddMicroblogsContent1Tag1ViewableByEveryone()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard");
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//div[contains(@id,'_1_WAR_microblogsportlet_autocompleteContent')]"));
		assertEquals(RuntimeVariables.replace(
				"You do not have any microblog entries."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("//div[contains(@id,'_1_WAR_microblogsportlet_autocompleteContent')]",
			RuntimeVariables.replace("Update your status..."));
		selenium.waitForElementPresent("//textarea");
		selenium.clickAt("//textarea", RuntimeVariables.replace("Text area"));
		selenium.sendKeys("//textarea",
			RuntimeVariables.replace("#Microblogs1 Post1"));
		selenium.waitForText("//span[@class='microblogs-countdown']", "132");
		assertEquals(RuntimeVariables.replace("132"),
			selenium.getText("//span[@class='microblogs-countdown']"));
		selenium.select("//select[@id='_1_WAR_microblogsportlet_socialRelationType']",
			RuntimeVariables.replace("Everyone"));
		selenium.clickAt("//input[@value='Post']",
			RuntimeVariables.replace("Post"));
		selenium.waitForVisible("//div[@class='content']");
		assertEquals(RuntimeVariables.replace("Microblogs1 Post1"),
			selenium.getText("//div[@class='content']"));
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("//span[@class='action comment']/a"));
		assertTrue(selenium.isElementNotPresent(
				"//span[@class='action repost']/a"));
	}
}