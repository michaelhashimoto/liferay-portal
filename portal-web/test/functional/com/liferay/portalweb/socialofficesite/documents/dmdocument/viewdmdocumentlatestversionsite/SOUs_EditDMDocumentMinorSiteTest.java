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

package com.liferay.portalweb.socialofficesite.documents.dmdocument.viewdmdocumentlatestversionsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditDMDocumentMinorSiteTest extends BaseTestCase {
	public void testSOUs_EditDMDocumentMinorSite() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/socialoffice01/so/dashboard/");
		selenium.clickAt("//input[contains(@class,'search-input')]",
			RuntimeVariables.replace("Go to"));
		selenium.waitForVisible("//input[@class='search-input focus']");
		selenium.type("//input[@class='search-input focus']",
			RuntimeVariables.replace("Open"));
		Thread.sleep(1000);
		assertEquals(RuntimeVariables.replace("Open Site Name"),
			selenium.getText(
				"//li[contains(@class, 'social-office-enabled')]/span[2]/a"));
		selenium.clickAt("//li[contains(@class, 'social-office-enabled')]/span[2]/a",
			RuntimeVariables.replace("Open Site Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Documents"),
			selenium.getText("//nav/ul/li[contains(.,'Documents')]/a/span"));
		selenium.clickAt("//nav/ul/li[contains(.,'Documents')]/a/span",
			RuntimeVariables.replace("Documents"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			RuntimeVariables.replace("DM Document Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText("//span[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//button[contains(.,'Edit')]"));
		selenium.clickAt("//button[contains(.,'Edit')]",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadCommonFile("//input[@id='_20_file']",
			RuntimeVariables.replace("Document_1.odt"));
		selenium.type("//input[@id='_20_title']",
			RuntimeVariables.replace("DM Document Title Edit1"));
		selenium.type("//textarea[@id='_20_description']",
			RuntimeVariables.replace("DM Document Description Edit1"));
		selenium.type("//input[@id='_20_changeLog']",
			RuntimeVariables.replace("Minor Edit"));
		selenium.clickAt("//span[contains(.,'Minor Revision')]/span/input",
			RuntimeVariables.replace("Minor Revision"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("DM Document Title Edit1"),
			selenium.getText("//span[@class='document-title']"));
		assertTrue(selenium.isVisible("//span[@class='document-thumbnail']/img"));
		assertTrue(selenium.isPartialText(
				"//span[@class='user-date']/span/span", "Uploaded by Joe Bloggs"));
		assertTrue(selenium.isVisible("//span[@class='lfr-asset-ratings']"));
		assertEquals(RuntimeVariables.replace("Version History"),
			selenium.getText(
				"//div[@class='lfr-document-library-versions']/div/div/div"));
		assertEquals(RuntimeVariables.replace("Version 1.1"),
			selenium.getText("xPath=(//span[@class='version-number'])[1]"));
		assertEquals(RuntimeVariables.replace("By: Social01 Office01 User01"),
			selenium.getText("xPath=(//span[@class='user-name'])[1]"));
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='modified-date'])[1]"));
		assertEquals(RuntimeVariables.replace("Size: 9.0k"),
			selenium.getText("xPath=(//span[@class='size'])[1]"));
		assertEquals(RuntimeVariables.replace("Minor Edit"),
			selenium.getText("//div[@class='changelog']"));
		assertEquals(RuntimeVariables.replace(
				"No comments yet. Be the first. Subscribe to Comments"),
			selenium.getText(
				"xPath=(//fieldset[@class='aui-fieldset add-comment ']/div)[1]"));
		assertEquals(RuntimeVariables.replace("Be the first."),
			selenium.getText(
				"xPath=(//fieldset[@class='aui-fieldset add-comment ']/div/a)[1]"));
		assertEquals(RuntimeVariables.replace("Subscribe to Comments"),
			selenium.getText(
				"xPath=(//span[@class='subscribe-link']/a/span)[1]"));
		assertEquals(RuntimeVariables.replace("Version 1.0"),
			selenium.getText("xPath=(//span[@class='version-number'])[2]"));
		assertEquals(RuntimeVariables.replace("By: Joe Bloggs"),
			selenium.getText("xPath=(//span[@class='user-name'])[2]"));
		assertTrue(selenium.isVisible(
				"xPath=(//span[@class='modified-date'])[2]"));
		assertEquals(RuntimeVariables.replace("Size: 21.5k"),
			selenium.getText("xPath=(//span[@class='size'])[2]"));
		assertEquals(RuntimeVariables.replace("Add Comment"),
			selenium.getText(
				"xPath=(//fieldset[@class='aui-fieldset add-comment ']/div/span[1])[2]"));
		assertEquals(RuntimeVariables.replace("Subscribe to Comments"),
			selenium.getText(
				"xPath=(//fieldset[@class='aui-fieldset add-comment ']/div/span[2])[1]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("xPath=(//span[@class='user-name'])[3]"));
		assertEquals(RuntimeVariables.replace("DM Document Comment1"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[1]"));
		assertEquals(RuntimeVariables.replace("Version 1.1"),
			selenium.getText("//h3[contains(@class,'version')]"));
		assertEquals(RuntimeVariables.replace(
				"Last Updated by Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-asset-icon lfr-asset-author']"));
		assertTrue(selenium.isVisible(
				"//div[@class='lfr-asset-icon lfr-asset-date']"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("DM Document Description Edit1"),
			selenium.getText("//blockquote[@class='lfr-asset-description']"));
		assertEquals(RuntimeVariables.replace("Download (9.0k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
		assertEquals(RuntimeVariables.replace("Get URL or WebDAV URL."),
			selenium.getText("//span[@class='webdav-url']"));
	}
}