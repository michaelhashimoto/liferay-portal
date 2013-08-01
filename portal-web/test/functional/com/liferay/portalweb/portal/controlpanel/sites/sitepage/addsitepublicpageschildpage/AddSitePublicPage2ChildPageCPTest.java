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

package com.liferay.portalweb.portal.controlpanel.sites.sitepage.addsitepublicpageschildpage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSitePublicPage2ChildPageCPTest extends BaseTestCase {
	public void testAddSitePublicPage2ChildPageCP() throws Exception {
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
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Sites", RuntimeVariables.replace("Sites"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_134_name']",
					RuntimeVariables.replace("Site Name"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//span[@title='Actions']/ul/li/strong/a/span"));
				selenium.clickAt("//span[@title='Actions']/ul/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForText("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Manage Pages')]",
					"Manage Pages");
				assertEquals(RuntimeVariables.replace("Manage Pages"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Manage Pages')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Manage Pages')]",
					RuntimeVariables.replace("Manage Pages"));
				selenium.waitForVisible("//li[2]/div/div[3]/a");
				assertEquals(RuntimeVariables.replace("Public Page2"),
					selenium.getText("//li[2]/div/div[3]/a"));
				selenium.clickAt("//li[2]/div/div[3]/a",
					RuntimeVariables.replace("Public Page2"));
				selenium.waitForValue("//input[@id='_156_name_en_US']",
					"Public Page2");
				assertEquals("Public Page2",
					selenium.getValue("//input[@id='_156_name_en_US']"));
				selenium.waitForVisible(
					"//div[@id='_156_layoutToolbar']/span/button/span[contains(.,'Add Child Page')]");
				assertEquals(RuntimeVariables.replace("Add Child Page"),
					selenium.getText(
						"//div[@id='_156_layoutToolbar']/span/button/span[contains(.,'Add Child Page')]"));
				selenium.clickAt("//div[@id='_156_layoutToolbar']/span/button/span[contains(.,'Add Child Page')]",
					RuntimeVariables.replace("Add Child Page"));
				selenium.waitForVisible(
					"//input[@id='_156_addLayoutName_en_US']");
				selenium.type("//input[@id='_156_addLayoutName_en_US']",
					RuntimeVariables.replace("Public Page2 Child Page"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Add Page']"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.clickAt("//div[@class='aui-tree-hitarea']",
					RuntimeVariables.replace("Drop Down Arrow"));
				selenium.waitForElementPresent(
					"xPath=(//a[@class='layout-tree'])[2]");

				boolean pageVisible = selenium.isVisible(
						"xPath=(//a[@class='layout-tree'])[2]");

				if (pageVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@class='aui-tree-hitarea']",
					RuntimeVariables.replace("Drop Down Arrow"));

			case 2:
				selenium.waitForVisible("//li/ul/li/ul/li/div/div[3]/a");
				assertEquals(RuntimeVariables.replace("Public Page2 Child Page"),
					selenium.getText("//li/ul/li/ul/li/div/div[3]/a"));

			case 100:
				label = -1;
			}
		}
	}
}