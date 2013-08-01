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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationpage.addorganizationprivatepage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationPrivatePageTest extends BaseTestCase {
	public void testAddOrganizationPrivatePage() throws Exception {
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
					RuntimeVariables.replace("Name"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isPartialText(
						"//td[@id='_134_groupsSearchContainer_col-name_row--organization-name']/a",
						"Organization Name"));
				assertTrue(selenium.isPartialText(
						"//td[@id='_134_groupsSearchContainer_col-name_row--organization-name']/a",
						"Belongs to an organization of type Regular Organization."));
				assertEquals(RuntimeVariables.replace("Private"),
					selenium.getText(
						"//td[@id='_134_groupsSearchContainer_col-type_row--organization-name']/a"));
				assertEquals(RuntimeVariables.replace("1 Organization"),
					selenium.getText(
						"//td[@id='_134_groupsSearchContainer_col-members_row--organization-name']"));
				assertEquals(RuntimeVariables.replace("Yes"),
					selenium.getText(
						"//td[@id='_134_groupsSearchContainer_col-active_row--organization-name']"));
				assertEquals(RuntimeVariables.replace("Actions"),
					selenium.getText(
						"//span[@title='Actions']/ul[@id='_134_groupsSearchContainer_-organization-name_menu']/li/strong/a/span"));
				selenium.clickAt("//span[@title='Actions']/ul[@id='_134_groupsSearchContainer_-organization-name_menu']/li/strong/a/span",
					RuntimeVariables.replace("Actions"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Manage Pages')]");
				assertEquals(RuntimeVariables.replace("Manage Pages"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Manage Pages')]"));
				selenium.click(RuntimeVariables.replace(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(.,'Manage Pages')]"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("//a[contains(text(),'Private Pages')]",
					RuntimeVariables.replace("Private Pages"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Add Page"),
					selenium.getText("//div[2]/span/button"));
				assertEquals(RuntimeVariables.replace("Add Page"),
					selenium.getText(
						"//button[@type='button']/span[contains(.,'Add Page')]"));
				selenium.clickAt("//button[@type='button']/span[contains(.,'Add Page')]",
					RuntimeVariables.replace("Add Page"));
				selenium.waitForVisible(
					"//input[@id='_156_addLayoutName_en_US']");
				selenium.type("//input[@id='_156_addLayoutName_en_US']",
					RuntimeVariables.replace("Private Page"));
				selenium.clickAt("//input[@value='Add Page']",
					RuntimeVariables.replace("Add Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));

				boolean pagePresent = selenium.isVisible(
						"//a[@id='layoutsTree_layout_private-page']");

				if (pagePresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[@class='aui-tree-hitarea']",
					RuntimeVariables.replace("Drop Down Arrow"));

			case 2:
				selenium.waitForText("//a[@id='layoutsTree_layout_private-page']",
					"Private Page");
				assertEquals(RuntimeVariables.replace("Private Page"),
					selenium.getText(
						"//a[@id='layoutsTree_layout_private-page']"));

			case 100:
				label = -1;
			}
		}
	}
}