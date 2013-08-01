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
public class User_MergeSPChristmasSPValentinesTest extends BaseTestCase {
	public void testUser_MergeSPChristmasSPValentines()
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

				boolean valentinesPresent = selenium.isElementPresent(
						"link=Valentines");

				if (!valentinesPresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=Valentines",
					RuntimeVariables.replace("Valentines"));
				selenium.waitForPageToLoad("30000");

			case 2:
				assertEquals(RuntimeVariables.replace(
						"Valentines Site Pages Variation of Site Name"),
					selenium.getText(
						"//span[@class='layout-set-branch-description']"));
				assertEquals(RuntimeVariables.replace(
						"Manage Site Pages Variations"),
					selenium.getText("//a[@id='_170_manageLayoutSetBranches']"));
				selenium.clickAt("//a[@id='_170_manageLayoutSetBranches']",
					RuntimeVariables.replace("Manage Site Pages Variations"));
				Thread.sleep(5000);
				selenium.selectFrame(
					"//div[@class='yui3-widget-bd aui-panel-bd aui-dialog-bd aui-dialog-iframe-bd']/iframe");
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"xPath=(//span[@title='Actions']/ul/li/strong/a/span)[1]"));
				selenium.clickAt("xPath=(//span[@title='Actions']/ul/li/strong/a/span)[1]",
					RuntimeVariables.replace("Actions"));
				selenium.waitForText("//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a[contains(.,'Merge')]",
					"Merge");
				assertEquals(RuntimeVariables.replace("Merge"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a[contains(.,'Merge')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[4]/a[contains(.,'Merge')]",
					RuntimeVariables.replace("Merge"));
				Thread.sleep(5000);
				selenium.waitForVisible("//tr[5]/td[1]");
				assertEquals(RuntimeVariables.replace("Valentines"),
					selenium.getText("//tr[5]/td[1]"));
				Thread.sleep(5000);
				assertTrue(selenium.isElementPresent(
						"//a[contains(@data-layoutsetbranchname,'Valentines')]"));
				selenium.clickAt("//a[contains(@data-layoutsetbranchname,'Valentines')]",
					RuntimeVariables.replace("Select"));
				selenium.waitForConfirmation(
					"Are you sure you want to merge changes from Valentines?");
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Site page variation was merged."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}