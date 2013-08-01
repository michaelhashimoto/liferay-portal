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

package com.liferay.portalweb.portlet.messageboards.mbthread.splitthreadmbcategorythreadreplyexplanation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SplitThreadMBCategoryThreadReplyExplanationTest
	extends BaseTestCase {
	public void testSplitThreadMBCategoryThreadReplyExplanation()
		throws Exception {
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
		assertFalse(selenium.isTextPresent(
				"RE: MB Category Thread Message Subject"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread Message Subject"),
			selenium.getText("//td[1]/a"));
		selenium.clickAt("//td[1]/a",
			RuntimeVariables.replace("MB Category Thread Message Subject"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread Message Subject"),
			selenium.getText(
				"//div[@id='toggle_id_message_boards_view_message_thread']/table/tbody/tr[2]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText(
				"//div[@id='toggle_id_message_boards_view_message_thread']/table/tbody/tr[2]/td[2]/a"));
		assertTrue(selenium.isElementPresent(
				"//div[@id='toggle_id_message_boards_view_message_thread']/table/tbody/tr[2]/td[3]/a"));
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread Message Subject"),
			selenium.getText("xPath=(//div[@class='subject']/a/strong)[2]"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread Message Reply Body"),
			selenium.getText("xPath=(//div[@class='thread-body'])[2]"));
		assertEquals(RuntimeVariables.replace("Split Thread"),
			selenium.getText("//a/span[.='Split Thread']"));
		selenium.clickAt("//a/span[.='Split Thread']",
			RuntimeVariables.replace("Split Thread"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isChecked(
				"//input[@id='_19_addExplanationPostCheckbox']"));
		selenium.clickAt("//input[@id='_19_addExplanationPostCheckbox']",
			RuntimeVariables.replace(
				"Add explanation post to the source thread."));
		assertTrue(selenium.isChecked(
				"//input[@id='_19_addExplanationPostCheckbox']"));
		selenium.waitForVisible("//input[@id='_19_subject']");
		selenium.type("//input[@id='_19_subject']",
			RuntimeVariables.replace(
				"MB Category Thread Message Explanation Subject"));
		selenium.waitForElementPresent(
			"//textarea[@id='_19_editor' and contains(@style,'display: none;')]");
		selenium.waitForVisible("//td[@id='cke_contents__19_editor']/iframe");
		selenium.selectFrame("//td[@id='cke_contents__19_editor']/iframe");
		selenium.waitForText("//body",
			"The new thread can be found at ${newThreadURL}.");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='OK']", RuntimeVariables.replace("OK"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread Message Subject"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"RE: MB Category Thread Message Subject"),
			selenium.getText("//div[@class='subject']/a/strong"));
		assertEquals(RuntimeVariables.replace(
				"MB Category Thread Message Reply Body"),
			selenium.getText("//div[@class='thread-body']"));
	}
}