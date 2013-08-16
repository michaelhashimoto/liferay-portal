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

package com.liferay.portalweb.demo.media.dmdraganddropdocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveDMDocument1NewFolderFolder1ActionsTest extends BaseTestCase {
	public void testMoveDMDocument1NewFolderFolder1Actions()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText(
				"//div[@data-title='DM Document1 Title']/a/span[2]"));
		selenium.clickAt("//div[@data-title='DM Document1 Title']/span[2]/span/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Move')]");
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Move')]"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Move')]"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Select']",
			RuntimeVariables.replace("Select"));
		Thread.sleep(5000);
		selenium.selectWindow("title=Documents and Media");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//td[1]/a"));
		selenium.click("//td[4]/input[@value='Choose']");
		selenium.selectWindow("null");
		selenium.waitForText("//a[@id='_20_folderName']", "DM Folder1 Name");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//a[@id='_20_folderName']"));
		selenium.clickAt("//input[@value='Move']",
			RuntimeVariables.replace("Move"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isElementNotPresent(
				"//div[@data-title='DM Document1 Title']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//div[@data-title='DM Folder1 Name']/a/span[2]"));
		selenium.clickAt("//div[@data-title='DM Folder1 Name']/a/span[2]",
			RuntimeVariables.replace("DM Folder1 Name"));
		selenium.waitForText("//li[contains(@class,'selected')]/a/span[2]",
			"DM Folder1 Name");
		assertEquals(RuntimeVariables.replace("DM Folder1 Name"),
			selenium.getText("//li[contains(@class,'selected')]/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Document1 Title"),
			selenium.getText(
				"//div[@data-title='DM Document1 Title']/a/span[2]"));
	}
}