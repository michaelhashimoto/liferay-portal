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

package com.liferay.portalweb.demo.media.dmdocumenttypemusic;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDMFolderMusicArtistNullTest extends BaseTestCase {
	public void testAddDMFolderMusicArtistNull() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText(
				"//div[@data-title='DM Folder Name']/a/span[@class='entry-title']"));
		selenium.clickAt("//div[@data-title='DM Folder Name']/a/span[@class='entry-title']",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForVisible(
			"//li[@class='folder selected']/a/span[@class='entry-title']");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span[@title='Add']/ul/li/strong/a/span"));
		selenium.clickAt("//span[@title='Add']/ul/li/strong/a/span",
			RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Music')]");
		assertEquals(RuntimeVariables.replace("Music"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Music')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Music')]",
			RuntimeVariables.replace("Music"));
		selenium.waitForPageToLoad("30000");
		selenium.uploadCommonFile("//input[@id='_20_file']",
			RuntimeVariables.replace("Document_1.mp3"));
		selenium.type("//input[@id='_20_title']",
			RuntimeVariables.replace("DM Music Title"));
		selenium.type("//textarea[@id='_20_description']",
			RuntimeVariables.replace("DM Music Description"));
		selenium.type("//input[contains(@name,'artist')]",
			RuntimeVariables.replace(""));
		selenium.type("//input[contains(@name,'track')]",
			RuntimeVariables.replace("01"));
		selenium.type("//input[contains(@name,'album')]",
			RuntimeVariables.replace("DM Music Album"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForVisible("//div[@role='alert']");
		assertEquals(RuntimeVariables.replace("This field is required."),
			selenium.getText("//div[@role='alert']"));
	}
}