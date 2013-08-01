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

package com.liferay.portalweb.demo.media.dmkaleo2workflow;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_ViewApproveDMFolderDocumentDocTest extends BaseTestCase {
	public void testUser_ViewApproveDMFolderDocumentDoc()
		throws Exception {
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
		selenium.waitForVisible("//li[contains(@class,'folder selected')]/a");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("DM Document Title Edit"),
			selenium.getText(
				"//div[@data-title='DM Document Title Edit']/a/span[@class='entry-title']"));
		selenium.clickAt("//div[@data-title='DM Document Title Edit']/a/span[@class='entry-title']",
			RuntimeVariables.replace("DM Document Title Edit"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Document Title Edit"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("DM Document Title Edit"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace("DM Document Description"),
			selenium.getText("//span[@class='document-description']"));
		assertEquals(RuntimeVariables.replace("Version 1.0"),
			selenium.getText("//h3[contains(@class,'version')]"));
		assertEquals(RuntimeVariables.replace("Last Updated by userfn userln"),
			selenium.getText("//div[contains(@class,'lfr-asset-author')]"));
		assertEquals(RuntimeVariables.replace("Status: Approved"),
			selenium.getText("//span[@class='workflow-status']"));
		assertEquals(RuntimeVariables.replace("DM Document Description"),
			selenium.getText("//blockquote[@class='lfr-asset-description']"));
		assertEquals(RuntimeVariables.replace("Download (22.5k)"),
			selenium.getText("//span[@class='download-document']/span/a/span"));
	}
}