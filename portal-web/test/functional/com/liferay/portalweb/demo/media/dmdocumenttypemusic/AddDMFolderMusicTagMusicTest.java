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
public class AddDMFolderMusicTagMusicTest extends BaseTestCase {
	public void testAddDMFolderMusicTagMusic() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
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
				assertEquals(RuntimeVariables.replace("DM Music Title"),
					selenium.getText(
						"//div[@data-title='DM Music Title']/a/span[@class='entry-title']"));
				selenium.clickAt("//div[@data-title='DM Music Title']/a/span[@class='entry-title']",
					RuntimeVariables.replace("DM Music Title"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Edit"),
					selenium.getText("//button[.='Edit']"));
				selenium.clickAt("//button[.='Edit']",
					RuntimeVariables.replace("Edit"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Categorization"),
					selenium.getText(
						"//div[@id='dlFileEntryCategorizationPanel']/div/div/span"));

				boolean categorizationCollapsed = selenium.isElementPresent(
						"//div[@id='dlFileEntryCategorizationPanel' and contains(@class,'lfr-collapsed')]");

				if (!categorizationCollapsed) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@id='dlFileEntryCategorizationPanel']/div/div/span",
					RuntimeVariables.replace("Categorization"));

			case 2:
				selenium.waitForVisible("//input[@title='Add Tags']");
				selenium.type("//input[@title='Add Tags']",
					RuntimeVariables.replace("Music"));
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace("Publish"));
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace("music"),
					selenium.getText("//span[@class='tag' and .='music']"));

			case 100:
				label = -1;
			}
		}
	}
}