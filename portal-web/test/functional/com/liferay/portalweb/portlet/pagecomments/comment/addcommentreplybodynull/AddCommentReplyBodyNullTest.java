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

package com.liferay.portalweb.portlet.pagecomments.comment.addcommentreplybodynull;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCommentReplyBodyNullTest extends BaseTestCase {
	public void testAddCommentReplyBodyNull() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Post Reply"),
			selenium.getText("//li[1]/span/a/span"));
		selenium.clickAt("//li[1]/span/a/span",
			RuntimeVariables.replace("Post Reply"));
		selenium.waitForVisible("//textarea[@name='_107_postReplyBody1']");
		assertTrue(selenium.isVisible("//textarea[@name='_107_postReplyBody1']"));
		selenium.type("//textarea[@name='_107_postReplyBody1']",
			RuntimeVariables.replace(""));
		selenium.clickAt("xPath=(//input[@value='Reply'])[2]",
			RuntimeVariables.replace("Reply"));
		selenium.waitForText("//div[@class='lfr-message-response portlet-msg-error']",
			"Please enter a valid message.");
		assertEquals(RuntimeVariables.replace("Please enter a valid message."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-error']"));
		assertFalse(selenium.isTextPresent(
				"Your request processed successfully."));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent(
				"xPath=(//div[@class='lfr-discussion-message'])[2]"));
	}
}