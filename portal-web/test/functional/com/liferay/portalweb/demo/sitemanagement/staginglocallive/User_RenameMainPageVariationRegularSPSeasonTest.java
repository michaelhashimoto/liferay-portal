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
public class User_RenameMainPageVariationRegularSPSeasonTest
	extends BaseTestCase {
	public void testUser_RenameMainPageVariationRegularSPSeason()
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

				boolean seasonPresent = selenium.isElementPresent("link=Season");

				if (!seasonPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Season",
					RuntimeVariables.replace("Season"));
				selenium.waitForPageToLoad("30000");

			case 2:
				assertEquals(RuntimeVariables.replace(
						"Season Site Pages Variation of Site Name"),
					selenium.getText(
						"//span[@class='layout-set-branch-description']"));
				assertEquals(RuntimeVariables.replace("Manage Page Variations"),
					selenium.getText(
						"//a[@id='_170_manageLayoutRevisions']/span"));
				selenium.clickAt("//a[@id='_170_manageLayoutRevisions']/span",
					RuntimeVariables.replace("Manage Page Variations"));
				Thread.sleep(5000);
				selenium.selectFrame(
					"//div[@class='yui3-widget-bd aui-panel-bd aui-dialog-bd aui-dialog-iframe-bd']/iframe");
				assertTrue(selenium.isPartialText("//td[1]/strong",
						"Main Variation"));
				assertEquals(RuntimeVariables.replace("Edit"),
					selenium.getText("//td[3]/span/a/span"));
				selenium.clickAt("//td[3]/span/a/span",
					RuntimeVariables.replace("Edit"));
				selenium.waitForVisible("//input[@id='_170_name']");
				selenium.type("//input[@id='_170_name']",
					RuntimeVariables.replace("Regular"));
				selenium.type("//textarea[@id='_170_description']",
					RuntimeVariables.replace("Regular Description"));
				selenium.clickAt("//input[@value='Update']",
					RuntimeVariables.replace("Update"));
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Page variation was updated."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertTrue(selenium.isPartialText("//td[1]/strong", "Regular"));
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.waitForElementPresent("link=Site Name");
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
				assertEquals(RuntimeVariables.replace(
						"Season Site Pages Variation of Site Name"),
					selenium.getText(
						"//span[@class='layout-set-branch-description']"));
				assertEquals(RuntimeVariables.replace("Regular Description"),
					selenium.getText(
						"//div[@class='layout-branch-description']"));
				assertEquals(RuntimeVariables.replace("Manage Page Variations"),
					selenium.getText(
						"//a[@id='_170_manageLayoutRevisions']/span"));
				selenium.clickAt("//a[@id='_170_manageLayoutRevisions']/span",
					RuntimeVariables.replace("Manage Page Variations"));
				Thread.sleep(5000);
				selenium.selectFrame(
					"//div[@class='yui3-widget-bd aui-panel-bd aui-dialog-bd aui-dialog-iframe-bd']/iframe");
				assertTrue(selenium.isPartialText("//td[1]/strong", "Regular"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}