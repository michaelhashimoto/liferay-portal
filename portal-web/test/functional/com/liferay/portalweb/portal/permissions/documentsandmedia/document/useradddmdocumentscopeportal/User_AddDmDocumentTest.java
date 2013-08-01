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

package com.liferay.portalweb.portal.permissions.documentsandmedia.document.useradddmdocumentscopeportal;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_AddDmDocumentTest extends BaseTestCase {
	public void testUser_AddDmDocument() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span[@title='Add']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Add']/ul/li/strong/a/span",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Basic Document')]");
		assertEquals(RuntimeVariables.replace("Basic Document"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Basic Document')]"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Basic Document')]"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadCommonFile("//input[@id='_20_file']",
			RuntimeVariables.replace("Document_1.doc"));
		selenium.type("//input[@id='_20_title']",
			RuntimeVariables.replace("DM Document Title"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request completed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText(
				"//a[@class='document-link']/span[@class='entry-title']"));
		selenium.clickAt("//a[@class='document-link']/span[@class='entry-title']",
			RuntimeVariables.replace("DM Document Title"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//span[@class='aui-toolbar-content']/button[1]",
			"Download");
		assertEquals(RuntimeVariables.replace("Download"),
			selenium.getText("//span[@class='aui-toolbar-content']/button[1]"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//span[@class='aui-toolbar-content']/button[2]"));
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText("//span[@class='aui-toolbar-content']/button[3]"));
		assertEquals(RuntimeVariables.replace("Checkout"),
			selenium.getText("//span[@class='aui-toolbar-content']/button[4]"));
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText("//span[@class='aui-toolbar-content']/button[5]"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//span[@class='aui-toolbar-content']/button[6]"));
		assertEquals(RuntimeVariables.replace("DM Document Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertTrue(selenium.isPartialText(
				"//span[@class='user-date']/span/span",
				"Uploaded by userfn userln"));
		assertEquals(RuntimeVariables.replace("Version 1.0"),
			selenium.getText("//h3[contains(@class,'version')]"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("Download (21.5k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
	}
}