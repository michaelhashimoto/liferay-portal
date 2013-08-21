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

package com.liferay.portalweb.socialofficehome.sites.site.searchdmfolderdocumentdeletesite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownPageSearchSOTest extends BaseTestCase {
	public void testTearDownPageSearchSO() throws Exception {
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
				selenium.waitForVisible("//li[@id='_145_toggleControls']");

				boolean EditControlOff = selenium.isElementPresent(
						"//body[contains(@class,'controls-hidden')]");

				if (!EditControlOff) {
					label = 2;

					continue;
				}

				assertEquals(RuntimeVariables.replace("Edit Controls"),
					selenium.getText("//li[@id='_145_toggleControls']"));
				selenium.clickAt("//li[@id='_145_toggleControls']",
					RuntimeVariables.replace("Edit Controls"));

			case 2:
				selenium.clickAt("//nav[@id='navigation']",
					RuntimeVariables.replace("Navigation"));
				selenium.waitForVisible(
					"//nav/ul/li[contains(.,'Search Test Page')]/a/span");

				boolean searchPagePresent = selenium.isElementPresent(
						"//nav/ul/li[contains(.,'Search Test Page')]/a/span");

				if (!searchPagePresent) {
					label = 3;

					continue;
				}

				selenium.mouseOver(
					"//nav/ul/li[contains(.,'Search Test Page')]/a/span");
				selenium.waitForVisible(
					"//nav/ul/li[contains(.,'Search Test Page')]/span[@class='delete-tab']");
				assertEquals(RuntimeVariables.replace("X"),
					selenium.getText(
						"//nav/ul/li[contains(.,'Search Test Page')]/span[@class='delete-tab']"));
				selenium.click(
					"//nav/ul/li[contains(.,'Search Test Page')]/span[@class='delete-tab']");
				selenium.waitForConfirmation(
					"Are you sure you want to delete this page?");
				selenium.waitForElementNotPresent(
					"//nav/ul/li[contains(.,'Search Test Page')]/span[@class='delete-tab']");

			case 3:
				assertEquals(RuntimeVariables.replace("Edit Controls"),
					selenium.getText("//li[@id='_145_toggleControls']"));
				selenium.clickAt("//li[@id='_145_toggleControls']",
					RuntimeVariables.replace("Edit Controls"));

			case 100:
				label = -1;
			}
		}
	}
}