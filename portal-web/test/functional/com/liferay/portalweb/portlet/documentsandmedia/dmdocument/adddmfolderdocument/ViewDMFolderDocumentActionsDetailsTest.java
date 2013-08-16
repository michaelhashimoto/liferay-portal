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

package com.liferay.portalweb.portlet.documentsandmedia.dmdocument.adddmfolderdocument;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewDMFolderDocumentActionsDetailsTest extends BaseTestCase {
	public void testViewDMFolderDocumentActionsDetails()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//span[@class='document-thumbnail']/img");
		assertTrue(selenium.isVisible("//span[@class='document-thumbnail']/img"));
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//div[@class='document-container']/div/a/span[2]"));
		selenium.clickAt("//div[@class='document-container']/div/a/span[2]",
			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForText("//li[@class='folder selected']/a/span[2]",
			"DM Folder Name");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("//li[@class='folder selected']/a/span[2]"));
		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText("xpath=(//span[@class='entry-title'])[2]"));
		selenium.clickAt("xpath=(//span[@class='entry-title'])[2]",
			RuntimeVariables.replace("DM Folder Document Title"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"//span[@class='aui-toolbar-content']/button[1]");
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
	}
}