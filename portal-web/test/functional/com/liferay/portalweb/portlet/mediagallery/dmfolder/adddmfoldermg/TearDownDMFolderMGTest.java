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

package com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmfoldermg;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownDMFolderMGTest extends BaseTestCase {
	public void testTearDownDMFolderMG() throws Exception {
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

				boolean mgFolder1Present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!mgFolder1Present) {
					label = 2;

					continue;
				}

				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Folder 1"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean mgFolder2Present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!mgFolder2Present) {
					label = 3;

					continue;
				}

				Thread.sleep(1000);
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Folder 2"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean mgFolder3Present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!mgFolder3Present) {
					label = 4;

					continue;
				}

				Thread.sleep(1000);
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Folder 3"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean mgFolder4Present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!mgFolder4Present) {
					label = 5;

					continue;
				}

				Thread.sleep(1000);
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Folder 4"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

				boolean mgFolder5Present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!mgFolder5Present) {
					label = 6;

					continue;
				}

				Thread.sleep(1000);
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Folder 5"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));

			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 100:
				label = -1;
			}
		}
	}
}