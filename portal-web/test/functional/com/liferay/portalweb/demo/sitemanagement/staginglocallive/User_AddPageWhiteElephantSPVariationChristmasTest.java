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

package com.liferay.portalweb.demo.sitemanagement.staginglocallive;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class User_AddPageWhiteElephantSPVariationChristmasTest
	extends BaseTestCase {
	public void testUser_AddPageWhiteElephantSPVariationChristmas()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/dockbar_underlay.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Site Name");
				selenium.clickAt("link=Site Name",
					RuntimeVariables.replace("Site Name"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//body[contains(@class,'live-view')]"));
				assertTrue(selenium.isElementNotPresent(
						"//body[contains(@class,'local-staging')]"));
				assertEquals(RuntimeVariables.replace("Staging"),
					selenium.getText(
						"//div[@class='staging-bar']/ul/li[2]/span/a"));
				selenium.clickAt("//div[@class='staging-bar']/ul/li[2]/span/a",
					RuntimeVariables.replace("Staging"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent(
						"//body[contains(@class,'local-staging')]"));
				assertTrue(selenium.isElementNotPresent(
						"//body[contains(@class,'live-view')]"));

				boolean christmasPresent = selenium.isElementPresent(
						"link=Christmas");

				if (!christmasPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Christmas",
					RuntimeVariables.replace("Christmas"));
				selenium.waitForPageToLoad("30000");

			case 2:
				assertEquals(RuntimeVariables.replace("Christmas"),
					selenium.getText("//li[1]/span/span/span[1]"));
				assertEquals(RuntimeVariables.replace(
						"Christmas Site Pages Variation of Site Name"),
					selenium.getText(
						"//span[@class='layout-set-branch-description']"));
				selenium.clickAt("//nav[@id='navigation']",
					RuntimeVariables.replace("Navigation"));
				selenium.waitForVisible(
					"//a[@class='menu-button']/span[contains(.,'Add')]");
				selenium.clickAt("//a[@class='menu-button']/span[contains(.,'Add')]",
					RuntimeVariables.replace("Add"));
				selenium.waitForElementPresent("//a[@id='addPage']");
				selenium.clickAt("//a[@id='addPage']",
					RuntimeVariables.replace("Add Page"));
				selenium.waitForVisible("//input[@type='text']");
				selenium.type("//input[@type='text']",
					RuntimeVariables.replace("White Elephant"));
				selenium.clickAt("//button[contains(@id,'Save')]",
					RuntimeVariables.replace("Save"));
				selenium.waitForVisible("link=White Elephant");
				selenium.clickAt("link=White Elephant",
					RuntimeVariables.replace("White Elephant"));
				selenium.waitForPageToLoad("30000");

			case 100:
				label = -1;
			}
		}
	}
}