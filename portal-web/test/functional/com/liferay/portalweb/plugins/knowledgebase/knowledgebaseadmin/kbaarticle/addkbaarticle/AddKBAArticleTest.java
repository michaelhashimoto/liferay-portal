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

package com.liferay.portalweb.plugins.knowledgebase.knowledgebaseadmin.kbaarticle.addkbaarticle;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddKBAArticleTest extends BaseTestCase {
	public void testAddKBAArticle() throws Exception {
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
		selenium.clickAt("link=Knowledge Base (Admin)",
			RuntimeVariables.replace("Knowledge Base (Admin)"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Article']",
			RuntimeVariables.replace("Add Article"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_1_WAR_knowledgebaseportlet_title']",
			RuntimeVariables.replace("Knowledge Base Admin Article Title"));
		selenium.waitForElementPresent(
			"//td[@id='cke_contents__1_WAR_knowledgebaseportlet_editor']");
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//a[@class='cke_button_source cke_on']");
		selenium.waitForVisible(
			"//td[@id='cke_contents__1_WAR_knowledgebaseportlet_editor']/textarea");
		selenium.type("//td[@id='cke_contents__1_WAR_knowledgebaseportlet_editor']/textarea",
			RuntimeVariables.replace("Knowledge Base Admin Article Content"));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForElementPresent(
			"//td[@id='cke_contents__1_WAR_knowledgebaseportlet_editor']");
		selenium.waitForVisible(
			"//td[@id='cke_contents__1_WAR_knowledgebaseportlet_editor']/iframe");
		selenium.selectFrame(
			"//td[@id='cke_contents__1_WAR_knowledgebaseportlet_editor']/iframe");
		selenium.waitForText("//body", "Knowledge Base Admin Article Content");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals("1.0",
			selenium.getValue("//tr[3]/td[2]/span/span/span/input"));
		assertEquals(RuntimeVariables.replace(
				"Knowledge Base Admin Article Title"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//tr[3]/td[4]"));
		assertTrue(selenium.isVisible("//tr[3]/td[5]"));
		assertTrue(selenium.isVisible("//tr[3]/td[6]"));
		assertEquals(RuntimeVariables.replace("0 (Approved)"),
			selenium.getText("//tr[3]/td[7]"));
		assertTrue(selenium.isVisible("//tr[3]/td[8]"));
	}
}