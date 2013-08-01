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

package com.liferay.portalweb.portal.permissions.imagegallery.assertactions;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_GrantMemberAddImageTest extends BaseTestCase {
	public void testSA_GrantMemberAddImage() throws Exception {
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
				assertEquals(RuntimeVariables.replace(
						"Media Gallery Permissions Test Folder"),
					selenium.getText(
						"//a[@title='Media Gallery Permissions Test Folder - ']"));
				selenium.clickAt("//a[@title='Media Gallery Permissions Test Folder - ']",
					RuntimeVariables.replace(
						"Media Gallery Permissions Test Folder"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Permissions"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li/a[contains(.,'Permissions')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li/a[contains(.,'Permissions')]",
					RuntimeVariables.replace("Permissions"));
				selenium.waitForPageToLoad("30000");

				boolean memberActionAddCheckbox1 = selenium.isChecked(
						"//input[@id='member_ACTION_ADD_DOCUMENT']");

				if (memberActionAddCheckbox1) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='member_ACTION_ADD_DOCUMENT']",
					RuntimeVariables.replace("Member Action Add Checkbox"));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@id='member_ACTION_ADD_DOCUMENT']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Media Gallery Test Page",
					RuntimeVariables.replace("Media Gallery Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Media Gallery Permissions Test Folder"),
					selenium.getText(
						"//a[@title='Media Gallery Permissions Test Folder - ']"));
				selenium.clickAt("//a[@title='Media Gallery Permissions Test Folder - ']",
					RuntimeVariables.replace(
						"Media Gallery Permissions Test Folder"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Media Gallery Permissions Test Subfolder"),
					selenium.getText(
						"//a[@title='Media Gallery Permissions Test Subfolder - ']"));
				selenium.clickAt("//a[@title='Media Gallery Permissions Test Subfolder - ']",
					RuntimeVariables.replace(
						"Media Gallery Permissions Test Subfolder"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Permissions"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li/a[contains(.,'Permissions')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li/a[contains(.,'Permissions')]",
					RuntimeVariables.replace("Permissions"));
				selenium.waitForPageToLoad("30000");

				boolean memberActionAddCheckbox2 = selenium.isChecked(
						"//input[@id='member_ACTION_ADD_DOCUMENT']");

				if (memberActionAddCheckbox2) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@id='member_ACTION_ADD_DOCUMENT']",
					RuntimeVariables.replace("Member Action Add Checkbox"));

			case 3:
				assertTrue(selenium.isChecked(
						"//input[@id='member_ACTION_ADD_DOCUMENT']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertTrue(selenium.isChecked(
						"//input[@id='member_ACTION_ADD_DOCUMENT']"));

			case 100:
				label = -1;
			}
		}
	}
}