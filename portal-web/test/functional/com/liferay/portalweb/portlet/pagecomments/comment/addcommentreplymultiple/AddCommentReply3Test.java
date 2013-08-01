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

package com.liferay.portalweb.portlet.pagecomments.comment.addcommentreplymultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCommentReply3Test extends BaseTestCase {
	public void testAddCommentReply3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Post Reply"),
			selenium.getText("//div[3]/div[3]/div/div[2]/ul/li[1]/span/a/span"));
		selenium.clickAt("//div[3]/div[3]/div/div[2]/ul/li[1]/span/a/span",
			RuntimeVariables.replace("Post Reply"));
		selenium.waitForVisible("//textarea[@name='_107_postReplyBody3']");
		assertTrue(selenium.isVisible("//textarea[@name='_107_postReplyBody3']"));
		selenium.type("//textarea[@name='_107_postReplyBody3']",
			RuntimeVariables.replace("PC Comment Reply3"));
		selenium.clickAt("xPath=(//input[@value='Reply'])[4]",
			RuntimeVariables.replace("Reply"));
		selenium.waitForText("//div[@class='lfr-message-response portlet-msg-success']",
			"Your request processed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("PC Comment"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[1]"));
		assertEquals(RuntimeVariables.replace("PC Comment Reply1"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[2]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='lfr-discussion-posted-on'])[2]",
				"in reply to"));
		assertEquals(RuntimeVariables.replace("PC Comment Reply2"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[3]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='lfr-discussion-posted-on'])[3]",
				"in reply to"));
		assertEquals(RuntimeVariables.replace("PC Comment Reply3"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[4]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='lfr-discussion-posted-on'])[4]",
				"in reply to"));
	}
}