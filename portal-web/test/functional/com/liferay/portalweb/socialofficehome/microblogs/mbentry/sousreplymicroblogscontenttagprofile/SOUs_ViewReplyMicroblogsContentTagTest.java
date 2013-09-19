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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.sousreplymicroblogscontenttagprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewReplyMicroblogsContentTagTest extends BaseTestCase {
	public void testSOUs_ViewReplyMicroblogsContentTag()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/socialoffice01/so/dashboard/");
				selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
					RuntimeVariables.replace("Microblogs"));
				selenium.waitForPageToLoad("30000");

				boolean replyVisible = selenium.isElementPresent(
						"//div[@class='microblogs-entry show-comments']");

				if (replyVisible) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("1 Comment"),
					selenium.getText("//span[@class='action comment']/a"));
				selenium.clickAt("//span[@class='action comment']/a",
					RuntimeVariables.replace("1 Comment"));
				selenium.waitForVisible("xPath=(//div[@class='content'])[2]");

			case 2:
				assertTrue(selenium.isPartialText(
						"xPath=(//div[@class='content'])[2]",
						"Microblogs Post Comment"));
				assertEquals(RuntimeVariables.replace("Joe Bloggs"),
					selenium.getText("//div[@class='content']/span/a"));
				selenium.clickAt("//div[@class='content']/span/a",
					RuntimeVariables.replace("Joe Bloggs"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//div[@class='user-profile-detail']"));
				assertEquals(RuntimeVariables.replace("Profile"),
					selenium.getText(
						"//nav[contains(.,'Profile')]/ul/li/a/span"));
				assertEquals(RuntimeVariables.replace("Joe Bloggs"),
					selenium.getText(
						"xPath=(//div[@class='lfr-contact-name']/a)[2]"));
				assertEquals(RuntimeVariables.replace("test@liferay.com"),
					selenium.getText("//div[@class='lfr-contact-extra']"));
				assertEquals(RuntimeVariables.replace("Activities"),
					selenium.getText("//span[@class='portlet-title-text']"));
				selenium.waitForVisible(
					"xPath=(//div[@class='activity-action'])[1]");
				assertEquals(RuntimeVariables.replace("Microblogs Post"),
					selenium.getText(
						"xPath=(//div[@class='activity-action'])[1]"));
				assertEquals(RuntimeVariables.replace("1 Comment"),
					selenium.getText("//span[@class='view-comments action']/a"));
				selenium.clickAt("//span[@class='view-comments action']/a",
					RuntimeVariables.replace("1 Comment"));
				selenium.waitForVisible("//div[@class='comment-body']");
				assertTrue(selenium.isPartialText(
						"//div[@class='comment-body']",
						"Social01 Office01 User01"));
				assertTrue(selenium.isPartialText(
						"//div[@class='comment-body']",
						"Microblogs Post Comment"));
				assertTrue(selenium.isPartialText(
						"//div[@class='comment-body']", "[@joebloggs]"));

			case 100:
				label = -1;
			}
		}
	}
}