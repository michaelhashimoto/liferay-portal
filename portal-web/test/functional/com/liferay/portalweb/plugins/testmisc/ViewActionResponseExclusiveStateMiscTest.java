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

package com.liferay.portalweb.plugins.testmisc;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.BrowserCommands;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewActionResponseExclusiveStateMiscTest extends BaseTestCase {
	public void testViewActionResponseExclusiveStateMisc()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Test Misc Page",
			RuntimeVariables.replace("Test Misc Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Portlet Response (ActionResponse, Exclusive State)"),
			selenium.getText("//h3[3]"));
		assertEquals(RuntimeVariables.replace("Download File"),
			selenium.getText("//p[3]/a"));
		selenium.clickAt("//p[3]/a", RuntimeVariables.replace("Download File"));
		BrowserCommands.downloadTempFile("logo(1).png");
		Thread.sleep(5000);
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
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Basic Document')]/a");
		assertEquals(RuntimeVariables.replace("Basic Document"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Basic Document')]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Basic Document')]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadTempFile("//input[@id='_20_file']",
			RuntimeVariables.replace("logo(1).png"));
		selenium.type("//input[@id='_20_title']",
			RuntimeVariables.replace(
				"Portlet Response (ActionResponse,Exclusive State)"));
		selenium.type("//textarea[@id='_20_description']",
			RuntimeVariables.replace(
				"Portlet Response (ActionResponse,Exclusive State)"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request completed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"Portlet Response (ActionResponse,Exclusive State)"),
			selenium.getText(
				"link=Portlet Response (ActionResponse,Exclusive State)"));
		selenium.clickAt("link=Portlet Response (ActionResponse,Exclusive State)",
			RuntimeVariables.replace(
				"Portlet Response (ActionResponse,Exclusive State)"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Portlet Response (ActionResponse,Exclusive State)"),
			selenium.getText("//h2[@class='document-title']"));
		selenium.waitForText("//span[@class='download-document']/span/a/span",
			"Download (2.0k)");
		assertEquals(RuntimeVariables.replace("Download (2.0k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
	}
}