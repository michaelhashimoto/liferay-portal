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

package com.liferay.portalweb.portlet.wikidisplay.attachment.addwdfrontpageattachment;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWDFrontPageAttachmentTest extends BaseTestCase {
	public void testViewWDFrontPageAttachment() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Display Test Page",
			RuntimeVariables.replace("Wiki Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1 Attachment"),
			selenium.getText("//div[@class='article-actions']/span[2]/a/span"));
		selenium.clickAt("//div[@class='article-actions']/span[2]/a/span",
			RuntimeVariables.replace("1 Attachment"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'FrontPage')]"));
		assertEquals(RuntimeVariables.replace("Recent Changes"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'Recent Changes')]"));
		assertEquals(RuntimeVariables.replace("All Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'All Pages')]"));
		assertEquals(RuntimeVariables.replace("Orphan Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'Orphan Pages')]"));
		assertEquals(RuntimeVariables.replace("Draft Pages"),
			selenium.getText(
				"//ul[@class='top-links-navigation']/li/span[contains(.,'Draft Pages')]"));
		assertTrue(selenium.isVisible(
				"//span[@class='aui-search-bar']/span/span/span/input"));
		assertTrue(selenium.isVisible("//input[@title='Search Pages']"));
		assertEquals(RuntimeVariables.replace("FrontPage"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isVisible("link=Content"));
		assertTrue(selenium.isVisible("link=Details"));
		assertTrue(selenium.isVisible("link=History"));
		assertTrue(selenium.isVisible("link=Incoming Links"));
		assertTrue(selenium.isVisible("link=Outgoing Links"));
		assertTrue(selenium.isVisible("link=Attachments"));
		assertTrue(selenium.isVisible("//input[@value='Add Attachments']"));
		assertEquals(RuntimeVariables.replace("File Name"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[1]"));
		assertEquals(RuntimeVariables.replace("Size"),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[2]"));
		assertEquals(RuntimeVariables.replace(""),
			selenium.getText(
				"//tr[@class='portlet-section-header results-header']/th[3]"));
		assertEquals(RuntimeVariables.replace("Document_1.jpg"),
			selenium.getText("//tr[3]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("12.9k"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//tr[3]/td[3]/span/a/span"));
		selenium.clickAt("//tr[3]/td[1]/a",
			RuntimeVariables.replace("Document_1.jpg"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//img[contains(@src,'fileName=Document_1.jpg')]"));
	}
}