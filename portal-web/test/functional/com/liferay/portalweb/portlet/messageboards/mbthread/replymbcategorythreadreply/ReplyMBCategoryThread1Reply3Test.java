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

package com.liferay.portalweb.portlet.messageboards.mbthread.replymbcategorythreadreply;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ReplyMBCategoryThread1Reply3Test extends BaseTestCase {
	public void testReplyMBCategoryThread1Reply3() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Message Boards Test Page",
			RuntimeVariables.replace("Message Boards Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("MB Category Name"),
			selenium.getText("//td[1]/a/strong"));
		selenium.clickAt("//td[1]/a/strong",
			RuntimeVariables.replace("MB Category Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=MB Category Thread1 Message Subject",
			RuntimeVariables.replace("MB Category Thread1 Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Reply"),
			selenium.getText(
				"//div[6]/table/tbody/tr[1]/td[2]/div[1]/ul/li[2]/span/a/span"));
		selenium.clickAt("//div[6]/table/tbody/tr[1]/td[2]/div[1]/ul/li[2]/span/a/span",
			RuntimeVariables.replace("Reply"));
		selenium.waitForPageToLoad("30000");
		assertEquals("RE: MB Category Thread1 Message Subject",
			selenium.getValue("//input[@id='_19_subject']"));
		Thread.sleep(1000);
		selenium.waitForVisible("//iframe[contains(@title,'Rich text editor')]");
		selenium.typeFrame("//iframe[contains(@title,'Rich text editor')]",
			RuntimeVariables.replace("MB Category Thread1 Message Reply3 Body"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread1 Message Subject"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread1 Message Subject"),
			selenium.getText("//a/strong"));
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread1 Message Subject"),
			selenium.getText("xPath=(//div[@class='subject']/a/strong)[2]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread1 Message Reply1 Body"),
			selenium.getText("xPath=(//div[@class='thread-body'])[2]"));
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread1 Message Subject"),
			selenium.getText("xPath=(//div[@class='subject']/a/strong)[3]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread1 Message Reply2 Body"),
			selenium.getText("xPath=(//div[@class='thread-body'])[3]"));
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread1 Message Subject"),
			selenium.getText("xPath=(//div[@class='subject']/a/strong)[4]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread1 Message Reply3 Body"),
			selenium.getText("xPath=(//div[@class='thread-body'])[4]"));
	}
}