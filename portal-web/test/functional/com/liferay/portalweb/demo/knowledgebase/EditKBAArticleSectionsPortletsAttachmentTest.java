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

package com.liferay.portalweb.demo.knowledgebase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditKBAArticleSectionsPortletsAttachmentTest extends BaseTestCase {
	public void testEditKBAArticleSectionsPortletsAttachment()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Knowledge Base (Admin)",
			RuntimeVariables.replace("Knowledge Base (Admin)"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("KB Admin Article"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Attachments \u00bb"),
			selenium.getText(
				"//div[@id='_1_WAR_knowledgebaseportlet_attachments']/div/div/a"));
		selenium.clickAt("//div[@id='_1_WAR_knowledgebaseportlet_attachments']/div/div/a",
			RuntimeVariables.replace("Add Attachments \u00bb"));
		selenium.waitForPopUp("selectAttachments",
			RuntimeVariables.replace("30000"));
		selenium.selectWindow("name=selectAttachments");
		Thread.sleep(5000);
		selenium.waitForVisible(
			"//input[@id='_1_WAR_knowledgebaseportlet_file']");
		selenium.uploadCommonFile("//input[@id='_1_WAR_knowledgebaseportlet_file']",
			RuntimeVariables.replace("Document_1.jpg"));
		selenium.waitForVisible("//a/span");
		assertEquals(RuntimeVariables.replace("Document_1.jpg (12.9k)"),
			selenium.getText("//a/span"));
		selenium.close();
		Thread.sleep(5000);
		selenium.selectWindow("null");
		selenium.waitForVisible(
			"//div[@id='_1_WAR_knowledgebaseportlet_attachments']/div/div/span/a/span");
		assertEquals(RuntimeVariables.replace("Document_1.jpg (12.9k)"),
			selenium.getText(
				"//div[@id='_1_WAR_knowledgebaseportlet_attachments']/div/div/span/a/span"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}