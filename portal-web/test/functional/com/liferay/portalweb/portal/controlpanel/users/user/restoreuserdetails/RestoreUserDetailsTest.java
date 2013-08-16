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

package com.liferay.portalweb.portal.controlpanel.users.user.restoreuserdetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RestoreUserDetailsTest extends BaseTestCase {
	public void testRestoreUserDetails() throws Exception {
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
				selenium.clickAt("link=Users and Organizations",
					RuntimeVariables.replace("Users and Organizations"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Search All Users",
					RuntimeVariables.replace("Search All Users"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForElementPresent("//a[.='Advanced \u00bb']");

				boolean advancedVisible = selenium.isVisible(
						"//a[.='Advanced \u00bb']");

				if (!advancedVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("//a[.='Advanced \u00bb']",
					RuntimeVariables.replace("Advanced \u00bb"));

			case 2:
				selenium.waitForVisible("//select[@name='_125_status']");
				selenium.select("//select[@name='_125_status']",
					RuntimeVariables.replace("label=Inactive"));
				selenium.clickAt("xPath=(//input[@value='Search'])[2]",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("userfn"),
					selenium.getText("//td[2]/a"));
				assertEquals(RuntimeVariables.replace("userln"),
					selenium.getText("//td[3]/a"));
				assertEquals(RuntimeVariables.replace("usersn"),
					selenium.getText("//td[4]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//td[5]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//td[6]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//td[7]/a"));
				assertFalse(selenium.isChecked(
						"//td[1]/input[@name='_125_rowIds']"));
				selenium.clickAt("//td[1]/input[@name='_125_rowIds']",
					RuntimeVariables.replace("User Checkbox"));
				assertTrue(selenium.isChecked(
						"//td[1]/input[@name='_125_rowIds']"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Restore']"));
				selenium.waitForPageToLoad("30000");
				selenium.waitForVisible("//div[@class='portlet-msg-success']");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertFalse(selenium.isTextPresent("userfn"));
				assertFalse(selenium.isTextPresent("userln"));
				assertFalse(selenium.isTextPresent("usersn"));
				selenium.clickAt("//a[.='\u00ab Basic']",
					RuntimeVariables.replace("\u00ab Basic"));
				selenium.type("//input[@name='_125_keywords']",
					RuntimeVariables.replace("userfn*"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("userfn"),
					selenium.getText("//td[2]/a"));
				assertEquals(RuntimeVariables.replace("userln"),
					selenium.getText("//td[3]/a"));
				assertEquals(RuntimeVariables.replace("usersn"),
					selenium.getText("//td[4]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//td[5]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//td[6]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//td[7]/a"));

			case 100:
				label = -1;
			}
		}
	}
}