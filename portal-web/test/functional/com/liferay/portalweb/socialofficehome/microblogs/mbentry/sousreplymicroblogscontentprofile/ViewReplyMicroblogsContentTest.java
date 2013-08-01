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
public class ViewReplyMicroblogsContentTest extends BaseTestCase {
	public void testViewReplyMicroblogsContent() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				assertTrue(selenium.isElementPresent(
						"//div[contains(@id,'_2_WAR_microblogsportlet_autocompleteContent')]"));
				assertEquals(RuntimeVariables.replace("Microblogs Post"),
					selenium.getText("//div[@class='content']"));
				selenium.clickAt("//nav/ul/li[contains(.,'Microblogs')]/a/span",
					RuntimeVariables.replace("Microblogs"));
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

			case 100:
				label = -1;
			}
		}
	}
}