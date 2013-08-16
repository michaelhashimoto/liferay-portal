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

package com.liferay.portalweb.portlet.wikidisplay.comment.addwdfrontpagecommentmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWDFrontPageComment3Test extends BaseTestCase {
	public void testAddWDFrontPageComment3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Comment"),
			selenium.getText(
				"//fieldset[@class='aui-fieldset add-comment ']/div/span/a/span"));
		selenium.clickAt("//fieldset[@class='aui-fieldset add-comment ']/div/span/a/span",
			RuntimeVariables.replace("Add Comment"));
		selenium.waitForVisible("//textarea");
		selenium.type("//textarea",
			RuntimeVariables.replace("Wiki FrontPage Comment3"));
		selenium.click("//input[@value='Reply']");
		selenium.waitForVisible(
			"//div[@class='lfr-message-response portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Comment1"),
			selenium.getText(
				"xpath=(//div[@class='lfr-discussion-message'])[1]"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Comment2"),
			selenium.getText(
				"xpath=(//div[@class='lfr-discussion-message'])[2]"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage Comment3"),
			selenium.getText(
				"xpath=(//div[@class='lfr-discussion-message'])[3]"));
	}
}