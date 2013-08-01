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

package com.liferay.portalweb.asset.webcontent.wcwebcontentcomment.bethefirstwcwebcontentcommentap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class BeTheFirstWCWebContentCommentAPTest extends BaseTestCase {
	public void testBeTheFirstWCWebContentCommentAP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//fieldset[contains(.,'Be the first.')]/div/a");
		assertEquals(RuntimeVariables.replace("Be the first."),
			selenium.getText("//fieldset[contains(.,'Be the first.')]/div/a"));
		selenium.clickAt("//fieldset[contains(.,'Be the first.')]/div/a",
			RuntimeVariables.replace("Be the first."));
		selenium.waitForVisible("//textarea");
		selenium.type("//textarea",
			RuntimeVariables.replace("WC Web Content Comment"));
		selenium.clickAt("//input[@value='Reply']",
			RuntimeVariables.replace("Reply"));
		selenium.waitForVisible(
			"//div[@class='lfr-message-response portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("WC Web Content Comment"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
	}
}