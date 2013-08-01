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

package com.liferay.portalweb.portlet.blogs.blogsentrycomment.editblogsentrycomment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditBlogsEntryCommentTest extends BaseTestCase {
	public void testEditBlogsEntryComment() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//div[@class='entry-title']/h2/a"));
		selenium.clickAt("//div[@class='entry-title']/h2/a",
			RuntimeVariables.replace("Blogs Entry Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Comment Body"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
		selenium.mouseOver("//div[@class='lfr-discussion first']");
		selenium.waitForVisible(
			"//ul[@class='lfr-discussion-actions']/li[3]/span/a/span");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//ul[@class='lfr-discussion-actions']/li[3]/span/a/span"));
		selenium.clickAt("//ul[@class='lfr-discussion-actions']/li[3]/span/a/span",
			RuntimeVariables.replace("Edit"));
		selenium.waitForVisible("//textarea[@name='_33_editReplyBody1']");
		selenium.type("//textarea[@name='_33_editReplyBody1']",
			RuntimeVariables.replace("Blogs Entry Comment Body Edit"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForText("//div[@class='lfr-message-response portlet-msg-success']",
			"Your request processed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Comment Body Edit"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
		assertNotEquals(RuntimeVariables.replace("Blogs Entry Comment Body"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
	}
}