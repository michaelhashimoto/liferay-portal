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

package com.liferay.portalweb.socialofficehome.sites.publicrestrictedsite.searchdocumentdeletesitepublicrestrict;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPageSearchSOTest extends BaseTestCase {
	public void testAddPageSearchSO() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/user/joebloggs/so/dashboard/");
				selenium.clickAt("//a[contains(@id,'toggleDockbar')]",
					RuntimeVariables.replace("Toggle Dockbar"));
				selenium.waitForElementPresent(
					"//body[contains(@class,'show-dockbar')]");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Add"),
					selenium.getText("//li[@id='_145_addContent']/a/span"));
				selenium.mouseOver("//li[@id='_145_addContent']/a/span");
				selenium.waitForVisible("//a[@id='addPage']");
				assertEquals(RuntimeVariables.replace("Page"),
					selenium.getText("//a[@id='addPage']"));
				selenium.clickAt("//a[@id='addPage']",
					RuntimeVariables.replace("Page"));
				selenium.waitForVisible(
					"//li[@class='add-page']/div/div/span/span/input");
				selenium.type("//li[@class='add-page']/div/div/span/span/input",
					RuntimeVariables.replace("Search Test Page"));

				boolean newSaveButtonPresent = selenium.isElementPresent(
						"//button[contains(@id,'Save')]");

				if (!newSaveButtonPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//button[contains(@id,'Save')]",
					RuntimeVariables.replace("Save"));

			case 2:

				boolean oldSaveButtonPresent = selenium.isElementPresent(
						"//button[contains(@id,'save')]");

				if (!oldSaveButtonPresent) {
					label = 3;

					continue;
				}

				selenium.clickAt("//button[contains(@id,'save')]",
					RuntimeVariables.replace("Save"));

			case 3:
				selenium.waitForVisible("link=Search Test Page");
				selenium.clickAt("link=Search Test Page",
					RuntimeVariables.replace("Search Test Page"));
				selenium.waitForPageToLoad("30000");

			case 100:
				label = -1;
			}
		}
	}
}