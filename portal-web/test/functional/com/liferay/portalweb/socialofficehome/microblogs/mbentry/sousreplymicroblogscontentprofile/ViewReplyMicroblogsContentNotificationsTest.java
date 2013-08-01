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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymicroblogscontentprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewReplyMicroblogsContentNotificationsTest extends BaseTestCase {
	public void testViewReplyMicroblogsContentNotifications()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				selenium.waitForElementPresent(
					"//li[@id='_145_notificationsMenu']");
				assertEquals(RuntimeVariables.replace("1"),
					selenium.getText("//span[@class='notification-count']"));
				selenium.mouseOver("//li[@id='_145_notificationsMenu']");
				selenium.waitForVisible("//div[@class='title']");
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01 commented on your post."),
					selenium.getText("//div[@class='title']"));
				assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
					selenium.getText("//div[@class='body']"));
				selenium.clickAt("//div[@class='title']",
					RuntimeVariables.replace(
						"Social01 Office01 User01 commented on your post."));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Joe Bloggs"),
					selenium.getText(
						"xPath=(//div[@class='user-name']/span)[contains(.,'Joe Bloggs')]"));
				assertEquals(RuntimeVariables.replace("Microblogs Post"),
					selenium.getText("xPath=(//div[@class='content'])[1]"));
				assertEquals(RuntimeVariables.replace("1 Comment"),
					selenium.getText("//span[@class='action comment']/a"));

				boolean commentVisible = selenium.isVisible(
						"//div[@class='comments-container reply']");

				if (commentVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//span[@class='action comment']/a",
					RuntimeVariables.replace("1 Comment"));
				selenium.waitForVisible(
					"//div[@class='comments-container reply']");

			case 2:
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01"),
					selenium.getText(
						"xPath=(//div[@class='user-name']/span)[contains(.,'Social01 Office01 User01')]"));
				assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
					selenium.getText("xPath=(//div[@class='content'])[2]"));
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				selenium.waitForElementPresent(
					"//li[@id='_145_notificationsMenu']");
				assertEquals(RuntimeVariables.replace("1"),
					selenium.getText("//span[@class='notification-count']"));
				selenium.mouseOver("//li[@id='_145_notificationsMenu']");
				selenium.waitForVisible("//div[@class='title']");
				assertEquals(RuntimeVariables.replace(
						"Social01 Office01 User01 commented on your post."),
					selenium.getText("//div[@class='title']"));
				assertEquals(RuntimeVariables.replace("Microblogs Post Comment"),
					selenium.getText("//div[@class='body']"));
				assertEquals(RuntimeVariables.replace("Mark All as Read"),
					selenium.getText("//span[@class='dismiss-notifications']/a"));
				selenium.clickAt("//span[@class='dismiss-notifications']/a",
					RuntimeVariables.replace("Mark All as Read"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				selenium.waitForElementPresent(
					"//li[@id='_145_notificationsMenu']");
				assertEquals(RuntimeVariables.replace("0"),
					selenium.getText("//span[@class='notification-count']"));
				selenium.mouseOver("//li[@id='_145_notificationsMenu']");
				assertFalse(selenium.isTextPresent(
						"Social01 Office01 User01 commented on your post."));

			case 100:
				label = -1;
			}
		}
	}
}