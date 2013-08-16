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

package com.liferay.portalweb.portlet.mediagallery.dmfolder.adddmsubfoldermg;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownDMSubfolderMGTest extends BaseTestCase {
	public void testTearDownDMSubfolderMG() throws Exception {
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
				assertEquals(RuntimeVariables.replace("DM Folder Name"),
					selenium.getText("//a[@class='image-thumbnail']"));
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Folder Name"));
				selenium.waitForPageToLoad("30000");

				boolean subfolder1present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!subfolder1present) {
					label = 2;

					continue;
				}

				assertTrue(selenium.isVisible("//a[@class='image-thumbnail']"));
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Subfolder 1"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				Thread.sleep(1000);

				boolean subfolder2present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!subfolder2present) {
					label = 3;

					continue;
				}

				assertTrue(selenium.isVisible("//a[@class='image-thumbnail']"));
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Subfolder 2"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				Thread.sleep(1000);

				boolean subfolder3present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!subfolder3present) {
					label = 4;

					continue;
				}

				assertTrue(selenium.isVisible("//a[@class='image-thumbnail']"));
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Subfolder 3"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				Thread.sleep(1000);

				boolean subfolder4present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!subfolder4present) {
					label = 5;

					continue;
				}

				assertTrue(selenium.isVisible("//a[@class='image-thumbnail']"));
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Subfolder 4"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				Thread.sleep(1000);

				boolean subfolder5present = selenium.isElementPresent(
						"//a[@class='image-thumbnail']");

				if (!subfolder5present) {
					label = 6;

					continue;
				}

				assertTrue(selenium.isVisible("//a[@class='image-thumbnail']"));
				selenium.clickAt("//a[@class='image-thumbnail']",
					RuntimeVariables.replace("DM Subfolder 5"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]"));
				selenium.clickAt("//div[contains(@class,'lfr-component lfr-menu-list')]/ul/li/a[contains(.,'Delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				Thread.sleep(1000);

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