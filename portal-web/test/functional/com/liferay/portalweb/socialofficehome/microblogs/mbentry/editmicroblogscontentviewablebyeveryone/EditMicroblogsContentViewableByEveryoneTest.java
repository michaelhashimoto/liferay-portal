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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.editmicroblogscontentviewablebyeveryone;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditMicroblogsContentViewableByEveryoneTest extends BaseTestCase {
	public void testEditMicroblogsContentViewableByEveryone()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
			RuntimeVariables.replace("Microblogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//div[@class='user-name']/span"));
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("//div[@class='content']"));
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("//span[@class='action comment']/a"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//span[@class='action edit']/a"));
		selenium.clickAt("//span[@class='action edit']/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForElementPresent("//textarea");
		selenium.clickAt("//textarea", RuntimeVariables.replace("Text area"));
		selenium.sendKeys("//textarea", RuntimeVariables.replace("Edit"));
		selenium.waitForText("xPath=(//span[@class='microblogs-countdown'])[2]",
			"131");
		assertEquals(RuntimeVariables.replace("131"),
			selenium.getText("xPath=(//span[@class='microblogs-countdown'])[2]"));
		assertEquals("Everyone",
			selenium.getSelectedLabel(
				"xPath=(//select[@id='_1_WAR_microblogsportlet_socialRelationType'])[2]"));
		Thread.sleep(1000);
		selenium.clickAt("xPath=(//input[@value='Post'])[2]",
			RuntimeVariables.replace("Post"));
		selenium.waitForVisible("//div[@class='content']");
		assertEquals(RuntimeVariables.replace("Microblogs PostEdit"),
			selenium.getText("//div[@class='content']"));
		assertEquals(RuntimeVariables.replace("Comment"),
			selenium.getText("//span[@class='action comment']/a"));
		assertTrue(selenium.isElementNotPresent(
				"//span[@class='action repost']/a"));
	}
}