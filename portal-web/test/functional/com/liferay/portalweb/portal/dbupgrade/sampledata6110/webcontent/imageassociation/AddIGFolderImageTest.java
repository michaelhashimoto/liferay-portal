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

package com.liferay.portalweb.portal.dbupgrade.sampledata6110.webcontent.imageassociation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddIGFolderImageTest extends BaseTestCase {
	public void testAddIGFolderImage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/web-content-image-association-community/");
		selenium.clickAt("link=Image Gallery Page",
			RuntimeVariables.replace("Image Gallery Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Folder Test"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("Folder Test"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Media"),
			selenium.getText(
				"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li[contains(.,'Add Media')]/a"));
		selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li[contains(.,'Add Media')]/a",
			RuntimeVariables.replace("Add Media"));
		Thread.sleep(5000);
		selenium.waitForVisible("//iframe");
		selenium.selectFrame("//iframe");
		selenium.waitForVisible(
			"//a[@class='select-file-entry-type' and contains(.,'Basic Document')]");
		assertEquals(RuntimeVariables.replace("Basic Document"),
			selenium.getText(
				"//a[@class='select-file-entry-type' and contains(.,'Basic Document')]"));
		selenium.click(RuntimeVariables.replace(
				"//a[@class='select-file-entry-type' and contains(.,'Basic Document')]"));
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=top");
		selenium.waitForVisible("//input[@id='_31_file']");
		selenium.uploadFile("//input[@id='_31_file']",
			RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\portal\\dbupgrade\\sampledata6110\\webcontent\\imageassociation\\dependencies\\ImageGallery.jpg"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("Folder Test"),
			selenium.getText("//span[@class='image-title']"));
		selenium.clickAt("//span[@class='image-title']",
			RuntimeVariables.replace("Folder Test"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//a[contains(@class,'image-thumbnail')]/img"));
		assertEquals(RuntimeVariables.replace("ImageGallery.jpg"),
			selenium.getText("//span[@class='image-title']"));
	}
}