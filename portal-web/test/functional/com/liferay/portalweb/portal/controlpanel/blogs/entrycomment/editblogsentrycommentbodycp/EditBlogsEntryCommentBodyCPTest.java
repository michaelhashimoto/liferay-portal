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

package com.liferay.portalweb.portal.controlpanel.blogs.entrycomment.editblogsentrycommentbodycp;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditBlogsEntryCommentBodyCPTest extends BaseTestCase {
	public void testEditBlogsEntryCommentBodyCP() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Blogs", RuntimeVariables.replace("Blogs"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Blogs Entry Title"),
			selenium.getText("//tr[contains(.,'Blogs Entry Title')]/td[2]/a"));
		selenium.clickAt("//tr[contains(.,'Blogs Entry Title')]/td[2]/a",
			RuntimeVariables.replace("Blogs Entry Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1 Comment"),
			selenium.getText("//span[@class='comments']"));
		assertEquals(RuntimeVariables.replace("Blogs Entry Comment Body"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
		selenium.mouseOver("//li[@class='lfr-discussion-delete-reply']/span/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//li[@class='lfr-discussion-delete-reply']/span/a"));
		selenium.clickAt("//li[@class='lfr-discussion-delete-reply']/span/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForVisible("//textarea[@name='_161_editReplyBody1']");
		selenium.type("//textarea[@name='_161_editReplyBody1']",
			RuntimeVariables.replace("Blogs Entry Comment Body Edited"));
		selenium.keyPress("//textarea[@name='_161_editReplyBody1']",
			RuntimeVariables.replace("\\48"));
		selenium.keyPress("//textarea[@name='_161_editReplyBody1']",
			RuntimeVariables.replace("\\8"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		Thread.sleep(5000);
		selenium.waitForVisible("//span[@class='comments']");
		assertEquals(RuntimeVariables.replace("1 Comment"),
			selenium.getText("//span[@class='comments']"));
		selenium.waitForText("//div[@class='lfr-discussion-message']",
			"Blogs Entry Comment Body Edited");
		assertEquals(RuntimeVariables.replace("Blogs Entry Comment Body Edited"),
			selenium.getText("//div[@class='lfr-discussion-message']"));
	}
}