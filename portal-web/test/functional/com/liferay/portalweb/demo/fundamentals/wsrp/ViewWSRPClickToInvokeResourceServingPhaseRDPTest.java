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

package com.liferay.portalweb.demo.fundamentals.wsrp;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.BrowserCommands;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWSRPClickToInvokeResourceServingPhaseRDPTest
	extends BaseTestCase {
	public void testViewWSRPClickToInvokeResourceServingPhaseRDP()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=WSRP Remote Test Misc Test Page",
			RuntimeVariables.replace("WSRP Remote Test Misc Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Portlet Response (ResourceResponse)"),
			selenium.getText("//div[@class='portlet-body']/h3[4]"));
		assertEquals(RuntimeVariables.replace("Download File"),
			selenium.getText("//div[@class='portlet-body']/p[4]/a[2]"));
		selenium.clickAt("//div[@class='portlet-body']/p[4]/a[2]",
			RuntimeVariables.replace("Download File"));
		BrowserCommands.downloadTempFile("logo(1).png");
		Thread.sleep(5000);
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span[@title='Add']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Add']/ul/li/strong/a/span",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[5]/a");
		assertEquals(RuntimeVariables.replace("Basic Document"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[5]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[5]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadTempFile("//input[@id='_20_file']",
			RuntimeVariables.replace("logo(1).png"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//div[@class='portlet-msg-success']");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("logo(1).png"),
			selenium.getText(
				"xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[1]"));
		assertEquals(RuntimeVariables.replace("logo.png"),
			selenium.getText(
				"xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[2]"));
		selenium.clickAt("xPath=(//a[contains(@class,'document-link')]/span[@class='entry-title'])[1]",
			RuntimeVariables.replace("logo(1).png"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("logo(1).png"),
			selenium.getText("//h2[@class='document-title']"));
		selenium.waitForText("//span[@class='download-document']/span/a/span",
			"Download (2.0k)");
		assertEquals(RuntimeVariables.replace("Download (2.0k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
	}
}