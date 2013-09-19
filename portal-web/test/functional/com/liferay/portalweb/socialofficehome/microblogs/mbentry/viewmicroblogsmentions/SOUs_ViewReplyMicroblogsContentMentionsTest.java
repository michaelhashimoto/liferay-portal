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

package com.liferay.portalweb.socialofficehome.microblogs.mbentry.viewmicroblogsmentions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_ViewReplyMicroblogsContentMentionsTest extends BaseTestCase {
	public void testSOUs_ViewReplyMicroblogsContentMentions()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard");
		selenium.waitForVisible("xPath=(//div[@class='activity-action'])[1]");
		assertEquals(RuntimeVariables.replace("Microblogs Post"),
			selenium.getText("xPath=(//div[@class='activity-action'])[1]"));
		assertEquals(RuntimeVariables.replace("1 Comment"),
			selenium.getText("//span[@class='view-comments action']/a"));
		selenium.clickAt("//span[@class='view-comments action']/a",
			RuntimeVariables.replace("1 Comment"));
		selenium.waitForVisible("//div[@class='comment-body']");
		assertTrue(selenium.isPartialText("//div[@class='comment-body']",
				"Social01 Office01 User01"));
		assertTrue(selenium.isPartialText("//div[@class='comment-body']",
				"Microblogs Post Comment"));
		assertTrue(selenium.isPartialText("//div[@class='comment-body']",
				"[@joebloggs]"));
	}
}