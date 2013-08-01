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

package com.liferay.portalweb.portlet.wiki.comment.editfrontpagecommentbody;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditFrontPageCommentBodyTest extends BaseTestCase {
	public void testEditFrontPageCommentBody() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Wiki Test Page");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Front Page Comment Body"),
			selenium.getText("//div/div[3]/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//li[contains(.,'Edit')]/span/a/span"));
		selenium.clickAt("//li[contains(.,'Edit')]/span/a/span",
			RuntimeVariables.replace("Edit"));
		selenium.type("//textarea[@name='_36_editReplyBody1']",
			RuntimeVariables.replace("Wiki Front Page Comment Body Edit"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForVisible(
			"//div[@class='lfr-message-response portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"Wiki Front Page Comment Body Edit"),
			selenium.getText("//div/div[3]/div/div[1]"));
		assertNotEquals(RuntimeVariables.replace("Wiki Front Page Comment Body"),
			selenium.getText("//div/div[3]/div/div[1]"));
	}
}