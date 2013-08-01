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

package com.liferay.portalweb.portal.permissions.documentlibrary.content.documentlibraryfolder.view;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DefineMemberRoleTest extends BaseTestCase {
	public void testDefineMemberRole() throws Exception {
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
				selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_128_keywords']",
					RuntimeVariables.replace("Member"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Member"),
					selenium.getText("//tr[3]/td/a"));
				selenium.clickAt("//tr[3]/td/a",
					RuntimeVariables.replace("Member"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Define Permissions",
					RuntimeVariables.replace("Define Permissions"));
				selenium.waitForPageToLoad("30000");
				selenium.select("//select[@id='_128_add-permissions']",
					RuntimeVariables.replace(
						"value=regexp:.*portletResource=20&.*showModelResources=0"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Documents and Media"),
					selenium.getText("//h3"));

				boolean accessInControlPanel = selenium.isChecked(
						"//input[@value='20ACCESS_IN_CONTROL_PANEL']");

				if (accessInControlPanel) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@value='20ACCESS_IN_CONTROL_PANEL']",
					RuntimeVariables.replace("Access in Control Panel"));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@value='20ACCESS_IN_CONTROL_PANEL']"));

				boolean viewPermissions = selenium.isChecked(
						"//input[@value='20VIEW']");

				if (viewPermissions) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@value='20VIEW']",
					RuntimeVariables.replace("View"));

			case 3:
				assertTrue(selenium.isChecked("//input[@value='20VIEW']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"The role permissions were updated."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.select("//select[@id='_128_add-permissions']",
					RuntimeVariables.replace("Documents and Media"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Document Type"),
					selenium.getText("//h3"));

				boolean documentLibraryView = selenium.isChecked(
						"//input[@value='com.liferay.portlet.documentlibraryVIEW']");

				if (documentLibraryView) {
					label = 4;

					continue;
				}

				selenium.clickAt("//input[@value='com.liferay.portlet.documentlibraryVIEW']",
					RuntimeVariables.replace("documentLibraryView"));

			case 4:
				assertTrue(selenium.isChecked(
						"//input[@value='com.liferay.portlet.documentlibraryVIEW']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"The role permissions were updated."),
					selenium.getText("//div[@class='portlet-msg-success']"));

			case 100:
				label = -1;
			}
		}
	}
}