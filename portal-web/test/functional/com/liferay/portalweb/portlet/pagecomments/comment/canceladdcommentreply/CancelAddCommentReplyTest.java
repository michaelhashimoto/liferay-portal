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

package com.liferay.portalweb.portlet.pagecomments.comment.canceladdcommentreply;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CancelAddCommentReplyTest extends BaseTestCase {
	public void testCancelAddCommentReply() throws Exception {
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
			RuntimeVariables.replace("PC Comment Reply"));
		selenium.clickAt("xPath=(//input[@value='Cancel'])[2]",
			RuntimeVariables.replace("Cancel"));
		selenium.waitForNotVisible("//textarea[@name='_107_postReplyBody1']");
		assertFalse(selenium.isTextPresent("PC Comment Reply"));
		assertFalse(selenium.isVisible(
				"//textarea[@name='_107_postReplyBody1']"));
	}
}