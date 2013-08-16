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

package com.liferay.portalweb.portal.permissions.imagegallery.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigureMediaGalleryTest extends BaseTestCase {
	public void testConfigureMediaGallery() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Media Gallery Test Page",
					RuntimeVariables.replace("Media Gallery Test Page"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Options"),
					selenium.getText("//span[@title='Options']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
					RuntimeVariables.replace("Options"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]");
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Configuration')]",
					RuntimeVariables.replace("Configuration"));
				selenium.waitForVisible(
					"//iframe[contains(@id,'configurationIframeDialog')]");
				selenium.selectFrame(
					"//iframe[contains(@id,'configurationIframeDialog')]");
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/navigation_interaction.js')]");
				selenium.waitForVisible(
					"//input[@id='_86_showActionsCheckbox']");

				boolean showActionsCheckbox = selenium.isChecked(
						"//input[@id='_86_showActionsCheckbox']");

				if (showActionsCheckbox) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='_86_showActionsCheckbox']",
					RuntimeVariables.replace("Show Actions Checkbox"));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@id='_86_showActionsCheckbox']"));

				boolean showFolderMenuCheckbox = selenium.isChecked(
						"//input[@id='_86_showFolderMenuCheckbox']");

				if (showFolderMenuCheckbox) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@id='_86_showFolderMenuCheckbox']",
					RuntimeVariables.replace("Show Folder Menu Checkbox"));

			case 3:
				assertTrue(selenium.isChecked(
						"//input[@id='_86_showFolderMenuCheckbox']"));

				boolean showNavigationLinksCheckbox = selenium.isChecked(
						"//input[@id='_86_showTabsCheckbox']");

				if (showNavigationLinksCheckbox) {
					label = 4;

					continue;
				}

				selenium.clickAt("//input[@id='_86_showTabsCheckbox']",
					RuntimeVariables.replace("Show Navigation Links Checkbox"));

			case 4:
				assertTrue(selenium.isChecked(
						"//input[@id='_86_showTabsCheckbox']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"You have successfully updated the setup."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_86_showActionsCheckbox']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_86_showFolderMenuCheckbox']"));
				assertTrue(selenium.isChecked(
						"//input[@id='_86_showTabsCheckbox']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}