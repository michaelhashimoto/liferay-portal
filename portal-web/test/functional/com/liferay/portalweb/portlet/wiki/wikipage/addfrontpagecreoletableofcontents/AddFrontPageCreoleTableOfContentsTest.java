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

package com.liferay.portalweb.portlet.wiki.wikipage.addfrontpagecreoletableofcontents;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddFrontPageCreoleTableOfContentsTest extends BaseTestCase {
	public void testAddFrontPageCreoleTableOfContents()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"This page is empty. Edit it to add some text."),
			selenium.getText("//div[@class='wiki-body']/div/a"));
		selenium.clickAt("//div[@class='wiki-body']/div/a",
			RuntimeVariables.replace(
				"This page is empty. Edit it to add some text."));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//a[@class='cke_button_source cke_on']");
		selenium.waitForVisible("//td[@id='cke_contents__36_editor']/textarea");
		selenium.type("//td[@id='cke_contents__36_editor']/textarea",
			RuntimeVariables.replace(
				"<<TableOfContents>>\n== Unit ==\n=== Chapter ===\n==== Section ===="));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("//span[.='Source']"));
		selenium.clickAt("//span[.='Source']",
			RuntimeVariables.replace("Source"));
		selenium.waitForVisible("//td[@id='cke_contents__36_editor']/iframe");
		selenium.selectFrame("//td[@id='cke_contents__36_editor']/iframe");
		selenium.waitForPartialText("//body", "<<TableOfContents>>");
		selenium.waitForPartialText("//body", "Unit");
		selenium.waitForPartialText("//body", "Chapter");
		selenium.waitForPartialText("//body", "Section");
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Table of Contents [-]"),
			selenium.getText("//div[@class='collapsebox']/h4"));
		assertEquals(RuntimeVariables.replace("[-]"),
			selenium.getText("//div[@class='collapsebox']//a"));
		assertEquals(RuntimeVariables.replace("Unit"),
			selenium.getText("//div[@class='toc-index']/ol/li/a"));
		assertEquals(RuntimeVariables.replace("Chapter"),
			selenium.getText("//div[@class='toc-index']/ol/li/ol/li/a"));
		assertEquals(RuntimeVariables.replace("Section"),
			selenium.getText("//div[@class='toc-index']/ol/li/ol/li/ol/li/a"));
		assertEquals(RuntimeVariables.replace("Unit #"),
			selenium.getText("//div[6]/div/h2"));
		assertEquals(RuntimeVariables.replace("Chapter #"),
			selenium.getText("//div[6]/div/h3"));
		assertEquals(RuntimeVariables.replace("Section #"),
			selenium.getText("//div[6]/div/h4"));
	}
}