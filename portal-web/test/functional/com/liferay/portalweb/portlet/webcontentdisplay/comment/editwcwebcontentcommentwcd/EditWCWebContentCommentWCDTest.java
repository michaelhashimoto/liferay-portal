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

package com.liferay.portalweb.portlet.webcontentdisplay.comment.editwcwebcontentcommentwcd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditWCWebContentCommentWCDTest extends BaseTestCase {
	public void testEditWCWebContentCommentWCD() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.waitForVisible("link=Web Content Display Test Page");
		selenium.clickAt("link=Web Content Display Test Page",
			RuntimeVariables.replace("Web Content Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("WC WebContent Content"),
			selenium.getText("//div[@class='journal-content-article']/p"));
		assertEquals(RuntimeVariables.replace("WC WebContent Comment"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//li[3]/span/a/span"));
		selenium.clickAt("//li[3]/span/a/span", RuntimeVariables.replace("Edit"));
		selenium.waitForVisible("//div[4]/div/div[2]/span/span/span/textarea");
		selenium.type("//div[4]/div/div[2]/span/span/span/textarea",
			RuntimeVariables.replace("WC WebContent Comment Edit"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForVisible(
			"//div[@class='lfr-message-response portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("WC WebContent Comment Edit"),
			selenium.getText("//div/div[3]/div/div[1]"));
		assertNotEquals(RuntimeVariables.replace("WC WebContent Comment"),
			selenium.getText("//div/div[3]/div/div[1]"));
	}
}