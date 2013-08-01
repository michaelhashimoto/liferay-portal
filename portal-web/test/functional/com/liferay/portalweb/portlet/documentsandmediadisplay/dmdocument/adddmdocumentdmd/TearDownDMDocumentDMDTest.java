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

package com.liferay.portalweb.portlet.documentsandmediadisplay.dmdocument.adddmdocumentdmd;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownDMDocumentDMDTest extends BaseTestCase {
	public void testTearDownDMDocumentDMD() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Documents and Media Display Test Page",
					RuntimeVariables.replace(
						"Documents and Media Display Test Page"));
				selenium.waitForPageToLoad("30000");

				boolean dmDocument1Present = selenium.isElementPresent(
						"//span[@class='entry-title']");

				if (!dmDocument1Present) {
					label = 2;

					continue;
				}

				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

				boolean dmDocument2Present = selenium.isElementPresent(
						"//span[@class='entry-title']");

				if (!dmDocument2Present) {
					label = 3;

					continue;
				}

				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

				boolean dmDocument3Present = selenium.isElementPresent(
						"//span[@class='entry-title']");

				if (!dmDocument3Present) {
					label = 4;

					continue;
				}

				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

				boolean dmDocument4Present = selenium.isElementPresent(
						"//span[@class='entry-title']");

				if (!dmDocument4Present) {
					label = 5;

					continue;
				}

				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

				boolean dmDocument5Present = selenium.isElementPresent(
						"//span[@class='entry-title']");

				if (!dmDocument5Present) {
					label = 6;

					continue;
				}

				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menuButton')]/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]");
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText(
						"//a[contains(@id,'objectsSearchContainer_1_menu_delete')]"));
				selenium.clickAt("//a[contains(@id,'objectsSearchContainer_1_menu_delete')]",
					RuntimeVariables.replace("Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				assertEquals(RuntimeVariables.replace(
						"There are no documents or media files in this folder."),
					selenium.getText("//div[@class='portlet-msg-info']"));

			case 100:
				label = -1;
			}
		}
	}
}