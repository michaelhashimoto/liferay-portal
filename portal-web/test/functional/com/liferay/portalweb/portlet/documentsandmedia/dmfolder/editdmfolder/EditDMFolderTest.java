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

package com.liferay.portalweb.portlet.documentsandmedia.dmfolder.editdmfolder;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditDMFolderTest extends BaseTestCase {
	public void testEditDMFolder() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			"DM Folder Name");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		Thread.sleep(5000);
		selenium.clickAt("xPath=(//span[@class='overlay document-action']/span/ul/li/strong/a)[2]",
			RuntimeVariables.replace("Drop Down"));
		Thread.sleep(5000);
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a");
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a",
			RuntimeVariables.replace("Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_20_name']",
			RuntimeVariables.replace("DM Folder Name Edit"));
		selenium.type("//textarea[@id='_20_description']",
			RuntimeVariables.replace("DM Folder Description Edit"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//div[@class='portlet-msg-success']",
			"Your request completed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("DM Folder Name Edit"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
		selenium.clickAt("//button[@title='List View']",
			RuntimeVariables.replace("List View"));
		selenium.waitForText("//tr[3]/td[2]/span/a/span", "DM Folder Name Edit");
		assertEquals(RuntimeVariables.replace("DM Folder Name Edit"),
			selenium.getText("//tr[3]/td[2]/span/a/span"));
		assertEquals(RuntimeVariables.replace("--"),
			selenium.getText("//tr[3]/td[3]"));
		assertEquals(RuntimeVariables.replace("--"),
			selenium.getText("//tr[3]/td[4]"));
		selenium.clickAt("//button[@title='Icon View']",
			RuntimeVariables.replace("Icon View"));
		selenium.waitForText("//a[contains(@class,'document-link')]/span[@class='entry-title']",
			"DM Folder Name Edit");
		assertEquals(RuntimeVariables.replace("DM Folder Name Edit"),
			selenium.getText(
				"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
	}
}