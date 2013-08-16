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

package com.liferay.portalweb.socialofficehome.mydocuments.dmdocument.adddmfolderdocumenttags;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDMFolderDocumentTagsTest extends BaseTestCase {
	public void testAddDMFolderDocumentTags() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				assertEquals(RuntimeVariables.replace("My Documents"),
					selenium.getText(
						"//nav/ul/li[contains(.,'My Documents')]/a/span"));
				selenium.clickAt("//nav/ul/li[contains(.,'My Documents')]/a/span",
					RuntimeVariables.replace("My Documents"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("DM Folder Name"),
					selenium.getText(
						"//a[contains(@class,'document-link')]/span[@class='entry-title']"));
				selenium.clickAt("//a[contains(@class,'document-link')]/span[@class='entry-title']",
					RuntimeVariables.replace("DM Folder Name"));
				selenium.waitForText("//li[@class='folder selected']/a",
					"DM Folder Name");
				assertEquals(RuntimeVariables.replace("DM Folder Name"),
					selenium.getText("//li[@class='folder selected']/a"));
				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Add"),
					selenium.getText("//span[@title='Add']/ul/li/strong/a/span"));
				selenium.clickAt("//span[@title='Add']/ul/li/strong/a/span",
					RuntimeVariables.replace("Add"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Basic Document')]");
				assertEquals(RuntimeVariables.replace("Basic Document"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Basic Document')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Basic Document')]",
					RuntimeVariables.replace("Basic Document"));
				selenium.waitForPageToLoad("30000");
				selenium.uploadCommonFile("//input[@id='_20_file']",
					RuntimeVariables.replace("Document_1.doc"));
				selenium.type("//input[@id='_20_title']",
					RuntimeVariables.replace("DM Folder Document Title"));

				boolean addTagsVisible = selenium.isVisible(
						"//input[@title='Add Tags']");

				if (addTagsVisible) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Categorization"),
					selenium.getText(
						"//div[@id='dlFileEntryCategorizationPanel']/div/div/span"));
				selenium.clickAt("//div[@id='dlFileEntryCategorizationPanel']/div/div/span",
					RuntimeVariables.replace("Categorization"));
				selenium.waitForVisible("//input[@title='Add Tags']");

			case 2:
				selenium.type("//input[@title='Add Tags']",
					RuntimeVariables.replace("tag1"));
				selenium.clickAt("//button[@id='add']",
					RuntimeVariables.replace("Add"));
				selenium.waitForVisible(
					"xPath=(//span[@class='aui-textboxlistentry-text'])[1]");
				assertEquals(RuntimeVariables.replace("tag1"),
					selenium.getText(
						"xPath=(//span[@class='aui-textboxlistentry-text'])[1]"));
				selenium.type("//input[@title='Add Tags']",
					RuntimeVariables.replace("tag2"));
				selenium.clickAt("//button[@id='add']",
					RuntimeVariables.replace("Add"));
				selenium.waitForVisible(
					"xPath=(//span[@class='aui-textboxlistentry-text'])[2]");
				assertEquals(RuntimeVariables.replace("tag2"),
					selenium.getText(
						"xPath=(//span[@class='aui-textboxlistentry-text'])[2]"));
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace("Publish"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace(
						"DM Folder Document Title"),
					selenium.getText(
						"//a[contains(@class,'document-link')]/span[@class='entry-title']"));

			case 100:
				label = -1;
			}
		}
	}
}