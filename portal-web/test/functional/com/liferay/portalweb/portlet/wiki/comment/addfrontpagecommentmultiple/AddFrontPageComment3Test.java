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

package com.liferay.portalweb.portlet.wiki.comment.addfrontpagecommentmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFrontPageComment3Test extends BaseTestCase {
	public void testAddFrontPageComment3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Comment"),
			selenium.getText("//fieldset/div/span[1]/a/span"));
		selenium.clickAt("//fieldset/div/span[1]/a/span",
			RuntimeVariables.replace("Add Comment"));
		selenium.waitForVisible("//textarea[@name='_36_postReplyBody0']");
		selenium.type("//textarea[@name='_36_postReplyBody0']",
			RuntimeVariables.replace("Wiki Front Page Comment3 Body"));
		selenium.click("//input[@value='Reply']");
		selenium.waitForVisible(
			"//div[@class='lfr-message-response portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Wiki Front Page Comment1 Body"),
			selenium.getText("//div/div[3]/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Wiki Front Page Comment2 Body"),
			selenium.getText("//div[2]/div[3]/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Wiki Front Page Comment3 Body"),
			selenium.getText("//div[3]/div[3]/div/div[1]"));
	}
}