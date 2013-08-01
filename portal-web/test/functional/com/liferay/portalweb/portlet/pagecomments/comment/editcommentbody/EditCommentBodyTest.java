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

package com.liferay.portalweb.portlet.pagecomments.comment.editcommentbody;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditCommentBodyTest extends BaseTestCase {
	public void testEditCommentBody() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("PC Comment"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
		selenium.mouseOver("//li[3]/span/a/span[contains(.,'Edit')]");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//li[3]/span/a/span[contains(.,'Edit')]"));
		selenium.clickAt("//li[3]/span/a/span[contains(.,'Edit')]",
			RuntimeVariables.replace("Edit"));
		selenium.waitForVisible("//textarea[@name='_107_editReplyBody1']");
		selenium.type("//textarea[@name='_107_editReplyBody1']",
			RuntimeVariables.replace("PC Comment Edit"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForText("//div[@class='lfr-message-response portlet-msg-success']",
			"Your request processed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("PC Comment Edit"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
	}
}