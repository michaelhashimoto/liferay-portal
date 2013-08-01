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

package com.liferay.portalweb.portlet.mediagallery.dmimage.adddmfolderimagemg;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDMFolderImage1MGTest extends BaseTestCase {
	public void testAddDMFolderImage1MG() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Test Page",
			RuntimeVariables.replace("Media Gallery Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace(
				"There are no media files in this folder."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		assertTrue(selenium.isVisible(
				"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(@id,'menu_add-media')]"));
		selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(@id,'menu_add-media')]",
			RuntimeVariables.replace("Add Media"));
		assertEquals(RuntimeVariables.replace("Add Media"),
			selenium.getText(
				"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(@id,'menu_add-media')]"));
		selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(@id,'menu_add-media')]",
			RuntimeVariables.replace("Add Media"));
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible("//tr[3]/td[1]/a");
		selenium.clickAt("//tr[3]/td[1]/a",
			RuntimeVariables.replace("Basic Document"));
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=top");
		selenium.uploadCommonFile("//input[@id='_31_file']",
			RuntimeVariables.replace("Document_1.jpg"));
		selenium.type("//input[@id='_31_title']",
			RuntimeVariables.replace("DM Folder Image1 Title"));
		selenium.type("//textarea[@id='_31_description']",
			RuntimeVariables.replace("DM Folder Image1 Description"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Folder Image1 Title"),
			selenium.getText("xPath=(//span[@class='image-title'])[1]"));
	}
}