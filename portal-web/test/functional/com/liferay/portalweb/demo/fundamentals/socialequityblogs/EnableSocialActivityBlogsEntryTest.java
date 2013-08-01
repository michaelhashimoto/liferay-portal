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

package com.liferay.portalweb.demo.fundamentals.socialequityblogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EnableSocialActivityBlogsEntryTest extends BaseTestCase {
	public void testEnableSocialActivityBlogsEntry() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Social Activity",
			RuntimeVariables.replace("Social Activity"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertFalse(selenium.isChecked(
				"//input[@id='_179_com.liferay.portlet.blogs.model.BlogsEntry.enabledCheckbox']"));
		selenium.clickAt("//input[@id='_179_com.liferay.portlet.blogs.model.BlogsEntry.enabledCheckbox']",
			RuntimeVariables.replace("Blogs Entry"));
		assertTrue(selenium.isChecked(
				"//input[@id='_179_com.liferay.portlet.blogs.model.BlogsEntry.enabledCheckbox']"));
		selenium.clickAt("link=Blogs Entry",
			RuntimeVariables.replace("Blogs Entry"));
		selenium.waitForVisible(
			"//div[@class='aui-settings-display-content']/ul/li[2]/div/span");
		assertEquals(RuntimeVariables.replace("Adds a Comment"),
			selenium.getText(
				"//div[@class='aui-settings-display-content']/ul/li[2]/div/span"));
		selenium.select("//select[@id='ADD_COMMENT_participationIncrement']",
			RuntimeVariables.replace("2"));
		selenium.select("//select[@id='ADD_COMMENT_contributionIncrement']",
			RuntimeVariables.replace("2"));
		assertEquals(RuntimeVariables.replace("Limit"),
			selenium.getText(
				"//div[@class='aui-settings-display-content']/ul/li[2]/div/div/div[2]/a[1]/span"));
		selenium.clickAt("//div[@class='aui-settings-display-content']/ul/li[2]/div/div/div[2]/a[1]/span",
			RuntimeVariables.replace("Limit"));
		selenium.waitForVisible(
			"//select[@id='ADD_COMMENT_contributionLimitValue']");
		selenium.select("//select[@id='ADD_COMMENT_contributionLimitValue']",
			RuntimeVariables.replace("2"));
		assertEquals(RuntimeVariables.replace("Reads a Blog"),
			selenium.getText(
				"//div[@class='aui-settings-display-content']/ul/li[3]/div/span"));
		selenium.clickAt("//div[@class='aui-settings-display-content']/ul/li[3]/div/div/div[2]/a[2]/span",
			RuntimeVariables.replace("Close"));
		selenium.waitForVisible(
			"//ul[@class='settings-actions']/li[2]/div/span");
		assertEquals(RuntimeVariables.replace("Reads a Blog"),
			selenium.getText("//ul[@class='settings-actions']/li[2]/div/span"));
		assertEquals(RuntimeVariables.replace("Subscribes to a Blog"),
			selenium.getText(
				"//div[@class='aui-settings-display-content']/ul/li[3]/div/span"));
		selenium.clickAt("//div[@class='aui-settings-display-content']/ul/li[3]/div/div/div[2]/a[2]/span",
			RuntimeVariables.replace("Close"));
		selenium.waitForText("//ul[@class='settings-actions']/li[3]/div/span",
			"Subscribes to a Blog");
		assertEquals(RuntimeVariables.replace("Subscribes to a Blog"),
			selenium.getText("//ul[@class='settings-actions']/li[3]/div/span"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}